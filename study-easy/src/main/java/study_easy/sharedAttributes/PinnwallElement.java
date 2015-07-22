package study_easy.sharedAttributes;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import study_easy.users.RegUser;

@Embeddable
public class PinnwallElement {

	@Column
	private String entry;
	@Column
	private String creator;
	@Column
	private Date date;

	public String getEntry() {
		return entry;
	}

	public void setEntry(String entry) {
		this.entry = entry;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
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