import java.util.Scanner;
import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char bracket = stack.pop();

                if ((ch == ')' && bracket != '(') ||
                    (ch == '}' && bracket != '{') ||
                    (ch == ']' && bracket != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}

public class isValidParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution solution = new Solution();

        System.out.println("Enter the string:");
        String input = scanner.nextLine();

        boolean isValid = solution.isValid(input);

        if (isValid) {
            System.out.println("The string has valid parentheses.");
        } else {
            System.out.println("The string does not have valid parentheses.");
        }

        scanner.close();
    }
}
