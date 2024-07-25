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
public class NameGame {

    public static class Result {

        String output1;
        String output2;
        String output3;

        public Result(String output1, String output2, String output3) {
            this.output1 = output1;
            this.output2 = output2;
            this.output3 = output3;
        }
    }

    public static Result encodeStrings(String input1, String input2, String input3) {
        String[] parts1 = splitString(input1);
        String[] parts2 = splitString(input2);
        String[] parts3 = splitString(input3);
        String output1 = parts1[0] + parts2[1] + parts3[2];
        String output2 = parts1[1] + parts2[2] + parts3[0];
        String output3 = toggleCase(parts1[2] + parts2[0] + parts3[1]);
        return new Result(output1, output2, output3);
    }

    private static String[] splitString(String input) {
        int len = input.length();
        int partLength = len / 3;
        int remainder = len % 3;
        String front, middle, end;
        if (remainder == 0) {
            front = input.substring(0, partLength);
            middle = input.substring(partLength, 2 * partLength);
            end = input.substring(2 * partLength);
        } else if (remainder == 1) {
            front = input.substring(0, partLength);
            middle = input.substring(partLength, 2 * partLength + 1);
            end = input.substring(2 * partLength + 1);
        } else {
            front = input.substring(0, partLength + 1);
            middle = input.substring(partLength + 1, 2 * partLength + 1);
            end = input.substring(2 * partLength + 1);
        }
        return new String[]{front, middle, end};
    }

    private static String toggleCase(String input) {
        StringBuilder toggled = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isUpperCase(c)) {
                toggled.append(Character.toLowerCase(c));
            } else {
                toggled.append(Character.toUpperCase(c));
            }
        }
        return toggled.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first string:");
        String input1 = scanner.nextLine();
        System.out.println("Enter the second string:");
        String input2 = scanner.nextLine();
        System.out.println("Enter the third string:");
        String input3 = scanner.nextLine();
        Result result = encodeStrings(input1, input2, input3);
        System.out.println("Output1: " + result.output1);
        System.out.println("Output2: " + result.output2);
        System.out.println("Output3: " + result.output3);
    }
}
