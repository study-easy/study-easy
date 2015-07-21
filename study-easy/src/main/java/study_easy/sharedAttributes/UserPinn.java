package study_easy.sharedAttributes;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import study_easy.service.UserPinnServiceImpl;

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
		UPS.updateUserPinnEntries(this.owner, entry);
	}

	private Set<PinnwallElement> getEntries() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean getBanned(){
		return this.banned;
	}
	
	public void setBanned(boolean ban){
		this.banned = ban;
		UPS.updateUserPinnBan(this.owner, this.banned);
	}
}
