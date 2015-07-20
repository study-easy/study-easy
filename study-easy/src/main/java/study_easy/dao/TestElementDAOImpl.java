package study_easy.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import study_easy.groupFunctions.Subject;
import study_easy.groupFunctions.TestElement;

@Repository
@Transactional
public class TestElementDAOImpl implements TestElementDAO {

	@Autowired
	private SessionFactory factory;

	@Override
	public void addTestElement(TestElement tElement) {
		Session session = factory.getCurrentSession();
		session.save(tElement);

	}

	@Override
	public List<TestElement> listTestElement() {
		Session session = factory.getCurrentSession();
		List<TestElement> list = session.createQuery("from TestElement").list();
		return list;
	}

	@Override
	public void updateTestElementTask(int id, String task) {
		Session session = factory.getCurrentSession();
		TestElement element = (TestElement) session.load(TestElement.class, id);
		if (element != null) {
			element.setTask(task);
			session.update(element);
		}
	}

	@Override
	public void updateTestElementAnswer(int id, String answer) {
		Session session = factory.getCurrentSession();
		TestElement element = (TestElement) session.load(TestElement.class, id);
		if (element != null) {
			element.setRightAnswer(answer);
			session.update(element);
		}
	}

	@Override
	public void updateTestElementWrongAnswer1(int id, String wrongAnswer1) {
		Session session = factory.getCurrentSession();
		TestElement element = (TestElement) session.load(TestElement.class, id);
		if (element != null) {
			element.setWrongAnswer1(wrongAnswer1);
			session.update(element);
		}
	}

	@Override
	public void updateTestElementWrongAnswer2(int id, String wrongAnswer2) {
		Session session = factory.getCurrentSession();
		TestElement element = (TestElement) session.load(TestElement.class, id);
		if (element != null) {
			element.setWrongAnswer2(wrongAnswer2);
			session.update(element);
		}
	}

	@Override
	public void updateTestElementWrongAnswer3(int id, String wrongAnswer3) {
		Session session = factory.getCurrentSession();
		TestElement element = (TestElement) session.load(TestElement.class, id);
		if (element != null) {
			element.setWrongAnswer3(wrongAnswer3);
			session.update(element);
		}
	}

	@Override
	public void updateTestSubject(int id, Subject subject) {
		Session session = factory.getCurrentSession();
		TestElement element = (TestElement) session.load(TestElement.class, id);
		if (element != null) {
			element.setSubject(subject);
			session.update(element);
		}
	}

	@Override
	public void deleteTestElement(int id) {
		Session session = factory.getCurrentSession();
		TestElement element = (TestElement) session.load(TestElement.class, id);
		if (element != null)
			session.delete(element);
	}

	@Override
	public void updateTestSubjectPoints(int id, int points) {
		Session session = factory.getCurrentSession();
		TestElement element = (TestElement) session.load(TestElement.class, id);
		if (element != null) {
			element.setPoints(points);
			session.update(element);
		}
	}

}
