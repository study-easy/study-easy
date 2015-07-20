package study_easy.service;

import java.util.HashSet;
import java.util.List;

import study_easy.groupFunctions.Group;
import study_easy.groupFunctions.Test;
import study_easy.groupFunctions.TestElement;

public interface TestService {

	public void addTest(Test test);
	public List<Test> listTest();
	public void updateTestTime(int id, float time);
	public void updateTestCreator(int id, Group group);
	public void updateTestElements(int id, HashSet<TestElement> tests);
	public void deleteTest(int id);
	
}
