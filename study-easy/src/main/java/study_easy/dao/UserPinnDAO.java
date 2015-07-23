package study_easy.dao;

import java.util.List;

import study_easy.sharedAttributes.UserPinn;

public interface UserPinnDAO {
	
	public void addUserPinn(UserPinn pinn);
	public List<UserPinn> listUserPinn();
	public void updateUserPinn(UserPinn pinn);
	public void deleteUserPinn(String owner);
}
