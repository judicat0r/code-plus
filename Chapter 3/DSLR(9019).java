import java.io.*;
import java.util.*;

public class Main {

    static String solve(int a, int b) {
        int n = 10000;
        Queue<Integer> queue = new LinkedList<>();
        boolean checked[] = new boolean[n];
        int from[] = new int[n];
        int dist[] = new int[n];
        char how[] = new char[n];

        checked[a] = true;
        queue.add(a);

        while(!queue.isEmpty()) {
            int now = queue.poll();
            int next = (now*2) % 10000;
            if(checked[next] == false) {
                queue.add(next);
                checked[next] = true;
                dist[next] = dist[now] + 1;
                from[next] = now;
                how[next] = 'D';
            }
            next = now - 1;
            if(next == -1) next = 9999;
            if(checked[next] == false) {
                queue.add(next);
                checked[next] = true;
                dist[next] = dist[now] + 1;
                from[next] = now;
                how[next] = 'S';
            }
            next = (now%1000)*10 + now/1000;
            if(checked[next] == false) {
                queue.add(next);
                checked[next] = true;
                dist[next] = dist[now] + 1;
                from[next] = now;
                how[next] = 'L';
            }
            next = (now/10) + (now%10)*1000;
            if(checked[next] == false) {
                queue.add(next);
                checked[next] = true;
                dist[next] = dist[now] + 1;
                from[next] = now;
                how[next] = 'R';
            }
        }
        String ans = "";
        while(b != a) {
            ans += how[b];
            b = from[b];
        }
        return new StringBuffer(ans).reverse().toString();
    }


    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        
        while(t-- > 0) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            System.out.println(solve(a, b));
        }
        scanner.close();
    }

}
