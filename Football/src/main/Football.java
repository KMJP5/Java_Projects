package main;

import java.util.Scanner;

public class Football {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		League laliga = new League();

		System.out.print("Number Of Teams: ");
		int nteam = input.nextInt();
		laliga.setTeams(nteam);

		System.out.print("Number Of Matches: ");
		int nmatch = input.nextInt();
		laliga.setMacth(nmatch);

		laliga.showTable();
		
		
		

		input.close();

	}
}
