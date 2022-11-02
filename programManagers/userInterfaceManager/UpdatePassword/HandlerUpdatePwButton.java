package programManagers.userInterfaceManager.UpdatePassword;

import programManagers.FileManager.FileManager;
import programManagers.PasswordManager.PasswordManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HandlerUpdatePwButton extends JButton implements ActionListener {

    FileManager fileManager;
    PasswordManager pwManager;

    public HandlerUpdatePwButton(FileManager fileManager, PasswordManager pwManager) {
        super("Update a password");
        this.addActionListener(this);
        this.fileManager = fileManager;
        this.pwManager = pwManager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        UpdatePwWindowCreator updatePwWindow = new UpdatePwWindowCreator(fileManager, pwManager);

    }
}
