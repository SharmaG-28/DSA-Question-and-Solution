//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class recursion1toN
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			
            Solution ob = new Solution();
            ob.printTillN(N);
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static void printTillN(int N){
        // code here
        if(N>0){
            printTillN(N-1);
            System.out.print(N+ " ");
        }
    }
}