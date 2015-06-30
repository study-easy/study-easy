package sharedAttributes;

import java.util.ArrayList;

public class Pinnwall {
	
	private ArrayList<PinnwallElement> entries = new ArrayList<PinnwallElement>();

	public ArrayList<PinnwallElement> getEntries() {
		return entries;
	}

	public void addEntrie(PinnwallElement entrie) {
		entries.add(entrie);
	}
	
	public void deleteEntrie() {
		
	}
	

}
