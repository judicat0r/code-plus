import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n+1];
        int dp1[] = new int[n+1];
        int dp2[] = new int[n+1];
        
        for(int i = 1; i <= n; i++)
            a[i] = sc.nextInt();
        
        for(int i = n; i >= 1; i--) {
            dp1[i] = 1;
            for(int j = i; j <= n; j++) {
                if(a[i] > a[j] && dp1[i] < dp1[j] + 1)
                    dp1[i] = dp1[j] + 1;
            }
        }
        for(int i = 1; i <= n; i++) {
            dp2[i] = 1;
            for(int j = 1; j <= i; j++) {
                if(a[i] > a[j] && dp2[i] < dp2[j] + 1)
                    dp2[i] = dp2[j] + 1;
            }
        }
        int max = dp1[1]+dp2[1]-1;
        for(int i = 2; i <= n; i++) {
            max = Math.max(dp1[i]+dp2[i]-1, max);
        }
        System.out.println(max);
    }
}
