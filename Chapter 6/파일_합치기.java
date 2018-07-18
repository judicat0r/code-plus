import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int dp[][] = new int[n+1][n+1];
            int file[] = new int[n+1];
            for(int i = 1; i <= n; i++) {
                file[i] = sc.nextInt();
                Arrays.fill(dp[i], -1);
            }
            System.out.println(go(file, dp, 1, n));
        }
    }
    static int go(int[] file, int[][] dp, int i, int j) {
        if(i == j)
            return 0;
        if(dp[i][j] >= 0)
            return dp[i][j];
        int ans = -1;
        int sum = 0;
        for(int k = i; k <= j; k++)
            sum += file[k];
        for(int k = i; k <= j-1; k++) {
            int temp = go(file, dp, i, k) + go(file, dp, k+1, j) + sum;
            if(ans == -1 || ans > temp)
                ans = temp;
        }
        dp[i][j] = ans;
        return ans;
    }
}
