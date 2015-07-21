package study_easy.dao;

import java.util.ArrayList;
import java.util.List;

import study_easy.sharedAttributes.PinnwallElement;
import study_easy.sharedAttributes.UserPinn;

public interface UserPinnDAO {
	
	public void addUserPinn(UserPinn pinn);
	public List<UserPinn> listUserPinn();
	public void updateUserPinnEntries(String owner, PinnwallElement list);
	public void updateUserPinnBan(String owner, boolean ban);
	public void updateUserPinnOwner(String owner);
	public void deleteUserPinn(String owner);
}
