package programManagers.userInterfaceManager.UpdatePassword;

import programManagers.FileManager.FileManager;
import programManagers.PasswordManager.PasswordManager;
import programManagers.userInterfaceManager.GeneratePwEvent;
import programManagers.userInterfaceManager.RetrievePassword.SearchWindowPanel;
import programManagers.userInterfaceManager.addPassword.AddPasswordPanel;
import programManagers.userInterfaceManager.addPassword.AddPwWindowCreator;

import javax.swing.*;

public class UpdatePwWindowCreator extends JFrame {

        FileManager fileManager;
        PasswordManager pwManager;
        SearchWindowPanel searchWindowPanel;
        AddPasswordPanel addPwPanel;
        UpdatePwEvent updatePwAction;

        UpdatePwWindowCreator(FileManager fileManager, PasswordManager pwManager) {
            super("Update Password");
            this.fileManager = fileManager;
            this.pwManager = pwManager;


            this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
            this.setLocationRelativeTo(null);
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            searchWindowPanel = new SearchWindowPanel(fileManager, pwManager);
            addPwPanel = new AddPasswordPanel(fileManager, pwManager);
            this.add(searchWindowPanel);
            this.add(addPwPanel);

            updatePwAction = new UpdatePwEvent(pwManager, fileManager, addPwPanel.getAddRandomPwButton(),
                                               addPwPanel.getAddDefinedPwButton(), addPwPanel.getUserInputField(),
                                               addPwPanel.getUserDefinedPwField(), addPwPanel.getTextfields());

            addPwPanel.getAddRandomPwButton().removeActionListener(addPwPanel.generatePwAction);
            addPwPanel.getAddDefinedPwButton().removeActionListener(addPwPanel.generatePwAction);

            addPwPanel.getAddDefinedPwButton().addActionListener(updatePwAction);
            addPwPanel.getAddRandomPwButton().addActionListener(updatePwAction);

            this.pack();
            this.setVisible(true);
        }

}
