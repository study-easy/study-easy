package study_easy.sharedAttributes;

import java.util.Date;

import javax.persistence.*;

import study_easy.service.BadgeConditionServiceImpl;
import study_easy.service.BadgeServiceImpl;

@Entity
@Table(name = "BadgeCondition")
@Embeddable
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

	public ConditionTypes getConditionType() {
		return conditionType;
	}

	public void setConditionType(ConditionTypes conditionType) {
		this.conditionType = conditionType;
		BadgeConditionServiceImpl BC = new BadgeConditionServiceImpl();
		BC.updateBadgeConditionType(this.id, conditionType);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		BadgeConditionServiceImpl BC = new BadgeConditionServiceImpl();
		BC.updateBadgeConditionName(this.id, name);
	}

	public int getRequiredNumber() {
		return requiredNumber;
	}

	public void setRequiredNumber(int requiredNumber) {
		this.requiredNumber = requiredNumber;
		BadgeConditionServiceImpl BC = new BadgeConditionServiceImpl();
		BC.updateBadgeConditionRequiredInt(this.id, requiredNumber);
	}

	public String getRequiredString() {
		return requiredString;
	}

	public void setRequiredString(String requiredString) {
		this.requiredString = requiredString;
		BadgeConditionServiceImpl BC = new BadgeConditionServiceImpl();
		BC.updateBadgeConditionRequiredString(this.id, requiredString);
	}

	public Date getRequiredDate() {
		return requiredDate;
	}

	public void setRequiredDate(Date requiredDate) {
		this.requiredDate = requiredDate;
		BadgeConditionServiceImpl BC = new BadgeConditionServiceImpl();
		BC.updateBadgeConditionRequiredDate(this.id, requiredDate);
	}

}