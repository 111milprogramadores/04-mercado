/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.mercado.dao;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import poo.mercado.Contrato;
import poo.mercado.Estado;
import poo.mercado.Puesto;

/**
 *
 * @author joaquinleonelrobles
 */
public class ContratosDaoHibernateImpl implements ContratosDao {
    
    private SessionFactory sessionFactory;

    public ContratosDaoHibernateImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void guardar(Contrato contrato) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(contrato);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Contrato> buscarPorPuesto(Puesto puesto) {
        Session session = sessionFactory.openSession();
        
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Contrato> query = builder.createQuery(Contrato.class);
        Root<Contrato> root = query.from(Contrato.class);
        query.select(root);
        query.where(builder.equal(root.get("puesto"), puesto));
        
        List<Contrato> retorno = session.createQuery(query).list();
        
        session.close();
        
        return retorno;
    }

    @Override
    public int obtenerProximoNumero() {
        Session session = sessionFactory.openSession();
        
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Integer> query = builder.createQuery(Integer.class);
        Root<Contrato> root = query.from(Contrato.class);
        query.select(builder.max(root.get("numero")));
        
        Integer proximo = session.createQuery(query).uniqueResult();
        
        session.close();
        
        return (proximo == null) ? 1 : proximo + 1;
    }
    
}
