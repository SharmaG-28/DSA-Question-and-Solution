import java.util.*;

// Definition for a binary tree node.
class TreeNode {
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

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            result.add(root.val);
            result.addAll(preorderTraversal(root.left));
            result.addAll(preorderTraversal(root.right));
        }
        return result;
    }
}

public class preOrderTraversal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Taking input for binary tree
        System.out.print("Enter the value of the root node: ");
        int rootValue = scanner.nextInt();
        TreeNode root = new TreeNode(rootValue);
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            
            System.out.print("Enter the value of left child of " + current.val + " (Enter -1 if null): ");
            int leftValue = scanner.nextInt();
            if (leftValue != -1) {
                current.left = new TreeNode(leftValue);
                queue.offer(current.left);
            }
            
            System.out.print("Enter the value of right child of " + current.val + " (Enter -1 if null): ");
            int rightValue = scanner.nextInt();
            if (rightValue != -1) {
                current.right = new TreeNode(rightValue);
                queue.offer(current.right);
            }
        }
        
        // Perform preorder traversal
        Solution solution = new Solution();
        List<Integer> preorder = solution.preorderTraversal(root);
        
        // Print the preorder traversal result
        System.out.println("Preorder traversal: " + preorder);
        
        scanner.close();
    }
}
