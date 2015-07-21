package study_easy.dao;

import java.util.*;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import study_easy.users.RegUser;

import org.hibernate.SessionFactory;

@Repository
public class RegUserDAOImpl implements RegUserDAO{
	
	@Autowired
	private SessionFactory factory;

	@Override
	public void addRegUser(RegUser user) {
		Session session = factory.getCurrentSession();
		session.save(user);
	}	
		
	@Override
	public List<RegUser> listRegUsers(){
		Session session = factory.getCurrentSession();
		List<RegUser> list = session.createQuery("FROM reguser").list();
		return list;
		
	}
	
	@Override
	public void updateRegUserXP(String Username, int xpPoints){
		Session session = factory.getCurrentSession();
		RegUser user = (RegUser)session.load(RegUser.class, Username);
		if(user!=null){
			user.setXpPoints(xpPoints);
			session.update(user);
		}
	}
	
	@Override
	public void updateRegUserHobby(String Username, String hobby){
		Session session = factory.getCurrentSession();
		RegUser user = (RegUser)session.load(RegUser.class, Username);
		if(user!=null){
			user.setHobby(hobby);
			session.update(user);
		}
	}

	@Override
	public void updateRegUserPassword(String Username, String Password) {
		Session session = factory.getCurrentSession();
		RegUser user = (RegUser)session.load(RegUser.class, Username);
		if(user!=null){
			user.setPassword(Password);
			session.update(user);
		}
	}

	@Override
	public void updateRegUserEMail(String Username, String eMail) {
		Session session = factory.getCurrentSession();
		RegUser user = (RegUser)session.load(RegUser.class, Username);
		if(user!=null){
			user.setEmail(eMail);
			session.update(user);
		}
	}

	@Override
	public void updateRegUserRegisteredSince(String Username, Date Date) {
		Session session = factory.getCurrentSession();
		RegUser user = (RegUser)session.load(RegUser.class, Username);
		if(user!=null){
			//TODO
		}
	}

	@Override
	public void updateRegUserSchool(String Username, String School) {
		Session session = factory.getCurrentSession();
		RegUser user = (RegUser)session.load(RegUser.class, Username);
		if(user!=null){
			user.setSchool(School);
			session.update(user);
		}		
	}

	@Override
	public void deleteRegUser(String Username) {
		Session session = factory.getCurrentSession();
		RegUser user = (RegUser)session.load(RegUser.class, Username);
		if(user!=null)
			session.delete(user);
	}

	
}