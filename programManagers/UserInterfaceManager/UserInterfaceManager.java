package programManagers.UserInterfaceManager;

import programManagers.FileManager.FileManager;
import programManagers.PasswordManager.PasswordManager;
import programManagers.UserInterfaceManager.DeletePassword.HandlerDeletePwButton;
import programManagers.UserInterfaceManager.RetrievePassword.HandlerRetrievePwButton;
import programManagers.UserInterfaceManager.UpdatePassword.HandlerUpdatePwButton;
import programManagers.UserInterfaceManager.addPassword.HandlerAddPwButton;

import javax.swing.*;
import java.awt.*;

/* The User Interface Manager is a massive component to the program. It is responsible for creating the initial
* window (mainWindow JFrame) that holds all the primary functions of the program. Each component is responsible for
* handling their respective functions (i.e. the addPassword component creates a password through the
* Password Manager and then saves the data through the File Manager. Or the Retrieve Password component calls
* retrieval methods from the File Manager for display but does not utilize methods from the Password Manager). The
* User Interface Manager is a separate object from the main JFrame window. It creates a main window and adds the
* components. After that, each button has their own respective "handler" that creates their respective windows that are
* set up for their specific functions. This main window manager only sets up and consolidates the functions onto the
* main window for the handlers to operate off of and keeps the overall program running (EXIT_ON_CLOSE).
*
* Some panels are created as separate components for ease of reuse. For example, the addPasswordPanel is a separate
* component because the updatePassword object will use that same panel and then add a few more components for its use.
* The updatePassword object uses the addPassword functionality with the retrievePassword functionality in order to search
* for the password first, then overwrite the data with the new password (whether it is user defined or randomly created
* through the Password Manager).
 */


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
        mainWindow.setSize(800, 500);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setLocationRelativeTo(null);
        mainWindow.getContentPane().setBackground(Color.BLACK);

        JLabel mainTitle = new JLabel("Main Menu");
        mainTitle.setForeground(Color.GREEN);
        mainTitle.setFont(new Font("Times New Roman", Font.BOLD, 25));
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 20));
        titlePanel.setSize(20, 20);
        mainTitle.setHorizontalTextPosition(SwingConstants.CENTER);
        titlePanel.setBackground(Color.BLACK);
        titlePanel.add(mainTitle);

        JPanel addPwPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 20));
        addPwPanel.setSize(50, 50);
        JButton addPwButton = new HandlerAddPwButton(pwManager, fileManager);
        addPwPanel.setBackground(Color.BLACK);
        addPwPanel.add(addPwButton);

        JPanel retrievePwPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 20));
        retrievePwPanel.setSize(50, 50);
        JButton retrievePwButton = new HandlerRetrievePwButton(fileManager, pwManager);
        retrievePwPanel.setBackground(Color.BLACK);
        retrievePwPanel.add(retrievePwButton);

        JPanel updatePwPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 20));
        updatePwPanel.setSize(50, 50);
        JButton updatePwPanelButton = new HandlerUpdatePwButton(fileManager, pwManager);
        updatePwPanel.setBackground(Color.BLACK);
        updatePwPanel.add(updatePwPanelButton);

        JPanel deletePwPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 20));
        updatePwPanel.setSize(50, 50);
        JButton deletePwPanelButton = new HandlerDeletePwButton(fileManager, pwManager);
        deletePwPanel.setBackground(Color.BLACK);
        deletePwPanel.add(deletePwPanelButton);

        mainWindow.add(titlePanel);
        mainWindow.add(addPwPanel);
        mainWindow.add(retrievePwPanel);
        mainWindow.add(updatePwPanel);
        mainWindow.add(deletePwPanel);
        mainWindow.setVisible(true);
    }
}
