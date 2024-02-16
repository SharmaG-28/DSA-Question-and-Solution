//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
//User function template for JAVA

class Solution
{
    //Function to find the minimum indexed character.
    public static int minIndexChar(String str, String patt)
    {
        // Your code here
        Map<Character, Integer> indexMap = new HashMap<>();

        int result = Integer.MAX_VALUE;

        for (char c : patt.toCharArray()) {
            indexMap.putIfAbsent(c, Integer.MAX_VALUE);
        }

        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);

            if (indexMap.containsKey(currentChar)) {
                result = Math.min(result, i);
            }
        }
        
        return (result == Integer.MAX_VALUE) ? -1 : result;
    }
}

//{ Driver Code Starts.

class minIndexedChar {
	public static void main (String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t>0)
		{
		    t--;
		    
		    String s1=sc.next();
		    String s2=sc.next();
		    
		    int res = new Solution().minIndexChar(s1, s2);
		    System.out.println(res);
		}
	}
}

// } Driver Code Ends