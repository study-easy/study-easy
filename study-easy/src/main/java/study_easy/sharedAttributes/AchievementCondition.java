package study_easy.sharedAttributes;

import javax.persistence.*;

@Entity
@Table(name = "AchievementCondition")
@Embeddable
public class AchievementCondition {

	@GeneratedValue
	@Id
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
	private float requiredTime;
	@Column
	private int bonusXp;

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

	public float getRequiredTime() {
		return requiredTime;
	}

	public void setRequiredTime(float requiredTime) {
		this.requiredTime = requiredTime;
	}

	public int getBonusXp() {
		return bonusXp;
	}

	public void setBonusXp(int bonusXp) {
		this.bonusXp = bonusXp;
	}

}