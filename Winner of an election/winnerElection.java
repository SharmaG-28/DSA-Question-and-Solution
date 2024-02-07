//{ Driver Code Starts
import java.io.*;
import java.util.*;

class winnerElection
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            String arr[] = new String[n];
            
            for(int i = 0; i < n; i++)
                arr[i] = sc.next();
            
            Solution obj = new Solution();    
            String result[] = obj.winner(arr, n);
            System.out.println(result[0] + " " + result[1]);
            
           
        }
        
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to return the name of candidate that received maximum votes.
    public static String[] winner(String arr[], int n)
    {
        // add your code
        Map<String, Integer> voteCount = new HashMap<>();
        for (String candidate : arr) {
            voteCount.put(candidate, voteCount.getOrDefault(candidate, 0) + 1);
        }
        
        int maxVotes = 0;
        String winner = "";
        for (Map.Entry<String, Integer> entry : voteCount.entrySet()) {
            String candidate = entry.getKey();
            int votesReceived = entry.getValue();

            if (votesReceived > maxVotes || (votesReceived == maxVotes && candidate.compareTo(winner) < 0)) {
                maxVotes = votesReceived;
                winner = candidate;
            }
        }
        
        String[] result = {winner, Integer.toString(maxVotes)};
        return result;
    }
}

