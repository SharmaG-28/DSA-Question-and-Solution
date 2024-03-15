import java.util.Scanner;

class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trustCount = new int[n + 1];
        int[] trustedCount = new int[n + 1];

        for (int[] relationship : trust) {
            int a = relationship[0];
            int b = relationship[1];

            trustCount[a]--;
            trustedCount[b]++;
        }

        for (int i = 1; i <= n; i++) {
            if (trustCount[i] == 0 && trustedCount[i] == n - 1) {
                return i;
            }
        }

        return -1;
    }
}

public class findTheTownJudge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of people (n): ");
        int n = scanner.nextInt();

        System.out.print("Enter the trust relationships (space-separated): ");
        int[][] trust = new int[n][2];
        for (int i = 0; i < n; i++) {
            trust[i][0] = scanner.nextInt();
            trust[i][1] = scanner.nextInt();
        }

        Solution solution = new Solution();
        int judge = solution.findJudge(n, trust);
        System.out.println("The judge is: " + judge);
    }
}
