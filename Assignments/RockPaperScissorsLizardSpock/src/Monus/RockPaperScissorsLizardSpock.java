package Monus;

import java.util.Random;
import java.util.Scanner;

/**
 * Owen Monus
 * CS 30
 * ROCK PAPER SCISSORS LIZARD SPOCK
 *
 * Create a spectacle of computer-on-computer violence!
 * A program that plays a game of Rock Paper Scissors Lizard Spock between two computer-controlled players.
 * The program will keep playing rounds until one of the computer-controlled players wins a
 * user-defined amount of matches in a row.
 *
 * RULES:
 * Scissors cut Paper,
 * Paper covers Rock,
 * Rock crushes Lizard,
 * Lizard poisons Spock,
 * Spock melts Scissors,
 * Scissors decapitate Lizard,
 * Lizard eats Paper,
 * Paper disproves Spock,
 * Spock vaporizes Rock,
 * Rock breaks Scissors.
 */

public class RockPaperScissorsLizardSpock {
    private static final int rock = 0; //rock's assigned integer
    private static final int paper = 1; //paper's assigned integer
    private static final int scissors = 2; //scissors' assigned integer
    private static final int lizard = 3; //lizard's assigned integer
    private static final int spock = 4; //spock's assigned integer
    private static final int player1 = 1; //player 1 integer
    private static final int player2 = 2; //player 2 integer
    private int consecutiveWins; //a variable to track the winning players consecutive wins
    private int consecutiveWinGoal; //consecutive win goal
    private int lastWinner; //an integer that keeps track of who won last
    private int winner; //the current rounds winner
    private int p1Move; //p1 weapon selection
    private int p2Move; //p2 weapon selection
    private int gameCount = 0; //amount of games played

    //Sets the consecutive win goal, initializes p1 & p2's first weapons, and prints a header saying "Results: "
    public void setupGame() { //grabs an input from user and uses that as the consecutive win goal
        Scanner scan = new Scanner(System.in);
        System.out.print("How many consecutive wins are needed for victory? ");
        consecutiveWinGoal = scan.nextInt(); //sets consecutive win goal
        chooseWeapons(); // initializes player weapons
        System.out.println("\nThe results:");
    }

    //uses a random number generator to assign as player one's and player two's weapon of 'choice'
    public void chooseWeapons() {
        Random move = new Random();
        p1Move = move.nextInt(5); //random int from 0-4
        p2Move = move.nextInt(5); //random int from 0-4
    }

    //sets the new current game winner
    public void setWinner(int winner) {
        this.winner = winner;
    }

    //sets the consecutive wins count
    public void setConsecutiveWins(int consecutiveWins) {
        this.consecutiveWins = consecutiveWins;
    }

    //a method that checks if the new winner (int winner) is equal to the last winner (int lastWinner)
    public void isNewWinnerLastWinner(int winner) {
        if (gameCount < 1) { //if it is the first game, the last winner is set to the first winner
            lastWinner = winner;
        } else { //if it is not the first game
            if (lastWinner == winner) { //if the winner of the last  is the same as the last winner
                consecutiveWins++;
            } else { //if the new winner != the last winner
                setConsecutiveWins(0); //consecutive wins set to 0
                lastWinner = winner;
            }
        }
    }

    /*
    The following method does comparisons to determine if player 1 or player 2 won the round of RPSLS.
    They compare p1's move to p2's move. The first if statement compares the two to see if it is a tie. If
    it is a tie, then consecutive wins is set back to zero, and the winner is player 0, or no winner. The else if
    statement is specific to each method as each weapon has different strengths. Into this method is passed the moves
    that p1's move will beat. For example, if it is rock's weaponBeats(), the actual parameters will be
    lizard and scissors, because that is what rock beats. The else statement encompasses all cases in which rock would
    lose.
    */
    public void weaponBeats(int losingMove, int aLosingMove) {
        if (p1Move == p2Move) { //tie
            setConsecutiveWins(0);
            setWinner(0);
        } else if (p2Move == losingMove || p2Move == aLosingMove) { //if p1 wins
            winner = player1; //player 1 set to winner
        } else { //if p1 loses
            winner = player2;
        }
    }

    //a method that takes the formatting index and a string to stick into it, and then it is printed as a string
    public void resultFormatting(int index, String aOutput) {
        System.out.printf("%-" + index + "s", "|" + aOutput);
    }

    //a method that takes the formatting index and an integer to stick into it, and then it is printed as a string
    public void resultFormatting(int index, int aOutput) {
        System.out.printf("%-" + index + "s", "|" + aOutput);
    }

    //changes the weapon from an int to a string, it makes it prints nicely
    public void weaponNameFormatting(int index, int aWeapon) {
        String weapon = "none";
        switch (aWeapon) {
            case 0:
                weapon = "Rock";
                break;
            case 1:
                weapon = "Paper";
                break;
            case 2:
                weapon = "Scissors";
                break;
            case 3:
                weapon = "Lizard";
                break;
            case 4:
                weapon = "Spock";
                break;
        }
        System.out.printf("%-" + index + "s", "|" + weapon);
    }

    //Prints round results including a header every 25 rounds
    private void printResults() {
        if ((gameCount % 25) == 1) { //prints the header every 25 rounds
            resultFormatting(10, "P1 Move");
            resultFormatting(10, "P2 Move");
            resultFormatting(9, "Winner");
            resultFormatting(14, "Game Number");
            resultFormatting(19, "Consecutive Wins");
            resultFormatting(2, "\n"); //adds the last slash on the table and prints a new line
        }
        weaponNameFormatting(10, p1Move); //prints p1 move
        weaponNameFormatting(10, p2Move); //prints p2 move
        resultFormatting(9, winner); //prints the round winner
        resultFormatting(14, gameCount); //prints the game count
        resultFormatting(19, consecutiveWins); //prints the current number of consecutive wins
        resultFormatting(1, "\n"); //adds the last slash on the table and prints a new line
    }

    //the main method that runs the game
    public void playGame() {
        /*
        A for loop that begins by setting up the game. This loop will run while
        consecutive wins is less than the consecutive win goal. Every time the loop runs, the chooseWeapons() method
        runs to set p1 and p2's moves.
         */
        for (setupGame(); consecutiveWins < consecutiveWinGoal; chooseWeapons()) {
            gameCount++; //increases game count by one; not in for arguments so the first game doesn't show up as game 0
            /*
            The following switch statement uses player one's move as the basis for comparison. So if p1 chooses rock,
            the rock case will be executed. In each case is weaponBeats(), the actual parameters being the two weapons
            the case's namesake beats. e.g.
            *   case rock: //p1 chooses rock
            *       weaponBeats(lizard, scissors); //rock defeats lizard and scissors
            *       break; //exit switch statement
             */
            switch (p1Move) {
                case rock:
                    weaponBeats(lizard, scissors);
                    break;
                case paper:
                    weaponBeats(rock, spock);
                    break;
                case scissors:
                    weaponBeats(paper, lizard);
                    break;
                case lizard:
                    weaponBeats(paper, spock);
                    break;
                case spock:
                    weaponBeats(rock, scissors);
                    break;
            }
            isNewWinnerLastWinner(winner); //checks to see if consecutiveWins should be increased or reset
            printResults(); //prints out the rounds result
        }
        //Prints out the entire game's statistics.
        System.out.println("\nAfter " + gameCount + " games, Player " + winner + " was victorious!");
    }
}

