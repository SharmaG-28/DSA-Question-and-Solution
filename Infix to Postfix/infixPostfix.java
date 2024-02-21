//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class infixPostfix {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(
                new Solution().infixToPostfix(br.readLine().trim()));
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to convert an infix expression to a postfix expression.
    public static String infixToPostfix(String exp) {
        // Your code here
        Stack<Character> s = new Stack<>();
        StringBuilder postfix = new StringBuilder();

        for (char ch : exp.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                postfix.append(ch);
            } else if (ch == '(') {
                s.push(ch);
            } else if (ch == ')') {
                while (!s.isEmpty() && s.peek() != '(') {
                    postfix.append(s.pop());
                }
                s.pop();
            } else {
                while (!s.isEmpty() && getPrecedence(s.peek()) >= getPrecedence(ch)) {
                    postfix.append(s.pop());
                }
                s.push(ch);
            }
        }

        while (!s.isEmpty()) {
            postfix.append(s.pop());
        }

        return postfix.toString();
    }

    static int getPrecedence(char operator) {
        switch (operator) {
            case '^':
                return 3;
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 1;
            default:
                return 0;
        }
    }
}