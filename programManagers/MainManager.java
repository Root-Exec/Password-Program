package programManagers;

import programManagers.FileManager.FileManager;
import programManagers.PasswordManager.PasswordManager;
import programManagers.UserInterfaceManager.UserInterfaceManager;

/* Main Manager owns the opening loop of the program
* it is responsible for initializing the subset managers that are responsible
* for their aspects of the overall program
 */
public class MainManager {

    public static void main (String[] args) {

        PasswordManager pwManager = new PasswordManager();
        FileManager fileManager = new FileManager();
        UserInterfaceManager userInterfaceManager = new UserInterfaceManager(pwManager, fileManager);

    }
}
