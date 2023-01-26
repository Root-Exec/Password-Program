package programManagers.UserInterfaceManager.SecurityWindows;

import javax.swing.*;

public class LoginWindowCreator extends JFrame {

    private final int maxPasswordLength = 20;
    private JPanel passwordInputPanel;
    private JTextField userInputField = new JTextField(maxPasswordLength);

    private JPanel loginPanel;
    private JButton loginButton;

    LoginWindowCreator() {
        super("Log-in");
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        this.setVisible(true);
    }
}
