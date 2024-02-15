//{ Driver Code Starts
//Initial template for JAVA

import java.lang.*;
import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function template for JAVA

class Solution
{
    //Function to check if a string is Pangram or not.
    public static boolean checkPangram  (String s) {
        // your code here
        String str = s.toLowerCase();
        
        Set<Character> characterSet = new HashSet<>();
        
        for (char c : str.toCharArray()){
            if (Character.isLetter(c)) {
                characterSet.add(c);
            }
        }
        
        if(characterSet.size() == 26)
            return true;
        else
            return false;
    }
}

//{ Driver Code Starts.

class panagramChecking
 {
	public static void main (String[] args) throws IOException
	 {
	  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	  int t=Integer.parseInt(br.readLine());
	  while(t-->0)
	  {
	    String s=br.readLine().trim();
	    
	    System.out.println(new Solution().checkPangram (s)==true?1:0);
	  }
	  
	 }
}
// } Driver Code Ends
