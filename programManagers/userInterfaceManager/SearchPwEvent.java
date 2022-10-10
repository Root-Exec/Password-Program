package programManagers.userInterfaceManager;

import programManagers.FileManager.FileManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchPwEvent implements ActionListener {

    private FileManager fileManager;
    private JTextField pwName;
    private JTextField results;

    SearchPwEvent(FileManager fileManager, JTextField pwNameInput, JTextField results) {
        this.fileManager = fileManager;
        this.pwName = pwNameInput;
        this.results = results;
        this.results.enableInputMethods(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(pwName);
        results.setText(fileManager.retrievePassword(pwName.getText()));
        fileManager.closeFiles();
        fileManager = new FileManager();
    }
}
