import java.util.*;

public class RowColumnCipher {
    public static String encrypt(String text, String key) {
        text = text.replace(" ", "").toUpperCase();
        
        // FIX: Create a final variable for the lambda expression
        final String targetKey = key.toUpperCase();
        
        int numCols = targetKey.length();
        // Pad the message with 'X' to cleanly fill the grid
        while (text.length() % numCols != 0) {
            text += "X";
        }
        
        int numRows = text.length() / numCols;
        char[][] grid = new char[numRows][numCols];
        
        // Fill the grid row by row
        int charIdx = 0;
        for (int r = 0; r < numRows; r++) {
            for (int c = 0; c < numCols; c++) {
                grid[r][c] = text.charAt(charIdx++);
            }
        }
        
        // Find alphabetical order of key characters
        Integer[] colOrder = new Integer[numCols];
        for (int i = 0; i < numCols; i++) colOrder[i] = i;
        
        // Lambda now uses the final 'targetKey' variable safely
        Arrays.sort(colOrder, (a, b) -> Character.compare(targetKey.charAt(a), targetKey.charAt(b)));
        
        // Read columns based on sorted order
        StringBuilder ciphertext = new StringBuilder();
        for (int col : colOrder) {
            for (int r = 0; r < numRows; r++) {
                ciphertext.append(grid[r][col]);
            }
        }
        return ciphertext.toString();
    }

    public static void main(String[] args) {
        String msg = "MEET ME AT NOON";
        String key = "HACK";
        System.out.println("Row & Column Cipher: " + encrypt(msg, key));
    }
}

