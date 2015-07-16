package sharedAttributes;

import javax.persistence.*;

import users.User;

@Entity
public class UserPinn extends Pinnwall {

	@Id
	private User owner;

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

}
