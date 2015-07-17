package sharedAttributes;

import javax.persistence.*;

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
