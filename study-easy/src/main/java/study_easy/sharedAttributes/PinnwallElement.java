package study_easy.sharedAttributes;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import study_easy.users.RegUser;

@Entity
@Table(name = "PinnwallElement")
@Embeddable
public class PinnwallElement {

	@Id
	@GeneratedValue
	@Column
	private int id;
	@Column
	private String entry;
	@ElementCollection
	private Set<PinnwallElement> comments = new HashSet<PinnwallElement>();
	@OneToOne
	private RegUser creator;
	@Column
	private Date date;

	public String getEntry() {
		return entry;
	}

	public void setEntry(String entry) {
		this.entry = entry;
	}

	public Set<PinnwallElement> getComments() {
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