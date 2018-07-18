import java.util.*;
public class Main {
	static int n;
	static int d[][] = new int[50][250001];
	static int a[] = new int[50];
	
	static {
		for(int i = 0; i < 50; i++)
			Arrays.fill(d[i], -1);
	}
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        for(int i = 0; i < n; i++)
        	a[i] = scan.nextInt();
        int ans = go(0, 0);
        if(ans == 0) 
        	System.out.println(-1);
        else
        	System.out.println(ans);
        scan.close();
    }
    
    static int go(int k, int diff) {
    	if(diff > 250000)
    		return Integer.MIN_VALUE;
    	if(k == n) {
    		if(diff == 0)
    			return 0;
    		else
    			return Integer.MIN_VALUE;
    	}
    	int ans = d[k][diff];
    	if(ans != -1)
    		return d[k][diff];
    	
    	ans = go(k+1, diff);
    	ans = Math.max(ans, go(k+1, diff+a[k]));
    	if(a[k] > diff) 
    		ans = Math.max(ans, go(k+1, a[k]-diff) + diff);
    	else
    		ans = Math.max(ans, go(k+1, diff-a[k]) + a[k]);
    		
    	d[k][diff] = ans;
    	return ans;
    }
}
