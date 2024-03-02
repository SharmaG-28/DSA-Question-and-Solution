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

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> levelValues = new ArrayList<>();
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                
                if (leftToRight) {
                    levelValues.add(node.val);
                } else {
                    levelValues.add(0, node.val);
                }
                
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            
            result.add(levelValues);
            leftToRight = !leftToRight;
        }
        
        return result;
    }
}

public class zigZagLevelOrderTraversal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input binary tree as array
        System.out.println("Enter the values of the binary tree (enter null for missing nodes):");
        List<Integer> treeValues = new ArrayList<>();
        String[] inputValues = scanner.nextLine().split(" ");
        for (String value : inputValues) {
            if (value.equals("null")) {
                treeValues.add(null);
            } else {
                treeValues.add(Integer.parseInt(value));
            }
        }

        // Build binary tree from input values
        TreeNode root = buildTree(treeValues);

        // Call zigzagLevelOrder method
        Solution solution = new Solution();
        List<List<Integer>> zigzagOrder = solution.zigzagLevelOrder(root);

        // Output the zigzag level order traversal
        System.out.println("Zigzag level order traversal:");
        for (List<Integer> level : zigzagOrder) {
            System.out.println(level);
        }
    }

    // Helper method to build binary tree from array representation
    private static TreeNode buildTree(List<Integer> values) {
        if (values.isEmpty()) return null;

        TreeNode[] nodes = new TreeNode[values.size()];
        for (int i = 0; i < values.size(); i++) {
            if (values.get(i) != null) {
                nodes[i] = new TreeNode(values.get(i));
            }
        }

        TreeNode root = nodes[0];
        for (int i = 0; i < values.size(); i++) {
            if (nodes[i] != null) {
                int leftIndex = 2 * i + 1;
                int rightIndex = 2 * i + 2;
                if (leftIndex < values.size()) {
                    nodes[i].left = nodes[leftIndex];
                }
                if (rightIndex < values.size()) {
                    nodes[i].right = nodes[rightIndex];
                }
            }
        }

        return root;
    }
}
