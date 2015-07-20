package study_easy.sharedAttributes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import study_easy.service.UserPinnServiceImpl;

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
		UserPinnServiceImpl UPS = new UserPinnServiceImpl();
		//UPS.updateUserPinnEntries(this.owner, this.getEntries());
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
		UserPinnServiceImpl UPS = new UserPinnServiceImpl();
		UPS.updateUserPinnBan(this.owner, this.banned);
	}
}
