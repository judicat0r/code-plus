import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int mod = 1000000007;
        int n = scan.nextInt();
        int l = scan.nextInt();
        int r = scan.nextInt();

        long dp[][][] = new long[n + 1][l + 1][r + 1];
        dp[1][1][1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= l; j++) {
                for (int k = 1; k <= r; k++) {
                    dp[i][j][k] = dp[i - 1][j - 1][k] + dp[i - 1][j][k - 1] + dp[i - 1][j][k] * (i - 2);
                    dp[i][j][k] %= mod;
                }
            }
        }
        System.out.println(dp[n][l][r]);
    }
}
