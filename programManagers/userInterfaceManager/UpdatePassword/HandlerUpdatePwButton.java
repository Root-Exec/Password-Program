package programManagers.userInterfaceManager.UpdatePassword;

import programManagers.FileManager.FileManager;
import programManagers.PasswordManager.PasswordManager;
import programManagers.userInterfaceManager.RetrievePassword.SearchPwWindowCreator;

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
        SearchPwWindowCreator searchPwWindow = new SearchPwWindowCreator(fileManager, pwManager);

        /*
        JFrame updatePwWindow = new JFrame("Update Password");
        updatePwWindow.setLayout(new BoxLayout(updatePwWindow.getContentPane(), BoxLayout.Y_AXIS));
        updatePwWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        updatePwWindow.setLocationRelativeTo(null);

        JPanel searchBarPanel = new JPanel();
        searchBarPanel.setLayout(new FlowLayout());
        JLabel searchLabel = new JLabel("Password Search: ");
        JTextField userInputField = new JTextField(20);
        JButton searchButton = new JButton("Search");
        searchBarPanel.add(searchLabel);
        searchBarPanel.add(userInputField);
        searchBarPanel.add(searchButton);

        JPanel resultsPanel = new JPanel();
        resultsPanel.setLayout(new FlowLayout());
        JLabel resultsLabel = new JLabel("Result: ");
        JTextField resultsField = new JTextField(25);
        resultsField.enableInputMethods(false);
        resultsPanel.add(resultsLabel);
        resultsPanel.add(resultsField);

        searchButton.addActionListener(new SearchPwEvent(fileManager, userInputField, resultsField));

        updatePwWindow.add(searchBarPanel);
        updatePwWindow.add(resultsPanel);
        updatePwWindow.pack();
        updatePwWindow.setVisible(true);


         */


    }
}
