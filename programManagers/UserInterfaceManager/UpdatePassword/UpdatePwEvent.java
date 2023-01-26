package programManagers.UserInterfaceManager.UpdatePassword;

import programManagers.FileManager.FileManager;
import programManagers.PasswordManager.InvalidPasswordNameException;
import programManagers.PasswordManager.PasswordManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdatePwEvent implements ActionListener {
    private PasswordManager pwManager;
    private FileManager fileManager;
    private JButton addRandomPw;
    private JButton addDefinedPw;
    private JTextField userInputField;
    private JTextField userDefinedPwField;
    private JFormattedTextField[] textFields;

    UpdatePwEvent (PasswordManager pwManager, FileManager fileManager, JButton addRandomPw,
                   JButton addDefinedPw, JTextField userInputField, JTextField userDefinedPwField,
                   JFormattedTextField[] textFields) {
        this.fileManager = fileManager;
        this.pwManager = pwManager;
        this.addRandomPw = addRandomPw;
        this.addDefinedPw = addDefinedPw;
        this.userInputField = userInputField;
        this.userDefinedPwField = userDefinedPwField;
        this.textFields = textFields;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        pwManager.setPwName(userInputField.getText());

        if (e.getSource() == addRandomPw && pwManager.getPwName().length() > 0) {

            pwManager.setPasswordParameters( ((Number) textFields[0].getValue()).intValue(),
                    ((Number) textFields[1].getValue()).intValue(),
                    ((Number) textFields[2].getValue()).intValue(),
                    ((Number) textFields[3].getValue()).intValue());
            pwManager.setRandomPassword();
        }

        if (e.getSource() == addDefinedPw && pwManager.getPwName().length() > 0) {
            pwManager.setDefinedPassword(userDefinedPwField.getText());
        }

        if (pwManager.getPwName().length() == 0) {
            userInputField.setText("Invalid password name. 0 < Name length < 20");
            pwManager = new PasswordManager();
            return;
        }

        if (pwManager.getPassword().length() == 0) {
            userDefinedPwField.setText("Password cannot contain ':' and must be less than 20 characters");
            pwManager = new PasswordManager();
            return;
        }

        fileManager.updateDatabase(pwManager.getPwName() + ":" + pwManager.getPassword(),
                                   pwManager.getPwName());
        pwManager = new PasswordManager();
    }
}
