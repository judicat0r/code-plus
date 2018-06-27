import java.io.*;
import java.util.*;

public class Main {
    
    static int r;
    static int c;
    static char[][] map;
    static boolean check[] = new boolean[26];
    static int dx[] = {0, -1, 1, 0};
    static int dy[] = {-1, 0, 0, 1};

    static int go(int x, int y) {
        int ans = 0;
        for(int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if(nx >= 0 && nx < r && ny >= 0 && ny < c) {
                if(!check[map[nx][ny]-'A']) {
                    check[map[nx][ny]-'A'] = true;
                    int next = go(nx, ny);
                    if(ans < next) ans = next;
                    check[map[nx][ny]-'A'] = false;
                }
            }
        }
        return ans + 1;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        r = scanner.nextInt();
        c = scanner.nextInt();
        scanner.nextLine();

        map = new char[r][c];

        for(int i = 0; i < r; i++) {
            String input = scanner.nextLine();
            for(int j = 0; j < c; j++) {
                map[i][j] = input.charAt(j);
            }
        }
        check[map[0][0]-'A'] = true;
        System.out.println(go(0, 0));
        scanner.close();               
    }
}
