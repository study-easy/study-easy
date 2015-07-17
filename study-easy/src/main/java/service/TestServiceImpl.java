package service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import dao.TestDAOImpl;
import groupFunctions.Group;
import groupFunctions.Test;
import groupFunctions.TestElement;

@Service
public class TestServiceImpl implements TestService{

	TestDAOImpl tdao = new TestDAOImpl();
	
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
	public void updateTestElements(int id, ArrayList<TestElement> tests) {
		tdao.updateTestElements(id, tests);
		
	}

	@Override
	public void deleteTest(int id) {
		tdao.deleteTest(id);
		
	}

}
