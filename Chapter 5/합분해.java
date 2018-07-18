import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, k, mod = 1000000000;
        n = sc.nextInt(); k = sc.nextInt();
        long dp[][] = new long[k+1][n+1];
        
        dp[0][0] = 1;
        for(int x = 1; x <= k; x++) {
            for(int y = 0; y <= n; y++) {
                for(int z = 0; z <= y; z++) {
                    dp[x][y] += dp[x-1][y-z];
                    dp[x][y] %= mod;
                }
            }
        }
        System.out.println(dp[k][n]%mod);
    }
}
