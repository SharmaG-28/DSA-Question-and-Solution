//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class mergeKSortedArrays{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0){
			int n = sc.nextInt();
			int[][] a = new int[n][n];
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					a[i][j] = sc.nextInt();
			Solution T = new Solution();
			ArrayList<Integer> arr= T.mergeKArrays(a, n);
			for(int i = 0; i < n*n ; i++)
			    System.out.print(arr.get(i)+" ");
		    System.out.println();
		    
		    t--;
		}
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to merge k sorted arrays.
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int K) 
    {
        // Write your code here.
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> arr[a[0]][a[1]]));

        for (int i = 0; i < K; i++) {
            minHeap.add(new int[]{i, 0});
        }

        ArrayList<Integer> result = new ArrayList<>();

        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int row = current[0];
            int col = current[1];

            result.add(arr[row][col]);

            if (col + 1 < K) {
                minHeap.add(new int[]{row, col + 1});
            }
        }

        return result;
    }
}