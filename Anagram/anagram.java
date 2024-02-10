package Anagram;
import java.util.*;
import java.io.*;

class anagram{
    
    public static void main (String[] args)throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-->0)
        {
            String str = br.readLine();
            String s1 = str.split(" ")[0];
            String s2 = str.split(" ")[1];
            
            if(Solution.isAnagram(s1,s2)) // Calling static method
            {
                System.out.println("YES");
            }
            else
            {
                 System.out.println("NO");
            }
        }
    }
}

class Solution
{    
    //Function is to check whether two strings are anagram of each other or not.
    public static boolean isAnagram(String a,String b)
    {
        // Your code here
        char [] a_Array = a.toCharArray();
        char [] b_Array = b.toCharArray();
        
        Arrays.sort(a_Array);
        Arrays.sort(b_Array);
        
        String a_sorted = new String(a_Array);
        String b_sorted = new String(b_Array);
        
        return a_sorted.equals(b_sorted);
    }
}