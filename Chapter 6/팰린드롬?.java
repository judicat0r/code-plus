import java.util.*;
public class Main {
    static int p[];
    static int dp[][];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m;
        n = sc.nextInt();
        p = new int[n+1];
        dp = new int[n+1][n+1];
        for(int i = 0; i <= n; i++)
            Arrays.fill(dp[i], -1);
        for(int i = 1; i <= n; i++)
            p[i] = sc.nextInt();
        m = sc.nextInt();
        while(m-- > 0) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            System.out.println(palindrome(s, e));
        }

    }

    static int palindrome(int s, int e) {
        if(s == e) return 1;
        else if(s + 1 == e) {
            if(p[s] == p[e])
                return 1;
            else
                return 0;
        }
        if(dp[s][e] >= 0) return dp[s][e];
        if(p[s] != p[e]) return dp[s][e] = 0;
        else return dp[s][e] = palindrome(s+1, e-1);
    }
}
