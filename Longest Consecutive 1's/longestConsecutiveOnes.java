//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class Solution{
    
    /*  Function to calculate the longest consecutive ones
    *   N: given input to calculate the longest consecutive ones
    */
    public static int maxConsecutiveOnes(int N) {
        
        // Your code here
        String binaryString = Integer.toBinaryString(N);
        int count = 0;
        int maxCount = 0;
        
        for(int i=0; i< binaryString.length(); i++){
            if(binaryString.charAt(i) == '1'){
                count++;
                maxCount = Math.max(maxCount, count);
            }
            else{
                count=0;
            }
        }
        
        return maxCount;
    }
}



//{ Driver Code Starts.

class longestConsecutiveOnes {
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();//testcases
		while(t-->0){
		    int n = sc.nextInt();//input n
		    
		    Solution obj = new Solution();
		    
		    //calling maxConsecutiveOnes() function
		    System.out.println(obj.maxConsecutiveOnes(n));
		}
	}
}



// } Driver Code Ends