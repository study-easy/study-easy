package study_easy.sharedAttributes;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class UserPinn extends Pinnwall {

	@Id@GeneratedValue
	private int id;
	@ElementCollection
	private Set<PinnwallElement> entries = new HashSet<PinnwallElement>();


	public void addEntry(PinnwallElement entry) {
		this.getEntries().add(entry);
	}

	private Set<PinnwallElement> getEntries() {
		return this.entries;
	}

	public boolean getBanned(){
		return this.pinnBanned;
	}
	
	public void setBanned(boolean ban){
		this.pinnBanned = ban;
	}
	
	public int getId(){
		return this.id;
	}
}
