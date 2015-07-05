package groupFunctions;

import javax.persistence.Entity;

@Entity
public class TestElement {

	private Subject subject;
	private String task;
	private String answer;
	
	public TestElement(Subject subject, String task, String answer){
		this.subject = subject;
		this.task = task;
		this.answer = answer;
	}
	
}
