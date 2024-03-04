import java.util.Scanner;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        if (Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left)
                && isBalanced(root.right))
            return true;

        return false;
    }

    private int height(TreeNode node) {
        if (node == null)
            return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }
}

public class balancedBinaryTree {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input as an array of integers
        System.out.print("Enter the number of elements in the tree: ");
        int n = scanner.nextInt();
        System.out.print("Enter the elements of the tree (use -1 for null nodes): ");
        int[] elements = new int[n];
        for (int i = 0; i < n; i++) {
            elements[i] = scanner.nextInt();
        }

        // Construct the binary tree from the input array
        TreeNode root = buildTree(elements, 0);

        // Call the isBalanced function from Solution class
        Solution solution = new Solution();
        boolean result = solution.isBalanced(root);

        // Output the result
        System.out.println("Output: " + result);

        scanner.close();
    }

    // Function to construct a binary tree from an array
    private static TreeNode buildTree(int[] elements, int index) {
        TreeNode root = null;
        if (index < elements.length) {
            if (elements[index] != -1) {
                root = new TreeNode(elements[index]);
                root.left = buildTree(elements, 2 * index + 1);
                root.right = buildTree(elements, 2 * index + 2);
            }
        }
        return root;
    }
}
