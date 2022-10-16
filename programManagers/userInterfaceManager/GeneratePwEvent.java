package programManagers.userInterfaceManager;

import programManagers.FileManager.FileManager;
import programManagers.PasswordManager.InvalidPasswordNameException;
import programManagers.PasswordManager.PasswordManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GeneratePwEvent implements ActionListener {
    private PasswordManager pwManager;
    private FileManager fileManager;
    private JButton addRandomPw;
    private JButton addDefinedPw;
    private JTextField userInputField;
    private JTextField userDefinedPwField;
    private JFormattedTextField[] textFields;

    public GeneratePwEvent(PasswordManager pwManager, FileManager fileManager, JButton addRandomPw,
                           JButton addDefinedPw, JTextField userInputField, JTextField userDefinedPwField,
                           JFormattedTextField[] textField) {
        this.pwManager = pwManager;
        this.fileManager = fileManager;
        this.addRandomPw = addRandomPw;
        this.addDefinedPw = addDefinedPw;
        this.userInputField = userInputField;
        this.userDefinedPwField = userDefinedPwField;
        this.textFields = new JFormattedTextField[4];
        this.textFields = textField.clone();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            pwManager.setPwName(userInputField.getText());
        } catch (InvalidPasswordNameException ex) {
            userInputField.setText("Invalid password name contains ':' character");
            return;
        }

        if (e.getSource() == addRandomPw && pwManager.getPwName().length() > 0) {

            pwManager.setPasswordParameters( ((Number) textFields[0].getValue()).intValue(),
                                             ((Number) textFields[1].getValue()).intValue(),
                                             ((Number) textFields[2].getValue()).intValue(),
                                             ((Number) textFields[3].getValue()).intValue());
            pwManager.setRandomPassword();
        }

        if (e.getSource() == addDefinedPw && pwManager.getPwName().length() > 0) {

            try {
                pwManager.setDefinedPassword(userDefinedPwField.getText());
            } catch (InvalidPasswordNameException ex) {
                userDefinedPwField.setText("Invalid password, contains ':' character");
            }
        }

        fileManager.addPassword(pwManager.getPwName(), pwManager.getPassword());
        pwManager = PasswordManager.getPasswordManagerInstance();
    }
}
