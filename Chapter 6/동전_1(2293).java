import java.util.*;
public class Main {
    static int p[];
    static boolean c[][];
    static int dp[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int a[] = new int[n+1];
        int dp[] = new int[k+1];
        for(int i = 1; i <= n; i++)
            a[i] = sc.nextInt();
        Arrays.sort(a);
        dp[0] = 1;
        for(int i = 1; i <= n; i++) {
            for(int j = a[i]; j <= k; j++) {
                dp[j] += dp[j-a[i]];
            }
        }
        System.out.println(dp[k]);
    }
}
