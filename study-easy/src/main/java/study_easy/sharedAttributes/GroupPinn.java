package study_easy.sharedAttributes;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import study_easy.service.GroupPinnServiceImpl;

=======
>>>>>>> origin/ConnorsVerzweiflungsBranch
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
<<<<<<< HEAD
		GPS.updateGroupPinnHistory(this.owner, element);
=======
>>>>>>> origin/ConnorsVerzweiflungsBranch
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
<<<<<<< HEAD
		GPS.updateGroupPinnEntries(this.owner, entry);
=======
>>>>>>> origin/ConnorsVerzweiflungsBranch
	}

	private Set<PinnwallElement> getEntries() {
		return this.entries;
	}

}