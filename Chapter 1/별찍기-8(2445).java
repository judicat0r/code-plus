import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= i; j++)
                System.out.print('*');
            for(int k = i + 1; k <= N; k++)
                System.out.print(' ');
            
            for(int m = N + 1; m <= 2*N - i; m++)
                System.out.print(' ');
            for(int n = 2*N - i + 1; n <= 2*N; n++)
                System.out.print('*');
        System.out.println(' ');
        }

        for(int i = N - 1; i >= 1; i--) {
            for(int j = 1; j <= i; j++)
                System.out.print('*');
            for(int k = i + 1; k <= N; k++)
                System.out.print(' ');
            
            for(int m = N + 1; m <= 2*N - i; m++)
                System.out.print(' ');
            for(int n = 2*N - i + 1; n <= 2*N; n++)
                System.out.print('*');
            if(i != 1)
                System.out.println(' ');
        }
    }
}
