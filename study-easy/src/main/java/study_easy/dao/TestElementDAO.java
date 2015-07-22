package study_easy.dao;

import java.util.List;

import study_easy.groupFunctions.TestElement;

public interface TestElementDAO {
	
	public void addTestElement(TestElement element);
	public List<TestElement> listTestElement();
	public void updateTestElement(TestElement element);
	public void deleteTestElement(TestElement id);

}
