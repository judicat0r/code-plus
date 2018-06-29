import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	private static long dp[][];
	
	public static void main(String[] args) throws IOException, NumberFormatException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine().trim());
		
		dp = new long[n + 1][10];
		
		for(int i = 1; i < 10; i++)
			dp[1][i] = 1;
		
		for(int i = 2; i <= n; i++) {
			dp[i][0] = dp[i-1][1]%1000000000;
			dp[i][1] = (dp[i-1][0] + dp[i-1][2])%1000000000;
			dp[i][2] = (dp[i-1][1] + dp[i-1][3])%1000000000;
			dp[i][3] = (dp[i-1][2] + dp[i-1][4])%1000000000;
			dp[i][4] = (dp[i-1][3] + dp[i-1][5])%1000000000;
			dp[i][5] = (dp[i-1][4] + dp[i-1][6])%1000000000;
			dp[i][6] = (dp[i-1][5] + dp[i-1][7])%1000000000;
			dp[i][7] = (dp[i-1][6] + dp[i-1][8])%1000000000;
			dp[i][8] = (dp[i-1][7] + dp[i-1][9])%1000000000;
			dp[i][9] = dp[i-1][8]%1000000000;
		}
		
		System.out.println(sumOfArray(dp[n])%1000000000);
	}
	
	public static long sumOfArray(long array[]) {
		
		long result = 0;
		
		for(int i=0; i < 10; i++)
			result += array[i] % 1000000000;
		
		return result;
	}

}
