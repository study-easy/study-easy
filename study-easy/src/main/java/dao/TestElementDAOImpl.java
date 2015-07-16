package dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import groupFunctions.Subject;
import groupFunctions.TestElement;

@Repository
@Transactional
public class TestElementDAOImpl implements TestElementDAO{

	@Autowired
	private SessionFactory factory;
	
	@Override
	public void addTestElement(TestElement element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TestElement> listTestElement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateTestElementTask(int id, String task) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTestElementAnswer(int id, String answer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTestElementWrongAnswer1(int id, String wrongAnswer1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTestElementWrongAnswer2(int id, String wrongAnswer2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTestElementWrongAnswer3(int id, String wrongAnswer3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTestSubject(int id, Subject subject) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTestElement(int id) {
		Session session = factory.getCurrentSession();
		TestElement element = (TestElement) session.load(TestElement.class, id);
		if(element!=null)
			session.delete(element);
	}

}
