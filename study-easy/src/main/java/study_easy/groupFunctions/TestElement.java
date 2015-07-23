package study_easy.groupFunctions;

import javax.persistence.*;

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
	Boolean check;
	Boolean check2;
	Boolean check3;
	Boolean check4;
	public void setCheck(Boolean check) {
		this.check = check;
	}

	public Boolean getCheck() {
		return check;
	}
	public void setCheck2(Boolean check2) {
		this.check2 = check2;
	}

	public Boolean getCheck2() {
		return check2;
	}
	public void setCheck3(Boolean check3) {
		this.check3 = check3;
	}

	public Boolean getCheck3() {
		return check3;
	}
	public void setCheck4(Boolean check4) {
		this.check4 = check4;
	}

	public Boolean getCheck4() {
		return check4;
	}
	
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