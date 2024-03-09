import java.util.PriorityQueue;
import java.util.Scanner;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int num : nums) {
            minHeap.offer(num);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }
}

public class kthLargestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input array
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] nums = new int[size];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            nums[i] = scanner.nextInt();
        }

        // Input k
        System.out.print("Enter the value of k: ");
        int k = scanner.nextInt();

        // Call findKthLargest method
        Solution solution = new Solution();
        int result = solution.findKthLargest(nums, k);

        // Output result
        System.out.println("Output: " + result);

        scanner.close();
    }
}
