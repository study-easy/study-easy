package study_easy.service;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import study_easy.dao.TestDAOImpl;
import study_easy.groupFunctions.Group;
import study_easy.groupFunctions.Test;
import study_easy.groupFunctions.TestElement;

@Service
@Transactional
public class TestService{

	@Autowired
	private TestDAOImpl tdao;
	
	public void addTest(Test test) {
		tdao.addTest(test);
		
	}

	public List<Test> listTest() {
		return tdao.listTest();
	}

	public void updateTestTime(Test test){
		tdao.updateTestTime(test);
	}

	public void deleteTest(Test test) {
		tdao.deleteTest(test);
		
	}

}
