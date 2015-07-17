package service;

import java.util.ArrayList;
import java.util.List;

import sharedAttributes.PinnwallElement;
import sharedAttributes.UserPinn;

public interface UserPinnService {
	public void addUserPinn(UserPinn pinn);
	public List<UserPinn> listUserPinn();
	public void updateUserPinnEntries(String owner, ArrayList<PinnwallElement> list);
	public void updateUserPinnBan(String owner, boolean ban);
	public void deleteUserPinn(String owner);

}
