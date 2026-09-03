import java.util.*;

public class RailFenceCipher {
    public static String encrypt(String text, int rails) {
        // Remove spaces and convert to uppercase
        text = text.replace(" ", "").toUpperCase();
        
        // Edge case: if rows are 1, cipher remains the same
        if (rails <= 1) return text;

        // Create string builders for each rail row
        StringBuilder[] fence = new StringBuilder[rails];
        for (int i = 0; i < rails; i++) {
            fence[i] = new StringBuilder();
        }
        
        int rail = 0;
        int direction = 1; // 1 means moving down, -1 means moving up
        
        // Loop through characters and assign to their respective rails
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            fence[rail].append(c);
            
            rail += direction;
            
            // Bounce direction when reaching the top or bottom rail row
            if (rail == 0 || rail == rails - 1) {
                direction = -direction;
            }
        }
        
        // Combine all rails into one final ciphertext string
        StringBuilder ciphertext = new StringBuilder();
        for (StringBuilder row : fence) {
            ciphertext.append(row);
        }
        
        return ciphertext.toString();
    }

    public static void main(String[] args) {
        String msg = "SECRET MESSAGE";
        int rails = 3;
        
        System.out.println("Plaintext: " + msg);
        System.out.println("Rail Fence Cipher: " + encrypt(msg, rails));
    }
}

