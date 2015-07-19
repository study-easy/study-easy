package sharedAttributes;

import java.util.ArrayList;

import javax.persistence.*;

@MappedSuperclass
public abstract class Pinnwall {
	
	@OneToMany
	private ArrayList<PinnwallElement> entries = new ArrayList<PinnwallElement>();
	public boolean banned = false;

	public ArrayList<PinnwallElement> getEntries() {
		return entries;
	}
	
	public void deleteEntry() {
		
	}

}