/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bad022;

import java.util.*;
;

/**
 *
 * @author admin
 */
public class charGame {

    public static char[] genChar(int[] input1) {
        int n = input1.length;
        char[] result = new char[n];
        List<int[]> indexValuePairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            indexValuePairs.add(new int[]{i, input1[i]});
        }
        indexValuePairs.sort(Comparator.comparingInt(pair -> pair[1]));
        for (int i = 0; i < n; i++) {
            int index = indexValuePairs.get(i)[0];
            result[index] = (char) ('a' + i);
        }
        return result;
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
        char[] output = genChar(input1);
        System.out.println("Output:");
        System.out.println(Arrays.toString(output));
    }
}
