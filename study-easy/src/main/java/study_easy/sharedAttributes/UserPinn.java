package study_easy.sharedAttributes;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "UserPinn")
public class UserPinn extends Pinnwall {

	@Id
	@Column
	private String owner;
	@ElementCollection
	private Set<PinnwallElement> entries = new HashSet<PinnwallElement>();

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public void addEntry(PinnwallElement entry) {
		this.getEntries().add(entry);
	}

	private Set<PinnwallElement> getEntries() {
		return this.entries;
	}

	public boolean getBanned(){
		return this.banned;
	}
	
	public void setBanned(boolean ban){
		this.banned = ban;
	}
}
