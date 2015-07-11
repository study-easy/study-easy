package groupFunctions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.*;

@Entity
public class Combat {

	@Column(name = "test")
	private Test test;
	@Column(name = "challenger")
	private Group challenger;
	@Column(name = "opponent")
	private Group opponent;
	@Column(name = "corrector")
	private Group corrector;
	@Column(name = "notificationToChallenger")
	private String notificationToChallenger;
	@Column(name = "notificationToOpponen")
	private String notificationToOpponent;
	@Column(name = "notificationToCorrector")
	private String notificationToCorrector;
	@Column(name = "testSelected")
	private boolean testSelected;
	
	public Combat() {
	}

	public Combat(Group challenger, Group opponent, Group corrector) {
		this.challenger = challenger;
		this.opponent = opponent;
		this.corrector = corrector;
		this.challenger.getCurrentCombats().add(this);
		this.opponent.getCurrentCombats().add(this);
		this.corrector.getCurrentCombats().add(this);
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("dd.MM.yyyy");

		this.notificationToChallenger = "Die herausgeforderte Gruppe " + opponent.getName()
				+ " hat ihre Herausforderung angenommen. Korrektor ist die Gruppe " + this.corrector.getName() + "  "
				+ format.format(date);

		this.notificationToOpponent = "Sie haben die Herausforderung der Gruppe " + challenger.getName()
				+ " angenommen.Korrektor ist die Gruppe " + this.corrector.getName() + "  " + format.format(date);

		this.notificationToCorrector = "Sie sind nun Korrektor für einen Combat zwischen den Gruppen "
				+ this.challenger.getName() + " und " + this.opponent.getName() + ". Wählen Sie einen Test aus.  "
				+ format.format(date);

		this.challenger.getCombatNotifications().add(0, this.notificationToChallenger);
		this.opponent.getCombatNotifications().add(0, this.notificationToOpponent);
		this.corrector.getCombatNotifications().add(0, this.notificationToCorrector);
	}

	public void addTest(Group corrector, Test test) {
		if (this.corrector == corrector && this.testSelected == false){
			this.test = test;
			this.testSelected = true;
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
	}

	public Group getOpponent() {
		return opponent;
	}

	public void setOpponent(Group opponent) {
		this.opponent = opponent;
	}

	public Group getCorrector() {
		return corrector;
	}

	public void setCorrector(Group corrector) {
		this.corrector = corrector;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public String getNotificationToChallenger() {
		return notificationToChallenger;
	}

	public void setNotificationToChallenger(String notificationToChallenger) {
		this.notificationToChallenger = notificationToChallenger;
	}

	public String getNotificationToOpponent() {
		return notificationToOpponent;
	}

	public void setNotificationToOpponent(String notificationToOpponent) {
		this.notificationToOpponent = notificationToOpponent;
	}

	public String getNotificationToCorrector() {
		return notificationToCorrector;
	}

	public void setNotificationToCorrector(String notificationToCorrector) {
		this.notificationToCorrector = notificationToCorrector;
	}

}