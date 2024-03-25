//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class main {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            ArrayList<String> result = ob.NBitBinary(n);
            for(String value  : result){
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    ArrayList<String> NBitBinary(int N) {
        ArrayList<String> ans = new ArrayList<>();
        String curr = "";
        solve(ans, curr, 0, 0, N);
        return ans;
    }

    public void solve(List<String> ans, String curr, int ones, int zeroes, int n) {
        if (ones < zeroes) return;

        if (curr.length() == n) {
            ans.add(curr);
            return;
        }

        solve(ans, curr + '1', ones + 1, zeroes, n);
        solve(ans, curr + '0', ones, zeroes + 1, n);

        return;
    }
}