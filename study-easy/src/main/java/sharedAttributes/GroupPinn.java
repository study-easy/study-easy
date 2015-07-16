package sharedAttributes;

import java.util.ArrayList;

import javax.persistence.*;

import groupFunctions.Group;

@Entity
public class GroupPinn extends Pinnwall {

	@Id
	private String owner;
	private ArrayList<HistoryElement> history = new ArrayList<HistoryElement>();

	public void addHistoryElement(HistoryElement element) {
		history.add(element);
	}

	public ArrayList<HistoryElement> getHistory() {
		return history;
	}

	public void setOwner(String group) {
		this.owner = group;
	}

	public String getOwner() {
		return owner;
	}

}