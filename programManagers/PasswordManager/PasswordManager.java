package programManagers.PasswordManager;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* The password manager is responsible for creating the passwords and temporarily storing them until they can be
* written to the source file via the File Manager. The password manager also validates proper password rules
* by using regex pattern match. Once the Password Manager creates the password (whether user defined or random),
* it will store it and then the caller will utilize these get methods to send to the File Manager for storing.
 */

public final class PasswordManager {

        private StringBuffer password;
        private StringBuffer availableCharacters;
        private String name;
        private int numLowerCase;
        private int numUpperCase;
        private int numNumbers;
        private int numSpecialChars;
        final private int MAXPASSWORDLENGTH = 20;

        public PasswordManager() {
            this.password = new StringBuffer();
            this.availableCharacters = new StringBuffer();
            this.name = "";
        }

        public void setPwName(String name) {

            Pattern valid = Pattern.compile("[a-zA-Z]*+[\\d]*+:[a-zA-Z]*+[\\d]*+");
            Matcher checkValid = valid.matcher(name);

            if (!checkValid.matches() && name.length() > 0 && name.length() < MAXPASSWORDLENGTH) {
                this.name = name;
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

        public void setDefinedPassword(String userDefinedPw) {
            Pattern invalid = Pattern.compile("[a-zA-Z]*+[\\d]*+:[a-zA-Z]*+[\\d]*+");
            Matcher checkInvalid = invalid.matcher(userDefinedPw);

            if (!(checkInvalid.matches() && userDefinedPw.length() < MAXPASSWORDLENGTH && userDefinedPw.length() > 0)) {
                password.append(userDefinedPw);
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

            while (len > 0) {
                index = randStream.nextInt(len);
                password.append(availableCharacters.charAt(index));
                availableCharacters.deleteCharAt(index);
                len--;
            }

        }

}
