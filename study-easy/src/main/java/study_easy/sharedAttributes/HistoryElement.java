package study_easy.sharedAttributes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import study_easy.groupFunctions.Combat;
import study_easy.service.GroupPinnServiceImpl;
import study_easy.service.HistoryElementServiceImpl;
import study_easy.system.Controller;

@Entity
@Table(name = "HistoryElement")
@Embeddable
@Component
public class HistoryElement {

	@Id
	@GeneratedValue
	@Column
	private int id;
	@Column
	private String description;
	@Column
	private Date date;
	@Autowired
	private static HistoryElementServiceImpl HE;
	@Autowired
	private static GroupPinnServiceImpl GPS;

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
		
		Controller.getSystem().findGroup(combat.getChallenger()).getPinnwall().addHistoryElement(this);
		Controller.getSystem().findGroup(combat.getOpponent()).getPinnwall().addHistoryElement(this);
		
		HE.addHistoryElement(this);
		GPS.updateGroupPinnHistory(combat.getChallenger(), this);
		GPS.updateGroupPinnHistory(combat.getOpponent(), this);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
		HE.updateHistoryElementContent(this.id, description);
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
		HE.updateHistoryElementDate(this.id, date);
	}

}