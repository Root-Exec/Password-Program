package programManagers.userInterfaceManager.RetrievePassword;

import programManagers.FileManager.FileManager;
import programManagers.PasswordManager.PasswordManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchPwEvent implements ActionListener {

    private FileManager fileManager;
    private PasswordManager pwManager;
    private JTextField pwName;
    private JTextField results;

    public SearchPwEvent(FileManager fileManager, PasswordManager pwManager, JTextField pwNameInput, JTextField results) {
        this.fileManager = fileManager;
        this.pwName = pwNameInput;
        this.pwManager = pwManager;
        this.results = results;
        results.enableInputMethods(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        pwName.setText(pwName.getText());
        results.setText(fileManager.retrievePassword(pwName.getText()));
    }
}
