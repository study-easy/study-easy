package service;

import java.util.List;

import sharedAttributes.PinnwallElement;
import sharedAttributes.UserPinn;
import users.RegUser;

public interface UserPinnService {
	public void addUserPinn(UserPinn pinn);
	public List<UserPinn> listUserPinn();
	public void updateUserPinnEntries(RegUser owner, List<PinnwallElement> list);
	public void updateUserPinnBan(String owner, boolean ban);
	public void deleteUserPinn(String owner);

}
