package groupFunctions;

import javax.persistence.*;

import service.CombatServiceImpl;
import service.GroupServiceImpl;

@Entity
public class Combat {

	@GeneratedValue
	@Id
	private int id;
	private Test test;
	private Group challenger;
	private Group opponent;
	private Group corrector;
	

	public Combat() {
	}

	public Combat(Group challenger, Group opponent, Group corrector) {
		this.challenger = challenger;
		this.opponent = opponent;
		this.corrector = corrector;
		this.challenger.getCurrentCombats().add(this);
		this.opponent.getCurrentCombats().add(this);
		this.corrector.getCurrentCombats().add(this);

		CombatServiceImpl CS = new CombatServiceImpl();
		CS.addCombat(this);
		GroupServiceImpl GS = new GroupServiceImpl();
		GS.updateGroupCurrentCombats(this.challenger.getName(), this.challenger.getCurrentCombats());
		GS.updateGroupCurrentCombats(this.opponent.getName(), this.opponent.getCurrentCombats());
		GS.updateGroupCurrentCombats(this.corrector.getName(), this.corrector.getCurrentCombats());
	}

	public void addTest(Group corrector, Test test) {
		if (this.corrector == corrector && this.test != null) {
			this.test = test;
			CombatServiceImpl CS = new CombatServiceImpl();
			CS.updateCombatTest(this.id, test);
		}
	}

	public Test getTest() {
		return this.test;
	}

	public Group getChallenger() {
		return challenger;
	}

	public void setChallenger(Group challenger) {
		this.challenger = challenger;
		CombatServiceImpl CS = new CombatServiceImpl();
		CS.updateCombatChallenger(this.id, challenger);
	}

	public Group getOpponent() {
		return opponent;
	}

	public void setOpponent(Group opponent) {
		this.opponent = opponent;
		CombatServiceImpl CS = new CombatServiceImpl();
		CS.updateCombatOpponent(this.id, opponent);
	}

	public Group getCorrector() {
		return corrector;
	}

	public void setCorrector(Group corrector) {
		this.corrector = corrector;
		CombatServiceImpl CS = new CombatServiceImpl();
		CS.updateCombatCorrector(this.id, corrector);
	}

	public void setTest(Test test) {
		this.test = test;
	}

}