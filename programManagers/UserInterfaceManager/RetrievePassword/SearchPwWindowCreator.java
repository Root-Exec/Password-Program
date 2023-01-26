package programManagers.UserInterfaceManager.RetrievePassword;

import programManagers.FileManager.FileManager;
import programManagers.PasswordManager.PasswordManager;

import javax.swing.*;
import java.awt.*;

public class SearchPwWindowCreator extends JFrame {

    private FileManager fileManager;
    private PasswordManager pwManager;
    protected JPanel mainPanel;

    public SearchPwWindowCreator(FileManager fileManager, PasswordManager pwManager) {
        super("Password Search");
        this.fileManager = fileManager;
        this.pwManager = pwManager;

        this.setLayout(new FlowLayout());
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        mainPanel = new SearchWindowPanel(fileManager, pwManager);
        this.add(mainPanel);
        this.pack();
        this.setVisible(true);
    }
}
