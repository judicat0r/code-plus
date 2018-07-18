import java.util.*;
public class Main {
    static int dx[] = {-1, 0, 0, 1};
    static int dy[] = {0, 1, -1, 0};
    static int[][] dp, a;
    static int m, n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt(); n = sc.nextInt();
        a = new int[m+1][n+1];
        dp = new int[m+1][n+1];

        for(int i = 1; i <= m; i++) {
            Arrays.fill(dp[i], -1);
            for(int j = 1; j <= n; j++)
                a[i][j] = sc.nextInt();
        }
        System.out.println(go(1, 1));
    }

    static int go(int x, int y) {
        if(x == m && y == n) {
            return 1;
        }
        if(dp[x][y] != -1)
            return dp[x][y];

        dp[x][y] = 0;
        for(int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if(nx > 0 && nx <= m && ny > 0 && ny <= n) {
                if(a[x][y] > a[nx][ny])
                    dp[x][y] += go(nx, ny);
            }
        }
        return dp[x][y];
    }
}
