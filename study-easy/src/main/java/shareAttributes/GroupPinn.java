package shareAttributes;

import java.util.ArrayList;
import groupFunctions.Group;

public class GroupPinn extends Pinnwall {

	private Group owner;
	private ArrayList<HistoryElement> history = new ArrayList<HistoryElement>();

	public void addHistoryElement(HistoryElement element) {
		history.add(element);
	}

	public ArrayList<HistoryElement> getHistory() {
		return history;
	}

	public void setOwner(Group group) {
		this.owner = group;
	}

	public Group getOwner() {
		return owner;
	}

}
