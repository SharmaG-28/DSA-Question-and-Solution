//Driver Code Starts
import java.io.*;
import java.util.*;

class CountDigitsInFactorial
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(read.readLine());

        Solution ob = new Solution();
        System.out.println(ob.facDigits(N));
    }
}
//Driver Code Ends

class Solution
{
    static int facDigits(int N){
        double count = 0;
        if(N == 1)
            return 1;

        for(int i=1; i<=N; i++)
            count = count + Math.log10(i);
            
        return (int)(count+1);
    }
}