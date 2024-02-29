import java.util.Scanner;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }
}

public class maxDepthOfTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the values of the binary tree nodes separated by commas (use 'null' for null nodes):");
        String[] values = scanner.nextLine().split(",");

        TreeNode root = constructTree(values, 0);

        Solution solution = new Solution();
        int maxDepth = solution.maxDepth(root);

        System.out.println("Maximum depth of the binary tree: " + maxDepth);
    }

    private static TreeNode constructTree(String[] values, int index) {
        if (index >= values.length || values[index].equals("null")) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(values[index]));
        node.left = constructTree(values, 2 * index + 1);
        node.right = constructTree(values, 2 * index + 2);

        return node;
    }
}
