package programManagers.userInterfaceManager.RetrievePassword;

import programManagers.FileManager.FileManager;
import programManagers.PasswordManager.PasswordManager;
import programManagers.userInterfaceManager.RetrievePassword.SearchPwWindowCreator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HandlerRetrievePwButton extends JButton implements ActionListener {

    private FileManager fileManager;
    private PasswordManager pwManager;

    public HandlerRetrievePwButton(FileManager fileManager, PasswordManager pwManager) {
        super("Retrieve a Password");
        this.addActionListener(this);
        this.fileManager = fileManager;
        this.pwManager = pwManager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        SearchPwWindowCreator searchPwWindow = new SearchPwWindowCreator(fileManager, pwManager);
    }
}
