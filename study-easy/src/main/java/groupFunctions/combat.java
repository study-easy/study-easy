package groupFunctions;

import javax.persistence.Entity;

@Entity
public class Combat {
	
	
	private Test test;
	private Group challenger;
	private Group opponent;
	private Group corrector;
	
	public Combat(Group challenger, Group opponent, Group corrector){
		this.challenger = challenger;
		this.opponent = opponent;
		this.corrector = corrector;
		this.challenger.getCurrentCombats().add(this);
		this.opponent.getCurrentCombats().add(this);
		this.corrector.getCurrentCombats().add(this);
	}
	
	public Test getTest(){
		return this.test;
	}

}
