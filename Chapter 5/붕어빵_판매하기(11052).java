import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p[] = new int[n+1];
        int dp[] = new int[n+1];
        
        for(int i = 1; i <= n; i++) {
            p[i] = sc.nextInt();
        }
        
        dp[0] = 0;
        dp[1] = p[1];
        for(int i = 2; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                dp[i] = Math.max(p[j] + dp[i-j], dp[i]);
            }
        }
        System.out.println(dp[n]);      
    }
}
