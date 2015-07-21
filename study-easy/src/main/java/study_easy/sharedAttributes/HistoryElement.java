package study_easy.sharedAttributes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.*;

import study_easy.groupFunctions.Combat;
import study_easy.service.GroupPinnServiceImpl;
import study_easy.service.HistoryElementServiceImpl;
import study_easy.system.Functionals;

@Entity
@Table(name = "HistoryElement")
@Embeddable
public class HistoryElement {

	@Id
	@GeneratedValue
	@Column
	private int id;
	@Column
	private String description;
	@Column
	private Date date;

	public HistoryElement(Combat combat) {
		this.date = new Date();
		DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		this.description = "Am " + format.format(this.date) + " ist ein Combat zwischen den Gruppen "
				+ combat.getChallenger() + " und " + combat.getOpponent() + " beendet worden. ";
		if (combat.getChallengerRight() > combat.getOpponentRight())
			this.description = this.description + "Sieger war " + combat.getChallenger() + " mit insgesamnt "
					+ combat.getChallengerRight() + " richtigen Antworten. Verloren hat "
					+ combat.getOpponent() + " mit " + combat.getOpponentRight() + " richtigen Antworten";
		else if (combat.getChallengerRight() < combat.getOpponentRight())
			this.description = this.description + "Sieger war " + combat.getOpponent() + " mit insgesamnt "
					+ combat.getOpponentRight() + " richtigen Antworten. Verloren hat "
					+ combat.getChallenger() + " mit " + combat.getChallengerRight() + " richtigen Antworten";
		else
			this.description = this.description + "Er endete in einem Unentschieden. Beide Gruppen hatten insgesamnt "
					+ combat.getChallengerRight() + " richtige Antworten";
		
		Functionals.getSystem().findGroup(combat.getChallenger()).getPinnwall().addHistoryElement(this);
		Functionals.getSystem().findGroup(combat.getOpponent()).getPinnwall().addHistoryElement(this);
		
		HistoryElementServiceImpl HES = new HistoryElementServiceImpl();;
		HES.addHistoryElement(this);
		GroupPinnServiceImpl GPS = new GroupPinnServiceImpl();
		//GPS.updateGroupPinnHistory(combat.getChallenger().getName(), combat.getChallenger().getPinnwall().getHistory());
		//GPS.updateGroupPinnHistory(combat.getOpponent().getName(), combat.getOpponent().getPinnwall().getHistory());
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}