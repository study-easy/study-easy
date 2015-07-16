package sharedAttributes;

import javax.persistence.*;

import users.User;

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

}
