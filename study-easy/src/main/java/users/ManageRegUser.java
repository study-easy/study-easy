package users;

import java.util.*;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.Hibernate;

public class ManageRegUser {
	private static SessionFactory factory;

	public String addRegUser(String name, String password, String email){
		Session session = factory.openSession();
		Transaction tx = null;
		String Username = null;
		try{
			tx = session.beginTransaction();
			User user = new RegUser();
			Username = (String) session.save(user);
			tx.commit();
		}catch(HibernateException e){
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return Username;
	}
	
	public List<RegUser> listRegUsers(){
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			List<RegUser> regUsers = session.createQuery("FROM RegUser").list();
			tx.commit();
			return regUsers;
		} catch(HibernateException e){
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return null;
	}
	
	public void updateRegUser(String Username, int xpPoints){
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			RegUser regUser = (RegUser) session.get(RegUser.class, Username);
			regUser.setXpPoints(xpPoints);
			session.update(regUser);
			tx.commit();
		}catch(HibernateException e){
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	
	public void deleteRegUser(String Username){
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			RegUser regUser = (RegUser) session.get(RegUser.class, Username);
			session.delete(regUser);
			tx.commit();
		}catch(HibernateException e){
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
}