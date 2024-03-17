import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows in the image:");
        int rows = scanner.nextInt();

        System.out.println("Enter the number of columns in the image:");
        int cols = scanner.nextInt();

        int[][] image = new int[rows][cols];

        System.out.println("Enter the elements of the image row by row:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                image[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Enter the starting row (sr):");
        int sr = scanner.nextInt();

        System.out.println("Enter the starting column (sc):");
        int sc = scanner.nextInt();

        System.out.println("Enter the new color:");
        int color = scanner.nextInt();

        Solution solution = new Solution();
        int[][] result = solution.floodFill(image, sr, sc, color);

        System.out.println("Output:");
        printMatrix(result);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image == null || image.length == 0 || image[0].length == 0) {
            return image;
        }

        int rows = image.length;
        int cols = image[0].length;
        int oldColor = image[sr][sc];

        if (oldColor != color) {
            bfs(image, sr, sc, oldColor, color);
        }

        return image;
    }

    private void bfs(int[][] image, int sr, int sc, int oldColor, int color) {
        int rows = image.length;
        int cols = image[0].length;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});
        image[sr][sc] = color;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int[] direction : directions) {
                int newRow = current[0] + direction[0];
                int newCol = current[1] + direction[1];

                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols
                        && image[newRow][newCol] == oldColor) {
                    queue.offer(new int[]{newRow, newCol});
                    image[newRow][newCol] = color;
                }
            }
        }
    }
}
