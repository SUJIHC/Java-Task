/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bad022;

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class arrGame {

    public static String[] transformCodes(int[] input1) {
        String[] result = new String[input1.length];
        for (int i = 0; i < input1.length; i++) {
            int n = input1[i];
            StringBuilder answer = new StringBuilder();
            if (String.valueOf(n).length() == 6) {
                answer.append("C");
            } else {
                answer.append("W");
            }
            if (n == 0) {
                answer.append("Z");
            } else if (n == 1) {
                answer.append("O");
            } else if (isPrime(n)) {
                answer.append("P");
            } else {
                answer.append("N");
            }
            int digitSum = sumToSingleDigit(n);
            answer.append(digitSum);

            if (n % 2 == 0) {
                answer.append(n / 2);
            } else {
                answer.append((n - 1) / 2);
            }
            result[i] = answer.toString();
        }
        return result;
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

    private static int sumToSingleDigit(int n) {
        while (n >= 10) {
            int sum = 0;
            while (n > 0) {
                sum += n % 10;
                n /= 10;
            }
            n = sum;
        }
        return n;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements:");
        int size = scanner.nextInt();
        int[] input1 = new int[size];
        System.out.println("Enter the elements:");
        for (int i = 0; i < size; i++) {
            input1[i] = scanner.nextInt();
        }
        String[] output = transformCodes(input1);
        System.out.println("Output:");
        for (String s : output) {
            System.out.println(s);
        }
    }
}
