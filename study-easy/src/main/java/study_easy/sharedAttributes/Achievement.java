package study_easy.sharedAttributes;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import study_easy.groupFunctions.Group;
import study_easy.users.RegUser;

@Entity
@Table(name = "Achievement")
@Embeddable
@Component
public class Achievement {

	@Id	
	@Column
	private String name;
	@ElementCollection
	private Set<AchievementCondition> conditions = new HashSet<AchievementCondition>();
	@Autowired
	private static AchievementServiceImpl GPS;

	public void addAchievmentConditions(AchievementCondition element) {
		conditions.add(element);
<<<<<<< HEAD
		GPS.updateAchievementConditions(this.name, element);
=======
>>>>>>> origin/ConnorsVerzweiflungsBranch
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
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<AchievementCondition> getConditions() {
		return conditions;
	}

	public void addConditions(AchievementCondition condition) {
		this.conditions.add(condition);
		GPS.updateAchievementConditions(this.name, condition);
	}
}
