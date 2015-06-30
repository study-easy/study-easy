package shareAttributes;

import java.util.ArrayList;
import java.util.List;

import users.RegUser;


public class Badge {
	
	private String name;
	private List<BadgeCondition> conditions = new ArrayList<BadgeCondition>();
	
	public boolean conditionsTrue(Badge badge, RegUser user) {
		boolean bool=false;
		//Fuer alle conditions im array von badge den Typ bestimmen und in type speichern
		for(int i=0; i<=conditions.size(); i++) {
			String type = badge.conditions.get(i).getConditionType().toString();
			
			switch (type) {
			case "XpCondition":
				if(badge.conditions.get(i).getRequiredNumber() <= user.getXpPoints()) {
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
				//ToDo
				
			case "TimeCondition":
				//ToDo
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

	public List<BadgeCondition> getConditions() {
		return conditions;
	}

	public void setConditions(List<BadgeCondition> conditions) {
		this.conditions = conditions;
	}

}
