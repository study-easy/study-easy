package study_easy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import study_easy.dao.TestElementDAOImpl;
import study_easy.groupFunctions.TestElement;

@Service
@Transactional
public class TestElementService{

	@Autowired
	private TestElementDAOImpl tedao;
	
	
	public void addTestElement(TestElement element) {
		tedao.addTestElement(element);
		
	}

	public List<TestElement> listTestElement() {
		return tedao.listTestElement();
	}

	public void updateTestElement(TestElement element) {
		tedao.updateTestElement(element);
		
	}

	public void deleteTestElement(TestElement id) {
		tedao.deleteTestElement(id);
		
	}
	
	public TestElement getThisElement(int id){
		return null;
		//TODO
		
	}


}
