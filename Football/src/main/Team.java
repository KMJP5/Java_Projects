package main;

public class Team {
	private String Name;
	private int played;
	private int points;
	private int goalFor;
	private int goalAgainst;
	private int goalDiffrence;

	// .............................................

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getPlayed() {
		return played;
	}

	public void setPlayed(int played) {
		this.played += played;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points += points;
	}

	public int getGoalFor() {
		return goalFor;
	}

	public void setGoalFor(int goalFor) {
		this.goalFor += goalFor;
	}

	public int getGoalAgainst() {
		return goalAgainst;
	}

	public void setGoalAgainst(int goalAgainst) {
		this.goalAgainst += goalAgainst;
	}

	public int getGoalDiffrence() {
		return goalDiffrence;
	}

	// .............................................

	public void calculateGoalDiffrence() {
		goalDiffrence = goalFor - goalAgainst;
	}
}
