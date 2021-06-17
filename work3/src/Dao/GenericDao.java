/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author The flash
 */
public class GenericDao<A> {
    private Class<A> type; 

    public GenericDao(Class<A> type) {
        this.type = type;
    }
    
    
    public String createA(A obj) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.save(obj);
        s.getTransaction().commit();
        s.close();
        return "success";
    }

    public String updateA(A obj) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.update(obj);
        s.getTransaction().commit();
        s.close();
        return "success";
    }

    public String deleteA(A obj) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.delete(obj);
        s.getTransaction().commit();
        s.close();
        return "success";
    }

    public List<A> findAll() {
        Session s = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Query q = s.createQuery("from "+type.getName());
        List<A> li = q.list();
        s.close();
        return li;
    }

    public A findById(String id) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        A obj = (A) s.get(type, id);
        s.close();
        return obj;
    }
}