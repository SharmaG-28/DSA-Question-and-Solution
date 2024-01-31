//{ Driver Code Starts
import java.io.*;
import java.util.*;

class sumOfMatrix
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            
            int matrix[][] = new int[n][n];
            for(int i = 0; i < n; i++)
                for(int j = 0; j < n; j++)
                    matrix[i][j] = sc.nextInt();

            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.sumTriangles(matrix,n);
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to return sum of upper and lower triangles of a matrix.
    static ArrayList<Integer> sumTriangles(int matrix[][], int n)
    {
        // code here
        int up = 0, low = 0;
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++)
                up += matrix[i][j];
            for(int j=0; j<=i; j++)
                low += matrix[i][j];
        }
                    
        ArrayList<Integer> result = new ArrayList<>();
        result.add(up);
        result.add(low);
        return result;
    }
}