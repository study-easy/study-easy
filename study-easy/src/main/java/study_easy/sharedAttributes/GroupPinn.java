package study_easy.sharedAttributes;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import study_easy.service.BadgeConditionServiceImpl;
import study_easy.service.GroupPinnServiceImpl;

@Entity
@Table(name = "GroupPinn")
public class GroupPinn extends Pinnwall {

	@Id
	@Column
	private String owner;
	@ElementCollection
	private Set<PinnwallElement> entries = new HashSet<PinnwallElement>();
	@ElementCollection
	private Set<HistoryElement> history = new HashSet<HistoryElement>();

	public void addHistoryElement(HistoryElement element) {
		this.history.add(element);
		GroupPinnServiceImpl GPS = new GroupPinnServiceImpl();
		//TODO speichern
	}

	public Set<HistoryElement> getHistory() {
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
		//GPS.updateGroupPinnEntries(this.owner, entry);
	}

	private Set<PinnwallElement> getEntries() {
		// TODO Auto-generated method stub
		return null;
	}

}