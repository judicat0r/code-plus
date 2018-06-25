import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t, n; n = scanner.nextInt();
        t = n;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n+i+1; j++) {
                if(j < n-i-1)
                    System.out.print(" ");
                else if(j >= n-1-i && j <= n-1+i)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
}
