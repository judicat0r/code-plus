import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int s[] = new int[101];
        int d[][] = new int[101][51];
        Arrays.fill(d[0],1, m+1, (int) -1e9);

        for(int i = 1; i <= n; i++) {
            s[i] = scanner.nextInt();
            s[i] += s[i-1];
            for(int j = 1; j <= m; j++) {
                d[i][j] = d[i-1][j];
                for(int k = i-1; k/2 >= j-1; k--) {
                    d[i][j] = Math.max(d[i][j], (j > 1 ? d[k-1][j-1] : 0) + s[i] - (k == -1 ? 0 : s[k]));
                }
            }
        }
        System.out.println(d[n][m]);
    }
}
