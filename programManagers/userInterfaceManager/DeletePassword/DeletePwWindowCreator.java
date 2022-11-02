package programManagers.userInterfaceManager.DeletePassword;

import programManagers.FileManager.FileManager;
import programManagers.PasswordManager.PasswordManager;
import programManagers.userInterfaceManager.RetrievePassword.SearchPwWindowCreator;
import programManagers.userInterfaceManager.RetrievePassword.SearchWindowPanel;

import javax.swing.*;
import java.awt.*;

public class DeletePwWindowCreator extends JFrame {
        FileManager fileManager;
        PasswordManager pwManager;
        SearchWindowPanel searchPanel;
        JButton deleteButton;
        DeletePwEvent deleteAction;

        public DeletePwWindowCreator (FileManager fileManager, PasswordManager pwManager) {
            super("Delete Password");
            this.fileManager = fileManager;
            this.pwManager = pwManager;
            this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.setLocationRelativeTo(null);

            searchPanel = new SearchWindowPanel(fileManager, pwManager);
            this.add(searchPanel);

            deleteButton = new JButton("Delete");
            deleteAction = new DeletePwEvent(fileManager, searchPanel.getPwNameInput(), searchPanel.getResultsField());
            deleteButton.addActionListener(deleteAction);
            this.add(deleteButton);

            this.pack();
            this.setVisible(true);
        }
}
