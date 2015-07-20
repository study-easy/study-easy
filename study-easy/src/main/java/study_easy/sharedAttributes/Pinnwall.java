package study_easy.sharedAttributes;

import java.util.ArrayList;

import javax.persistence.*;

@MappedSuperclass
public abstract class Pinnwall {
	
	
	@Column
	public boolean banned = false;


}