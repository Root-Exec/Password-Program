package programManagers.userInterfaceManager.DeletePassword;

import programManagers.FileManager.FileManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class deletePwEvent implements ActionListener {

    private FileManager fileManager;
    private JTextField pwName;
    private JTextField results;

    public deletePwEvent (FileManager fileManager, JTextField pwName, JTextField results) {
        this.fileManager = fileManager;
        this.pwName = pwName;
        this.results = results;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (fileManager.deletePassword(pwName.getText())) {
            results.setText("Successfully deleted password");
        } else {
            results.setText("Could not delete password");
        }
    }

}
