import java.util.Scanner;

class Cricketmatchhg {
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

        // Calculate toss result based on the length of  merged string 
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

        // Ask how many overs the match want 
        System.out.print("Enter number of overs for the match: ");
        int overs = scanner.nextInt();
        int ballsPerOver = 6;

        // Variables to store match details
        int totalRuns = 0;
        int totalWickets = 0;
        int wideBalls = 0;
        int noBalls = 0;

        // Create a 2D array to store runs for each ball
        String[][] matchRuns = new String[overs][ballsPerOver];

        
        String[] batsmen = new String[2];
        int[] runsScored = new int[2]; // Total runs for each batsman
        int currentBatsmanIndex = 0; // Index for the batsman on strike
        int nextBatsmanIndex = 1; // Index for the next batsman

        // Enter batsman name 
        System.out.print("Enter name for Batsman 1: ");
        batsmen[0] = scanner.next();
        System.out.print("Enter name for Batsman 2: ");
        batsmen[1] = scanner.next();

        // Enter runs for each ball
        for (int over = 0; over < overs; over++) {
            System.out.println("Over " + (over + 1) + ":");

            for (int ball = 0; ball < ballsPerOver; ) {
                System.out.println("Enter run,W(wicket), WD(wide), NB(no-ball) ball " + (ball + 1) + ": ");
                String input = scanner.next().toUpperCase();

                // Rule 1: Max 6 runs
                if (input.matches("[0-6]")) {
                    int runs = Integer.parseInt(input);
                    totalRuns += runs;
                    matchRuns[over][ball] = input;
                    runsScored[currentBatsmanIndex] += runs;
                    ball++; 

                } else if (input.equals("W")) {
                    // Rule 2: Wicket
                    totalWickets++;
                    matchRuns[over][ball] = "W";
                    ball++; 
                    System.out.println("Wicket! Total wickets: " + totalWickets);
                    
                    // Enter new batsman name
                    System.out.print("Enter name for new batsman: ");
                    batsmen[currentBatsmanIndex] = scanner.next();

                } else if (input.equals("WD")) {
                    // Rule 3: Wide ball with extra runs
                    wideBalls++;
                    totalRuns++; // Extra run for wide
                    System.out.println("Wide ball! Extra run awarded. Total wides: " + wideBalls);

                    // Ask if additional runs were scored due to wide (0 to 4)
                    System.out.print("Did the ball reach the boundary on wide? Enter extra runs (0-4): ");
                    int extraRuns = scanner.nextInt();
                    if (extraRuns < 0 || extraRuns > 4) {
                        System.out.println("Invalid extra runs entered, please re-enter.");
                        continue;
                    }
                    totalRuns += extraRuns;
                    System.out.println("Total runs after wide and extra: " + (1 + extraRuns));

                    // Do not increment ball, as wide doesn't count towards the over

                } else if (input.equals("NB")) {
                    // Rule 4: No-ball with free hit
                    noBalls++;
                    totalRuns++; // Extra run for no-ball
                    System.out.println("No-ball! Extra run awarded. Total no-balls: " + noBalls);

                    // Ask if any runs were scored on the no-ball
                    System.out.print("Enter runs scored on the no-ball itself (0-6): ");
                    int noBallRuns = scanner.nextInt();
                    totalRuns += noBallRuns;
                    System.out.println("Total runs after no-ball and runs: " + (1 + noBallRuns));

                    // Free-hit
                    System.out.print("Free hit! Enter runs scored on the free-hit ball (0-6): ");
                    int freeHitRuns = scanner.nextInt();
                    totalRuns += freeHitRuns;
                    System.out.println("Total runs after free hit: " + freeHitRuns);

                    matchRuns[over][ball] = "NB + " + noBallRuns + " + Free Hit " + freeHitRuns;
                    ball++; 

                } else {
                    System.out.println("Invalid input. Please enter a valid value (0-6, W, WD, NB).");
                }

                // Update the scoreboard after each ball
                displayScoreboard(totalRuns, totalWickets, over + 1, overs);

                // Check if it's the last ball of the over
                if (ball == ballsPerOver) {
                    // Change strike at the end of the over
                    currentBatsmanIndex = (currentBatsmanIndex + 1) % 2;
                    System.out.println("End of over " + (over + 1) + ":");
                    System.out.println("=∆=∆=∆=∆=∆=∆=∆=∆=∆=∆=∆=∆=∆=∆=∆=∆=∆=∆=∆=∆=");
                }
            }
        }

        // Display final match records 
        System.out.println("Match over! Here's the summary:");
        System.out.println("Total runs: " + totalRuns);
        System.out.println("Total wickets: " + totalWickets);
        System.out.println("Total wide balls: " + wideBalls);
        System.out.println("Total no-balls: " + noBalls);

        // Display batsman details
        for (int i = 0; i < 2; i++) {
            System.out.println("Batsman " + batsmen[i] + ": " + runsScored[i] + " runs");
        }

        //  on strike batsman 
        System.out.println("On strike: " + batsmen[currentBatsmanIndex]);

        // Display opponent team and runs needed to win
        System.out.println(team2Name + " needs " + (totalRuns + 1) + " runs to win against " + team1Name + ".");

        scanner.close();
    }

    //  display the scoreboard
    static void displayScoreboard(int totalRuns, int totalWickets, int oversCompleted, int totalOvers) {
        double runRate = (double) totalRuns / oversCompleted;
        System.out.printf("%s: %d/%d (%d overs)  Run Rate: %.2f%n", "Score", totalRuns, totalWickets, oversCompleted, runRate);
    }
                        }
