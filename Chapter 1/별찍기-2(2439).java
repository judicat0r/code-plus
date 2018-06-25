import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int num = scanner.nextInt();
		
		for(int i = num; i > 0; i--) {
			for(int j = 1; j <= num; j++) {
				if ( j < i)
					System.out.print(" ");
				else
					System.out.print("*");
			}
			System.out.println();
		}
		
		scanner.close();
	}

}
