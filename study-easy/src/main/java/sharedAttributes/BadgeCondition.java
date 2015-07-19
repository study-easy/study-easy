package sharedAttributes;

import java.util.Date;

import javax.persistence.*;

@Entity
public class BadgeCondition {

	@Id
	@GeneratedValue
	private int id;
	private ConditionTypes conditionType;
	private String name;
	private int requiredNumber;
	private String requiredString;
	private Date requiredDate;

	public ConditionTypes getConditionType() {
		return conditionType;
	}

	public void setConditionType(ConditionTypes conditionType) {
		this.conditionType = conditionType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRequiredNumber() {
		return requiredNumber;
	}

	public void setRequiredNumber(int requiredNumber) {
		this.requiredNumber = requiredNumber;
	}

	public String getRequiredString() {
		return requiredString;
	}

	public void setRequiredString(String requiredString) {
		this.requiredString = requiredString;
	}

	public Date getRequiredDate() {
		return requiredDate;
	}

	public void setRequiredDate(Date requiredDate) {
		this.requiredDate = requiredDate;
	}

}