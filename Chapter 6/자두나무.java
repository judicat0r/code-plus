import java.util.*;
public class Main {
	static int t,w;
	static int d[][] = new int[1005][31];
	static int a[] = new int[1001];
	
	static {
		for(int i = 0; i < 1005; i++)
			Arrays.fill(d[i], -1);
	}
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        t = scan.nextInt();
        w = scan.nextInt();
        for(int i = 1; i <= t; i++)
        	a[i] = scan.nextInt();
        int ans = Math.max(go(1, 0), go(1, 1));
        System.out.println(ans);
        scan.close();
    }
    
    static int go(int sec, int turn) {
    	if(sec == t+1 && turn <= w)
    		return 0;
    	if(turn > w) return 0;
    	int where = turn % 2 + 1;
    	if(d[sec][turn] != -1)
    		return d[sec][turn];
    	else
    		d[sec][turn] = Math.max(go(sec+1, turn), go(sec+1, turn+1)) + (a[sec] == where ? 1 : 0);
    	return d[sec][turn];
    }
}
