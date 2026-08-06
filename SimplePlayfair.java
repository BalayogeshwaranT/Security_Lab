import java.util.Scanner;
public class SimplePlayfair {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] grid = {
            {'K', 'E', 'Y', 'W', 'O'},
            {'R', 'D', 'A', 'B', 'C'},
            {'F', 'G', 'H', 'I', 'L'},
            {'M', 'N', 'P', 'Q', 'S'},
            {'T', 'U', 'V', 'X', 'Z'}
        };
        System.out.print("Enter message to encrypt: ");
        String input = scanner.nextLine();
        String cleanText = input.toUpperCase().replaceAll("\\s+", "").replace("J", "I");
        String preparedText = "";
        for (int i = 0; i < cleanText.length(); i++) {
            preparedText += cleanText.charAt(i);
            if (i + 1 < cleanText.length()) {
                if (cleanText.charAt(i) == cleanText.charAt(i + 1)) {
                    preparedText += 'X';
                } else {
                    preparedText += cleanText.charAt(i + 1);
                    i++;
                }
            }
        }
        if (preparedText.length() % 2 != 0) {
            preparedText += 'X';
        }
        String encryptedText = "";
        for (int i = 0; i < preparedText.length(); i += 2) {
            char char1 = preparedText.charAt(i);
            char char2 = preparedText.charAt(i + 1);
            int r1 = -1, c1 = -1, r2 = -1, c2 = -1;
            for (int r = 0; r < 5; r++) {
                for (int c = 0; c < 5; c++) {
                    if (grid[r][c] == char1) { r1 = r; c1 = c; }
                    if (grid[r][c] == char2) { r2 = r; c2 = c; }
                }
            }
            if (r1 == r2) {
                encryptedText += grid[r1][(c1 + 1) % 5];
                encryptedText += grid[r2][(c2 + 1) % 5];
            } else if (c1 == c2) {
                encryptedText += grid[(r1 + 1) % 5][c1];
                encryptedText += grid[(r2 + 1) % 5][c2];
            } else {
                encryptedText += grid[r1][c2];
                encryptedText += grid[r2][c1];
            }
        }
        System.out.println("Encrypted Text: " + encryptedText);
    }
}
