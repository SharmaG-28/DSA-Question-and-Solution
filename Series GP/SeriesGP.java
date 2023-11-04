//Driver Code Starts
import java.io.*;

class SeriesGP
{
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //Take input a, r, n in simultaneously
        String s1 = br.readLine().trim();
        String[] s2 = s1.split(" ");
        
        int a = Integer.parseInt(s2[0]);
        int r = Integer.parseInt(s2[1]);
        int n = Integer.parseInt(s2[2]);

        //Instance of Solution class is created
        Solution ob = new Solution();
        System.out.println(ob.Nth_term(a, r, n));
    }
}
//Driver Code Ends

//Solution class with Nth_term method
class Solution
{
    int Nth_term(int a, int r, int n)
    {
        int mod = (int) (Math.pow(10, 9) + 7);
        
        int ans = (int) ((a * (long) (Math.pow(r, n-1)) % mod)%mod);
        
        return ans;
    }
}

//Code Ends