import java.util.Scanner;

public class Main {
    static long mod = 1_000_000_007;

    static long modPow(long base, long exp) {
        if (exp == 0) return 1;
        if (exp == 1) return base % mod;

        long half = modPow(base, exp / 2);
        long result = (half * half) % mod;

        if (exp % 2 == 1) {
            result = (result * base) % mod;
        }

        return result;
    }

    static long countSheep(long A, long B) {
        if (A == 1) {
            return B % mod; 
        } else {
            // (A^(B-1) + A^(B-2) + ... + A^0) % mod
            long result = (modPow(A, B) - 1 + mod) % mod;

            long inverse = modPow(A - 1, mod - 2);
            result = (result * inverse) % mod;

            return result;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();

        long answer = countSheep(A, B);
        System.out.println(answer);
    }
}