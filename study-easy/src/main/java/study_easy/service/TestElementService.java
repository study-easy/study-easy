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

	public void updateTestElementTask(int id, String task) {
		tedao.updateTestElementTask(id, task);
		
	}

	public void deleteTestElement(int id) {
		tedao.deleteTestElement(id);
		
	}


}
