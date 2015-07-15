package dao;

import java.util.*;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import users.RegUser;
import users.User;

import org.hibernate.SessionFactory;
import org.hibernate.Hibernate;

@Repository
public class RegUserDAOImpl implements RegUserDAO{
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	@Override
	public void addRegUser(String name, String password, String email){
		Session session = sessionFactory.openSession();
		try{
			session.beginTransaction();
			User user = new RegUser();
			user.setName(name);
			user.setPassword(password);
			user.setEmail(email);
			session.save(user);
			session.getTransaction().commit();
		}catch(HibernateException e){
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	
	@Override
	public List<RegUser> listRegUsers(){
		Session session = sessionFactory.openSession();
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
	
	@Override
	public void updateRegUserXP(String Username, int xpPoints){
		Session session = sessionFactory.openSession();
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
	
	@Override
	public void deleteRegUser(String Username){
		Session session = sessionFactory.openSession();
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

	@Override
	public void updateRegUserPassword(String Username, String Password) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateRegUserEMail(String Username, String eMail) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateRegUserRegisteredSince(String Username, Date Date) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateRegUserSchool(String Username, String School) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateRegUserHobby(String Username, String Hobby) {
		// TODO Auto-generated method stub
		
	}
}