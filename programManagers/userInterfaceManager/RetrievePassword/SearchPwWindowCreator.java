package programManagers.userInterfaceManager.RetrievePassword;

import programManagers.FileManager.FileManager;
import programManagers.PasswordManager.PasswordManager;
import programManagers.userInterfaceManager.RetrievePassword.SearchPwEvent;

import javax.swing.*;
import java.awt.*;

public class SearchPwWindowCreator extends JFrame {

    private FileManager fileManager;
    private PasswordManager pwManager;
    private SearchPwEvent searchPw;
    protected JTextField passwordNameInput;
    protected JFrame pwSearch;
    protected JPanel userInputLine;
    protected JPanel resultsLine;
    protected JTextField results;

    public SearchPwWindowCreator(FileManager fileManager, PasswordManager pwManager) {
        this.fileManager = fileManager;
        this.pwManager = pwManager;

        pwSearch = new JFrame("Password Search");
        pwSearch.setLayout(new BoxLayout(pwSearch.getContentPane(), BoxLayout.Y_AXIS));
        pwSearch.setLocationRelativeTo(null);
        pwSearch.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        userInputLine = new JPanel(new FlowLayout());
        passwordNameInput = new JTextField();
        JButton searchButton = new JButton("Search");
        passwordNameInput.setText("Password name to search...");
        userInputLine.add(passwordNameInput);

        resultsLine = new JPanel(new FlowLayout());
        JLabel resultsLabel = new JLabel("Search Results: ");
        results = new JTextField();
        results.enableInputMethods(false);
        resultsLine.add(resultsLabel);
        results.setColumns(20);
        resultsLine.add(results);

        searchPw = new SearchPwEvent(fileManager, pwManager, passwordNameInput, results);
        searchButton.addActionListener(searchPw);
        userInputLine.add(searchButton);

        pwSearch.add(userInputLine);
        pwSearch.add(resultsLine);
        pwSearch.pack();
        pwSearch.setVisible(true);

    }
}
