package programManagers;


//main program loop
//responsible for object creation (file managers, password managers)

import programManagers.FileManager.FileManager;
import programManagers.PasswordManager.PasswordManager;
import programManagers.userInterfaceManager.UserInterfaceManager;

public class MainManager {

    public static void main (String[] args) {

        PasswordManager pwManager = new PasswordManager();
        FileManager fileManager = new FileManager();
        UserInterfaceManager userInterfaceManager = new UserInterfaceManager(pwManager, fileManager);

        /*
        char userInput = '\0';
        String name = "\0";


        while (userInput != 'q' && userInput != 'Q') {

            userInterfaceManager.printScreen();
            userInput = userInterfaceManager.getUserInput(userInput);

            switch (userInput) {
                case '1' -> {
                    System.out.print("Enter name of password: ");
                    name = userInterfaceManager.getUserInput(name);
                    pwManager.setPassword();
                    fileManager.addPassword(name, pwManager.getPassword());
                }
                case '2' -> {
                    System.out.println("Enter name of password for search: ");
                    name = userInterfaceManager.getUserInput(name);
                    pwManager.setPassword(fileManager.retrievePassword(name));
                    pwManager.printPassword();
                }
                case '3' -> {
                    System.out.println(("Enter name of password for search: "));
                    name = userInterfaceManager.getUserInput(name);
                    pwManager.setPassword();
                    if (fileManager.updateDatabase(name + ":" + pwManager.getPassword() + "\n", name)) {
                        System.out.println("Successfully updated password");
                    }
                }

                case '4' -> {
                    System.out.println("Enter name of password for deletion: ");
                    name = userInterfaceManager.getUserInput(name);
                    if (fileManager.deletePassword(name)) {
                        System.out.println("Successfully deleted password");
                    }
                }

                default -> throw new InputMismatchException("Invalid input");
            }

            fileManager.closeFiles();
            System.out.println("Press c to continue, q to quit");
            userInput = userInterfaceManager.getUserInput(userInput);

            if (userInput == 'c') {
                fileManager = new FileManager();
                pwManager = new PasswordManager();
                userInterfaceManager.clearScreen();
            }
        }*/

    }
}
