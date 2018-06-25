import java.io.*;
import java.util.*;

public class Main {

    static int n = 10000;
    static boolean primelist[] = new boolean[n];
    
    static void eratos() {
        primelist[0] = false;
        primelist[1] = false;

        for(int i = 2; i < n; i++)
            primelist[i] = true;

        for(int i = 2; (i*i) < n; i++) {
            if(primelist[i]) {
                for(int j = i*i; j < n; j+=i) {
                    primelist[j] = false;
                }
            }
        }
    }

    static void solve(int a, int b) {
        Queue<Integer> queue = new LinkedList<>();
        boolean checked[] = new boolean[n];
        int d[] = new int[n];
        checked[a] = true;
        queue.add(a);

        while(!queue.isEmpty()) {
            int now = queue.poll();
            for(int i = 0; i < 4; i++) {
                for(int j = 0; j <= 9; j++) {
                    int next = change(now, i, j);
                    if(next != -1) {
                        if(primelist[next] && checked[next] == false) {
                            checked[next] = true;
                            queue.add(next);
                            d[next] = d[now] + 1;
                        }
                    }
                }
            }
        }
        System.out.println(d[b]);
    }

    static int change(int now, int index, int digit) {
        if(index == 0 && digit == 0)
            return -1;

        String temp = Integer.toString(now);
        StringBuilder sb = new StringBuilder(temp);
        sb.setCharAt(index, (char)(digit + '0'));
        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        eratos();

        while(t-- > 0) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            solve(a, b);
        }
        scanner.close();
    }

}
