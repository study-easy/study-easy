package system;

import java.util.ArrayList;
import java.util.List;

import sharedAttributes.Badge;
import users.Admin;
import users.RegUser;



public class System {

	private static System system;
	List<RegUser> regUserlist = new ArrayList<RegUser>();
	List<Admin> adminList = new ArrayList<Admin>();
		//lel
	public static System getSystem() {
		if (system == null) {
			system = new System();
			return system;
		} else
			return system;
	}
	
	public List<RegUser> getUserList(){
		return this.regUserlist;
	}
	
	public List<Admin> getAdminList(){
		return this.adminList;
	}
	
	public void awardBadge(Badge badge, String name){
		for(RegUser user: this.regUserlist){
			if(user.getName() == name){
				if(badge.conditionsTrue(user)){
					user.getEarnedBadges().add(badge);
				}
						
			}
				
		}
	}

}
