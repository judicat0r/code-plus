import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		List<Integer> list = new LinkedList<>();
		
		int T = scan.nextInt();
		scan.nextLine();
		
		while(T-- > 0) {
			list.add(scan.nextInt());
		}
		Collections.sort(list);
		System.out.println(list.get(0) + " " + list.get(list.size() - 1));
		
		scan.close();
	}

}
