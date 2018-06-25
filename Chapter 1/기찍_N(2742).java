import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        
        int num = scan.nextInt();
        scan.close();
        for(int i = num; i > 0; i--)
            System.out.println(i);
    }
}
