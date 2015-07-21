package study_easy.sharedAttributes;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import study_easy.service.BadgeConditionServiceImpl;
import study_easy.service.GroupPinnServiceImpl;

@Entity
@Table(name = "GroupPinn")
@Component
public class GroupPinn extends Pinnwall {

	@Id
	@Column
	private String owner;
	@ElementCollection
	private Set<PinnwallElement> entries = new HashSet<PinnwallElement>();
	@ElementCollection
	private Set<HistoryElement> history = new HashSet<HistoryElement>();
	@Autowired
	private static GroupPinnServiceImpl GPS;

	public void addHistoryElement(HistoryElement element) {
		this.history.add(element);
		GPS.updateGroupPinnHistory(this.owner, element);
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
		GPS.updateGroupPinnEntries(this.owner, entry);
	}

	private Set<PinnwallElement> getEntries() {
		// TODO Auto-generated method stub
		return null;
	}

}