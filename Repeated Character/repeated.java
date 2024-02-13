//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class repeated
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String s;
            s = sc.next();
            
            Solution ob = new Solution();
            char res = ob.firstRep(s);
            if (res == '#')
                System.out.println(-1);
            else
                System.out.println(res);
             
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    char firstRep(String S)
    {
        // your code here
        HashSet<Character> set = new HashSet<>();
        HashSet<Character> repeatedSet = new HashSet<>();

        for(char ch : S.toCharArray()){
            if(!set.add(ch)){
                repeatedSet.add(ch);
            }
        }
        
        for(char ch : S.toCharArray()){
            if(repeatedSet.contains(ch)){
                return ch;
            }
        }

        return '#';
    }
}