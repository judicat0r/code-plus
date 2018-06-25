import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        int i = 0;

        StringTokenizer input = new StringTokenizer(br.readLine());

        while(input.hasMoreTokens()) {
            arr[i++] = Integer.parseInt(input.nextToken());
        }
        if(next_permutation(N)) {
            for(int j = 0; j < N; j++) {
                bw.write(arr[j] + " ");
            }
        } else {
            bw.write("-1\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static boolean next_permutation(int n) {
        
        int i = n - 1;
        while(i > 0 && arr[i - 1] >= arr[i]) i -= 1;
        if(i == 0) return false;
        int j = n - 1;
        while(arr[j] <= arr[i - 1]) j -= 1;
        swap(j, i - 1);
        j = n - 1;
        while(i < j) {
            swap(i, j);
            i += 1; j -= 1;
        }
        return true;
    }

    static void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
