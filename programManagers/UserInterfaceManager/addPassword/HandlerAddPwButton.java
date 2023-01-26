package programManagers.UserInterfaceManager.addPassword;

import programManagers.FileManager.FileManager;
import programManagers.PasswordManager.PasswordManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HandlerAddPwButton extends JButton implements ActionListener {
    private PasswordManager pwManager;
    private FileManager fileManager;

    public HandlerAddPwButton(PasswordManager pwManager, FileManager fileManager) {
        super("Add a Password");
        this.pwManager = pwManager;
        this.fileManager = fileManager;
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (pwManager == null) {System.out.println("Invalid pwManager object");}
        AddPwWindowCreator addPwWindowCreator = new AddPwWindowCreator(fileManager, pwManager);
    }
}
