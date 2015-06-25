package System;

import java.util.ArrayList;
import java.util.List;

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

}
