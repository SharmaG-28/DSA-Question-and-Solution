//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution
{
    //Function to swap odd and even bits.
    public static int swapBits(int n) 
    {
	    // Your code
	    int odd = n & 0b101010101010101010101010101010;
	    odd = odd>>1;
	    
	    int even = n & 0b010101010101010101010101010101;
	    even = even<<1;
	    
	    int ans = odd | even;
	    return ans;
	}
    
}

//{ Driver Code Starts.

class swapOddEven{

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();//testcases
		while(t-->0){
		    int n = sc.nextInt();//taking n
		    
		    Solution obj = new Solution();
		    
		    //calling swapBits() method of class
		    //Swap
		    System.out.println(obj.swapBits(n));
		}
	}
}
// } Driver Code Ends