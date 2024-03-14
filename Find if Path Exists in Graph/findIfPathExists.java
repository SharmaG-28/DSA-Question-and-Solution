import java.util.Scanner;

class findIfPathExists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of nodes
        System.out.println("Enter the number of nodes:");
        int n = scanner.nextInt();

        // Input number of edges
        System.out.println("Enter the number of edges:");
        int m = scanner.nextInt();

        // Input edges
        System.out.println("Enter the edges:");
        int[][] edges = new int[m][2];
        for (int i = 0; i < m; i++) {
            edges[i][0] = scanner.nextInt();
            edges[i][1] = scanner.nextInt();
        }

        // Input source and destination nodes
        System.out.println("Enter the source node:");
        int source = scanner.nextInt();
        System.out.println("Enter the destination node:");
        int destination = scanner.nextInt();

        // Create Solution object
        findIfPathExists solution = new findIfPathExists();

        // Call validPath method and print result
        boolean result = solution.validPath(n, edges, source, destination);
        System.out.println("Is there a valid path from source to destination? " + result);
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        int[] nodeRoots = new int[n];
        for (int i = 0; i < nodeRoots.length; i++) {
            nodeRoots[i] = i;
        }
        for (int[] edge : edges) {
            int root1 = findRoot(edge[0], nodeRoots);
            int root2 = findRoot(edge[1], nodeRoots);
            nodeRoots[root1] = root2;
        }

        return findRoot(source, nodeRoots) == findRoot(destination, nodeRoots);
    }

    private int findRoot(int node, int[] nodeRoots) {
        if (node == nodeRoots[node]) {
            return node;
        }
        int root = findRoot(nodeRoots[node], nodeRoots);
        nodeRoots[node] = root;
        return root;
    }
}
