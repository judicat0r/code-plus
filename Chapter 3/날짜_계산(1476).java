import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		int E = Integer.parseInt(tokens.nextToken());
		int S = Integer.parseInt(tokens.nextToken());
		int M = Integer.parseInt(tokens.nextToken());
		
		int e, s, m;
		e = s = m = 1;
		int n = 1;
		
		while(true) {
						
			if(E == e && S == s && M == m) {
				System.out.println(n);
				break;
			}
			e += 1;
			s += 1;
			m += 1;
			n += 1;
			
			if(e == 16)
				e = 1;
			
			if(s == 29)
				s = 1;
			
			if(m == 20)
				m = 1;			
		}
	}

}
