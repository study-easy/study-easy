package study_easy.groupFunctions;

import javax.persistence.*;

import study_easy.service.TestElementServiceImpl;

@Entity
@Table(name = "TestElement")
@Embeddable
public class TestElement {

	@Id
	@GeneratedValue
	@Column
	private int id;
	@Column
	private Subject subject;
	@Column
	private String task;
	@Column
	private String rightAnswer;
	@Column
	private String wrongAnswer1;
	@Column
	private String wrongAnswer2;
	@Column
	private String wrongAnswer3;
	@Column
	private int points;
	
	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
		TestElementServiceImpl TES = new TestElementServiceImpl();
		TES.updateTestSubject(this.id, this.subject);
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
		TestElementServiceImpl TES = new TestElementServiceImpl();
		TES.updateTestElementTask(this.id, this.task);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRightAnswer() {
		return rightAnswer;
	}

	public void setRightAnswer(String rightAnswer) {
		this.rightAnswer = rightAnswer;
		TestElementServiceImpl TES = new TestElementServiceImpl();
		TES.updateTestElementAnswer(this.id, this.rightAnswer);
	}

	public String getWrongAnswer1() {
		return wrongAnswer1;
	}

	public void setWrongAnswer1(String wrongAnswer1) {
		this.wrongAnswer1 = wrongAnswer1;
		TestElementServiceImpl TES = new TestElementServiceImpl();
		TES.updateTestElementWrongAnswer1(this.id, this.wrongAnswer1);
	}

	public String getWrongAnswer2() {
		return wrongAnswer2;
	}

	public void setWrongAnswer2(String wrongAnswer2) {
		this.wrongAnswer2 = wrongAnswer2;
		TestElementServiceImpl TES = new TestElementServiceImpl();
		TES.updateTestElementWrongAnswer2(this.id, this.wrongAnswer2);
	}

	public String getWrongAnswer3() {
		return wrongAnswer3;
	}

	public void setWrongAnswer3(String wrongAnswer3) {
		this.wrongAnswer3 = wrongAnswer3;
		TestElementServiceImpl TES = new TestElementServiceImpl();
		TES.updateTestElementWrongAnswer3(this.id, this.wrongAnswer3);
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public TestElement(){}

}