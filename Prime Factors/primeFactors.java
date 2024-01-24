//{ Driver Code Starts


    import java.util.*;
    import java.lang.*;
    import java.io.*;
    
    class primeFactors
    {
        public static void main(String[] args) throws IOException
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine().trim());
            while(T-->0)
            {
                int N = Integer.parseInt(br.readLine().trim());
                Solution ob = new Solution();
                int[] ans = ob.AllPrimeFactors(N);
                for(int i = 0; i < ans.length; i++)
                    System.out.print(ans[i] + " ");
                System.out.println();
            }
        }
    }
    
    // } Driver Code Ends
    
    class Solution
    {
        public int[] AllPrimeFactors(int N)
        {
            ArrayList<Integer> list = new ArrayList<>();
            for(int i=2; i<=N; i++){
                if(prime(i)){
                    if(N%i==0){
                        list.add(i);    
                    }
                    
                }
            }
            
            int[]result = new int[list.size()];
            for(int i = 0; i<list.size(); i++){
                result[i] = list.get(i);
            }
            return result;
        }
    
        static boolean prime(int N){
            if(N==1){
                return false;
            }
            
            if(N==2||N==3){
                return true;
            }
            
            if(N%2==0||N%3==0){
                return false;
            }
            
            for(int i = 5; i*i<=N; i=i+6){
                if(N%i==0||N%(i+2)==0){
                    return false;
                }
            }
            
            return true;
        }
    }