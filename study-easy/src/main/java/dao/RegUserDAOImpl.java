package dao;

import java.util.*;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import users.RegUser;
import org.hibernate.SessionFactory;

@Repository
@Transactional
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
		return null;
		
	}
	
	@Override
	public void updateRegUserXP(String Username, int xpPoints){
		
	}
	
	@Override
	public void deleteRegUser(String Username){
		
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