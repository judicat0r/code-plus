import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static boolean prev_permutation(int arr[]) {
        
        int i = arr.length - 1;

        while(i > 0 && arr[i - 1] <= arr[i]) i--;
        if(i <= 0) return false;
        
        int j = arr.length - 1;
        while(arr[i - 1] <= arr[j]) j-= 1;
        int temp = arr[j];
        arr[j] = arr[i - 1];
        arr[i - 1] = temp;

        j = arr.length - 1;
        while(i < j) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i += 1; j -= 1;
        }
        
        return true;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int i = 0;

        StringTokenizer inputs = new StringTokenizer(br.readLine());
        
        while(inputs.hasMoreTokens()) {
            arr[i++] = Integer.parseInt(inputs.nextToken());
        }

        if(prev_permutation(arr)) {
            for(i = 0; i < N; i++)
                bw.write(arr[i] + " ");
        } else {
            bw.write("-1\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }


}
