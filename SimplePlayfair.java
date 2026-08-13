import java.util.Scanner;

public class SimplePlayfair {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Get key from user
        System.out.print("Enter key: ");
        String key = scanner.nextLine().toUpperCase().replace("J", "I");

        // Get message from user
        System.out.print("Enter message to encrypt: ");
        String input = scanner.nextLine();

        // Remove spaces and replace J with I
        String cleanText = input.toUpperCase()
                .replaceAll("\\s+", "")
                .replace("J", "I");

        // Create Playfair matrix automatically
        String alphabet = "ABCDEFGHIKLMNOPQRSTUVWXYZ";
        String combined = key + alphabet;
        String unique = "";

        // Remove repeated letters
        for (int i = 0; i < combined.length(); i++) {
            char ch = combined.charAt(i);

            if (unique.indexOf(ch) == -1) {
                unique += ch;
            }
        }

        // Create 5x5 matrix
        char[][] grid = new char[5][5];
        int index = 0;

        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                grid[r][c] = unique.charAt(index++);
            }
        }

        // Display the generated matrix
        System.out.println("\nPlayfair Matrix:");

        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                System.out.print(grid[r][c] + " ");
            }
            System.out.println();
        }

        // Prepare the plaintext
        String preparedText = "";

        for (int i = 0; i < cleanText.length(); i++) {

            char first = cleanText.charAt(i);
            preparedText += first;

            if (i + 1 < cleanText.length()) {

                char second = cleanText.charAt(i + 1);

                if (first == second) {
                    preparedText += 'X';
                } else {
                    preparedText += second;
                    i++;
                }
            }
        }

        // If length is odd, add X
        if (preparedText.length() % 2 != 0) {
            preparedText += 'X';
        }

        System.out.println("\nPrepared Text: " + preparedText);

        // Encryption
        String encryptedText = "";

        for (int i = 0; i < preparedText.length(); i += 2) {

            char char1 = preparedText.charAt(i);
            char char2 = preparedText.charAt(i + 1);

            int r1 = -1, c1 = -1;
            int r2 = -1, c2 = -1;

            // Find positions of both characters
            for (int r = 0; r < 5; r++) {
                for (int c = 0; c < 5; c++) {

                    if (grid[r][c] == char1) {
                        r1 = r;
                        c1 = c;
                    }

                    if (grid[r][c] == char2) {
                        r2 = r;
                        c2 = c;
                    }
                }
            }

            // Same row
            if (r1 == r2) {

                encryptedText += grid[r1][(c1 + 1) % 5];
                encryptedText += grid[r2][(c2 + 1) % 5];

            }

            // Same column
            else if (c1 == c2) {

                encryptedText += grid[(r1 + 1) % 5][c1];
                encryptedText += grid[(r2 + 1) % 5][c2];

            }

            // Rectangle rule
            else {

                encryptedText += grid[r1][c2];
                encryptedText += grid[r2][c1];
            }
        }

        System.out.println("\nEncrypted Text: " + encryptedText);

        scanner.close();
    }
}

