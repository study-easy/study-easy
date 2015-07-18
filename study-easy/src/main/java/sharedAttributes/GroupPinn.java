package sharedAttributes;

import java.util.ArrayList;

import javax.persistence.*;

import service.GroupPinnServiceImpl;
import service.UserPinnServiceImpl;

@Entity
public class GroupPinn extends Pinnwall {

	@Id
	private String owner;
	@OneToMany
	private ArrayList<HistoryElement> history = new ArrayList<HistoryElement>();

	public void addHistoryElement(HistoryElement element) {
		history.add(element);
		GroupPinnServiceImpl GPS = new GroupPinnServiceImpl();
		GPS.updateGroupPinnHistory(this.owner, this.history);
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

	public void addEntrie(PinnwallElement entry) {
		this.getEntries().add(entry);
		GroupPinnServiceImpl GPS = new GroupPinnServiceImpl();
		GPS.updateGroupPinnEntries(this.owner, this.getEntries());
	}

}