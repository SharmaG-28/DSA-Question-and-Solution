import java.util.*;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();

        int left = 0;
        int right = arr.length - 1;

        while (right - left + 1 > k){
            int leftDistance = Math.abs(arr[left] - x);
            int rightDistance = Math.abs(arr[right] - x);

            if (leftDistance > rightDistance)
                left++;
            else
                right--;
        }

        for (int i = left; i <= right; i++){
            result.add(arr[i]);
        }
        return result;
    }
}

public class kClosestElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input arr, k, and x
        System.out.print("Enter the size of the arr array: ");
        int size = scanner.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter the elements of the arr array:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.print("Enter the value of k: ");
        int k = scanner.nextInt();
        System.out.print("Enter the value of x: ");
        int x = scanner.nextInt();

        // Call findClosestElements method
        Solution solution = new Solution();
        List<Integer> result = solution.findClosestElements(arr, k, x);

        // Output result
        System.out.print("Output: [");
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i));
            if (i < result.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        scanner.close();
    }
}
