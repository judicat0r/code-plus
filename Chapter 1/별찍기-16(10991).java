import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i = 1; i <= N; i++) {
            boolean flag = true;
            for(int j = 1; j <= N - i; j++)
                System.out.print(' ');
            for(int k = N - i + 1; k <= N + i; k++) {
                if(flag) {
                    System.out.print('*');
                }
                else {
                    System.out.print(' ');
                }
                flag = !flag;
            }
            System.out.println();
        }   
    }
}
