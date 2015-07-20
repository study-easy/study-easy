package study_easy.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import study_easy.sharedAttributes.PinnwallElement;
import study_easy.sharedAttributes.UserPinn;

public interface UserPinnService {
	
	public void addUserPinn(UserPinn pinn);
	public List<UserPinn> listUserPinn();
	public void updateUserPinnEntries(String owner, PinnwallElement entries);
	public void updateUserPinnBan(String owner, boolean ban);
	public void updateUserPinnOwner(String owner);
	public void deleteUserPinn(String owner);

}
