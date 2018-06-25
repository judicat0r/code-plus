import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int W[][] = new int[N][N];
        int d[] = new int[N-1];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                W[i][j] = scanner.nextInt();
            }
        }

        for(int i = 0; i < N-1; i++) {
            d[i] = i+1;
        }
        scanner.close();

        int min = Integer.MAX_VALUE;
        do {
            boolean ok = true;
            int n = 0;
            for(int i = 0; i < N-2; i++) {
                if(W[d[i]][d[i+1]] == 0) ok = false;
                else n += W[d[i]][d[i+1]];
            }
            if(ok && W[0][d[0]] != 0 && W[d[N-2]][0] != 0) {
                n += W[0][d[0]] + W[d[N-2]][0];
            min = Math.min(min, n);
            }
        } while (next_permutation(d));
        System.out.println(min);
    }

    static boolean next_permutation(int arr[]) {
        int i = arr.length - 1;
        while(i > 0 && arr[i-1] >= arr[i]) 
            i--;
        if(i <= 0) return false;

        int j = arr.length - 1;
        while(arr[j] <= arr[i-1]) 
            j--;
        
        int temp = arr[j];
        arr[j] = arr[i-1];
        arr[i-1] = temp;

        j = arr.length - 1;
        while(i < j) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++; j--;
        }
        return true;
    }
}
