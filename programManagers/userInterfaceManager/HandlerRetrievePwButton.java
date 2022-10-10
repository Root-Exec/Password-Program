package programManagers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class HandlerRetrievePwButton extends JButton implements ActionListener {

    SearchPwEvent searchPw;
    FileManager fileManager;
    public HandlerRetrievePwButton(FileManager fileManager) {
        super("Retrieve a Password");
        this.addActionListener(this::actionPerformed);
        this.fileManager = fileManager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame pwSearch = new JFrame("Password Search");
        pwSearch.setLayout(new BoxLayout(pwSearch.getContentPane(), BoxLayout.Y_AXIS));
        pwSearch.setLocationRelativeTo(null);

        JPanel userInputLine = new JPanel(new FlowLayout());
        JTextField passwordNameInput = new JTextField();
        JButton searchButton = new JButton("Search");
        passwordNameInput.setText("Password name to search...");
        userInputLine.add(passwordNameInput);

        JPanel resultsLine = new JPanel(new FlowLayout());
        JLabel resultsLabel = new JLabel("Search Results: ");
        JTextField results = new JTextField();
        results.enableInputMethods(false);
        resultsLine.add(resultsLabel);
        results.setColumns(20);
        resultsLine.add(results);

        searchPw = new SearchPwEvent(fileManager, passwordNameInput, results);
        searchButton.addActionListener(searchPw);
        userInputLine.add(searchButton);

        pwSearch.add(userInputLine);
        pwSearch.add(resultsLine);
        pwSearch.pack();
        pwSearch.setVisible(true);

    }
}
