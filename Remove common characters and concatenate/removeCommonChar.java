//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class removeCommonChar{
    public static void main(String args[]){
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        
        while(t--!=0){
            String s1=in.next(),
                   s2=in.next();
            
            Solution obj = new Solution();
            
            System.out.println(obj.concatenatedString(s1,s2));
        }
    }
}

// } Driver Code Ends




class Solution
{
    //Function to remove common characters and concatenate two strings.
    public static String concatenatedString(String s1,String s2)
    {
        // Your code here
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();

        for (char c : s1.toCharArray()) {
            set1.add(c);
        }

        for (char c : s2.toCharArray()) {
            set2.add(c);
        }

        Set<Character> commonChars = new HashSet<>(set1);
        commonChars.retainAll(set2);

        Set<Character> uncommonCharsS1 = new HashSet<>(set1);
        uncommonCharsS1.removeAll(set2);

        Set<Character> uncommonCharsS2 = new HashSet<>(set2);
        uncommonCharsS2.removeAll(set1);

        StringBuilder result = new StringBuilder();

        for (char c : s1.toCharArray()) {
            if (uncommonCharsS1.contains(c)) {
                result.append(c);
            }
        }

        for (char c : s2.toCharArray()) {
            if (uncommonCharsS2.contains(c)) {
                result.append(c);
            }
        }

        if (result.length() == 0) {
            return "-1";
        } else {
            return result.toString();
        }
    }
}