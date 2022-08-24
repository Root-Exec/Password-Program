package programManagers;
import java.io.*;
import java.util.*;
import java.util.regex.*;

//object will be responsible for writing, retrieving, and updating source file of passwords

public class FileManager {
    private String fileName = "Keychain.txt";
    private BufferedWriter writer;
    private BufferedReader reader;

    private int maxPasswordLen = 20;
    public Boolean fileStatus;

    FileManager() {

        try {
            writer = new BufferedWriter(new FileWriter(fileName, true));
            System.out.println("Writer initialized");
        } catch (IOException e) {
            System.out.println("Writer Failed");
        }

        try {
            reader = new BufferedReader(new FileReader(fileName));
            fileStatus = true;
            System.out.println("Reader Initialized");
        } catch (FileNotFoundException e) {
            System.out.println("Reader Failed");
        }

    }

    public void addPassword(PasswordManager pwManager) {
        StringBuffer line = new StringBuffer();
        Scanner userInput = new Scanner(System.in);
        System.out.print("Enter name for new password: ");
        line.append(userInput.nextLine());
        line.append(":");
        pwManager.setPasswordParameters();
        line.append(pwManager.getPassword());
        line.append("\n");
        System.out.println(line.toString());

        try {
            writer.append(line.toString());
            System.out.println("Save successful!");
        } catch (IOException e) {
            System.out.println("Failed to save password data to source file");
        }

    }

    public String retrievePassword() {
        String line;
        String[] components;
        System.out.println("Enter name of password for search: ");
        Scanner userInput = new Scanner(System.in);
        String name = userInput.nextLine();

        do  {
            try {
                line = reader.readLine();
                System.out.println(line);
                /*components = line.split(":");
                if (name.equals(components[0]))
                    return components[1];*/
            } catch (IOException e) {
                System.out.println("Could not read Keychain Data file");
                return "";
            }

        } while (line != null);

        System.out.println("Password not found");
        return "";
    }

    public void closeFiles() {
        try {
            writer.close();
        } catch (IOException e) {
            System.out.println("Error closing writing stream");
        }

        try {
            reader.close();
        } catch (IOException e) {
            System.out.println("Error closing reading stream");
        }
    }

}
