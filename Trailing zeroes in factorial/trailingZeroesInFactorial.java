//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class trailingZeroesInFactorial
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N = sc.nextInt();
			
            Solution ob = new Solution();
            int ans  = ob.trailingZeroes(N);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static int trailingZeroes(int N){
        // Write your code here
        int count = 0;
        int fact = N;
        while(fact >= 5){
            count = count + fact/5;
            fact = fact/5;
        }
        return count;
    }
}