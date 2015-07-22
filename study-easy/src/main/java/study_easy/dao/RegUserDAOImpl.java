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
	
	public RegUserDAOImpl(){
		
	}

	@Override
	public void addRegUser(RegUser user) {
		Session session = factory.getCurrentSession();
		session.save(user);
	}	
		
	@Override
	public List<RegUser> listRegUsers(){
		Session session = factory.getCurrentSession();
		List<RegUser> list = session.createQuery("from RegUser").list();
		return list;
		
	}

	@Override
	public void deleteRegUser(String Username) {
		Session session = factory.getCurrentSession();
		RegUser user = (RegUser)session.load(RegUser.class, Username);
		if(user!=null)
			session.delete(user);
	}

	@Override
	public void updateRegUser(RegUser user) {
		factory.getCurrentSession().update(user);
	}

	
}