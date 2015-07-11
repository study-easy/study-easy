package sharedAttributes;

import java.util.ArrayList;

public abstract class Pinnwall {
	
	private ArrayList<PinnwallElement> entries = new ArrayList<PinnwallElement>();
	private boolean banned = false;

	public ArrayList<PinnwallElement> getEntries() {
		return entries;
	}

	public void addEntrie(PinnwallElement entry) {
		entries.add(entry);
	}
	
	public void deleteEntry() {
		
	}
	
	public boolean getBanned(){
		return this.banned;
	}
	
	public void setBanned(boolean ban){
		this.banned = ban;
	}

}