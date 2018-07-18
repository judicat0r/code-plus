import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int[] stairs = new int[301];
		int[] dp = new int[301];
		
		for(int i=0; i < n; i++)
			stairs[i] = scan.nextInt();
		
		scan.close();
		
		dp[0] = stairs[0];
		dp[1] = Max(stairs[0] + stairs[1], stairs[1]);
		dp[2] = Max(stairs[0] + stairs[2], stairs[1] + stairs[2]);
		
		for(int i=3; i < n; i++)
			dp[i] = Max(dp[i-2] + stairs[i], dp[i-3] + stairs[i-1] + stairs[i]);
		
		System.out.println(dp[n-1]);
	}
	
	static int Max(int a, int b) {
		return a > b ? a : b;
	}
}
