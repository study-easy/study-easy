package study_easy.system;

import java.util.Comparator;

import study_easy.groupFunctions.Group;

public class LeaderboardComparator implements Comparator<Group>{

	@Override
	public int compare(Group o1, Group o2) {
		if(o1.getWins() == o2.getWins()){
			if(o1.getWinToLoss() == o2.getWinToLoss()){
				if(o1.getWinStreak()==o2.getWinStreak())
					return 0;
				else if(o1.getWinStreak() > o2.getWinStreak())
					return -1;
				else
					return 1;
			}else if(o1.getWinToLoss() > o2.getWinToLoss())
				return -1;
			else 
				return 1;						
		}
		else if(o1.getWins() > o2.getWins())
			return -1;
		else
			return 1;
	}

}