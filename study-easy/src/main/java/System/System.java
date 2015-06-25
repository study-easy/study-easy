package System;

import java.util.ArrayList;
import java.util.List;



import Users.User;

public class System {

	static System system;
	List<User> userlist = new ArrayList<User>();

	public static System getSystem() {
		if (system == null) {
			system = new System();
			return system;
		} else
			return system;
	}
	
	public List<User> getUserList(){
		return this.userlist;
	}

}
