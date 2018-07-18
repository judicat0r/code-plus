import java.util.*;
public class Main {
    static int p[];
    static boolean c[][];
    static int dp[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = s.length();
        s = " " + s;
        c = new boolean[n+1][n+1];
        dp = new int[n+1];

        for(int i = 1; i <= n; i++) c[i][i] = true;
        for(int i = 1; i <= n-1; i++) {
            if(s.charAt(i) == s.charAt(i+1))
                c[i][i+1] = true;
        }
        for(int k = 2; k < n; k++) {
            for (int i = 1; i <= n - k; i++) {
                int j = i + k;
                if (s.charAt(i) == s.charAt(j) && c[i + 1][j - 1])
                    c[i][j] = true;
            }
        }
        for(int i = 1; i <= n; i++) {
            dp[i] = -1;
            for(int j = 1; j <= i; j++) {
                if(c[j][i]) {
                    if(dp[i] == -1 || dp[i] > dp[j-1] + 1)
                        dp[i] = dp[j-1] + 1;
                }
            }
        }
        System.out.println(dp[n]);
    }
}
