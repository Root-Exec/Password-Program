package programManagers;

//main program loop
//responsible for object creation (file managers, password managers)

public class MainManager {

    public static void main (String[] args) {

        PasswordManager pwManager = new PasswordManager();
        FileManager fileManager = new FileManager();

        fileManager.addPassword(pwManager);
        //if (fileManager.fileStatus != false)
            //fileManager.retrievePassword();
        fileManager.closeFiles();
    }
}
