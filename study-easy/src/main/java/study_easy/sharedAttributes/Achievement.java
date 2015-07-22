package study_easy.sharedAttributes;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import study_easy.groupFunctions.Group;
import study_easy.users.RegUser;


@Entity
public class Achievement {

	@Id
	@GeneratedValue
	private int achievId;
	public int getAchievId() {
		return achievId;
	}

	public void setAchievId(int achievId) {
		this.achievId = achievId;
	}

	public String getAchievName() {
		return achievName;
	}

	public void setAchievName(String achievName) {
		this.achievName = achievName;
	}

	@Column
	private String achievName;
	@ManyToMany
	@JoinTable(name = "achievement_relation", joinColumns = @JoinColumn(name="achievId"), inverseJoinColumns = @JoinColumn(name="id"))
	private Set<AchievementCondition> conditions = new HashSet<AchievementCondition>();

	public void addAchievmentConditions(AchievementCondition element) {
		conditions.add(element);
	} 
	
	public boolean conditionsTrue(Group group) {
		boolean bool=false;
		//Fuer alle conditions im array von achievement den Typ bestimmen und in type speichern
		for(AchievementCondition condition : this.conditions) {
			String type = condition.getConditionType().toString();
			
			switch (type) {
			case "XpCondition":
				int allXP = 0;
				for(RegUser user : group.getUserList()){
					allXP = allXP + user.getXpPoints();
				}
				if(condition.getRequiredNumber() <= allXP) {
					bool = true;
				} else {
					bool = false;
				} 
			case "LevelCondition":
				float averageLevel = 0;
				for(RegUser user : group.getUserList()){
					averageLevel = averageLevel + user.getLevel();
				}
				averageLevel = averageLevel/group.getUserList().size();
				if(condition.getRequiredNumber() <= averageLevel) {
					bool = true;
				} else {
					bool=false;
				}
			case "StringCondition":
				//TODO
				
			case "TimeCondition":
				//TODO
				
			case "DateCondition":
				//TODO
				
			}
		}
		return bool;
	}
	public String getName() {
		return achievName;
	}

	public void setName(String name) {
		this.achievName = name;
	}

	public Set<AchievementCondition> getConditions() {
		return conditions;
	}

	public void setConditions(Set<AchievementCondition> conditions) {
		this.conditions = conditions;
	}
}

//Connor ist eine DivaBitch