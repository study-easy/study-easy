package groupFunctions;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Test {
	
	@Id @GeneratedValue
	private int id;
	private float time;
	private ArrayList<TestElement> tasks = new ArrayList<TestElement>();
	
	public int getId() {
		return id;
	}
	
	public ArrayList<TestElement> getTasks() {
		return tasks;
	}
	
	public void addTasks(TestElement task){
		this.tasks.add(task);
	}
	
	
	
	
}
