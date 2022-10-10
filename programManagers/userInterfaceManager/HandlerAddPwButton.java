package programManagers;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.ParsePosition;

public class HandlerAddPwButton extends JButton implements ActionListener {
    private PasswordManager pwManager;
    private FileManager fileManager;
    private JFrame addPwWindow;
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
    private JFormattedTextField textfields[];
    private final NumberFormat numFormat = NumberFormat.getInstance();
    private final int MAXLEN = 20;

    public HandlerAddPwButton(PasswordManager pwManager, FileManager fileManager) {
        super("Add a Password");
        this.pwManager = pwManager;
        this.fileManager = fileManager;
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        addPwWindow = new JFrame("Add Password");
        addPwWindow.setLayout(new BoxLayout(addPwWindow.getContentPane(), BoxLayout.Y_AXIS));
        addPwWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addPwWindow.setLocationRelativeTo(null);

        userInputLine = new JPanel(new FlowLayout());
        pwName = new JLabel("Enter Name for Password");
        userInputLine.add(pwName);
        userInputField = new JTextField(MAXLEN);
        userInputLine.add(userInputField);

        userDefinedPwLine = new JPanel(new FlowLayout());
        definedPw = new JLabel("For User Defined Password: ");
        userDefinedPwLine.add(definedPw);
        userDefinedPwField = new JTextField(MAXLEN);
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
        randomPwLine.add(lowerCaseLabel);
        randomPwLine.add(lowerCaseInput);

        upperCaseLabel = new JLabel("Upper case: ");
        upperCaseInput = new JFormattedTextField(numFormat);
        upperCaseInput.setColumns(2);
        randomPwLine.add(upperCaseLabel);
        randomPwLine.add(upperCaseInput);

        numbersLabel = new JLabel("Numbers: ");
        numbersInput = new JFormattedTextField(numFormat);
        numbersInput.setColumns(2);
        randomPwLine.add(numbersLabel);
        randomPwLine.add(numbersInput);

        specialCharLabel = new JLabel("Special Characters: ");
        specialCharInput = new JFormattedTextField(numFormat);
        specialCharInput.setColumns(2);
        randomPwLine.add(specialCharLabel);
        randomPwLine.add(specialCharInput);

        textfields = new JFormattedTextField[4];
        textfields[0] = lowerCaseInput;
        textfields[1] = upperCaseInput;
        textfields[2] = numbersInput;
        textfields[3] = specialCharInput;

        addRandomPw = new JButton("Generate Random Password");
        GeneratePwEvent generatePwAction = new GeneratePwEvent(pwManager, fileManager, addRandomPw,
                                                               addDefinedPw, userInputField, userDefinedPwField,
                                                               textfields);

        addRandomPw.addActionListener(generatePwAction);
        addDefinedPw.addActionListener(generatePwAction);
        randomPwLine.add(addRandomPw);

        addPwWindow.add(userInputLine);
        addPwWindow.add(userDefinedPwLine);
        addPwWindow.add(randomPwLine);

        addPwWindow.pack();
        addPwWindow.setVisible(true);

    }
}