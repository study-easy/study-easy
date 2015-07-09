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

}
