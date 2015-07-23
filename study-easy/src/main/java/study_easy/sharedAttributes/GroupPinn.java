package study_easy.sharedAttributes;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class GroupPinn extends Pinnwall {

	@Id@GeneratedValue
	private int id;
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

	public void addEntrie(PinnwallElement entry) {
		this.getEntries().add(entry);
	}

	private Set<PinnwallElement> getEntries() {
		return this.entries;
	}
	
	public int getId(){
		return this.id;
	}

}