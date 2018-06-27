import java.io.*;
import java.util.*;

public class Main {
    static int n, m, left = 0, right = 0;
    static int arr[];
    static int sum, answer = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        
        arr = new int[n + 1];
        for(int i = 0; i < n; i++)
            arr[i] = scanner.nextInt();
        sum = arr[0];

        while(left <= right && right < n) {
            if(sum < m) {
                right++;
                sum += arr[right];
            } else if(sum == m) {
                answer++;
                right++;
                sum += arr[right];
            } else {
                sum -= arr[left];
                left++;
                if (left > right && left < n) {
                    right = left;
                    sum = arr[left];
                }
            }
        }
        System.out.println(answer);
        scanner.close();
    }
}
