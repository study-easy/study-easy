package study_easy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import study_easy.dao.TestElementDAO;
import study_easy.dao.TestElementDAOImpl;
import study_easy.groupFunctions.Subject;
import study_easy.groupFunctions.TestElement;

@Service
@Transactional
public class TestElementServiceImpl implements TestElementService{

	@Autowired
	private TestElementDAOImpl tedao;
	
	@Override
	public void addTestElement(TestElement element) {
		tedao.addTestElement(element);
		
	}

	@Override
	public List<TestElement> listTestElement() {
		return tedao.listTestElement();
	}

	@Override
	public void updateTestElementTask(int id, String task) {
		tedao.updateTestElementTask(id, task);
		
	}

	@Override
	public void updateTestElementAnswer(int id, String answer) {
		tedao.updateTestElementAnswer(id, answer);
		
	}

	@Override
	public void updateTestElementWrongAnswer1(int id, String wrongAnswer1) {
		tedao.updateTestElementWrongAnswer1(id, wrongAnswer1);
		
	}

	@Override
	public void updateTestElementWrongAnswer2(int id, String wrongAnswer2) {
		tedao.updateTestElementWrongAnswer2(id, wrongAnswer2);
		
	}

	@Override
	public void updateTestElementWrongAnswer3(int id, String wrongAnswer3) {
		tedao.updateTestElementWrongAnswer3(id, wrongAnswer3);
		
	}

	@Override
	public void updateTestSubject(int id, Subject subject) {
		tedao.updateTestSubject(id, subject);
		
	}

	@Override
	public void deleteTestElement(int id) {
		tedao.deleteTestElement(id);
		
	}

}
