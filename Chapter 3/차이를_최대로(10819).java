import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int arr[] = new int[n];

        for(int i = 0; i < n; i++)
            arr[i] = scanner.nextInt();

        scanner.close();
        Arrays.sort(arr);
        int ans = Integer.MIN_VALUE;

        do {
            ans = Math.max(ans, calculate(arr));
        } while (next_permutation(arr));
        System.out.println(ans);
        
    }

    static int calculate(int arr[]) {
        int result = 0;

        for(int i = 0; i < arr.length - 1; i++) {
            result += Math.abs(arr[i] - arr[i+1]);
        }
        return result;
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
