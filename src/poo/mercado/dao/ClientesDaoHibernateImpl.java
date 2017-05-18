/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.mercado.dao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import poo.mercado.Cliente;

/**
 *
 * @author joaquinleonelrobles
 */
public class ClientesDaoHibernateImpl implements ClientesDao {
    
    private SessionFactory sessionFactory;

    public ClientesDaoHibernateImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void guardar(Cliente cliente) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(cliente);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Cliente buscarPorRazonSocial(String nombre) {
        Session session = sessionFactory.openSession();
        
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Cliente> query = builder.createQuery(Cliente.class);
        Root<Cliente> root = query.from(Cliente.class);
        query.select(root);
        query.where(builder.equal(root.get("razonSocial"), nombre));
        
        Cliente cliente = session.createQuery(query).uniqueResult();
        
        session.close();
        
        return cliente;
    }
    
}
