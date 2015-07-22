package study_easy.sharedAttributes;

import javax.persistence.*;

@Entity
public class AchievementCondition {

	@Id
	@GeneratedValue
	int id;
	@Column
	private ConditionTypes conditionType;
	@Column
	private String achievConditionName;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAchievConditionName() {
		return achievConditionName;
	}

	public void setAchievConditionName(String achievConditionName) {
		this.achievConditionName = achievConditionName;
	}

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
		return achievConditionName;
	}

	public void setName(String name) {
		this.achievConditionName = name;
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