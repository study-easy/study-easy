package study_easy.service;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study_easy.dao.TestDAOImpl;
import study_easy.groupFunctions.Group;
import study_easy.groupFunctions.Test;
import study_easy.groupFunctions.TestElement;

@Service
public class TestServiceImpl implements TestService{

	@Autowired
	private TestDAOImpl tdao;
	
	@Override
	public void addTest(Test test) {
		tdao.addTest(test);
		
	}

	@Override
	public List<Test> listTest() {
		return tdao.listTest();
	}

	@Override
	public void updateTestTime(int id, float time) {
		tdao.updateTestTime(id, time);
		
	}

	@Override
	public void updateTestCreator(int id, Group group) {
		tdao.updateTestCreator(id, group);
		
	}

	@Override
	public void updateTestElements(int id, HashSet<TestElement> tests) {
		tdao.updateTestElements(id, tests);
		
	}

	@Override
	public void deleteTest(int id) {
		tdao.deleteTest(id);
		
	}

}
