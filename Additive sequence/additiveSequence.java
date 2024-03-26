//{ Driver Code Starts
import java.util.*;

public class additiveSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            Solution ss = new Solution();
            boolean result = ss.isAdditiveSequence(s);
            System.out.println((result == true ? 1 : 0));
        }
        sc.close();
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    public boolean isAdditiveSequence(String n) {
        int len = n.length();
        for (int i = 1; i <= len / 2; i++) {
            for (int j = 1; Math.max(i, j) <= len - i - j; j++) {
                if (isValidSequence(n, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isValidSequence(String n, int firstLen, int secondLen) {
        if ((n.charAt(0) == '0' && firstLen > 1) || (n.charAt(firstLen) == '0' && secondLen > 1)) {
            return false;
        }
        String first = n.substring(0, firstLen);
        String second = n.substring(firstLen, firstLen + secondLen);
        String remaining = n.substring(firstLen + secondLen);

        while (!remaining.isEmpty()) {
            String sum = addStrings(first, second);
            if (!remaining.startsWith(sum)) {
                return false;
            }
            remaining = remaining.substring(sum.length());
            first = second;
            second = sum;
        }
        return true;
    }
    
    private String addStrings(String num1, String num2) {
        StringBuilder sum = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        while (i >= 0 || j >= 0 || carry > 0) {
            int digit1 = (i >= 0) ? num1.charAt(i--) - '0' : 0;
            int digit2 = (j >= 0) ? num2.charAt(j--) - '0' : 0;
            int total = digit1 + digit2 + carry;
            sum.insert(0, total % 10);
            carry = total / 10;
        }

        return sum.toString();
    }
}