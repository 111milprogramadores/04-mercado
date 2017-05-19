/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.mercado.dao;

import java.util.Date;
import java.util.List;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import poo.mercado.Contrato;
import poo.mercado.Dimension;
import poo.mercado.Estado;
import poo.mercado.PrecioAlquiler;
import poo.mercado.Puesto;
import poo.mercado.TipoPuesto;

/**
 *
 * @author joaquinleonelrobles
 */
public class PuestosDaoHibernateImpl implements PuestosDao {
    
    private SessionFactory sessionFactory;
    private EstadosDao estadosDao;

    public PuestosDaoHibernateImpl(SessionFactory sessionFactory, EstadosDao estadosDao) {
        this.sessionFactory = sessionFactory;
        this.estadosDao = estadosDao;
    }

    @Override
    public void guardar(Puesto puesto) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(puesto);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Puesto> buscarDisponiblesEnFechas(TipoPuesto tipoPuesto, Dimension dimension, Date fechaDesde, Date fechaHasta) {
        Session session = sessionFactory.openSession();
        
        // comenzamos el armado de la criteria
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Puesto> criteria = builder.createQuery(Puesto.class);
        Root<Puesto> root = criteria.from(Puesto.class);
        
        // al hacer un join es importante seleccionar solo los distintos
        criteria.select(root).distinct(true);
        
        // filtramos por tipo de puesto y dimension a traves del precio de alquiler
        Join<Puesto, PrecioAlquiler> precios = root.join("preciosAlquiler");
        
        // debe tener el mismo tipo y dimension
        Predicate mismoPuestoDimension = builder.and(
            builder.equal(precios.get("tipoPuesto"), tipoPuesto),
            builder.equal(precios.get("dimension"), dimension)
        );
        
        // ...no tener un contrato que colisione con las fechas
        Subquery<Contrato> subquery = criteria.subquery(Contrato.class);
        Root<Contrato> rootContrato = subquery.from(Contrato.class);
        subquery.select(rootContrato);
        
        // verificamos que la fecha de inicio o fin buscada no entre en un contrato
        ParameterExpression<Date> paramFechaDesde = builder.parameter(Date.class);
        ParameterExpression<Date> paramFechaHasta = builder.parameter(Date.class);
        
        // comprobamos que las fechas ingresadas se encuentren cubiertas por un contrato
        Predicate incluyeDesde = builder.between(paramFechaDesde, rootContrato.get("fechaInicioContrato"), rootContrato.get("fechaFinContrato"));
        Predicate incluyeHasta = builder.between(paramFechaHasta, rootContrato.get("fechaInicioContrato"), rootContrato.get("fechaFinContrato"));
        Predicate desdeMayorInicio = builder.greaterThanOrEqualTo(rootContrato.get("fechaInicioContrato"), paramFechaDesde);
        Predicate hastaMenorFin = builder.lessThanOrEqualTo(rootContrato.get("fechaFinContrato"), paramFechaHasta);
        
        // agregamos las condiciones: vincuar por el puesto e incluir al menos una fecha 
        subquery.where(builder.and(
            builder.equal(rootContrato.get("puesto"), root),
            builder.or(incluyeDesde, incluyeHasta, builder.and(desdeMayorInicio, hastaMenorFin))
        ));
        
        // aplicamos las condiciones en el where: que se trate del mismo tipo de
        // puesto y dimension seleccionados y que, o bien esté disponible o no
        // existan contratos que cubran fechaDesde o fechaHasta
        criteria.where(
            builder.and(mismoPuestoDimension, builder.not(builder.exists(subquery)))
        );
        
        // creamos una query tipada para asignarle parametros (fechaDesde y fechaHasta)
        TypedQuery<Puesto> query = session.createQuery(criteria);
        query.setParameter(paramFechaDesde, fechaDesde, TemporalType.DATE);
        query.setParameter(paramFechaHasta, fechaHasta, TemporalType.DATE);
        
        // obtenemos los resultados
        List<Puesto> retorno = query.getResultList();
        
        session.close();
        
        return retorno;
    }
    
}
