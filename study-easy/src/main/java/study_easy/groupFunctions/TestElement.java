package study_easy.groupFunctions;

import javax.persistence.*;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import study_easy.service.TestElementServiceImpl;

=======
>>>>>>> origin/ConnorsVerzweiflungsBranch
@Entity
@Table(name = "TestElement")
@Embeddable
@Component
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
	@Autowired
	private static TestElementServiceImpl TES;
	
	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
<<<<<<< HEAD
		TES.updateTestSubject(this.id, this.subject);
=======
>>>>>>> origin/ConnorsVerzweiflungsBranch
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
<<<<<<< HEAD
		TES.updateTestElementTask(this.id, this.task);
=======
>>>>>>> origin/ConnorsVerzweiflungsBranch
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
<<<<<<< HEAD
		TES.updateTestElementAnswer(this.id, this.rightAnswer);
=======
>>>>>>> origin/ConnorsVerzweiflungsBranch
	}

	public String getWrongAnswer1() {
		return wrongAnswer1;
	}

	public void setWrongAnswer1(String wrongAnswer1) {
		this.wrongAnswer1 = wrongAnswer1;
<<<<<<< HEAD
		TES.updateTestElementWrongAnswer1(this.id, this.wrongAnswer1);
=======
>>>>>>> origin/ConnorsVerzweiflungsBranch
	}

	public String getWrongAnswer2() {
		return wrongAnswer2;
	}

	public void setWrongAnswer2(String wrongAnswer2) {
		this.wrongAnswer2 = wrongAnswer2;
<<<<<<< HEAD
		TES.updateTestElementWrongAnswer2(this.id, this.wrongAnswer2);
=======
>>>>>>> origin/ConnorsVerzweiflungsBranch
	}

	public String getWrongAnswer3() {
		return wrongAnswer3;
	}

	public void setWrongAnswer3(String wrongAnswer3) {
		this.wrongAnswer3 = wrongAnswer3;
<<<<<<< HEAD
		TES.updateTestElementWrongAnswer3(this.id, this.wrongAnswer3);
=======
>>>>>>> origin/ConnorsVerzweiflungsBranch
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
		//TODO
		}

	public TestElement(){}

}