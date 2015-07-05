package system;

import java.util.Comparator;

import groupFunctions.Group;

public class LeaderboardComparator implements Comparator<Group>{

	@Override
	public int compare(Group o1, Group o2) {
		if(o1.getWinToLoss() == o2.getWinToLoss())
			return 0;
		else if(o1.getWinToLoss() > o2.getWinToLoss())
			return 1;
		else
			return -1;
	}

}
