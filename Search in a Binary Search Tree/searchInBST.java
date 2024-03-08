import java.util.Scanner;

// Definition for a binary tree node.
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
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }

        if (val < root.val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }
}

public class searchInBST {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input root node values
        System.out.print("Enter root value: ");
        int rootVal = scanner.nextInt();
        TreeNode root = new TreeNode(rootVal);

        System.out.print("Enter number of nodes in left subtree: ");
        int leftNodes = scanner.nextInt();
        root.left = buildTree(scanner, leftNodes);

        System.out.print("Enter number of nodes in right subtree: ");
        int rightNodes = scanner.nextInt();
        root.right = buildTree(scanner, rightNodes);

        // Input target value
        System.out.print("Enter target value to search: ");
        int target = scanner.nextInt();

        // Call searchBST method
        Solution solution = new Solution();
        TreeNode result = solution.searchBST(root, target);

        // Output result
        System.out.print("Output: ");
        printInOrder(result);

        scanner.close();
    }

    // Utility method to build binary tree
    private static TreeNode buildTree(Scanner scanner, int nodes) {
        if (nodes <= 0) {
            return null;
        }

        System.out.print("Enter node value: ");
        int val = scanner.nextInt();
        TreeNode node = new TreeNode(val);

        System.out.print("Enter number of nodes in left subtree: ");
        int leftNodes = scanner.nextInt();
        node.left = buildTree(scanner, leftNodes);

        System.out.print("Enter number of nodes in right subtree: ");
        int rightNodes = scanner.nextInt();
        node.right = buildTree(scanner, rightNodes);

        return node;
    }

    // Utility method to print binary tree in inorder traversal
    private static void printInOrder(TreeNode root) {
        if (root != null) {
            printInOrder(root.left);
            System.out.print(root.val + " ");
            printInOrder(root.right);
        }
    }
}
