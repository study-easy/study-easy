package study_easy.sharedAttributes;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import study_easy.service.AchievementConditionServiceImpl;
import study_easy.service.AchievementServiceImpl;

@Entity
@Table(name = "AchievementCondition")
@Embeddable
@Component
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
	@Autowired
	private static AchievementConditionServiceImpl AC;

	public ConditionTypes getConditionType() {
		return conditionType;
	}

	public void setConditionType(ConditionTypes conditionType) {
		this.conditionType = conditionType;
		AC.updateAchievementConditionType(this.id, conditionType);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		AC.updateAchievementConditionName(this.id, name);
	}

	public int getRequiredNumber() {
		return requiredNumber;
	}

	public void setRequiredNumber(int requiredNumber) {
		this.requiredNumber = requiredNumber;
		AC.updateAchievementConditionRequiredNumber(this.id, requiredNumber);
	}

	public String getRequiredString() {
		return requiredString;
	}

	public void setRequiredString(String requiredString) {
		this.requiredString = requiredString;
		AC.updateAchievementConditionRequiredString(this.id, requiredString);
	}

	public float getRequiredTime() {
		return requiredTime;
	}

	public void setRequiredTime(float requiredTime) {
		this.requiredTime = requiredTime;
		AC.updateAchievementConditionRequiredTime(this.id, requiredTime);
	}

	public int getBonusXp() {
		return bonusXp;
	}

	public void setBonusXp(int bonusXp) {
		this.bonusXp = bonusXp;
		AC.updateAchievementConditionXp(this.id, bonusXp);
	}

}