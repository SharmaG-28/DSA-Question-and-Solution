//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigInteger;


// } Driver Code Ends
//User function Template for Java

class Solution{
    
    //Function to return sum of count of set bits in the integers from 1 to n.
    public static int countSetBits(int n){
    
        // Your code here
        int count = 0;
        int x = 1;

        while (n >= x) {
            // Count set bits in numbers with the current bit set
            int totalPairs = (n + 1) / (x * 2);
            count += totalPairs * x;

            // Count the remaining set bits
            count += Math.max(0, (n + 1) % (x * 2) - x);

            x *= 2;
        }
        
        return count;
    }
}

//{ Driver Code Starts.

// Driver code
class countTotalSetBits {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();//testcases
		int x, n;
		while(t-->0) {
	        n = sc.nextInt();//input n

		    Solution obj = new Solution();

		    System.out.println(obj.countSetBits(n));//calling countSetBits() method
		}
	}
}

// } Driver Code Ends