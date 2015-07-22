package study_easy.sharedAttributes;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

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
	}

	private Set<PinnwallElement> getEntries() {
		return this.entries;
	}

}