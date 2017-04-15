package main;

import java.util.Scanner;

public class League {
	public static Team[] teams;
	private Match[] match;

	Scanner input = new Scanner(System.in);
	Scanner in = new Scanner(System.in);

	public void setTeams(int num) {
		teams = new Team[num];
		System.out.println("Enter Teams: ");

		for (int i = 0; i < num; i++) {
			teams[i] = new Team();
			teams[i].setName(input.next());
		}
	}

	public void setMacth(int num) {
		String s = "";
		match = new Match[num];
		System.out.println("Enter Match Details:");

		for (int i = 0; i < num; i++) {
			match[i] = new Match();
			System.out.print(i + 1 + "- ");
			s = in.nextLine();
			match[i].matchDetails(s);
			System.out.println();
		}
	}

	private void sortByPoints() {
		Team temp = new Team();

		for (int i = 0; i < teams.length - 1; i++) {
			for (int j = i; j < teams.length; j++) {
				if (teams[i].getPoints() < teams[j].getPoints()) {
					temp = teams[i];
					teams[i] = teams[j];
					teams[j] = temp;
				}
			}
		}
	}

	private void sortByGoalDiffrence() {
		for (int i = 0; i < teams.length; i++)
			teams[i].calculateGoalDiffrence();

		Team temp = new Team();

		for (int i = 0; i < teams.length - 1; i++) {
			for (int j = i; j < teams.length; j++) {
				if (teams[i].getPoints() == teams[j].getPoints()) {
					if (teams[i].getGoalDiffrence() < teams[j]
							.getGoalDiffrence()) {
						temp = teams[i];
						teams[i] = teams[j];
						teams[j] = temp;
					}
				}
			}
		}
	}

	public void showTable() {
		sortByPoints();
		sortByGoalDiffrence();

		for (int i = 0; i < teams.length; i++) {
			System.out.printf(i + 1 + "- " + teams[i].getName() + "\t"
					+ teams[i].getPlayed() + "\t" + teams[i].getPoints() + "\t"
					+ teams[i].getGoalDiffrence());
			System.out.println();
		}
	}
}
