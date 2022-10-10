package programManagers;
import java.io.*;
import java.util.*;
import java.util.regex.*;

//object will be responsible for writing, retrieving, and updating source file of passwords

public class FileManager {
    private String fileName = "Keychain.txt";
    private String temporaryFile = "Temp.txt";
    private BufferedWriter writer;
    private BufferedReader reader;

    private int maxPasswordLen = 20;
    public Boolean fileStatus;

    FileManager() {

        try {
            writer = new BufferedWriter(new FileWriter(fileName, true));
        } catch (IOException e) {
            System.out.println("Writer Failed");
        }

        try {
            reader = new BufferedReader(new FileReader(fileName));
            fileStatus = true;
        } catch (FileNotFoundException e) {
            System.out.println("Reader Failed");
        }
    }

    public void addPassword(String name, String password) {
        StringBuffer line = new StringBuffer();
        line.append(name);
        line.append(":");
        line.append(password);

        try {
            writer.append(line + "\n");
            System.out.println("Save successful!");
        } catch (IOException e) {
            System.out.println("Failed to save password data to source file");
        }
    }

    public String retrievePassword(String name) {
        String line;
        String[] components;

        do  {
            try {
                line = reader.readLine();
                if (line != null) {
                    components = line.split(":");
                    if (name.equals(components[0]))
                        return components[1];
                } else {
                    return "Password not found!";
                }
            } catch (IOException e) {
                System.out.println("Could not read Keychain Data file");
                return "";
            }

        } while (line != null);

        return "Password Not Found!";
    }

    public Boolean updateDatabase(String writeToFile, String name) {
        String[] lineComponents;
        String line;
        BufferedWriter updater;
        boolean validSave = false;
        File originalFile;
        File tempFile;

        try {
            writer.close();
        } catch (IOException e) {
            System.out.println("Unable to update file in updater object");
            return false;
        }

        try {
            updater = new BufferedWriter(new FileWriter(temporaryFile, true));
        } catch (IOException e) {
            System.out.println("File save error. File is not updated");
            return false;
        }

        while (true) {
            try {
                line = reader.readLine();
                if (line == null) break;
            } catch (IOException e) {
                System.out.println("Source File Read error in updater object");
                return false;
            }
            lineComponents = line.split(":");

            if (lineComponents[0].equals(name)) {
                try {
                    updater.append(writeToFile);
                    validSave = true;
                } catch (IOException e) {
                    System.out.println("Unable to update source file");
                    validSave = false;
                }
            } else {
                try {
                    updater.append(line);
                } catch (IOException e) {
                    System.out.println("Unable to update source file");
                    validSave = false;
                }
            }
        }

        if (validSave) {
            try {
                updater.close();
                reader.close();
            } catch (IOException e) {
                System.out.println("Unable to save updates in password updater object");
                return false;
            }

            //next steps require File objects not bufferedReader/Writers. They do not extend from File objects
            //close bufferedReader/bufferedWriter objects to use File objects
            originalFile = new File(fileName);
            tempFile = new File(temporaryFile);
            return tempFile.renameTo(originalFile);
        }

        System.out.println("Password name not found, file cannot be updated.");
        return false;
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

    public boolean deletePassword(String name) {
        String[] components;
        String line;
        BufferedWriter deleter;
        boolean deleteStatus = false;

        try {
            deleter = new BufferedWriter(new FileWriter(temporaryFile, true));
        } catch (IOException e) {
            System.out.println("Deleter object failure");
            return deleteStatus;
        }

        while (true) {
            try {
                line = reader.readLine();
                if (line == null) break;
                components = line.split(":");
            } catch (IOException e) {
                System.out.println("Unable to read source file within deleter object");
                return deleteStatus;
            }

            if (!name.contentEquals(components[0])) {
                try {
                    deleter.append(line + "\n");
                } catch (IOException e) {
                    System.out.println("Unable to update source file within deleter object");
                    return deleteStatus;
                }
            } else {
                deleteStatus = true;
            }
        }

        try {
            deleter.close();
        } catch (IOException e) {
            System.out.println("Cannot update source file within deleter object");
            return deleteStatus;
        }

        try {
            writer.close();
        } catch (IOException e) {
            System.out.println("IO File exception in deleter object");
        }

        File originalFile = new File(fileName);
        File tempFile = new File(temporaryFile);

        deleteStatus = tempFile.renameTo(originalFile);

        return deleteStatus;
    }

}
