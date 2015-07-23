package study_easy.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import study_easy.groupFunctions.Test;

@Repository
public class TestDAOImpl implements TestDAO{

	@Autowired
	private SessionFactory factory;
	
	@Override
	public void addTest(Test test) {
		Session session = factory.getCurrentSession();
		session.save(test);
	}

	@Override
	public List<Test> listTest() {
		Session session = factory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Test> list = session.createQuery("from Test").list();
		return list;
	}

	@Override
	public void deleteTest(Test test) {
		factory.getCurrentSession().delete(test);
	}

	@Override
	public void updateTestTime(Test test) {
		factory.getCurrentSession().update(test);
	}

}
