import java.util.Scanner;

// Abstract class representing a generic inning
abstract class Inning {
    int totalRuns = 0;
    int totalWickets = 0;
    int totalBalls = 0;
    int totalNoBalls = 0;
    int totalWideBalls = 0;
    int totalExtraRuns = 0;

    // Abstract method to implement subclasses
    public abstract void playInning(Scanner scanner);

    // Print the result of the inning
    public void printResult(String inningName) {
        System.out.println("\nEnd of " + inningName + " Innings:");
        System.out.println("Total Runs: " + totalRuns);
        System.out.println("Total Wickets: " + totalWickets);
        System.out.println("Total No-balls: " + totalNoBalls);
        System.out.println("Total Wide-balls: " + totalWideBalls);
        System.out.println("Total Extra Runs: " + totalExtraRuns);
        for (int i = 0; i < 20; i++) {
                System.out.print("=∆=");
                try {
                    Thread.sleep(100);  // Short delay for animation effect
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
    }
  }

    // Display the match summary
    public void printMatchSummary(Inning otherInning) {
        System.out.println("\nMatch Summary:");
        System.out.println("First Innings - Runs: " + this.totalRuns + " Wickets: " + this.totalWickets);
        System.out.println("Second Innings - Runs: " + otherInning.totalRuns + " Wickets: " + otherInning.totalWickets);

        if (this.totalRuns > otherInning.totalRuns) {
            System.out.println("First team wins by " + (this.totalRuns - otherInning.totalRuns) + " runs!");
        } else if (otherInning.totalRuns > this.totalRuns) {
            System.out.println("Second team wins by " + (10 - otherInning.totalWickets) + " wickets!");
        } else {
            System.out.println("The match is a tie!");
        }
    }
}

// Concrete class for playing a regular inning
class RegularInning extends Inning {

    public RegularInning(int totalBalls) {
        this.totalBalls = totalBalls;
    }

    @Override
    public void playInning(Scanner scanner) {
        int validBall = 0;
        boolean freeHit = false;
        int currentOver = 1;
        int overRuns = 0;
        StringBuilder overSummary = new StringBuilder();

        // Loop through all the balls in the inning
        for (int i = 0; validBall < totalBalls; i++) {
            if (totalWickets >= 10) {
                System.out.println("Innings Over - All Players Out!");
                break;
            }

            // Announce the start of a new over
            if (validBall % 6 == 0) {
                System.out.println("\nStart of Over " + currentOver);
            }

            // Enter run or wicket or no-ball or wide-ball
            System.out.print("Ball " + ((validBall % 6) + 1) + ": Enter Run (W for Wicket, N for No-ball, WB for Wide-ball, or runs 0-6): ");
            String input = scanner.next().toUpperCase();

            // Check if this input is correct or not
            while (!input.equals("W") && !input.equals("N") && !input.equals("WB") && !isValidRun(input)) {
                System.out.print("Invalid input. Please enter W (Wicket), N (No-ball), WB (Wide-ball), or a number between 0 and 6 for runs: ");
                input = scanner.next().toUpperCase();
            }

            switch (input) {
                case "W":
                    if (freeHit) {
                        System.out.println("Free hit! Wicket not counted.");
                    } else {
                        totalWickets++;
                    }
                    overSummary.append("Wicket, ");
                    validBall++;
                    freeHit = false;
                    break;
                case "N":
                    totalRuns++;  // If No-ball adds 1 run
                    totalNoBalls++;
                    overRuns++;
                    freeHit = true;
                    System.out.print("Enter the runs scored on this no-ball (0-6): ");
                    int noBallRuns = getValidRun(scanner);
                    totalRuns += noBallRuns;
                    overRuns += noBallRuns;
                    totalExtraRuns += noBallRuns;
                    overSummary.append("N " + noBallRuns + ", ");
                    break;
                case "WB":
                    totalRuns++;  // If Wide-ball adds 1 run
                    totalWideBalls++;
                    overRuns++;
                    System.out.print("Enter the runs scored on this wide-ball (0-6): ");
                    int wideBallRuns = getValidRun(scanner);
                    totalRuns += wideBallRuns;
                    overRuns += wideBallRuns;
                    totalExtraRuns += wideBallRuns;
                    overSummary.append("WB " + wideBallRuns + ", ");
                    break;
                default:
                    int runs = Integer.parseInt(input);
                    totalRuns += runs;
                    overRuns += runs;
                    overSummary.append(input + ", ");
                    validBall++;
                    freeHit = false;
            }

            // End of over summary every 6 balls
            if (validBall % 6 == 0 && validBall != 0) {
                System.out.println("\nEnd of Over " + currentOver + " Summary: ");
                System.out.println(overSummary.toString().substring(0, overSummary.length() - 2));
                System.out.println("Total runs this over: " + overRuns);
                overSummary.setLength(0); // Reset the over summary
                overRuns = 0; // Reset runs for the next over
                currentOver++;
            }
        }
    }

    // This method checks if the run input is between 0 and 6
    public boolean isValidRun(String input) {
        try {
            int run = Integer.parseInt(input);
            return run >= 0 && run <= 6;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // This method gets correct run input
    public int getValidRun(Scanner scanner) {
        int run = -1;
        while (run < 0 || run > 6) {
            try {
                run = scanner.nextInt();
                if (run < 0 || run > 6) {
                    System.out.print("Invalid input. Enter a number between 0 and 6: ");
                }
            } catch (Exception e) {
                System.out.print("Invalid input. Enter a number between 0 and 6: ");
                scanner.next();
            }
        }
        return run;
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        // Input team names
        System.out.print("Enter Team 1 name: ");
        String team1Name = scanner.nextLine();
        
        System.out.print("Enter Team 2 name: ");
        String team2Name = scanner.nextLine();

        // Toss logic
        String[] tossOptions = {"Heads", "Tails"};
        String tossResult = tossOptions[(int)(Math.random() * tossOptions.length)];
        
        System.out.print(team1Name + ", choose Heads or Tails: ");
        String team1Choice = scanner.nextLine();

        if (team1Choice.equalsIgnoreCase(tossResult)) {
            System.out.println(tossResult + "! " + team1Name + " wins the toss.");
        } else {
            System.out.println(tossResult + "! " + team2Name + " wins the toss.");
        }

        // Enter number of overs for each inning
        System.out.print("Enter the number of overs for each inning: ");
        int numOvers = scanner.nextInt();
        
        int totalBalls = numOvers * 6; // Calculate total balls based on overs

        // First inning start
        Inning firstInning = new RegularInning(totalBalls);
        System.out.println("\n" + team1Name + "'s Innings Start:");
        firstInning.playInning(scanner);
        
        firstInning.printResult(team1Name);

        // Second inning start
        Inning secondInning = new RegularInning(totalBalls);
        System.out.println("\n" + team2Name + "'s Innings Start:");
        secondInning.playInning(scanner);
        
        secondInning.printResult(team2Name);

        // Match result comparison and summary
        firstInning.printMatchSummary(secondInning);

       scanner.close(); // Close the scanner resource
   }
}
