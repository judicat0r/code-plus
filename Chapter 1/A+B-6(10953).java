import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		scan.nextLine();
		
		while(T-- > 0) {
			StringTokenizer tokens = new StringTokenizer(scan.nextLine(), ",");
			int out = Integer.parseInt(tokens.nextToken()) + Integer.parseInt(tokens.nextToken());
			System.out.println(out);
		}
		
		scan.close();
	}

}
