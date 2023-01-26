package programManagers.SecurityManager;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/* The security manager is responsible for initial log in, and encrypting and decrypting the source password file.
 */

public class SecurityManager {

    SecretKey key;
    Cipher cipher;


    FileInputStream encryptedToDecryptedFile;
    FileOutputStream decryptedToEncryptedFile;
    String encryptedFileName = "EncryptedKeychain.txt";
    String decryptedFileName = "Keychain.txt";


}
