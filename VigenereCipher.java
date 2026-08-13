import java.util.Scanner;
public class VigenereCipher {
    public static String encrypt(String text, String key) {
        StringBuilder result = new StringBuilder();
        text = text.toUpperCase();
        key = key.toUpperCase();
        int keyIndex = 0;
        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                int textValue = ch - 'A';
                int keyValue = key.charAt(keyIndex % key.length()) - 'A';
                int encryptedValue = (textValue + keyValue) % 26;
                result.append((char) ('A' + encryptedValue));
                keyIndex++;
            } else {
                // Keep spaces and special characters unchanged
                result.append(ch);
            }
        }
        return result.toString();
    }
    public static String decrypt(String text, String key) {
        StringBuilder result = new StringBuilder();
        text = text.toUpperCase();
        key = key.toUpperCase();
        int keyIndex = 0;
        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                int textValue = ch - 'A';
                int keyValue = key.charAt(keyIndex % key.length()) - 'A';
                int decryptedValue = (textValue - keyValue + 26) % 26;
                result.append((char) ('A' + decryptedValue));
                keyIndex++;
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter plaintext: ");
        String plaintext = sc.nextLine();
        System.out.print("Enter key: ");
        String key = sc.nextLine();
        String encrypted = encrypt(plaintext, key);
        String decrypted = decrypt(encrypted, key);
        System.out.println("Encrypted text: " + encrypted);
        System.out.println("Decrypted text: " + decrypted);
    }
}

