package study_easy.system;

import java.util.ArrayList;

import study_easy.groupFunctions.Group;

public class Leaderboard {

	private static Leaderboard leaderboard;
	private ArrayList<Group> board = new ArrayList<Group>();

	public static Leaderboard getLeaderboard() {
		if (leaderboard == null) {
			leaderboard = new Leaderboard();
			return leaderboard;
		} else {
			return leaderboard;
		}
	}

	public void sortBoard() {
		LeaderboardComparator comparator = new LeaderboardComparator();
		board.sort(comparator);
	}

	public void addGroup(Group group) {
		this.board.add(group);
		this.sortBoard();
	}

	public void deleteGroup(Group group) {
		this.board.remove(group);
		this.sortBoard();
	}
	
	public ArrayList<Group> getBoard(){
		return this.board;
	}

}