//{ Driver Code Starts
import java.util.*;


class circularTour
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t =sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			sc.nextLine();
			String str = sc.nextLine();
			String arr[] = str.split(" ");
			int p[] = new int[n];
			int d[] = new int[n];
			int j=0;
			int k=0;
			for(int i=0; i<2*n; i++)
			{
				if(i%2 == 0)
				{
					p[j]= Integer.parseInt(arr[i]);
					j++;
				}
				else
				{
					d[k] = Integer.parseInt(arr[i]);
					k++;
				}
			}
			
			System.out.println(new Solution().tour(p,d));
		t--;
		}
	}
}
// } Driver Code Ends


// In java function tour() takes two arguments array of petrol
// and array of distance

class Solution
{
    //Function to find starting point where the truck can start to get through
    //the complete circle without exhausting its petrol in between.
    int tour(int petrol[], int distance[])
    {
	    // Your code here
	    int n = petrol.length;
        Queue<Integer> queue = new LinkedList<>();

        int start = 0;
        int currPetrol = 0;

        int totalPetrol = 0;
        int totalDistance = 0;

        for (int i = 0; i < n; i++) {
            totalPetrol += petrol[i];
            totalDistance += distance[i];
            int netPetrol = petrol[i] - distance[i];
            currPetrol += netPetrol;

            if (currPetrol < 0) {
                start = i + 1;
                currPetrol = 0;
                queue.clear();
            } else {
                queue.offer(i);
            }
        }

        return (totalPetrol >= totalDistance) ? start : -1;
    }
}