//{ Driver Code Starts
    import java.io.*;
    import java.util.*;
    
    class primeNumber
    {
        public static void main(String args[])throws IOException
        {
            BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(read.readLine());
            while(t-- > 0)
            {
                int N = Integer.parseInt(read.readLine());
                Solution ob = new Solution();
                System.out.println(ob.isPrime(N));
            }
        }
    }
    // } Driver Code Ends
    
    class Solution{
        int isPrime(int N){
            // code here
            int a = 2;
            if(N == 1)
                return 0;
            else{
                while(a*a <= N){
                    if(N%a ==0){
                        return 0;
                    }
                    a++;
                }
                return 1;
            }
        }
    }