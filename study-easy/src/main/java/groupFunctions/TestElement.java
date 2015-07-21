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
	@Column(name = "answer")
	private String answer;
	@Column(name = "points")
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

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public TestElement(){}
	
	public TestElement(Subject subject, String task, String answer, int points){
		this.subject = subject;
		this.task = task;
		this.answer = answer;
		this.points = points;
	}

}