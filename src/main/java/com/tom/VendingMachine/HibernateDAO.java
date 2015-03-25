package com.tom.VendingMachine;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public abstract class HibernateDAO implements DAO {

	private SessionFactory sessionFactory;
	private Class type;
	
	public HibernateDAO(Class type) {
		this.type = type;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}
	
	public Object add(Object t) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		try
		{
			session.save(t);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return t;
	}
	public void remove(Object t) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		try
		{
			session.delete(t);
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	public void update(Object t) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		try
		{
			session.update(t);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public List<Object> getlist() {
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		List<Object> lt = null;
		
		try {
			lt = session.createCriteria(type).list();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return lt;
	}
}
