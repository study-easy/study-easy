package sharedAttributes;

import javax.persistence.*;

import service.UserPinnServiceImpl;

@Entity
public class UserPinn extends Pinnwall {

	@Id
	private String owner;

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public void addEntry(PinnwallElement entry) {
		this.getEntries().add(entry);
		UserPinnServiceImpl UPS = new UserPinnServiceImpl();
		UPS.updateUserPinnEntries(this.owner, this.getEntries());
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
