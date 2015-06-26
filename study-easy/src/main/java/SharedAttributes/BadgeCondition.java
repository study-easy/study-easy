package SharedAttributes;

public class BadgeCondition {
	
	private ConditionTypes conditionType;
	private String name;
	private int requiredNumber;
	private String requiredString;
	private float requiredTime;
	
	public enum ConditionTypes { XpCondition, TimeCondition, StringCondition, LevelCondition }

	
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
	
	

}
