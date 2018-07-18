import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long map[][] = new long[n+1][n+1];
        long dp[][] = new long[n+1][n+1];
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        
        dp[1][1] = 1;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(i == 1 && j == 1) continue;
                for(int k = 1; k < j; k++) {
                    if(map[i][k] + k == j)
                        dp[i][j] += dp[i][k];
                }
                for(int k = 1; k < i; k++) {
                    if(map[k][j] + k == i)
                        dp[i][j] += dp[k][j];
                }
            }
        }
        System.out.println(dp[n][n]);
    }   
}
