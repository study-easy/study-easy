package study_easy.groupFunctions;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import study_easy.service.TestServiceImpl;

=======
>>>>>>> origin/ConnorsVerzweiflungsBranch
@Entity
@Component
public class Test {

	@Id
	@GeneratedValue
	@Column
	private int id;
	@Column
	private float time;
	@ElementCollection
	private Set<TestElement> tasks;
	@OneToOne
	private Group creator;
	@Autowired
	private static TestServiceImpl TS;

	public int getId() {
		return id;
	}

	public Group getCreator() {
		return creator;
	}

	public void setCreator(Group creator) {
		this.creator = creator;
<<<<<<< HEAD
		TS.updateTestCreator(this.id, this.creator);
=======
>>>>>>> origin/ConnorsVerzweiflungsBranch
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTasks(HashSet<TestElement> tasks) {
		this.tasks = tasks;
<<<<<<< HEAD
		//TS.updateTestElements(this.id, this.tasks);
=======
>>>>>>> origin/ConnorsVerzweiflungsBranch
	}

	public float getTime() {
		return time;
	}

	public void setTime(float time) {
		this.time = time;
<<<<<<< HEAD
		TS.updateTestTime(this.id, this.time);
=======
>>>>>>> origin/ConnorsVerzweiflungsBranch
	}

	public Set<TestElement> getTasks() {
		return tasks;
	}

}