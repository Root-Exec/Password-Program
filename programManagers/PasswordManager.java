package programManagers;

import java.util.*;

//object will be responsible for creating/updating passwords based off of parameters provided by user

public class PasswordManager {
        private StringBuffer password;
        private StringBuffer availableCharacters;
        private int numLowerCase;
        private int numUpperCase;
        private int numNumbers;
        private char pwType;
        private int numSpecialChars;
        final private int maxPasswordLen = 20;

        PasswordManager() {
            this.password = new StringBuffer();
            this.availableCharacters = new StringBuffer();
        }

        PasswordManager(String pw) {
            password = new StringBuffer();
            availableCharacters = new StringBuffer();
            password.append(pw);
        }

        public String getPassword(){
        return password.toString();
    }

        public void printPassword() {
            System.out.println(this.password);
        }

        public void setPasswordParameters() {
            Scanner userInput = new Scanner(System.in);
            char input;

            System.out.print("Enter (u)ser defined password; (r)andom defined password: ");
            input = userInput.next().charAt(0);

            while (input != 'u' && input != 'U' && input != 'r' && input != 'R') {
                System.out.print("Invalid input. Enter 'u' for user defined password; 'r' for random defined password: ");
                input = userInput.next().charAt(0);
            }

            if (input == 'u' || input ==  'U') setDefinedPassword();
            else                               setRandomPassword();
        }

        private void setDefinedPassword() {
            Scanner userInput = new Scanner(System.in);
            while (true) {
                System.out.print("Enter your password (password cannot contain a ':' character): ");
                password.append(userInput.nextLine());
                if (!password.toString().contains("[.]+:[.]+")) {
                    break;
                }
            }
        }

        private void setRandomPassword() {
            Random randStream = new Random();
            Scanner userInput = new Scanner(System.in);
            int i;
            int len = 0;

            System.out.print("Enter number of lower case characters: ");
            this.numLowerCase = userInput.nextInt();
            System.out.print("Enter number of upper case characters: ");
            this.numUpperCase = userInput.nextInt();
            System.out.print("Enter number of numbers: ");
            this.numNumbers = userInput.nextInt();
            System.out.print("Enter number of special characters: ");
            this.numSpecialChars = userInput.nextInt();
            System.out.println();

            for (i = 0; i < numLowerCase && len < maxPasswordLen; i++, len++)
                availableCharacters.append((char) (randStream.nextInt(27) + 'a'));

            for (i = 0; i < numUpperCase && len < maxPasswordLen; i++, len++)
                availableCharacters.append((char) (randStream.nextInt(27) + 'A'));

            for (i = 0; i < numNumbers && len < maxPasswordLen; i++, len++)
                availableCharacters.append((char)(randStream.nextInt(10) + '0'));

            for (i = 0; i < numSpecialChars && len < maxPasswordLen; i++, len++)
                availableCharacters.append((char)(randStream.nextInt(16) + '!'));


            int index;
            len--;
            while (len > 0) {
                index = randStream.nextInt(len);
                password.append(availableCharacters.charAt(index));
                availableCharacters.deleteCharAt(index);
                len--;
            }
            password.append(availableCharacters.charAt(0));
        }

}
