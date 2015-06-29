package shareAttributes;

import java.util.ArrayList;
import java.util.List;

public class Achievement {
	
	private String name;
	private List<AchievementCondition> conditions = new ArrayList<AchievementCondition>();
	
	public boolean conditionsTrue(Achievement achievement) {
		
		return true;
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
