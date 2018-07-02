import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int d[] = new int[31];
        int s[] = new int[31];
        d[1] = 1; d[2] = 3;
        for(int i = 3; i <= n; i++)
            d[i] = d[i-1] + 2 * d[i-2];
        s[1] = 1; s[2] = 3;
        for(int i = 3; i <= n; i++) {
            if(i%2==0)
                s[i] = (d[i] + d[i/2] + 2*d[i/2-1])/2;
            else
                s[i] = (d[i] + d[i/2])/2;
        }
        System.out.println(s[n]);
    }
}
