import java.util.Scanner;

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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if ((p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right))
            return true;
        else
            return false;
    }
}

public class sameTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for tree node values
        System.out.println("Enter values for tree node p:");
        TreeNode p = createTree(scanner);

        System.out.println("Enter values for tree node q:");
        TreeNode q = createTree(scanner);

        Solution solution = new Solution();
        boolean result = solution.isSameTree(p, q);
        System.out.println("Output: " + result);
    }

    private static TreeNode createTree(Scanner scanner) {
        System.out.print("Enter value (or -1 for null): ");
        int val = scanner.nextInt();
        if (val == -1) {
            return null;
        }
        TreeNode node = new TreeNode(val);
        System.out.println("Enter left for " + val + ":");
        node.left = createTree(scanner);
        System.out.println("Enter right for " + val + ":");
        node.right = createTree(scanner);
        return node;
    }
}
