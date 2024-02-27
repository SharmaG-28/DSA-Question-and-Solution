import java.util.*;

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

public class inorderTraversal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Build the binary tree
        TreeNode root = buildTree(scanner);
        
        // Perform inorder traversal and print the result
        List<Integer> result = inorderTraversal(root);
        System.out.println("Inorder Traversal: " + result);
        
        scanner.close();
    }
    
    public static TreeNode buildTree(Scanner scanner) {
        System.out.println("Enter the root node value:");
        int val = scanner.nextInt();
        TreeNode root = new TreeNode(val);
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            
            System.out.println("Enter the left child value of " + current.val + " (Enter -1 if no left child):");
            int leftVal = scanner.nextInt();
            if (leftVal != -1) {
                current.left = new TreeNode(leftVal);
                queue.offer(current.left);
            }
            
            System.out.println("Enter the right child value of " + current.val + " (Enter -1 if no right child):");
            int rightVal = scanner.nextInt();
            if (rightVal != -1) {
                current.right = new TreeNode(rightVal);
                queue.offer(current.right);
            }
        }
        
        return root;
    }
    
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            result.addAll(inorderTraversal(root.left));
            result.add(root.val);
            result.addAll(inorderTraversal(root.right));
        }
        return result;
    }
}
