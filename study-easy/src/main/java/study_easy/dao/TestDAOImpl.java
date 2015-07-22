package study_easy.dao;

import java.util.HashSet;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import study_easy.groupFunctions.Group;
import study_easy.groupFunctions.Test;
import study_easy.groupFunctions.TestElement;

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
		List<Test> list = session.createQuery("from Test").list();
		return list;
	}

	@Override
	public void updateTestTime(int id, float time) {
		Session session = factory.getCurrentSession();
		Test test = (Test) session.load(Test.class, id);
		if(test!=null){
			test.setTime(time);
			session.update(test);
		}
	}

	@Override
	public void updateTestCreator(int id, Group group) {
		Session session = factory.getCurrentSession();
		Test test = (Test) session.load(Test.class, id);
		if(test!=null){
			test.setCreator(group);
			session.update(test);
		}
	}

	@Override
	public void updateTestElements(int id, HashSet<TestElement> tests) {
		Session session = factory.getCurrentSession();
		Test test = (Test) session.load(Test.class, id);
		if(test!=null){
			test.setTasks(tests);
			session.update(test);
		}
	}

	@Override
	public void deleteTest(int id) {
		Session session = factory.getCurrentSession();
		Test test = (Test) session.load(Test.class, id);
		if(test!=null)
			session.delete(test);
	}

}
