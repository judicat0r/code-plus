import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int a[][] = new int[n][2];
        for(int i = 0; i < n; i++) {
            a[i][0] = scan.nextInt();
            a[i][1] = scan.nextInt();
        }
        int dp[][] = new int[n][n];
        System.out.println(go(0, n-1, a, dp));
    }

    static int go(int i, int j, int[][] a, int[][] dp) {
        if(dp[i][j] > 0)
            return dp[i][j];
        if(i == j)
            return 0;
        if(i + 1 == j) {
            return a[i][0]*a[i][1]*a[j][1];
        }
        dp[i][j] = -1;
        for(int k = i; k < j; k++) {
            int t1 = go(i, k, a, dp);
            int t2 = go(k+1, j, a, dp);
            int t3 = a[i][0]*a[k][1]*a[j][1];
            if(dp[i][j] == -1 || dp[i][j] > t1+t2+t3)
                dp[i][j] = t1+t2+t3;
        }
        return dp[i][j];
    }
}
