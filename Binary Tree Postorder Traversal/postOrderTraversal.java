import java.util.*;

public class postOrderTraversal {
    // Definition for a binary tree node
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
    // Solution class containing postorderTraversal method
    static class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root != null) {
                result.addAll(postorderTraversal(root.left));
                result.addAll(postorderTraversal(root.right));
                result.add(root.val);
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the tree elements
        System.out.print("Enter the number of nodes in the binary tree: ");
        int n = scanner.nextInt();
        TreeNode[] nodes = new TreeNode[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter value of node " + (i + 1) + ": ");
            int val = scanner.nextInt();
            nodes[i] = new TreeNode(val);
        }

        System.out.println("Enter the parent-child relationships (as pairs of node indices).");
        for (int i = 0; i < n - 1; i++) {
            System.out.print("Enter parent index and child index separated by space: ");
            int parentIdx = scanner.nextInt();
            int childIdx = scanner.nextInt();
            if (nodes[parentIdx] != null) {
                if (nodes[childIdx] == null) {
                    System.out.print("Enter value of node " + (childIdx + 1) + ": ");
                    int val = scanner.nextInt();
                    nodes[childIdx] = new TreeNode(val);
                }
                if (nodes[parentIdx].left == null) {
                    nodes[parentIdx].left = nodes[childIdx];
                } else {
                    nodes[parentIdx].right = nodes[childIdx];
                }
            } else {
                System.out.println("Invalid parent index.");
            }
        }

        // Get the root node
        TreeNode root = null;
        for (int i = 0; i < n; i++) {
            if (nodes[i] != null && nodes[i].left == null && nodes[i].right == null) {
                root = nodes[i];
                break;
            }
        }

        // Perform postorder traversal
        Solution solution = new Solution();
        List<Integer> postorder = solution.postorderTraversal(root);

        // Output the result
        System.out.println("Postorder Traversal: " + postorder);

        scanner.close();
    }
}
