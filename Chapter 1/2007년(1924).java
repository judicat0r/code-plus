import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		String[] week = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
		Scanner scan = new Scanner(System.in);
		
		int mon = scan.nextInt();
		int day = scan.nextInt();
		
		for(int i = 1; i < mon; i++) {
			if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10)
				day += 31;
			else if ( i == 2 )
				day += 28;
			else
				day += 30;
		}
		scan.close();
		System.out.println(week[day%7]);

	}

}
