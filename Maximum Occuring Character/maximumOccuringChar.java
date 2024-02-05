//{ Driver Code Starts
import java.lang.*;
import java.io.*;
import java.util.*;

class maximumOccuringChar
{
    public static void main (String[] args) throws IOException
    {
     BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
     int tc=Integer.parseInt(br.readLine().trim());
     
     while(tc-- >0)
     {
         String line=br.readLine().trim();
         
         Solution obj = new Solution();
         
         System.out.println(obj.getMaxOccuringChar(line));
         
     }
     }
}
// } Driver Code Ends



class Solution
{
    //Function to find the maximum occurring character in a string.
    public static char getMaxOccuringChar(String line)
    {
        // Your code here
        Map<Character, Integer> charCount = new HashMap<>();
        
        for (char ch : line.toCharArray()){
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
        }
        
        char result = '#';
        int maxCount = 0;
        
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()){
            char Char = entry.getKey();
            int Count = entry.getValue();
            if (Count > maxCount || (Count == maxCount && Char < result)){
            result = Char;
            maxCount = Count;
            }
        }
        
        return result;

    }
    
}