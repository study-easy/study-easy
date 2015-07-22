package study_easy.sharedAttributes;

import java.util.Date;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import study_easy.service.BadgeConditionServiceImpl;

@Entity
@Table(name = "BadgeCondition")
@Embeddable
@Component
public class BadgeCondition {

	@Id
	@GeneratedValue
	@Column
	private int id;
	@Column
	private ConditionTypes conditionType;
	@Column
	private String name;
	@Column
	private int requiredNumber;
	@Column
	private String requiredString;
	@Column
	private Date requiredDate;
	@Autowired
	private static BadgeConditionServiceImpl BC;

	public ConditionTypes getConditionType() {
		return conditionType;
	}

	public void setConditionType(ConditionTypes conditionType) {
		this.conditionType = conditionType;
		BC.updateBadgeConditionType(this.id, conditionType);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		BC.updateBadgeConditionName(this.id, name);
	}

	public int getRequiredNumber() {
		return requiredNumber;
	}

	public void setRequiredNumber(int requiredNumber) {
		this.requiredNumber = requiredNumber;
		BC.updateBadgeConditionRequiredInt(this.id, requiredNumber);
	}

	public String getRequiredString() {
		return requiredString;
	}

	public void setRequiredString(String requiredString) {
		this.requiredString = requiredString;
		BC.updateBadgeConditionRequiredString(this.id, requiredString);
	}

	public Date getRequiredDate() {
		return requiredDate;
	}

	public void setRequiredDate(Date requiredDate) {
		this.requiredDate = requiredDate;
		BC.updateBadgeConditionRequiredDate(this.id, requiredDate);
	}

}