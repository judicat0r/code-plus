import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        List<Integer> primes = new ArrayList<>();
        boolean check[] = new boolean[n+1];
        for(int i = 2; i <= n; i++) {
            if(!check[i]) {
                primes.add(i);
                for(int j = i*2; j<=n; j+=i) {
                    check[j] = true;
                }
            }
        }
        int left = 0, right = 0, sum = primes.size() == 0 ? 0 : primes.get(0);
        int answer = 0;

        while(left <= right && right < primes.size()) {
            if(sum <= n) {
                if(sum == n) {
                    answer++;
                }
                right++;
                if(right < primes.size()) {
                    sum += primes.get(right);
                }
            } else {
                sum -= primes.get(left++);
            }
        }
        System.out.println(answer);
        scanner.close();
    }
}
