package sharedAttributes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.*;

import groupFunctions.Combat;
import service.GroupPinnServiceImpl;
import service.GroupServiceImpl;
import service.HistoryElementServiceImpl;

@Entity
public class HistoryElement {

	@Id
	@GeneratedValue
	private int id;
	private String description;
	private Date date;

	public HistoryElement(Combat combat) {
		this.date = new Date();
		DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		this.description = "Am " + format.format(this.date) + " ist ein Combat zwischen den Gruppen "
				+ combat.getChallenger().getName() + " und " + combat.getOpponent().getName() + " beendet worden. ";
		if (combat.getChallengerRight() > combat.getOpponentRight())
			this.description = this.description + "Sieger war " + combat.getChallenger().getName() + " mit insgesamnt "
					+ combat.getChallengerRight() + " richtigen Antworten. Verloren hat "
					+ combat.getOpponent().getName() + " mit " + combat.getOpponentRight() + " richtigen Antworten";
		else if (combat.getChallengerRight() < combat.getOpponentRight())
			this.description = this.description + "Sieger war " + combat.getOpponent().getName() + " mit insgesamnt "
					+ combat.getOpponentRight() + " richtigen Antworten. Verloren hat "
					+ combat.getChallenger().getName() + " mit " + combat.getChallengerRight() + " richtigen Antworten";
		else
			this.description = this.description + "Er endete in einem Unentschieden. Beide Gruppen hatten insgesamnt "
					+ combat.getChallengerRight() + " richtige Antworten";
		
		combat.getChallenger().getPinnwall().addHistoryElement(this);
		combat.getOpponent().getPinnwall().addHistoryElement(this);
		
		HistoryElementServiceImpl HES = new HistoryElementServiceImpl();;
		HES.addHistoryElement(this);
		GroupPinnServiceImpl GPS = new GroupPinnServiceImpl();
		GPS.updateGroupPinnHistory(combat.getChallenger().getName(), combat.getChallenger().getPinnwall().getHistory());
		GPS.updateGroupPinnHistory(combat.getOpponent().getName(), combat.getOpponent().getPinnwall().getHistory());
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