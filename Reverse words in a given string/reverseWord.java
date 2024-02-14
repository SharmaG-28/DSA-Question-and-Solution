//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class reverseWord {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.reverseWords(s));
            t--;
        }
    }
}

// } Driver Code Ends



class Solution 
{
    //Function to reverse words in a given string.
    String reverseWords(String S)
    {
        // code here 
        String[] words = S.split("\\.");
        StringBuilder reversedString = new StringBuilder();
        
        for (int i = words.length - 1; i >= 0; i--){
            
            reversedString.append(words[i]);
            if (i > 0) {
                reversedString.append(".");
            }
        }
        
        return reversedString.toString();
    }
}