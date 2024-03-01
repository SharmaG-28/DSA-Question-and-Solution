import java.util.*;

public class levelOrderTraversal {
    // Definition for a binary tree node.
    public static class TreeNode {
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

    public static class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();

            if (root == null) {
                return result;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                List<Integer> currentLevel = new ArrayList<>();
                int levelSize = queue.size();

                for (int i = 0; i < levelSize; i++) {
                    TreeNode node = queue.poll();
                    currentLevel.add(node.val);

                    if (node.left != null) {
                        queue.offer(node.left);
                    }

                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }

                result.add(currentLevel);
            }

            return result;
        }
    }

    // Function to deserialize a binary tree from array representation
    public static TreeNode deserialize(Integer[] arr) {
        if (arr.length == 0) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(arr[0]);
        queue.add(root);
        for (int i = 1; i < arr.length; ) {
            TreeNode node = queue.poll();
            if (arr[i] != null) {
                node.left = new TreeNode(arr[i]);
                queue.add(node.left);
            }
            i++;
            if (i < arr.length && arr[i] != null) {
                node.right = new TreeNode(arr[i]);
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }

    // Function to print the level order traversal of a binary tree
    public static void printLevelOrder(List<List<Integer>> levelOrder) {
        System.out.print("[");
        for (List<Integer> level : levelOrder) {
            System.out.print("[");
            for (int i = 0; i < level.size(); i++) {
                System.out.print(level.get(i));
                if (i < level.size() - 1) {
                    System.out.print(",");
                }
            }
            System.out.print("]");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the tree in array representation
        System.out.print("Enter the array representation of the tree: ");
        String input = scanner.nextLine();
        String[] values = input.substring(1, input.length() - 1).split(",");
        Integer[] arr = new Integer[values.length];
        for (int i = 0; i < values.length; i++) {
            arr[i] = values[i].equals("null") ? null : Integer.parseInt(values[i]);
        }
        TreeNode root = deserialize(arr);

        // Call the levelOrder function
        Solution solution = new Solution();
        List<List<Integer>> levelOrder = solution.levelOrder(root);

        // Output the result
        System.out.println("Level Order Traversal: ");
        printLevelOrder(levelOrder);

        scanner.close();
    }
}
