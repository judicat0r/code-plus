import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i = 1; i < N; i++) {
            for(int j = 1; j <= N - i; j++)
                System.out.print(' ');
            
            System.out.print('*');

            for(int k = N - i + 2; k <= N + i - 1; k++) {
                
                if(k == N + i - 1)
                    System.out.print("*");
                else
                    System.out.print(' ');
            }
            System.out.println(' ');                        
        }
        for(int i = 1; i <= 2*N - 1; i++)
            System.out.print('*');
    }
}
