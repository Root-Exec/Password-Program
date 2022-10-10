package programManagers;

import java.util.*;

//object will be responsible for creating/updating passwords based off of parameters provided by user

public class PasswordManager {
        private StringBuffer password;
        private StringBuffer availableCharacters;
        private String name;
        private int numLowerCase;
        private int numUpperCase;
        private int numNumbers;
        private int numSpecialChars;
        final private int maxPasswordLen = 20;

        PasswordManager() {
            this.password = new StringBuffer();
            this.availableCharacters = new StringBuffer();
        }

        void setPwName(String name) {
            this.name = name;
        }
        public void setPasswordParameters(int numLowerCase, int numUpperCase, int numNumbers, int numSpecialChars) {
            this.numLowerCase = numLowerCase;
            this.numUpperCase = numUpperCase;
            this.numNumbers = numNumbers;
            this.numSpecialChars = numSpecialChars;
        }
        String getPwName() { return name; }
        public String getPassword(){
        return password.toString();
    }

        public void setDefinedPassword(String userDefinedPw) {
            password.append(userDefinedPw);
        }


        public void setRandomPassword() {
            Random randStream = new Random();
            Scanner userInput = new Scanner(System.in);
            int i;
            int len = 0;
            /*
            System.out.print("Enter number of lower case characters: ");
            this.numLowerCase = userInput.nextInt();
            System.out.print("Enter number of upper case characters: ");
            this.numUpperCase = userInput.nextInt();
            System.out.print("Enter number of numbers: ");
            this.numNumbers = userInput.nextInt();
            System.out.print("Enter number of special characters: ");
            this.numSpecialChars = userInput.nextInt();
            System.out.println();
            */
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

        }

}
