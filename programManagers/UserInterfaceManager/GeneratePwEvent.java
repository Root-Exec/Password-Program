package programManagers.UserInterfaceManager;

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
    private String existingPwError = "Password exists in database";
    private String invalidPwCharacterError = "Invalid password. No ':' and less than 20 characters";

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

        pwManager.setPwName(userInputField.getText());

        if (pwManager.getPwName().length() == 0) {
                userInputField.setText("Input password name here");
                pwManager = new PasswordManager();
                return;
        }

        if (e.getSource() == addRandomPw) {

            pwManager.setPasswordParameters( ((Number) textFields[0].getValue()).intValue(),
                                             ((Number) textFields[1].getValue()).intValue(),
                                             ((Number) textFields[2].getValue()).intValue(),
                                             ((Number) textFields[3].getValue()).intValue());
            pwManager.setRandomPassword();
        }

        if (e.getSource() == addDefinedPw) {

            pwManager.setDefinedPassword(userDefinedPwField.getText());

            if (pwManager.getPassword().length() < 1 || pwManager.getPassword().length() > 20) {
                userDefinedPwField.setText(invalidPwCharacterError);
                pwManager = new PasswordManager();
                return;
            }

        }

        if (!fileManager.addPassword(pwManager.getPwName(), pwManager.getPassword())) {
            userInputField.setText(existingPwError);
        }
        pwManager = new PasswordManager();
    }
}
