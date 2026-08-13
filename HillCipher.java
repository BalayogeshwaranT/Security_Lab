import java.util.Scanner;
public class HillCipher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = 3, b = 3;
        int c = 2, d = 5;
        System.out.print("Enter 4-letter plaintext: ");
        String text = sc.nextLine().toUpperCase();
        int p1 = text.charAt(0) - 'A';
        int p2 = text.charAt(1) - 'A';
        int p3 = text.charAt(2) - 'A';
        int p4 = text.charAt(3) - 'A';
        int x1 = (a * p1 + b * p2) % 26;
        int x2 = (c * p1 + d * p2) % 26;
        int x3 = (a * p3 + b * p4) % 26;
        int x4 = (c * p3 + d * p4) % 26;
        String encrypted = "" +
                (char)(x1 + 'A') +
                (char)(x2 + 'A') +
                (char)(x3 + 'A') +
                (char)(x4 + 'A');
        System.out.println("Encrypted text: " + encrypted);
    }
}

