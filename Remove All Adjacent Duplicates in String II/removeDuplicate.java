import java.util.Scanner;
import java.util.Stack;

class Solution {
    public String removeDuplicates(String str, int k) {
        Stack<Character> s = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        StringBuilder ans = new StringBuilder();

        for (char ch : str.toCharArray()) {
            if (!s.isEmpty() && ch == s.peek()) {
                s.push(ch);
                countStack.push(countStack.peek() + 1);
            } else {
                s.push(ch);
                countStack.push(1);
            }

            if (countStack.peek() == k) {
                int count = k;
                while (count-- > 0) {
                    s.pop();
                    countStack.pop();
                }
            }
        }

        while (!s.isEmpty())
            ans.insert(0, s.pop());

        return ans.toString();
    }
}

public class removeDuplicate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution solution = new Solution();

        System.out.println("Enter the string:");
        String input = scanner.nextLine();

        System.out.println("Enter the value of k:");
        int k = scanner.nextInt();

        String result = solution.removeDuplicates(input, k);

        System.out.println("String after removing duplicates: " + result);

        scanner.close();
    }
}