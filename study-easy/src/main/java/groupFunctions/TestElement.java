package groupFunctions;

import javax.persistence.*;

@Entity
public class TestElement {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	@Column(name = "subject")
	private Subject subject;
	@Column(name = "task")
	private String task;
	@Column(name = "rightAnswer")
	private String rightAnswer;
	@Column(name = "wrongAnswer1")
	private String wrongAnswer1;
	@Column(name = "wongAnswer2")
	private String wrongAnswer2;
	@Column(name = "wrongAnswer3")
	private String wrongAnswer3;
	
	@Column(name = "points")
	private int points;
	
	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
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
	}

	public String getWrongAnswer1() {
		return wrongAnswer1;
	}

	public void setWrongAnswer1(String wrongAnswer1) {
		this.wrongAnswer1 = wrongAnswer1;
	}

	public String getWrongAnswer2() {
		return wrongAnswer2;
	}

	public void setWrongAnswer2(String wrongAnswer2) {
		this.wrongAnswer2 = wrongAnswer2;
	}

	public String getWrongAnswer3() {
		return wrongAnswer3;
	}

	public void setWrongAnswer3(String wrongAnswer3) {
		this.wrongAnswer3 = wrongAnswer3;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public TestElement(){}

}