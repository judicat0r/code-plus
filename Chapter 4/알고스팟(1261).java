import java.io.*;
import java.util.*;

public class Main {
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};
    static String[] miro;
    static int dist[][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();
        
        miro = new String[n];
        dist = new int[n][m];

        for(int i = 0; i < n; i++)
            miro[i] = sc.nextLine();

        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                dist[i][j] = -1;
        
        Pair start = new Pair(0, 0);
        Deque<Pair> deq = new ArrayDeque<>();
        dist[0][0] = 0;
        deq.add(start);

        while(!deq.isEmpty()) {
            Pair now = deq.poll();
            for(int k = 0; k < 4; k++) {
                int nx = now.x + dx[k];
                int ny = now.y + dy[k];

                if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if(dist[nx][ny] == -1) {
                        if(miro[nx].charAt(ny) == '0') {
                            dist[nx][ny] = dist[now.x][now.y];
                            deq.addFirst(new Pair(nx, ny));
                        }
                        else {
                            dist[nx][ny] = dist[now.x][now.y] + 1;
                            deq.addLast(new Pair(nx, ny));
                        }
                    }
                }
            }
        }
        System.out.println(dist[n-1][m-1]);
    }
}

class Pair {
    int x, y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
