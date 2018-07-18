import java.util.*;

public class Main {
			
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int n = sc.nextInt();
		int a[] = new int[n];
		
		for(int i=0; i<n; i++)
			a[i] = sc.nextInt();
		
		int m = sc.nextInt();
		int b[] = new int[m];
		
		for(int i=0; i<m; i++)
			b[i] = sc.nextInt();
		
		int a_total = (n*(n+1))/2;
		int b_total = (m*(m+1))/2;
		int first[] = new int[a_total];
		int second[] = new int[b_total];
		
		int k=0;
		for(int i=0; i<n; i++) {
			for(int j=i; j<n; j++) {
				first[k++] = sum(a,i,j);
			}
		}
		k=0;
		for(int i=0; i<m; i++) {
			for(int j=i; j<m; j++) {
				second[k++] = sum(b,i,j);
			}
		}
		
		Arrays.sort(first);
		Arrays.sort(second);
		
		long ans = 0;
		int min = 0;
		int max = second.length-1;
		
		while(min < first.length && max >= 0) {
			if(first[min] + second[max] < t) min++;
			else if(first[min] + second[max] == t) {				
				long c1 = 0;
				long c2 = 0;
				long temp1 = first[min];
				long temp2 = second[max];
				for(; min < first.length; min++) {
					if(first[min]==temp1) c1++;
					else break;
				}
				for(; max >= 0; max--) {
					if(second[max]==temp2) c2++;
					else break;
				}
				ans += (c1*c2);
			}
			else {
				max--;
			}
		}
		System.out.println(ans);
	}
	
	static int sum(int[] array, int i, int j) {
		int sum=0;
		for(int x=i; x<=j; x++)
			sum += array[x];
		return sum;
	}
}
