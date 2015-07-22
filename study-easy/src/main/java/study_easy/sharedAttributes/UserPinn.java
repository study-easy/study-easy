package study_easy.sharedAttributes;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import study_easy.service.UserPinnServiceImpl;

=======
>>>>>>> origin/ConnorsVerzweiflungsBranch
@Entity
@Table(name = "UserPinn")
@Component
public class UserPinn extends Pinnwall {

	@Id
	@Column
	private String owner;
	@ElementCollection
	private Set<PinnwallElement> entries = new HashSet<PinnwallElement>();
	@Autowired
	private static UserPinnServiceImpl UPS;

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public void addEntry(PinnwallElement entry) {
		this.getEntries().add(entry);
<<<<<<< HEAD
		UPS.updateUserPinnEntries(this.owner, entry);
=======
>>>>>>> origin/ConnorsVerzweiflungsBranch
	}

	private Set<PinnwallElement> getEntries() {
		return this.entries;
	}

	public boolean getBanned(){
		return this.banned;
	}
	
	public void setBanned(boolean ban){
		this.banned = ban;
<<<<<<< HEAD
		UPS.updateUserPinnBan(this.owner, this.banned);
=======
>>>>>>> origin/ConnorsVerzweiflungsBranch
	}
}
