import java.io.*;

public class Main {

	static int arr[] = new int[11];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
        arr[0] = 0; arr[1] = 1; arr[2] = 2; arr[3] = 4;
		
		while(T-- > 0) {
			int t = Integer.parseInt(br.readLine());
            for(int j = 4; j <= t; j++)
                arr[j] = arr[j-1] + arr[j-2] + arr[j-3];
            System.out.println(arr[t]);
		}
	}
}
