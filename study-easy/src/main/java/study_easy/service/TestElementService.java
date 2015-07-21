package study_easy.service;

import java.util.List;

import study_easy.groupFunctions.Subject;
import study_easy.groupFunctions.TestElement;

public interface TestElementService {

	public void addTestElement(TestElement element);
	public List<TestElement> listTestElement();
	public void updateTestElementTask(int id, String task);
	public void updateTestElementAnswer(int id, String answer);
	public void updateTestElementWrongAnswer1(int id, String wrongAnswer1);
	public void updateTestElementWrongAnswer2(int id, String wrongAnswer2);
	public void updateTestElementWrongAnswer3(int id, String wrongAnswer3);
	public void updateTestSubject(int id, Subject subject);
	public void deleteTestElement(int id);
	
}
