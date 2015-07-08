package system;

import java.util.ArrayList;

import groupFunctions.Group;

public class Leaderboard {

	private static Leaderboard leaderboard;
	private ArrayList<Group> board = new ArrayList<Group>();

	public Leaderboard getLeaderboard() {
		if (leaderboard == null) {
			leaderboard = new Leaderboard();
			return leaderboard;
		} else {
			return leaderboard;
		}
	}
	
	public void sortBoard(){
		LeaderboardComparator comparator = new LeaderboardComparator();
		board.sort(comparator);
	}

}
