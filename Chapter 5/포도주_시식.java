import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int G[] = new int[10000 + 1];
		int DP[] = new int[10000 + 1];
		
		for(int i = 1; i <= T; i++) {
			G[i] = sc.nextInt();
		}
		
		sc.close();
		DP[0] = 0;
		DP[1] = G[1];
		DP[2] = G[1] + G[2];
		
		for(int i = 3; i <= T; i++) {
			DP[i] = Max(DP[i-3] + G[i-1] + G[i], DP[i-1], G[i] + DP[i-2]);
		}
		
		System.out.println(DP[T]);
		
	}
	
	public static int Max(int a, int b, int c) {
		
		if(b > c) {
			if(a > b) return a;
			else return b;
		} else {
			if(a > c) return a;
			else return c;
		}
	}
}
