package programManagers.UserInterfaceManager.addPassword;

import programManagers.FileManager.FileManager;
import programManagers.PasswordManager.PasswordManager;

import javax.swing.*;

public class AddPwWindowCreator extends JFrame {

    private PasswordManager pwManager;
    private FileManager fileManager;
    private JFrame addPwWindow;
    private JPanel mainPanel;


    public AddPwWindowCreator(FileManager fileManager, PasswordManager pwManager) {

        super("Add a Password");
        this.pwManager = pwManager;
        this.fileManager = fileManager;

        addPwWindow = new JFrame("Add Password");
        addPwWindow.setLayout(new BoxLayout(addPwWindow.getContentPane(), BoxLayout.Y_AXIS));
        addPwWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addPwWindow.setLocationRelativeTo(null);

        mainPanel = new AddPasswordPanel(fileManager, pwManager);
        addPwWindow.add(mainPanel);
        addPwWindow.pack();
        addPwWindow.setVisible(true);

    }

}
