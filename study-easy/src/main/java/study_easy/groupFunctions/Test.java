package study_easy.groupFunctions;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import study_easy.service.TestServiceImpl;

@Entity
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

	public int getId() {
		return id;
	}

	public Group getCreator() {
		return creator;
	}

	public void setCreator(Group creator) {
		this.creator = creator;
		TestServiceImpl TS = new TestServiceImpl();
		TS.updateTestCreator(this.id, this.creator);
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTasks(HashSet<TestElement> tasks) {
		this.tasks = tasks;
		TestServiceImpl TS = new TestServiceImpl();
		//TS.updateTestElements(this.id, this.tasks);
	}

	public float getTime() {
		return time;
	}

	public void setTime(float time) {
		this.time = time;
		TestServiceImpl TS = new TestServiceImpl();
		TS.updateTestTime(this.id, this.time);
	}

	public Set<TestElement> getTasks() {
		return tasks;
	}

}