import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long answer = 0;
        long dp[][] = new long[n+2][2];
        
        dp[1][0] = 0; dp[1][1] = 1;
        dp[2][0] = 1; dp[2][1] = 0;
        
        for(int i = 3; i <= n; i++) {
            for(int j = 0; j < 2; j++) {
                    dp[i][j] = dp[i-1][0] + (j==0?dp[i-1][1]:0);
            }
        }
        
        for(int i = 0; i < 2; i++)
            answer += dp[n][i];
        
        System.out.println(answer);
    }
}
