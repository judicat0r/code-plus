import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<String> stack = new Stack<>();
				
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= N; i++) {
			StringBuilder sb = new StringBuilder();
			for(int j = 1; j <= N - i; j++)
				sb.append(' ');
			for(int k = N - i + 1; k <= N; k++)
				sb.append('*');
			if(i != N) stack.push(sb.toString());
			bw.write(sb.toString() + " \n");
		}
		while(!stack.isEmpty()) {
			bw.write(stack.pop() + " \n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
