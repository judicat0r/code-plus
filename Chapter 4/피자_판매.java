import java.util.*;

public class Main {
			
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int w = sc.nextInt();
		int m = sc.nextInt();
		int n = sc.nextInt();
		
		int a[] = new int[m];
		int b[] = new int[n];
		
		for(int i=0; i<m; i++)
			a[i] = sc.nextInt();
		for(int i=0; i<n; i++)
			b[i] = sc.nextInt();
		
		Map<Integer, Integer> map_a = new HashMap<>();
		Map<Integer, Integer> map_b = new HashMap<>();
		
		getMap(a, map_a, m);
		getMap(b, map_b, n);
		
		int ans = (map_a.get(w)==null?0:map_a.get(w))+(map_b.get(w)==null?0:map_b.get(w));
		for(int i=1; i<=w; i++) {
			if(map_a.get(i) != null && map_b.get(w-i) != null) {
				ans += map_a.get(i)*map_b.get(w-i);
			}
		}
		System.out.println(ans);
		
	}
	
	static void getMap(int[] a, Map<Integer, Integer> map, int size) {
		for(int i=1; i<size; i++) {
			for(int j=0; j<size; j++) {
				int sum = 0;
				for(int k=1; k<=i; k++) {
					if(j+k-1 < size) {
						sum += a[j+k-1];
					}
					else {
						sum += a[j+k-1-size];
					}
				}
				map.put(sum, (map.get(sum)==null?0:map.get(sum)) + 1);
			}			
		}
		int sum=0;
		for(int i=0; i<size; i++)
			sum += a[i];
		map.put(sum, 1);
	}
}
