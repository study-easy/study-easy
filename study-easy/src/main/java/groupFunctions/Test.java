package groupFunctions;

import javax.persistence.*;

@Entity
public class Test {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	@Column(name = "time")
	private float time;
	@Column(name = "tasks")
	private TestElement[] tasks;

	public int getId() {
		return id;
	}

	public float getTime() {
		return time;
	}

	public void setTime(float time) {
		this.time = time;
	}

	public TestElement[] getTasks() {
		return tasks;
	}

}
