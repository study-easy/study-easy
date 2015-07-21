package study_easy.sharedAttributes;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import study_easy.service.AchievementServiceImpl;
import study_easy.service.PinnwallElementServiceImpl;
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
		PinnwallElementServiceImpl PE = new PinnwallElementServiceImpl();
		PE.updatePinnwallElementContent(this.id, entry);
	}

	public Set<PinnwallElement> getComments() {
		return comments;
		
	}

	public void addComments(PinnwallElement comments) {
		this.comments.add(comments);
		PinnwallElementServiceImpl PE = new PinnwallElementServiceImpl();
		PE.updatePinnwallElementComments(this.id, comments);
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
		PinnwallElementServiceImpl PE = new PinnwallElementServiceImpl();
		PE.updatePinnwallElementDate(this.id, date);
	}

	public void edit(PinnwallElement element) {
		element.setEntry(entry);
	}

}