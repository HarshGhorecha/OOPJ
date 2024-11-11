import java.util.Scanner;

// Batsman class to track individual batsman's runs and balls faced
class Batsman {
	String name;
	int runs;
	int ballsFaced;

	public Batsman(String name) {
		this.name = name;
		this.runs = 0;
		this.ballsFaced = 0;
	}

	public void addRuns(int runs) {
		this.runs += runs;
		this.ballsFaced++;
	}
}

// BatsmanManager class to handle the management of batsmen
class BatsmanManager {
	private Batsman[] batsmen;
	private int currentBatsmanIndex;
	private int nextBatsmanIndex;

	public BatsmanManager() {
		batsmen = new Batsman[2]; // Only two active batsmen at a time
		currentBatsmanIndex = 0;
		nextBatsmanIndex = 1;
	}

	public void initializeBatsmen(String batsman1Name, String batsman2Name) {
		batsmen[0] = new Batsman(batsman1Name);
		batsmen[1] = new Batsman(batsman2Name);
	}

	public Batsman getCurrentBatsman() {
		return batsmen[currentBatsmanIndex];
	}

	public Batsman getNextBatsman() {
		return batsmen[nextBatsmanIndex];
	}

	public void switchStrike() {
		int temp = currentBatsmanIndex;
		currentBatsmanIndex = nextBatsmanIndex;
		nextBatsmanIndex = temp;
	}

	public void replaceBatsman(String newBatsmanName) {
		batsmen[currentBatsmanIndex] = new Batsman(newBatsmanName);
	}

	public void displayBatsmanScores() {
		for (Batsman batsman : batsmen) {
			System.out.println("Batsman " + batsman.name + ": " + batsman.runs + " runs, Balls faced: " + batsman.ballsFaced);
		}
	}
}

// Match superclass
class Match {
	protected String team1Name;
	protected String team2Name;
	protected int overs;

	public Match(String team1Name, String team2Name, int overs) {
		this.team1Name = team1Name;
		this.team2Name = team2Name;
		this.overs = overs;
	}
}

// Cricketmatchhg class that manages the cricket match
class Cricketmatchhg extends Match {
	private int totalRuns;
	private int totalWickets;
	private int wideBalls;
	private int noBalls;
	private String[][] matchRuns;
	private BatsmanManager batsmanManager;

	public Cricketmatchhg(String team1Name, String team2Name, int overs) {
		super(team1Name, team2Name, overs);
		this.totalRuns = 0;
		this.totalWickets = 0;
		this.wideBalls = 0;
		this.noBalls = 0;
		this.matchRuns = new String[overs][6];
		this.batsmanManager = new BatsmanManager();
	}

	public void initializeMatch(String batsman1Name, String batsman2Name) {
		batsmanManager.initializeBatsmen(batsman1Name, batsman2Name);
	}

	public void handleBallOutcome(String outcome, Scanner scanner, int over, int ball) {
		switch (outcome) {
		case "W":
			totalWickets++;
			System.out.println("Wicket! Total wickets: " + totalWickets);
			System.out.print("Enter name for new batsman: ");
			String newBatsmanName = scanner.next();
			batsmanManager.replaceBatsman(newBatsmanName);
			break;
		case "WD":
			wideBalls++;
			totalRuns++;
			System.out.print("Did the ball reach the boundary on wide? Enter extra runs (0-4): ");
			int extraRuns = scanner.nextInt();
			totalRuns += extraRuns;
			break;
		case "NB":
			noBalls++;
			totalRuns++;
			System.out.print("Enter runs scored on the no-ball itself (0-6): ");
			int noBallRuns = scanner.nextInt();
			totalRuns += noBallRuns;
			System.out.print("Free hit! Enter runs scored on the free-hit ball (0-6): ");
			int freeHitRuns = scanner.nextInt();
			totalRuns += freeHitRuns;
			break;
		default:
			int runs = Integer.parseInt(outcome);
			totalRuns += runs;
			batsmanManager.getCurrentBatsman().addRuns(runs);
			break;
		}
		matchRuns[over][ball] = outcome; // Store the outcome for the scoreboard
	}

	public void displayMatchSummary() {
		System.out.println("Match over! Here's the summary:");
		System.out.println("Total runs: " + totalRuns);
		System.out.println("Total wickets: " + totalWickets);
		System.out.println("Total wide balls: " + wideBalls);
		System.out.println("Total no-balls: " + noBalls);
		batsmanManager.displayBatsmanScores();
		System.out.println(team2Name + " needs " + (totalRuns + 1) + " runs to win against " + team1Name + ".");
	}

	public void displayScoreboard() {
		System.out.println("Scoreboard:");
		for (int i = 0; i < overs; i++) {
			System.out.print("Over " + (i + 1) + ": ");
			for (int j = 0; j < 6; j++) {
				if (matchRuns[i][j] != null) {
					System.out.print(matchRuns[i][j] + " ");
				}
			}
			System.out.println();
		}
	}

	public double calculateRunRate() {
		return (double) totalRuns / (overs * 6); // Runs per over
	}
}

// Main class to run the program
public class CricketMatchSimulator {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Enter team names
		System.out.print("Enter Team 1 name: ");
		String team1Name = scanner.nextLine();
		System.out.print("Enter Team 2 name: ");
		String team2Name = scanner.nextLine();

		// Merge team names and calculate the length
		String combinedNames = team1Name + team2Name;
		int combinedLength = combinedNames.length();
		System.out.println("Concatenated string length: " + combinedLength);

		// Predefined toss
		String[] tossOutcomes = {"heads", "tails", "heads", "heads", "tails", "tails", "heads", "tails", "heads", "heads", "tails", "tails", "tails", "heads", "heads", "tails", "heads", "tails", "heads", "tails"};

		// Enter toss choice for Team 1
		System.out.print("Team 1, choose heads or tails: ");
		String team1Choice = scanner.nextLine().toLowerCase();

		// Calculate toss result based on the length of merged string
		String tossResult = tossOutcomes[combinedLength % tossOutcomes.length];
		System.out.println("Toss result: " + tossResult);

		// Find who won the toss
		String tossWinner;
		if (tossResult.equals(team1Choice)) {
			tossWinner = team1Name;
			System.out.println(team1Name + " wins the toss!");
		} else {
			tossWinner = team2Name;
			System.out.println(team2Name + " wins the toss!");
		}

		// Ask the toss winner to choose bat or bowl
		System.out.print(tossWinner + ", choose to bat or bowl: ");
		String decision = scanner.nextLine().toLowerCase();

		if (decision.equals("bat")) {
			System.out.println(tossWinner + " chooses to bat first.");
		} else if (decision.equals("bowl")) {
			System.out.println(tossWinner + " chooses to bowl first.");
		} else {
			System.out.println("Invalid choice, defaulting to batting.");
			decision = "bat";
		}

		// Create a match instance
		Cricketmatchhg match = new Cricketmatchhg(team1Name, team2Name, 20); // Assuming 20 overs

		// Initialize match with batsmen names
		System.out.print("Enter name for Batsman 1: ");
		String batsman1 = scanner.next();
		System.out.print("Enter name for Batsman 2: ");
		String batsman2 = scanner.next();
		match.initializeMatch(batsman1, batsman2);

		// Match simulation
		for (int over = 0; over < 20; over++) {
			for (int ball = 0; ball < 6; ball++) {
				System.out.print("Enter outcome for ball (runs, W for wicket, WD for wide, NB for no-ball): ");
				String outcome = scanner.next();
				match.handleBallOutcome(outcome, scanner, over, ball);
			}
			System.out.println("====================");
		}

		// Display scoreboard
		match.displayScoreboard();

// Calculate and display run rate
		double runRate = match.calculateRunRate();
		System.out.println("Current Run Rate: " + runRate);

		// Display match summary
		match.displayMatchSummary();

		scanner.close(); // Close the scanner to prevent resource leak
	}
}
