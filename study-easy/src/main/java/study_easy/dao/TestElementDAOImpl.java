package study_easy.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import study_easy.groupFunctions.TestElement;

@Repository
public class TestElementDAOImpl implements TestElementDAO{

	@Autowired
	private SessionFactory factory;
	
	@Override
	public void addTestElement(TestElement element) {
		factory.getCurrentSession().save(element);
	}

	@Override
	public List<TestElement> listTestElement() {
		Session session = factory.getCurrentSession();
		List<TestElement> list = session.createQuery("from TestElement").list();
		return list;
	}

	@Override
	public void deleteTestElement(TestElement id) {
		factory.getCurrentSession().delete(id);
	}

	@Override
	public void updateTestElement(TestElement element) {
		factory.getCurrentSession().update(element);
	}

}
