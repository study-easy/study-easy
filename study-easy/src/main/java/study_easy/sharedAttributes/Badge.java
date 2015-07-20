package study_easy.sharedAttributes;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import study_easy.service.BadgeServiceImpl;
import study_easy.users.RegUser;

@Entity
@Table(name="Badge")
@Embeddable
public class Badge {
	
	@NotNull
	@Id
	@Column
	private String name;
	@NotNull
	@ElementCollection
	private Set<BadgeCondition> conditions = new HashSet<BadgeCondition>();
	
	public void addBadgeCondition(BadgeCondition element) {
		conditions.add(element);
		BadgeServiceImpl GPS = new BadgeServiceImpl();
		//GPS.updateBadgeConditions(this.name, this.conditions);
	}


	
	public boolean conditionsTrue(RegUser user) {
		boolean bool=false;
		//Fuer alle conditions im array von badge den Typ bestimmen und in type speichern
		for(BadgeCondition condition : this.conditions) {
			String type = condition.getConditionType().toString();
			
			switch (type) {
			case "XpCondition":
				if(condition.getRequiredNumber() <= user.getXpPoints()) {
					bool = true;
				} else {
					bool = false;
				} 
			case "LevelCondition":
				if(condition.getRequiredNumber() <= user.getLevel()) {
					bool = true;
				} else {
					bool=false;
				}
				
			case "DateCondition":
				if(condition.getRequiredDate().before(user.getRegisteredSinceDate())) {
					bool = true;
				} else {
					bool = false;
				}
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

	public Set<BadgeCondition> getConditions() {
		return conditions;
	}

	public void setConditions(HashSet<BadgeCondition> conditions) {
		this.conditions = conditions;
	}

}