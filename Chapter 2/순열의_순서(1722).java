import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		long facto[] = new long[21];
		facto[0] = 1;
		for(int i = 1; i <= 20; i++) {
			facto[i] = facto[i-1] * i;
		}
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int t = sc.nextInt();
		int arr[] = new int[n];
		boolean check[] = new boolean[n+1];
		
		if(t == 1) {
			long k = sc.nextLong();
			for(int i = 0; i < n; i++) {
				for(int j = 1; j <= n; j++) {
					if(check[j]) continue;
					if(facto[n-i-1] < k) {
						k -= facto[n-i-1];
					}
					else {
						check[j] = true;
						arr[i] = j;
						break;
					}
						
				}			
			}
			for(int i = 0; i < n; i++) {
				System.out.print(arr[i] + " ");
			}
		}
		else if(t == 2){						
			for(int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			long answer = 0;
			for(int i = 0; i < n; i++) {
				for(int j = 1; j < arr[i]; j++) {
					if(check[j] == false) {
						answer += facto[n-i-1];
					}
				}
				check[arr[i]] = true;
			}
			System.out.println(answer+1);
		}
		sc.close();
		
	}

}
