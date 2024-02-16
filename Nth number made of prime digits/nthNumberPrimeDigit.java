//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class nthNumberPrimeDigit {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		  int n=sc.nextInt();
		  Solution ob = new Solution();
		  System.out.println(ob.primeDigits(n));
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find nth number made of only prime digits.
    public static int primeDigits(int n)
    {
        //Your code here
        String primeDigits = "2357";
        int count = 0;
        int num = 1;

        while (count < n) {
            num++;
            String numStr = Integer.toString(num);

            boolean isPrimeDigit = true;
            for (char digit : numStr.toCharArray()) {
                if (primeDigits.indexOf(digit) == -1) {
                    isPrimeDigit = false;
                    break;
                }
            }

            if (isPrimeDigit) {
                count++;
            }
        }

        return num;
    }
}