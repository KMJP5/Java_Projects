package main;

public class Match {
	private Team home;
	private Team away;
	private Team winner;
	private int homeGoal;
	private int awayGoal;

	// .............................................
	public Team getHome() {
		return home;
	}

	public void setHome(Team home) {
		this.home = home;
	}

	public Team getAway() {
		return away;
	}

	public void setAway(Team away) {
		this.away = away;
	}

	public Team getWinner() {
		return winner;
	}

	public void setWinner(Team winner) {
		this.winner = winner;
	}

	public int getHomeGoal() {
		return homeGoal;
	}

	public void setHomeGoal(int homeGoal) {
		this.homeGoal = homeGoal;
	}

	public int getAwayGoal() {
		return awayGoal;
	}

	public void setAwayGoal(int awayGoal) {
		this.awayGoal = awayGoal;
	}

	// .............................................

	// set one match details
	public void matchDetails(String s) {
		String[] detail = s.split(" ");
		String[] teams = detail[0].split("-");
		String[] goals = detail[1].split("-");

		home = findTeam(teams[0]);
		away = findTeam(teams[1]);
		homeGoal = Integer.parseInt(goals[0]);
		awayGoal = Integer.parseInt(goals[1]);

		if (homeGoal > awayGoal) {
			winner = home;
			home.setPoints(3);
			away.setPoints(0);
		} else if (homeGoal < awayGoal) {
			winner = away;
			home.setPoints(0);
			away.setPoints(3);
		} else {
			home.setPoints(1);
			away.setPoints(1);
		}
		calcTeams();
	}

	private Team findTeam(String s) {
		Team team = new Team();
		for (int i = 0; i < League.teams.length; i++) {
			if (s.equals(League.teams[i].getName())) {
				team = League.teams[i];
				break;
			}
		}
		return team;
	}

	private void calcTeams() {
		home.setPlayed(1);
		home.setGoalFor(homeGoal);
		home.setGoalAgainst(awayGoal);

		away.setPlayed(1);
		away.setGoalFor(awayGoal);
		away.setGoalAgainst(homeGoal);
	}

}
