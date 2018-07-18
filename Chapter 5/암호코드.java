import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s; int n, mod = 1_000_000;
        s = sc.nextLine().trim();
        n = s.length();
        s = " " + s;
        long dp[] = new long[n+1];
        
        dp[0] = 1;
        for(int i = 1; i <= n; i++) {
            int x = s.charAt(i) - '0';
            if(x >= 1 && x <= 9) {
                dp[i] = (dp[i-1] + dp[i]) % mod;
            }
            if(i == 1) continue;
            if(s.charAt(i-1) == '0') continue;
            x = (s.charAt(i-1)-'0')*10 + (s.charAt(i)-'0');
            if(x >= 10 && x <= 26) {
                dp[i] = (dp[i-2] + dp[i]) % mod;
            }
        }
        System.out.println(dp[n]%mod);
    }
}
