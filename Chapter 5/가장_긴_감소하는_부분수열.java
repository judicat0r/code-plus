import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n+1];
        int dp[] = new int[n+1];
        
        for(int i = 1; i <= n; i++)
            a[i] = sc.nextInt();
        
        for(int i = 1; i <= n; i++) {
            dp[i] = 1;
            for(int j = 1; j <= i; j++) {
                if(a[i] < a[j] && dp[i] < dp[j] + 1)
                    dp[i] = dp[j] + 1;
            }
        }
        int max = 0;
        for(int i = 1; i <= n; i++) {
            max = Math.max(dp[i], max);
        }
        System.out.println(max);
    }
}
