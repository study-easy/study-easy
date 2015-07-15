package dao;

import java.util.List;

import groupFunctions.Group;
import groupFunctions.Test;
import groupFunctions.TestElement;

public interface TestDAO {
	
	public void addTest(Test test);
	public List<Test> listTest();
	public void updateTestTime(int id, float time);
	public void updateTestCreator(int id, Group group);
	public void updateTestElements(int id, List<TestElement> tests);

}
