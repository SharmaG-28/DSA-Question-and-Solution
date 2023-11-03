import java.io.*;
import java.util.*;

//Driver Code Starts
class factorial
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        //Input N
        int N = Integer.parseInt(read.readLine());

        //Create object of Solution class
        Solution ob = new Solution();
        System.out.println(ob.factorial(N));
    }
}
//Driver Code Ends


//Solution Class Starts
class Solution
{
    long factorial(int N)
    {
        Long fact = 1L;
        for(int i=2; i<=N; i++)
            fact = fact * i;
        return fact;
    }
}
//Solution Class Ends