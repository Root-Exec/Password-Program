package programManagers.PasswordManager;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//object will be responsible for creating/updating passwords based off of parameters provided by user

public final class PasswordManager {
        private static int objectsCreated = 0;
        private static StringBuffer password;
        private static StringBuffer availableCharacters;
        private String name;
        private int numLowerCase;
        private int numUpperCase;
        private int numNumbers;
        private int numSpecialChars;
        final private int MAXPASSWORDLENGTH = 20;
        private static PasswordManager pwManager;

        private PasswordManager() {
            password = new StringBuffer();
            availableCharacters = new StringBuffer();
            objectsCreated++;
            pwManager = getPasswordManagerInstance();
            name = "";
        }

        public static PasswordManager getPasswordManagerInstance() {
            if (objectsCreated < 1) {
                return new PasswordManager();
            } else {
                password = new StringBuffer();
                return pwManager;
            }
        }

        public void setPwName(String name) throws InvalidPasswordNameException {

            Pattern valid = Pattern.compile("[a-zA-Z]*+[\\d]*+:[a-zA-Z]*+[\\d]*+");
            Matcher checkValid = valid.matcher(name);

            if (!checkValid.matches()) {
                this.name = name;
            } else {
                throw new InvalidPasswordNameException("Invalid password name (contains : character)");
            }
        }

        public void setPasswordParameters(int numLowerCase, int numUpperCase, int numNumbers, int numSpecialChars) {
            this.numLowerCase = numLowerCase;
            this.numUpperCase = numUpperCase;
            this.numNumbers = numNumbers;
            this.numSpecialChars = numSpecialChars;
        }

        public String getPwName() { return name; }

        public String getPassword(){
            return password.toString();
        }

        public void setDefinedPassword(String userDefinedPw) throws InvalidPasswordNameException {
            Pattern invalid = Pattern.compile("[a-zA-Z]*+[\\d]*+:[a-zA-Z]*+[\\d]*+");
            Matcher checkInvalid = invalid.matcher(userDefinedPw);

            if (!checkInvalid.matches() && userDefinedPw.length() < MAXPASSWORDLENGTH) {
                password.append(userDefinedPw);
            } else {
                throw new InvalidPasswordNameException("Invalid password name. Must be less than 20 and not contain a :");
            }
        }

        public void setRandomPassword() {
            Random randStream = new Random();
            int i;
            int len = 0;

            for (i = 0; i < numLowerCase && len < MAXPASSWORDLENGTH; i++, len++)
                availableCharacters.append((char) (randStream.nextInt(27) + 'a'));

            for (i = 0; i < numUpperCase && len < MAXPASSWORDLENGTH; i++, len++)
                availableCharacters.append((char) (randStream.nextInt(27) + 'A'));

            for (i = 0; i < numNumbers && len < MAXPASSWORDLENGTH; i++, len++)
                availableCharacters.append((char)(randStream.nextInt(10) + '0'));

            for (i = 0; i < numSpecialChars && len < MAXPASSWORDLENGTH; i++, len++)
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
