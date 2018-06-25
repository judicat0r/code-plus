import java.io.*;
import java.util.*;

public class Main {

	static boolean broken[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
	
		broken = new boolean[10];
		if(B != 0) {
			StringTokenizer tokens = new StringTokenizer(br.readLine());
			while(B-- > 0) {
				int number = Integer.parseInt(tokens.nextToken());
				broken[number] = true;
			}
		}
		
		int answer = N - 100;
		if(answer < 0) {
			answer = -answer;
		}
		for(int i = 0; i <= 1000000; i++) {
			int c = i;
			int len = possible(c);
			
			if(len > 0) {
				int press = c - N;
				if(press < 0) {
					press = -press;
				}
				if(answer > len + press) {
					answer = len + press;
				}
			}
		}
		bw.write(String.valueOf(answer));
		bw.flush();
	}
	
	static int possible(int c) {
		
		if(c == 0) {
			if(broken[0]) {
				return 0;
			} else {
				return 1;
			}
		}
		int len = 0;
		while(c > 0) {
			if(broken[c % 10]) return 0;
			
			c /= 10;
			len += 1;
			
		}
		return len;
	}

}
