package programManagers.userInterfaceManager.RetrievePassword;

import programManagers.FileManager.FileManager;
import programManagers.PasswordManager.PasswordManager;

import javax.swing.*;
import java.awt.*;

public class SearchWindowPanel extends JPanel {

    private JPanel userInputLine;
    private JPanel resultsLine;
    private FileManager fileManager;
    private PasswordManager pwManager;
    protected SearchPwEvent searchPw;
    JTextField passwordNameInput;
    JTextField results;

    public SearchWindowPanel(FileManager fileManager, PasswordManager pwManager) {
        super();
        this.fileManager = fileManager;
        this.pwManager = pwManager;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        passwordNameInput = new JTextField(20);
        results = new JTextField(20);

        userInputLine = new JPanel(new FlowLayout());
        JButton searchButton = new JButton("Search");
        passwordNameInput.setText("Password name to search...");
        userInputLine.add(passwordNameInput);

        resultsLine = new JPanel(new FlowLayout());
        JLabel resultsLabel = new JLabel("Search Results: ");
        results.enableInputMethods(false);
        resultsLine.add(resultsLabel);
        results.setColumns(20);
        resultsLine.add(results);

        searchPw = new SearchPwEvent(fileManager, pwManager, passwordNameInput, results);
        searchButton.addActionListener(searchPw);
        userInputLine.add(searchButton);

        this.add(userInputLine);
        this.add(resultsLine);
    }

    public JTextField getPwNameInput() {
        return passwordNameInput;
    }

    public JTextField getResultsField() {
        return results;
    }


}
