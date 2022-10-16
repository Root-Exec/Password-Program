package programManagers;

import programManagers.FileManager.FileManager;
import programManagers.PasswordManager.PasswordManager;
import programManagers.userInterfaceManager.UserInterfaceManager;

import static programManagers.PasswordManager.PasswordManager.getPasswordManagerInstance;

public class MainManager {

    public static void main (String[] args) {

        PasswordManager pwManager = getPasswordManagerInstance();
        FileManager fileManager = new FileManager();
        UserInterfaceManager userInterfaceManager = new UserInterfaceManager(pwManager, fileManager);

    }
}
