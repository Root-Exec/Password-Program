package programManagers.userInterfaceManager;

import programManagers.FileManager.FileManager;
import programManagers.PasswordManager.PasswordManager;
import programManagers.userInterfaceManager.DeletePassword.HandlerDeletePwButton;
import programManagers.userInterfaceManager.RetrievePassword.HandlerRetrievePwButton;
import programManagers.userInterfaceManager.UpdatePassword.HandlerUpdatePwButton;
import programManagers.userInterfaceManager.addPassword.HandlerAddPwButton;

import javax.swing.*;
import java.awt.*;

public final class UserInterfaceManager {
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
        JButton retrievePwButton = new HandlerRetrievePwButton(fileManager, pwManager);
        retrievePwPanel.add(retrievePwButton);

        JPanel updatePwPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 20));
        updatePwPanel.setSize(50, 50);
        JButton updatePwPanelButton = new HandlerUpdatePwButton(fileManager, pwManager);
        updatePwPanel.add(updatePwPanelButton);

        JPanel deletePwPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 20));
        updatePwPanel.setSize(50, 50);
        JButton deletePwPanelButton = new HandlerDeletePwButton(fileManager, pwManager);
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
}
