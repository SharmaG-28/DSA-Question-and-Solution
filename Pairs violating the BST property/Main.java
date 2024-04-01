//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    public static Node buildTree(String str) {
        // Corner Case
        if (str.length() == 0 || str.charAt(0) == 'N') return null;

        // Creating array of Strings from input
        // String after spliting by space
        String ip[] = str.split(" ");

        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));

        // Push the root to the queue
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        // Starting from the second element
        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    public static Node inputTree(BufferedReader br) throws IOException {
        return buildTree(br.readLine().trim());
    }

    public static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            Node root = Node.inputTree(br);

            Solution obj = new Solution();
            int res = obj.pairsViolatingBST(n, root);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int pairsViolatingBST(int n, Node root) {
        List<Integer> arr = new ArrayList<>();
        inorder(root, arr);
        int[] arrArray = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            arrArray[i] = arr.get(i);
        }
        return (int) inversionCount(arrArray, n);
    }

    private static long merge(int[] arr, long low, long mid, long high) {
        long[] temp = new long[(int) (high - low + 1)];
        long k = 0;
        long i = low;
        long j = mid + 1;
        long inv = 0;

        while (i <= mid && j <= high) {
            if (arr[(int) i] <= arr[(int) j]) {
                temp[(int) k++] = arr[(int) i++];
            } else {
                inv += mid - i + 1;
                temp[(int) k++] = arr[(int) j++];
            }
        }

        while (i <= mid) {
            temp[(int) k++] = arr[(int) i++];
        }

        while (j <= high) {
            temp[(int) k++] = arr[(int) j++];
        }

        for (int x = (int) low; x <= high; x++) {
            arr[x] = (int) temp[x - (int) low];
        }

        return inv;
    }

    private static long mergeSort(int[] arr, long low, long high) {
        if (low >= high) return 0;
        long inv = 0;
        long mid = (low + high) / 2;
        inv += mergeSort(arr, low, mid);
        inv += mergeSort(arr, mid + 1, high);
        inv += merge(arr, low, mid, high);
        return inv;
    }

    private static long inversionCount(int[] arr, long N) {
        return mergeSort(arr, 0, N - 1);
    }

    private static void inorder(Node root, List<Integer> arr) {
        if (root != null) {
            inorder(root.left, arr);
            arr.add(root.data);
            inorder(root.right, arr);
        }
    }
}
