//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class pairs {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int)(n)];
            
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            
            Solution obj = new Solution();
            List<Long> answer = obj.PosNegPair(a, n);
            int sz = answer.size();
            
            if(sz==0)
            System.out.println(0);
            
            else{
                StringBuilder output = new StringBuilder();
                for(long x : answer)
                output.append(x+" ");
                System.out.println(output);
            }
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution {
    
    public List<Long> PosNegPair(long a[], long n)
    {
        List<Long> result = new ArrayList<>();
        Map<Long, Integer> frequencyMap = new HashMap<>();
        
        for (long num : a) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        for (long num : a) {
            if (num > 0 && frequencyMap.containsKey(-num)) {
                long negative = -num;
                long positive = num;
                int minFrequency = Math.min(frequencyMap.get(negative), frequencyMap.get(positive));
                for (int i = 0; i < minFrequency; i++) {
                    result.add(negative);
                    result.add(positive);
                }
                frequencyMap.remove(negative);
                frequencyMap.remove(positive);
            }
        }
        
        Collections.sort(result, Comparator.comparingLong(Math::abs));
        
        return result;
    }
}