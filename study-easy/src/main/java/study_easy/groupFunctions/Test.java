package study_easy.groupFunctions;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

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
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTasks(HashSet<TestElement> tasks) {
		this.tasks = tasks;
	}

	public float getTime() {
		return time;
	}

	public void setTime(float time) {
		this.time = time;
	}

	public Set<TestElement> getTasks() {
		return tasks;
	}

}