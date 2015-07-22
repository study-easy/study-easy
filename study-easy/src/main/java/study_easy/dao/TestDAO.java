package study_easy.dao;

import java.util.List;

import study_easy.groupFunctions.Test;

public interface TestDAO {
	
	public void addTest(Test test);
	public List<Test> listTest();
	public void updateTestTime(Test test);
	public void deleteTest(Test test);

}
