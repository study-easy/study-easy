package org.hohenheim;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import groupFunctions.Group;
import system.Leaderboard;
import users.ManageRegUser;

public class testing {

	public static void main(String[] args) {
//		 SessionFactory factory;
//		 try {
//		 factory = new Configuration().configure().buildSessionFactory();
//		 } catch (Throwable ex) {
//		 System.err.println("Failed" + ex);
//		 throw new ExceptionInInitializerError(ex);
//		 }
//		 ManageRegUser MU = new ManageRegUser();
//		
//		 String U1 = MU.addRegUser("xxx", "123", "hh@dd");
//		 String U2 = MU.addRegUser("lol", "abc", "ff@dd");
//		
//		 MU.listRegUsers();

		Group g1 = new Group();
		g1.setWins(12);
		g1.setWinToLoss(4.5f);
		g1.setWinStreak(1);
		Group g2 = new Group();
		g2.setWins(12);
		g2.setWinToLoss(6f);
		g2.setWinStreak(2);
		Group g3 = new Group();
		g3.setWins(12);
		g3.setWinToLoss(2f);
		g3.setWinStreak(1);
		Leaderboard.getLeaderboard().addGroup(g2);
		Leaderboard.getLeaderboard().addGroup(g1);
		Leaderboard.getLeaderboard().addGroup(g3);
		Group g4 = new Group();
		g4.setWins(5);
		g4.setWinStreak(2);
		g4.setWinToLoss(0.5f);
		Leaderboard.getLeaderboard().addGroup(g4);
		for (Group group : Leaderboard.getLeaderboard().getBoard()) {
			System.out.println(group.getWins() + " " + group.getWinToLoss() + " " + group.getWinStreak());
		}
	}
}
