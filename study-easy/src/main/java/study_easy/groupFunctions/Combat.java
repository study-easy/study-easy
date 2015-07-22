package study_easy.groupFunctions;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import study_easy.service.CombatServiceImpl;
import study_easy.service.GroupServiceImpl;
import study_easy.system.Controller;
import study_easy.users.RegUser;

@Entity
@Table(name = "Combat")
@Embeddable
@Component
public class Combat {

	@GeneratedValue
	@Id
	@Column
	private int id;
	@ManyToOne
	private Test test;
	@Column
	private String challenger;
	@Column
	private String opponent;
	@Column
	private int challengerRight;
	@Column
	private int opponentRight;
	@ElementCollection
	private Set<String> challengerNames = new HashSet<String>();
	@ElementCollection
	private Set<String> opponentNames = new HashSet<String>();
	@Autowired
	private static CombatServiceImpl CB;
	@Autowired
	private static CombatServiceImpl CS;
	@Autowired
	private static GroupServiceImpl GS;

	public int getChallengerRight() {
		return challengerRight;
	}

	public void setChallengerRight(int challengerRight) {
		this.challengerRight = challengerRight;
		CB.updateChallangerRight(this.id, challengerRight);
	}

	public int getOpponentRight() {
		return opponentRight;
	}

	public void setOpponentRight(int opponentRight) {
		this.opponentRight = opponentRight;
		CB.updateOpponentRight(this.id, opponentRight);
	}

	public Set<String> getChallengerNames() {
		return challengerNames;
	}

	public void setChallengerNames(HashSet<String> challengerNames) {
		this.challengerNames = challengerNames;
	}

	public Set<String> getOpponentNames() {
		return opponentNames;
	}

	public void setOpponentNames(HashSet<String> opponentNames) {
		this.opponentNames = opponentNames;
	}

	public Combat() {
	}

	public Combat(String challenger, String opponent, Test test) {
		this.challenger = challenger;
		this.opponent = opponent;
		this.test = test;
		Controller.getSystem().findGroup(challenger).getCurrentCombats().add(this);
		Controller.getSystem().findGroup(opponent).getCurrentCombats().add(this);
		this.opponentRight = 0;
		this.challengerRight = 0;
		for (RegUser user : Controller.getSystem().findGroup(challenger).getUserList()) {
			this.challengerNames.add(user.getName());
		}
		for (RegUser user : Controller.getSystem().findGroup(opponent).getUserList()) {
			this.challengerNames.add(user.getName());
		}

		CS.addCombat(this);
		GS.updateGroupCurrentCombats(this.challenger, Controller.getSystem().findGroup(this.challenger).getCurrentCombats());
		GS.updateGroupCurrentCombats(this.opponent, Controller.getSystem().findGroup(this.opponent).getCurrentCombats());
	}

	public Test getTest() {
		return this.test;
	}

	public String getChallenger() {
		return challenger;
	}

	public void setChallenger(String challenger) {
		this.challenger = challenger;
		CS.updateCombatChallenger(this.id, challenger);
	}

	public String getOpponent() {
		return opponent;
	}

	public void setOpponent(String opponent2) {
		this.opponent = opponent2;
		CS.updateCombatOpponent(this.id, opponent);
	}

	public int getId() {
		return id;
	}

	public void setTest(Test test) {
		this.test = test;
		CB.updateCombatTest(this.id, test);
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