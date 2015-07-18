package groupFunctions;

import java.util.ArrayList;

import javax.persistence.*;

import service.TestServiceImpl;

@Entity
public class Test {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	@Column(name = "time")
	private float time;
	@Column(name = "tasks")
	private ArrayList<TestElement> tasks;
	@Column(name = "creator")
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

	public void setTasks(ArrayList<TestElement> tasks) {
		this.tasks = tasks;
		TestServiceImpl TS = new TestServiceImpl();
		TS.updateTestElements(this.id, this.tasks);
	}

	public float getTime() {
		return time;
	}

	public void setTime(float time) {
		this.time = time;
		TestServiceImpl TS = new TestServiceImpl();
		TS.updateTestTime(this.id, this.time);
	}

	public ArrayList<TestElement> getTasks() {
		return tasks;
	}

	
}