package study_easy.sharedAttributes;

import javax.persistence.*;

@MappedSuperclass
public abstract class Pinnwall {
	
	
	@Column
	public boolean pinnBanned = false;


}