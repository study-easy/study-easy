package study_easy.sharedAttributes;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Embeddable
public class UserPinn extends Pinnwall {

	
	@ElementCollection
	private Set<PinnwallElement> entries = new HashSet<PinnwallElement>();

//	public String getOwner() {
//		return owner;
//	}

//	public void setOwner(String owner) {
//		this.owner = owner;
//	}

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
}
