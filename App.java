import javax.swing.SwingUtilities;

public class App {
    public static void main (String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // instantiate a RockPaperScissorGUI object
                RockPaperScissorGUI rockPaperScissorGUI = new RockPaperScissorGUI();

                // display the GUI
                rockPaperScissorGUI.setVisible(true);
            }
        });
    }
}