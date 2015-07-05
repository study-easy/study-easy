package System;

import java.util.ArrayList;
import java.util.List;

import SharedAttributes.Badge;
import Users.Admin;
import Users.RegUser;

public class System {

	private static System system;
	List<RegUser> regUserlist = new ArrayList<RegUser>();
	List<Admin> adminList = new ArrayList<Admin>();
		
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
			if(user.getName() == name)
				user.getEarnedBadges().add(badge);
		}
	}

}