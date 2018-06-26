import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int f,s,g,u,d;
        f = scanner.nextInt();
        s = scanner.nextInt();
        g = scanner.nextInt();
        u = scanner.nextInt();
        d = scanner.nextInt();
        scanner.close();

        if(s == g) {
            System.out.println("0");
            return;
        }
        Queue<Integer> queue = new LinkedList<>();
        boolean checked[] = new boolean[f+1];
        int dist[] = new int[f+1];

        queue.add(s);
        checked[s] = true;
        dist[s] = 0;

        while(!queue.isEmpty()) {
            int now = queue.poll();

            int next = now + u;
            if(next <= f) {
                if(!checked[next]) {
                    checked[next] = true;
                    dist[next] = dist[now] + 1;
                    queue.add(next);
                }
            }
            next = now - d;
            if(next > 0) {
                if(!checked[next]) {
                    checked[next] = true;
                    dist[next] = dist[now] + 1;
                    queue.add(next);
                }
            }
        }
        if(dist[g] != 0)
            System.out.println(dist[g]);
        else   
            System.out.println("use the stairs");

    }
}
