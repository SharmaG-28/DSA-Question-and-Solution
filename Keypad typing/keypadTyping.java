//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class keypadTyping {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		sc.nextLine();
		while(t-->0)
		{
		    String s=sc.nextLine();
		    
		    System.out.println(printNumber(s,s.length()));
		}
		
	}

// } Driver Code Ends
//User function Template for Java


//Function to find matching decimal representation of a string as on the keypad.
public static String printNumber(String s, int n) 
{
    //Your code here
    String result = "";
    
    for (int i=0; i<n; i++){
        if(s.charAt(i) == 'a' || s.charAt(i) == 'b' || s.charAt(i) == 'c')
            result += '2';
        else if(s.charAt(i) == 'd' || s.charAt(i) == 'e' || s.charAt(i) == 'f')
            result += '3';
        else if(s.charAt(i) == 'g' || s.charAt(i) == 'h' || s.charAt(i) == 'i')
            result += '4';
        else if(s.charAt(i) == 'j' || s.charAt(i) == 'k' || s.charAt(i) == 'l')
            result += '5';
        else if(s.charAt(i) == 'm' || s.charAt(i) == 'n' || s.charAt(i) == 'o')
            result += '6';
        else if(s.charAt(i) == 'p' || s.charAt(i) == 'q' || s.charAt(i) == 'r' || s.charAt(i) == 's')
            result += '7';
        else if(s.charAt(i) == 't' || s.charAt(i) == 'u' || s.charAt(i) == 'v')
            result += '8';
        else
            result += '9';
    }
    return result;
}
}