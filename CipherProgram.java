import java.util.Scanner;
public class CipherProgram {
    public static String shiftCipher(String text, int key) {
        String result = "";
        key = (key % 26 + 26) % 26;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                char shifted = (char) (ch + key);
                if (shifted > 'Z') {
                    shifted = (char) (shifted - 26);
                }
                result += shifted;
            } else if (ch >= 'a' && ch <= 'z') {
                char shifted = (char) (ch + key);
                if (shifted > 'z') {
                    shifted = (char) (shifted - 26);
                }
                result += shifted;
            } else {
                result += ch;
            }
        }
        return result;
    }
    public static String caesarCipher(String text) {
        return shiftCipher(text, 3);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your message: ");
        String message = scanner.nextLine();
        System.out.print("Enter shift key value (integer): ");
        int key = scanner.nextInt();
        System.out.println("\n--- RESULTS ---");        
        String caesarEncrypted = caesarCipher(message);
        System.out.println("Caesar Cipher (Shift 3): " + caesarEncrypted);
        String shiftEncrypted = shiftCipher(message, key);
        System.out.println("Shift Cipher (Shift " + key + "):   " + shiftEncrypted);        
    }
}
