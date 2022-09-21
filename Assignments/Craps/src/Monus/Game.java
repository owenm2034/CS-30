package Monus;

import java.util.Arrays;
import java.util.Scanner;

public class Game {
    Scanner scan = new Scanner(System.in);
    DiceCup diceCup = new DiceCup(2, 6);
    Player operator = new Player();

    static final int win = 1;
    static final int loss = 2;
    static final int undecided = 0;

    int point;
    int rounds;
    int rollResult;
    int gameResult = undecided;
    boolean firstGame = true;
    int[] winningNumbers = {7, 11};
    int[] losingNumbers = {2, 3, 12};


    Game() {
        System.out.println("Welcome to Craps!");
    }

    public void playGame() {
        if (firstGame) {
            introduceCraps();
            firstGame = false;
        }
        firstRound();
        while (gameResult == undecided) {
            roll();
            displayRollResults();
            continueGame();
        }
        displayGameResult();
        playAgain();
    }

    public void introduceCraps() {
        System.out.print("Would you like to hear the rules? (Y/n) ");
        String response = (scan.nextLine());
        if (response.equalsIgnoreCase("Y") || response.equalsIgnoreCase("YES")) {
            displayRules();
        } else if (!(response.equalsIgnoreCase("N") || response.equalsIgnoreCase("NO"))) {
            System.out.println("Invalid response, please try again.");
            introduceCraps();
        }
    }

    public void firstRound() {
        roll();
        displayRollResults();
        if (continueGame()) {
            System.out.println("That's your point.");
            System.out.println("Lets see if you can roll it before a 7...");

            Arrays.fill(winningNumbers, point);
            Arrays.fill(losingNumbers, 7);
        }
    }

    public void roll() {
        if (operator.readyToRoll()) {
            rollResult = diceCup.combinatorialRoll();
        }
        if (point == 0) {
            point = rollResult;
        }
        rounds++;
    }

    public boolean continueGame() {
        if (rollInArray(winningNumbers)) {
            gameResult = win;
            return false;
        } else if (rollInArray(losingNumbers)) {
            gameResult = loss;
            return false;
        } else {
            return true;
        }
    }

    boolean rollInArray(int[] array) {
        for (int target : array) {
            if (target == rollResult) {
                return true;
            }
        }
        return false;
    }

    public void displayGameResult() {
        switch (gameResult) {
            case win: {
                if(rounds > 1) {
                    System.out.println("You rolled the point. You won!");
                }
                else if (rounds == 1) {
                    System.out.println("You won!");
                }
                break;
            }
            case loss: {
                if (rounds > 1) {
                    System.out.println("You rolled a 7 before the point (" + point + "). You lose.");
                }
                else {
                    System.out.println("You lose.");
                }
                break;
            }
        }
        System.out.println("\nThis game took " + rounds + " rounds to finish.");
    }

    void displayRules() {
        System.out.println("Craps is a relatively simple game, the rules are as follows:");
        System.out.println("\nTwo six-sided dice are rolled and the numbers are added together.");
        System.out.println("If a 7 or an 11 is rolled, you win!");
        System.out.println("If a 2, 3, or 12 is rolled, play is over.");
        System.out.println("Any other number rolled on this first roll becomes the \"point\"");
        System.out.println("\nKeep rolling until:");
        System.out.println("    a. you roll the \"point\" again and win");
        System.out.println("    b. or you roll a 7 and lose\n");
    }

    public void displayRollResults() {
        if (continueGame() && rounds > 1) {
            System.out.println("The point is: " + point);
        }
        System.out.println("You rolled: " + rollResult);
    }

    public void playAgain() {
        System.out.println("Would you like to play again? (Y/n)");
        String response = (scan.nextLine());
        if (response.equalsIgnoreCase("Y") || response.equalsIgnoreCase("YES")) {
            reset();
            playGame();
        }
    }

    void reset() {
        point = 0;
        rounds = 0;
        rollResult = 0;
        gameResult = undecided;
    }
}

