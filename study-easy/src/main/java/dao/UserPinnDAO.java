package dao;

import java.util.List;

import sharedAttributes.PinnwallElement;
import sharedAttributes.UserPinn;
import users.RegUser;

public interface UserPinnDAO {
	
	public void addUserPinn(UserPinn pinn);
	public List<UserPinn> listUserPinn();
	public void updateUserPinnEntries(RegUser owner, List<PinnwallElement> list);
	public void updateUserPinnBan(RegUser owner, boolean ban);
	public void deleteUserPinn(RegUser owner);
}
