package sharedAttributes;

import java.util.Date;

import javax.persistence.*;

@Entity
public class HistoryElement {

	@Id
	@GeneratedValue
	private int id;
	private String description;
	private Date date;

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