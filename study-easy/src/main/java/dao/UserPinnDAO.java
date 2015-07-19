package dao;

import java.util.ArrayList;
import java.util.List;

import sharedAttributes.PinnwallElement;
import sharedAttributes.UserPinn;

public interface UserPinnDAO {
	
	public void addUserPinn(UserPinn pinn);
	public List<UserPinn> listUserPinn();
	public void updateUserPinnEntries(String owner, ArrayList<PinnwallElement> list);
	public void updateUserPinnBan(String owner, boolean ban);
	public void deleteUserPinn(String owner);
}
