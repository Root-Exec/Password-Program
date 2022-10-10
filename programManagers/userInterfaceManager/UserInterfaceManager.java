package programManagers;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Scanner;

public class UserInterfaceManager {
    private JFrame mainWindow;
    public PasswordManager pwManager;
    public FileManager fileManager;

    public UserInterfaceManager(PasswordManager pwManager, FileManager fileManager) {
        this.pwManager = pwManager;
        this.fileManager = fileManager;
        initMainWindow();
    }

    void initMainWindow() {
        mainWindow = new JFrame("Password Manager");
        mainWindow.setLayout(new BoxLayout(mainWindow.getContentPane(), BoxLayout.Y_AXIS));
        mainWindow.setSize(500, 500);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setLocationRelativeTo(null);

        JLabel mainTitle = new JLabel("Main Menu");
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 20));
        titlePanel.setSize(20, 20);
        mainTitle.setHorizontalTextPosition(SwingConstants.CENTER);
        titlePanel.add(mainTitle);

        JPanel addPwPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 20));
        addPwPanel.setSize(50, 50);
        JButton addPwButton = new HandlerAddPwButton(pwManager, fileManager);
        addPwPanel.add(addPwButton);

        JPanel retrievePwPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 20));
        retrievePwPanel.setSize(50, 50);
        JButton retrievePwButton = new HandlerRetrievePwButton(fileManager);
        retrievePwPanel.add(retrievePwButton);

        JPanel updatePwPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 20));
        updatePwPanel.setSize(50, 50);
        JButton updatePwPanelButton = new HandlerUpdatePwButton();
        updatePwPanel.add(updatePwPanelButton);

        JPanel deletePwPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 20));
        updatePwPanel.setSize(50, 50);
        JButton deletePwPanelButton = new HandlerDeletePwButton();
        deletePwPanel.add(deletePwPanelButton);

        mainWindow.add(titlePanel);
        mainWindow.add(addPwPanel);
        mainWindow.add(retrievePwPanel);
        mainWindow.add(updatePwPanel);
        mainWindow.add(deletePwPanel);
        mainWindow.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainWindow.pack();
        mainWindow.setVisible(true);
    }

    void printScreen() {
        System.out.println("--------Password Keychain application--------");
        System.out.println("Enter in the following:");
        System.out.println("1: Add a password.");
        System.out.println("2: Retrieve a password");
        System.out.println("3: Update a password");
        System.out.println("4: Delete a password");
    }

    char getUserInput (char userInput) {
        Scanner input = new Scanner(System.in);
        return input.nextLine().charAt(0);
    }

    String getUserInput (String name) {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    void clearScreen() {
        String os = "\0";
        String[] winCmds = {"cls"};
        String[] cmds = {"clear"};

        try {
            os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                try {
                    Runtime.getRuntime().exec(winCmds);
                } catch (IOException e) {
                    System.out.println("Invalid clear screen with System");
                }
            } else {
                try {
                    Runtime.getRuntime().exec(cmds);
                } catch (IOException e) {
                    System.out.println("Invalid clear screen with System");
                }
            }
        } catch(Exception e) {
            System.out.println("Invalid System Operating System inquiry for clear screen method");
        }
    }
}
