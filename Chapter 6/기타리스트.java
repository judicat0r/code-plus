import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n, s, m;
        n = scan.nextInt();
        s = scan.nextInt();
        m = scan.nextInt();
        int v[] = new int[n+1];
        for(int i = 1; i <= n; i++)
        	v[i] = scan.nextInt();
        int dp[][] = new int[n+1][m+1];
        
        dp[0][s] = 1;
        for(int i = 1; i <= n; i++) {
        	for(int j = 0; j <= m; j++) {
        		if(dp[i-1][j] == 1) {
        			if(j-v[i] >= 0) {
        				dp[i][j-v[i]] = 1;
        			}
        			if(j+v[i] <= m) {
        				dp[i][j+v[i]] = 1;
        			}
        		}
        	}
        }
        
        int ans = -1;
        for(int j = 0; j <= m; j++) {
        	ans = (dp[n][j] == 1) ? j : ans;
        }
        System.out.println(ans);
    }
}
