import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        n--;     
        int a[] = new int[n+1];
        for(int i = 1; i <= n; i++) {
        	a[i] = scan.nextInt();
        }
        int goal = scan.nextInt();
        long d[][] = new long[n+1][21];
        d[1][a[1]] = 1;
        for(int i = 2; i <= n; i++) {
        	for(int j = 0; j <= 20; j++) {
        		if(j-a[i] >= 0)
        			d[i][j] += d[i-1][j-a[i]];
        		if(j+a[i] <= 20)
        			d[i][j] += d[i-1][j+a[i]];
        	}
        }
        System.out.println(d[n][goal]);      
    }
}
