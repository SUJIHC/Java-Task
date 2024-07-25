/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bad022;

import java.util.*;

/**
 *
 * @author admin
 */
public class NewClass1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements:");
        int input2 = scanner.nextInt();
        int[] input1 = new int[input2];
        System.out.println("Enter the elements:");
        for (int i = 0; i < input2; i++) {
            input1[i] = scanner.nextInt();
        }
        int sum = fPrimeS(input1);
        System.out.println("Output: " + sum);
    }

    private static int fPrimeS(int[] input1) {
        List<Integer> primes = new ArrayList<>();
        for (int num : input1) {
            if (isPrime(num)) {
                primes.add(num);
            }
        }
        if (primes.size() <= 1) {
            return 0;
        }
        Collections.sort(primes);
        int sum = 0;
        for (int i = 1; i < primes.size(); i++) {
            sum += primes.get(i);
        }
        return sum;
    }

    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
