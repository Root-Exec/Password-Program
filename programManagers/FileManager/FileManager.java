package programManagers.FileManager;
import java.io.*;

/* File Manager is responsible for writing, retrieving, saving, opening, and closing the source file of passwords.
* No other objects are to have access to the source file and must use FileManager methods to interact with
* the source file.
 */

public final class FileManager {
    private final String fileName = "Keychain.txt";
    private final String temporaryFile = "Temp.txt";
    private BufferedWriter writer;
    public BufferedReader reader;
    public Boolean fileStatus;
    private String pwNotFound = "Password Not Found!";


    public FileManager() {

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

    public boolean addPassword(String name, String password) {

        String checkForExistingPassword = retrievePassword(name);

        if (!checkForExistingPassword.contentEquals(pwNotFound)) {
            return false;
        }

        StringBuffer line = new StringBuffer();
        line.append(name);
        line.append(":");
        line.append(password).append("\n");

        if (writer == null) {
            try {
                writer = new BufferedWriter(new FileWriter(fileName, true));
            } catch (IOException e) {
                System.out.println("Writer Failed");
            }
        }

        try {
            writer.append(line);
            System.out.println("Save successful!");
        } catch (IOException e) {
            System.out.println("Failed to save password data to source file in add password method of file manager class: " + e);
        }
        saveFiles();

        return true;
    }

    public String retrievePassword(String name) {

        String line;
        String[] components;

        do  {
            try {
                line = reader.readLine();
                if (line != null) {
                    components = line.split(":");
                    if (name.equals(components[0])) {
                        saveFiles();
                        return components[1];
                    }
                } else {
                    saveFiles();
                    return pwNotFound;
                }
            } catch (IOException e) {
                System.out.println("Could not read Keychain Data file in retrieve password method: " + e);
                return "";
            }

        } while (line != null);

        saveFiles();

        return pwNotFound;
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
                    updater.append(writeToFile).append(String.valueOf('\n'));
                    validSave = true;
                } catch (IOException e) {
                    System.out.println("Unable to update source file");
                    validSave = false;
                }
            } else {
                try {
                    updater.append(line).append(String.valueOf('\n'));
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

            if (tempFile.renameTo(originalFile)) {
                saveFiles();
                return true;
            }

            saveFiles();
            return false;
        }

        return false;
    }

    private void saveFiles() {

        closeFiles();
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

    private void closeFiles() {
        try {
            writer.close();
        } catch (IOException e) {
            System.out.println("Error closing writing stream: " + e);
        }

        try {
            reader.close();
        } catch (IOException e) {
            System.out.println("Error closing reading stream: " + e);
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
                System.out.println("Unable to read source file within deleter object: " + e);
                saveFiles();
                return deleteStatus;
            }

            if (!name.contentEquals(components[0])) {
                try {
                    deleter.append(line + "\n");
                } catch (IOException e) {
                    System.out.println("Unable to update source file within deleter object: " + e);
                    saveFiles();
                    return deleteStatus;
                }
            } else {
                deleteStatus = true;
            }
        }

        try {
            deleter.close();
        } catch (IOException e) {
            System.out.println("Cannot update source file within deleter object: " + e);
            saveFiles();
            return deleteStatus;
        }

        try {
            writer.close();
        } catch (IOException e) {
            saveFiles();
            System.out.println("IO File exception in deleter object: " + e);
        }

        File originalFile = new File(fileName);
        File tempFile = new File(temporaryFile);

        deleteStatus = tempFile.renameTo(originalFile);
        saveFiles();

        return deleteStatus;
    }

}
