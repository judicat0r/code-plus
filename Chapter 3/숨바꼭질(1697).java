import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int max = 100000;
        boolean check[] = new boolean[max + 1];
        int dist[] = new int[max + 1];

        Queue<Integer> queue = new LinkedList<>();
        check[n] = true;
        dist[n] = 0;
        queue.add(n);

        while(!queue.isEmpty()) {
            int x = queue.poll();

            if(x-1 >= 0) {
                if(check[x-1] == false) {
                    queue.add(x-1);
                    check[x-1] = true;
                    dist[x-1] = dist[x] + 1;
                }
            }

            if(x + 1 <= max) {
                if(check[x+1] == false) {
                    queue.add(x+1);
                    check[x+1] = true;
                    dist[x+1] = dist[x] + 1;
                }
            }

            if(2*x <= max) {
                if(check[2*x] == false) {
                    queue.add(2*x);
                    check[2*x] = true;
                    dist[2*x] = dist[x] + 1;
                }
            }
        }
        System.out.println(dist[k]);
        scanner.close();
    }

}
