// backend
import java.util.*;

public class RockPaperScissor {
    // all of the choices that a computer can make
    public static final String[] computerChoices = {"Rock", "Paper", "Scissors"};

    public String getcomputerChoice() {
        return computerChoice;
    }

    public int getcomputerScore() {
        return computerScore;
    }

    public int getplayerScore() {
        return playerScore;
    }

    // store the computer choice so that we can retreive the value and display it to the front end
    private String computerChoice;

    // store the score so that we we can retreive the values and display it to the frontend
    private int computerScore, playerScore;

    // use to generate a random number to chose a option for the computer randomly
    private Random random;

    // constructor to initailize the random object
    public RockPaperScissor() {
        random = new Random();
    }

    // call this method to begin playing rock paper scissors
    // this method will return the result of the game i.e; computer win, player win, draw
    public String playRockPaperScissor(String playerChoice) {
        // generate computer choice
        computerChoice = computerChoices[random.nextInt(computerChoices.length)];

        // will contain the returning message indicating the result of the game
        String result;

        // evaluate the winner
        if (computerChoice.equals("Rock")) {
            if (playerChoice.equals("Paper")) {
                result = "Player wins";
                playerScore++;
            } else if (playerChoice.equals("Scissors")) {
                result = "Computer wins";
                computerScore++;
            } else {
                result = "Draw";
            }
        } else if (computerChoice.equals("Paper")) {
            if (playerChoice.equals("Scissors")) {
                result = "Player wins";
                playerScore++;
            } else if (playerChoice.equals("Rock")) {
                result = "Computer wins";
                computerScore++;
            } else {
                result = "Draw";
            }
        } else {
            if (playerChoice.equals("Rock")) {
                result = "Player wins";
                playerScore++;
            } else if (playerChoice.equals("Paper")) {
                result = "Computer wins";
                computerScore++;
            } else {
                result = "Draw";
            }
        }

        return result;
    }
}