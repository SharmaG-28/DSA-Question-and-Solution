import java.util.PriorityQueue;
import java.util.Scanner;

class KthLargest {
    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>(k);
        
        for (int num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        minHeap.offer(val);
        
        while (minHeap.size() > k) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
}

public class kthLargestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input k
        System.out.print("Enter the value of k: ");
        int k = scanner.nextInt();

        // Input nums array
        System.out.print("Enter the size of nums array: ");
        int size = scanner.nextInt();
        int[] nums = new int[size];
        System.out.println("Enter the elements of nums array:");
        for (int i = 0; i < size; i++) {
            nums[i] = scanner.nextInt();
        }

        // Create KthLargest object
        KthLargest kthLargest = new KthLargest(k, nums);

        // Input val and call add method
        System.out.print("Enter the value of val: ");
        int val = scanner.nextInt();
        int result = kthLargest.add(val);

        // Output result
        System.out.println("Output: " + result);

        scanner.close();
    }
}
