package programManagers.userInterfaceManager.DeletePassword;

import programManagers.FileManager.FileManager;
import programManagers.PasswordManager.PasswordManager;
import programManagers.userInterfaceManager.RetrievePassword.SearchPwWindowCreator;

import javax.swing.*;
import java.awt.*;

public class DeletePwWindowCreator extends SearchPwWindowCreator {



        public DeletePwWindowCreator (FileManager fileManager, PasswordManager pwManager) {
            super(fileManager, pwManager);
            JPanel deletePwPanel = new JPanel();
            deletePwPanel.setLayout(new FlowLayout());
            JButton deleteButton = new JButton("Delete Password");
            deletePwEvent deletePw = new deletePwEvent(fileManager, passwordNameInput, results);
            deleteButton.addActionListener(deletePw);
            deletePwPanel.add(deleteButton);
            pwSearch.add(deletePwPanel);
            pwSearch.revalidate();
            pwSearch.pack();
        }
}
