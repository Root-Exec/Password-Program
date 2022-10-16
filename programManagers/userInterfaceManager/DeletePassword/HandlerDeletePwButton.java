package programManagers.userInterfaceManager.DeletePassword;

import programManagers.FileManager.FileManager;
import programManagers.PasswordManager.PasswordManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HandlerDeletePwButton extends JButton implements ActionListener {
    private FileManager fileManager;
    private PasswordManager pwManager;

    public HandlerDeletePwButton(FileManager fileManager, PasswordManager pwManager) {
        super("Delete a password");
        this.fileManager = fileManager;
        this.pwManager = pwManager;
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DeletePwWindowCreator deletePwWindowCreatorPwWindow = new DeletePwWindowCreator(fileManager, pwManager);
    }

}
