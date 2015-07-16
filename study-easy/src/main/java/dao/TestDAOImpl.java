package dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import groupFunctions.Group;
import groupFunctions.Test;
import groupFunctions.TestElement;

@Repository
@Transactional
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
		List<Test> list = session.createQuery("from Test").list();
		return list;
	}

	@Override
	public void updateTestTime(int id, float time) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTestCreator(int id, Group group) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTestElements(int id, List<TestElement> tests) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTest(int id) {
		Session session = factory.getCurrentSession();
		Test test = (Test) session.load(Test.class, id);
		if(test!=null)
			session.delete(test);
	}

}
