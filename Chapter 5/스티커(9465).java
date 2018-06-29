import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0) {
            int n = sc.nextInt();
            int map[][] = new int[n+1][2];
            int dp[][] = new int[n+1][2];
            
            for(int i = 1; i <= n; i++) {
                map[i][0] = sc.nextInt();
            }
            for(int i = 1; i <= n; i++) {
                map[i][1] = sc.nextInt();
            }
            
            dp[0][0] = dp[0][1] = 0;
            dp[1][0] = map[1][0];
            dp[1][1] = map[1][1];
            
            for(int i = 2; i <= n; i++) {
                dp[i][0] = Math.max(dp[i-1][1], dp[i-2][1]) + map[i][0];
                dp[i][1] = Math.max(dp[i-1][0], dp[i-2][0]) + map[i][1]; 
            }
            System.out.println(Math.max(dp[n][0], dp[n][1]));
        }
    }
}
