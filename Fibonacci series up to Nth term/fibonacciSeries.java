//{ Driver Code Starts
import java.io.*;
import java.util.*;

class fibonacciSeries {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            int ans[] = obj.Series(n);
            for (int i : ans) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution {

    int[] Series(int n) {
        // code here
        int fibonacci[] = new int[n+1];
        
        fibonacci[0] = 0;
        if(n>0){
            fibonacci[1] = 1;
        }
        
        for(int i=2; i<=n; i++){
            fibonacci[i] = (fibonacci[i-1] + fibonacci[i-2]) % 1000000007;
        }
        
        return fibonacci;
    }
}