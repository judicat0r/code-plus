import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); int k = sc.nextInt();
        int a[] = new int[n+1];
        int dp[] = new int[k+1];
        Arrays.fill(dp, -1);
        for(int i = 1; i <= n; i++)
            a[i] = sc.nextInt();

        dp[0] = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = a[i]; j <= k; j++) {
                if(dp[j-a[i]] != -1) {
                    if (dp[j] == -1 || dp[j] > dp[j - a[i]] + 1)
                        dp[j] = dp[j - a[i]] + 1;
                }
            }
        }
        System.out.println(dp[k]);
    }
}
