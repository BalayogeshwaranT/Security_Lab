import java.math.BigInteger;
import java.util.Scanner;
public class RSAExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter prime number p: ");
        BigInteger p = sc.nextBigInteger();
        System.out.print("Enter prime number q: ");
        BigInteger q = sc.nextBigInteger();
        System.out.print("Enter encryption key e: ");
        BigInteger e = sc.nextBigInteger();
        BigInteger n = p.multiply(q);
        System.out.println("n="+n);
        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        System.out.println("phi(n)="+phi);
        BigInteger d = e.modInverse(phi);
        System.out.println("Public Key: (" + e + ", " + n + ")");
        System.out.println("Private Key: (" + d + ", " + n + ")");
        System.out.print("Enter plaintext number: ");
        BigInteger message = sc.nextBigInteger();
        BigInteger cipherText = message.modPow(e, n);
        System.out.println("Encrypted Text: " + cipherText);
        BigInteger decryptedText = cipherText.modPow(d, n);
        System.out.println("Decrypted Text: " + decryptedText);
        sc.close();
    }
}
