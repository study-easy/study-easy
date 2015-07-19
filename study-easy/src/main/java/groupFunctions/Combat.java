package groupFunctions;

import java.util.HashSet;

import javax.persistence.*;

import service.CombatServiceImpl;
import service.GroupServiceImpl;
import users.RegUser;

@Entity
public class Combat {

	@GeneratedValue
	@Id
	private int id;
	private Test test;
	private Group challenger;
	private Group opponent;
	private int challengerRight;
	private int opponentRight;
	@OneToMany(mappedBy = "id")
	private HashSet<String> challengerNames = new HashSet<String>();
	@OneToMany(mappedBy = "id")
	private HashSet<String> opponentNames = new HashSet<String>();

	public int getChallengerRight() {
		return challengerRight;
	}

	public void setChallengerRight(int challengerRight) {
		this.challengerRight = challengerRight;
	}

	public int getOpponentRight() {
		return opponentRight;
	}

	public void setOpponentRight(int opponentRight) {
		this.opponentRight = opponentRight;
	}

	public HashSet<String> getChallengerNames() {
		return challengerNames;
	}

	public void setChallengerNames(HashSet<String> challengerNames) {
		this.challengerNames = challengerNames;
	}

	public HashSet<String> getOpponentNames() {
		return opponentNames;
	}

	public void setOpponentNames(HashSet<String> opponentNames) {
		this.opponentNames = opponentNames;
	}

	public Combat() {
	}

	public Combat(Group challenger, Group opponent, Test test) {
		this.challenger = challenger;
		this.opponent = opponent;
		this.test = test;
		this.challenger.getCurrentCombats().add(this);
		this.opponent.getCurrentCombats().add(this);
		this.opponentRight = 0;
		this.challengerRight = 0;
		for (RegUser user : challenger.getUserList()) {
			this.challengerNames.add(user.getName());
		}
		for (RegUser user : opponent.getUserList()) {
			this.challengerNames.add(user.getName());
		}

		CombatServiceImpl CS = new CombatServiceImpl();
		CS.addCombat(this);
		GroupServiceImpl GS = new GroupServiceImpl();
		GS.updateGroupCurrentCombats(this.challenger.getName(), this.challenger.getCurrentCombats());
		GS.updateGroupCurrentCombats(this.opponent.getName(), this.opponent.getCurrentCombats());
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

	public int getId() {
		return id;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public void finishUser(String name, int numberOfRight) {
		if (this.challengerNames.contains(name)) {
			this.setChallengerRight(this.getChallengerRight() + numberOfRight);
			this.challengerNames.remove(name);
		} else if (this.opponentNames.contains(name)) {
			this.setOpponentRight(this.getOpponentRight() + numberOfRight);
			this.opponentNames.remove(name);
		}
		//TODO listen updaten via dao und service
	}

}