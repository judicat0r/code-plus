import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int DP[], T[];
		
		int N = sc.nextInt();
		DP = new int[N + 1];
		T = new int[N + 1];
		
		for(int i=1; i <= N; i++)
			T[i] = sc.nextInt();
		
		sc.close();
		
		DP[1] = T[1];
		int max = DP[1];
		
		for(int i=2; i <= N; i++) {
			DP[i] = Math.max(DP[i-1] + T[i], T[i]);
			
			if(DP[i] > max)
				max = DP[i];
		}
		
		System.out.println(max);	
	}
}
