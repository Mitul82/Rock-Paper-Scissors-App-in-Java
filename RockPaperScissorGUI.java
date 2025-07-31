// frontend
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RockPaperScissorGUI extends JFrame implements ActionListener {
    // player buttons
    JButton rockButton, paperButton, scissorButton;

    // will display the choice of the computer
    JLabel computerChoice;

    // backend object (linking back end and front end)
    RockPaperScissor rps;

    // will display the score of the computer and the player
    JLabel computerScoreLabel, playerScoreLabel;

    public RockPaperScissorGUI() {
        // ivoking the jframe constructor and adding title to the GUI
        super("Rock Paper Scissors");

        // setting the size of the gui
        setSize(450, 574);

        // set layout to null to disable layout management, so we can use absolute positioning for the elements
        // (i.e, seeting x,y coordinates and width/height values)
        setLayout(null);

        // terminate the java virtual macheine when the GUI is closed
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // load GUI in the center of the screen every time we run the application
        setLocationRelativeTo(null);

        // initialize the backend object
        rps = new RockPaperScissor();

        // add GUI components
        addGUIcomponents();
    }

    private void addGUIcomponents() {
        // create computer score lable
        computerScoreLabel = new JLabel("Computer : 0");

        // set x,y coordiantes and width/height
        computerScoreLabel.setBounds(0, 43, 450, 30);

        // set the font to have a font family of dialof, font weight of bold and font seize of 26
        computerScoreLabel.setFont(new Font("Dialog", Font.BOLD, 26));

        // place the text in the center
        computerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // add to GUI
        add(computerScoreLabel);

        // create computer choice
        // setting the defaut value to "?" so that the value can be hidden again after each round
        computerChoice = new JLabel("?");

        computerChoice.setBounds(175, 118, 98, 81);

        computerChoice.setFont(new Font("Dialog", Font.PLAIN, 18));

        computerChoice.setHorizontalAlignment(SwingConstants.CENTER);

        // create a black border around
        computerChoice.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        add(computerChoice);

        // create player score lable
        playerScoreLabel = new JLabel("Player: 0");

        playerScoreLabel.setBounds(0, 317, 450, 30);

        playerScoreLabel.setFont(new Font("Dialog", Font.BOLD, 26));

        playerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);

        add(playerScoreLabel);

        // adding the rock paper and scissors buttons
        // rock button
        rockButton = new JButton("Rock");
        rockButton.setBounds(40, 387, 105, 81);
        rockButton.setFont(new Font("Dialog", Font.PLAIN, 18));
        rockButton.addActionListener(this);
        add(rockButton);

        // paper button
        paperButton = new JButton("Paper");
        paperButton.setBounds(165, 387, 105, 81);
        paperButton.setFont(new Font("Dialog", Font.PLAIN, 18));
        paperButton.addActionListener(this);
        add(paperButton);

        // scissors button
        scissorButton = new JButton("Scissors");
        scissorButton.setBounds(290, 387, 105, 81);
        scissorButton.setFont(new Font("Dialog", Font.PLAIN, 18));
        scissorButton.addActionListener(this);
        add(scissorButton);
    }

    // displays a message dialog which will show the winner and try again button to play again
    private void showDialog(String message) {
        JDialog resultDialog = new JDialog(this, "Result", true);
        resultDialog.setSize(227, 124);
        resultDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        resultDialog.setResizable(false);

        // message label
        JLabel resultLabel = new JLabel(message);
        resultLabel.setFont(new Font("Dialog", Font.BOLD, 18));
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultDialog.add(resultLabel, BorderLayout.CENTER);

        // adding a try again button to the dialog box
        JButton tryAgainButton = new JButton("Try Again?");
        tryAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // reset computer choice
                computerChoice.setText("?");

                // close the dialog box
                resultDialog.dispose();
            }
        });

        resultDialog.add(tryAgainButton, BorderLayout.SOUTH);

        resultDialog.setLocationRelativeTo(this);

        resultDialog.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // get player choice
        String playerChoice = e.getActionCommand().toString();

        // play rock paper scissor and store results into string var
        String result = rps.playRockPaperScissor(playerChoice);

        // load computers choice
        computerChoice.setText(rps.getcomputerChoice());

        // update the score labels
        computerScoreLabel.setText("Computer: " + rps.getcomputerScore());
        playerScoreLabel.setText("Player: " + rps.getplayerScore());

        showDialog(result);
    }
}