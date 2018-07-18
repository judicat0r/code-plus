import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m; n = sc.nextInt(); m = sc.nextInt();
        int map[][] = new int[n+1][m+1];
        int dp[][] = new int[n+1][m+1];
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                dp[i][j] = max(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + map[i][j];
            }
        }
        System.out.println(dp[n][m]);
    }
    
    static int max(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }
}
