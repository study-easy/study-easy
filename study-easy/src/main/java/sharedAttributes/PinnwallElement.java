package sharedAttributes;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.*;

import users.RegUser;

@Entity
public class PinnwallElement {

	@Id
	@GeneratedValue
	private int id;
	private String entry;
	@OneToMany
	private ArrayList<PinnwallElement> comments = new ArrayList<PinnwallElement>();
	private RegUser creator;
	private Date date;

	public String getEntry() {
		return entry;
	}

	public void setEntry(String entry) {
		this.entry = entry;
	}

	public ArrayList<PinnwallElement> getComments() {
		return comments;
	}

	public void setComments(PinnwallElement comments) {
		this.comments.add(comments);
	}

	public RegUser getCreator() {
		return creator;
	}

	public void setCreator(RegUser creator) {
		this.creator = creator;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void edit(PinnwallElement element) {
		element.setEntry(entry);
	}

}