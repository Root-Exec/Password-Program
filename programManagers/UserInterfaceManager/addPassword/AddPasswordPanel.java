package programManagers.UserInterfaceManager.addPassword;

import programManagers.FileManager.FileManager;
import programManagers.PasswordManager.PasswordManager;
import programManagers.UserInterfaceManager.GeneratePwEvent;

import javax.swing.*;
import java.awt.*;
import java.text.NumberFormat;

public class AddPasswordPanel extends JPanel {

    private PasswordManager pwManager;
    private FileManager fileManager;
    private JPanel userInputLine;
    private JPanel randomPwLine;
    private JPanel userDefinedPwLine;
    private JLabel pwName;
    private JLabel definedPw;
    private JLabel randomPw;
    private JTextField userInputField;
    private JTextField userDefinedPwField;
    private JFormattedTextField lowerCaseInput;
    private JLabel lowerCaseLabel;
    private JFormattedTextField upperCaseInput;
    private JLabel upperCaseLabel;
    private JFormattedTextField numbersInput;
    private JLabel numbersLabel;
    private JFormattedTextField specialCharInput;
    private JLabel specialCharLabel;
    private JButton addRandomPw;
    private JButton addDefinedPw;
    private JFormattedTextField[] textfields;
    private final NumberFormat numFormat = NumberFormat.getInstance();
    public GeneratePwEvent generatePwAction;
    private final int MAXLEN = 25;


    public AddPasswordPanel(FileManager fileManager, PasswordManager pwManager) {
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.fileManager = fileManager;
        this.pwManager = pwManager;

        userInputLine = new JPanel(new FlowLayout());
        pwName = new JLabel("Enter Name for Password");
        userInputLine.add(pwName);
        userInputField = new JTextField(MAXLEN);
        userInputLine.add(userInputField);

        userDefinedPwLine = new JPanel(new FlowLayout());
        definedPw = new JLabel("For User Defined Password: ");
        userDefinedPwLine.add(definedPw);
        userDefinedPwField = new JTextField(MAXLEN + 5);
        userDefinedPwLine.add(userDefinedPwField);
        addDefinedPw = new JButton("Generate User Defined Password");
        userDefinedPwLine.add(addDefinedPw);

        randomPwLine = new JPanel(new FlowLayout());
        randomPw = new JLabel("Parameters for random password: ");
        randomPwLine.add(randomPw);

        numFormat.setMaximumIntegerDigits(9);
        numFormat.setMinimumIntegerDigits(0);

        lowerCaseLabel = new JLabel("Lower case: ");
        lowerCaseInput = new JFormattedTextField(numFormat);
        lowerCaseInput.setColumns(2);
        lowerCaseInput.setValue(0);
        randomPwLine.add(lowerCaseLabel);
        randomPwLine.add(lowerCaseInput);

        upperCaseLabel = new JLabel("Upper case: ");
        upperCaseInput = new JFormattedTextField(numFormat);
        upperCaseInput.setColumns(2);
        upperCaseInput.setValue(0);
        randomPwLine.add(upperCaseLabel);
        randomPwLine.add(upperCaseInput);

        numbersLabel = new JLabel("Numbers: ");
        numbersInput = new JFormattedTextField(numFormat);
        numbersInput.setColumns(2);
        numbersInput.setValue(0);
        randomPwLine.add(numbersLabel);
        randomPwLine.add(numbersInput);

        specialCharLabel = new JLabel("Special Characters: ");
        specialCharInput = new JFormattedTextField(numFormat);
        specialCharInput.setColumns(2);
        specialCharInput.setValue(0);
        randomPwLine.add(specialCharLabel);
        randomPwLine.add(specialCharInput);

        textfields = new JFormattedTextField[4];
        textfields[0] = lowerCaseInput;
        textfields[1] = upperCaseInput;
        textfields[2] = numbersInput;
        textfields[3] = specialCharInput;

        addRandomPw = new JButton("Generate Random Password");
        generatePwAction = new GeneratePwEvent(this.pwManager, this.fileManager, addRandomPw,
                addDefinedPw, userInputField, userDefinedPwField,
                textfields);

        addRandomPw.addActionListener(generatePwAction);
        addDefinedPw.addActionListener(generatePwAction);
        randomPwLine.add(addRandomPw);

        this.add(userInputLine);
        this.add(userDefinedPwLine);
        this.add(randomPwLine);
    }

    public JButton getAddRandomPwButton() {
        return addRandomPw;
    }
    public JButton getAddDefinedPwButton() {
        return addDefinedPw;
    }

    public JFormattedTextField[] getTextFields() {
        return textfields;
    }

    public JTextField getUserInputField() {
        return userInputField;
    }

    public JTextField getUserDefinedPwField() {
        return userDefinedPwField;
    }
}
