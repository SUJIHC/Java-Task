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
public class Game {
  public static int Formula(String input1) {
    StringBuilder numb = new StringBuilder();
    StringBuilder oper = new StringBuilder();
    for (char c : input1.toCharArray()) {
      if (Character.isDigit(c)) {
        numb.append(c);
      } else if (c == '+' || c == '-' || c == '*' || c == '/') {
        oper.append(c);
      }
    }
    String[] numArray = numb.toString().split("");
    String[] opArray = oper.toString().split("");
    int result = Integer.parseInt(numArray[0]);
    for (int i = 1; i < numArray.length; i++) {
      int num = Integer.parseInt(numArray[i]);
      char op = opArray[i - 1].charAt(0);
      switch (op) {
        case '+':
          result += num;
          break;
        case '-':
          result -= num;
          break;
        case '*':
          result *= num;
          break;
        case '/':
          result /= num;
          break;
      }
    }
    return result;
  }
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the input string: ");
    String input = scanner.nextLine();
    int output = Formula(input);
    System.out.println("Output: " + output);
    scanner.close();
  }
}
