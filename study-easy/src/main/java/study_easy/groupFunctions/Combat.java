package study_easy.groupFunctions;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Combat {

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setChallengerNames(Set<String> challengerNames) {
		this.challengerNames = challengerNames;
	}

	public void setOpponentNames(Set<String> opponentNames) {
		this.opponentNames = opponentNames;
	}

	@Id
	@GeneratedValue
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
		// this.challenger = challenger;
		// this.opponent = opponent;
		// this.test = test;
		// Functionals.getSystem().findGroup(challenger).getCurrentCombats().add(this);
		// Functionals.getSystem().findGroup(opponent).getCurrentCombats().add(this);
		// this.opponentRight = 0;
		// this.challengerRight = 0;
		// for (RegUser user :
		// Functionals.getSystem().findGroup(challenger).getUserList()) {
		// this.challengerNames.add(user.getName());
		// }
		// for (RegUser user :
		// Functionals.getSystem().findGroup(opponent).getUserList()) {
		// this.challengerNames.add(user.getName());
		// }
	}

	public Test getTest() {
		return this.test;
	}

	public String getChallenger() {
		return challenger;
	}

	public void setChallenger(String challenger) {
		this.challenger = challenger;
	}

	public String getOpponent() {
		return opponent;
	}

	public void setOpponent(String opponent2) {
		this.opponent = opponent2;
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
		// TODO listen updaten via dao und service
	}

	public boolean isNotDone(String name) {
		if (this.challengerNames.contains(name) || this.opponentNames.contains(name))
			return true;
		else
			return false;
	}

}