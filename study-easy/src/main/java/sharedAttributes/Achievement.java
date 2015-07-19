package sharedAttributes;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import service.AchievementServiceImpl;
import service.GroupPinnServiceImpl;
import users.RegUser;

@Entity
@Table(name="ACHIEVEMENT")
public class Achievement {

	@NotNull
	@Id
		
	@Column(name="NAME")
	private String name;
	@NotNull
	@Column(name="CONDITIONS")
	@OneToMany
	@JoinTable(name = "Achievments_Conditions", joinColumns = {
			@JoinColumn(name = "name", referencedColumnName = "NAME") }, inverseJoinColumns = {
					@JoinColumn(name = "conditionType", referencedColumnName = "id") })
	private List<AchievementCondition> conditions = new ArrayList<AchievementCondition>();

	public void addAchievmentConditions(AchievementCondition element) {
		conditions.add(element);
		AchievementServiceImpl GPS = new AchievementServiceImpl();
		GPS.updateAchievementConditions(this.name, this.conditions);
	} 
	
	public boolean conditionsTrue(RegUser user) {
		boolean bool=false;
		//Fuer alle conditions im array von achievement den Typ bestimmen und in type speichern
		for(int i=0; i<=conditions.size(); i++) {
			String type = this.conditions.get(i).getConditionType().toString();
			
			switch (type) {
			case "XpCondition":
				if(this.conditions.get(i).getRequiredNumber() <= user.getXpPoints()) {
					bool = true;
				} else {
					bool = false;
				} 
			case "LevelCondition":
				if(conditions.get(i).getRequiredNumber() <= user.getLevel()) {
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

	public List<AchievementCondition> getConditions() {
		return conditions;
	}

	public void setConditions(List<AchievementCondition> conditions) {
		this.conditions = conditions;
	}
}