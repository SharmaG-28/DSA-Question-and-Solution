import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class IntMatrix {
    public static int[][] input(BufferedReader br, int n, int m) throws IOException {
        int[][] mat = new int[n][];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[m];
            for (int j = 0; j < m; j++) mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m) {
        for (int[] a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m) {
        for (ArrayList<Integer> a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int[] a = IntArray.input(br, 2);

            int[][] mat = IntMatrix.input(br, a[0], a[1]);

            Solution obj = new Solution();
            int res = obj.findShortestPath(mat);

            System.out.println(res);
        }
    }
}

class Solution {
    boolean check(int i, int j, int[][] mat){
        int rows = mat.length;
        int cols = mat[0].length;
        if(i - 1 >= 0 && mat[i - 1][j] == 0) return false;
        if(i + 1 < rows && mat[i + 1][j] == 0) return false;
        if(j - 1 >= 0 && mat[i][j - 1] == 0) return false;
        if(j + 1 < cols && mat[i][j + 1] == 0) return false;
        return true;
    }
    
    int solve(int i, int j, int[][] mat, boolean[][] vis, int[][] dp){
        int rows = mat.length;
        int cols = mat[0].length;
        if(i < 0 || j < 0 || i >= rows || j >= cols || vis[i][j] || mat[i][j] == 0) return Integer.MAX_VALUE;
        
        if(dp[i][j] != -1) return dp[i][j];
        
        if(!check(i, j, mat)) return Integer.MAX_VALUE;
        
        if(j == 0) return mat[i][0];
        
        vis[i][j] = true;
        
        int left = solve(i, j - 1, mat, vis, dp);
        int up = solve(i - 1, j, mat, vis, dp);
        int down = solve(i + 1, j, mat, vis, dp);
        
        if(left != Integer.MAX_VALUE) left += mat[i][j];
        if(up != Integer.MAX_VALUE) up += mat[i][j];
        if(down != Integer.MAX_VALUE) down += mat[i][j];
        
        vis[i][j] = false;
        
        return dp[i][j] = Math.min(left, Math.min(up, down));
    }

    int findShortestPath(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        boolean[][] vis = new boolean[n][m];
        int[][] dp = new int[n][m];
        for(int[] arr : dp) Arrays.fill(arr, -1);
        int mini = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            mini = Math.min(mini, solve(i, m - 1, mat, vis, dp));
        }
        if(mini == Integer.MAX_VALUE) return -1;
        else return mini;
    }
}
