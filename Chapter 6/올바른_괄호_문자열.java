import java.util.*;
import java.io.*;
public class Main {

    static long d[][];
    static char[] open = {'(','[','{'};
    static char[] close = {')',']','}'};
    static char[] input;
    static int n;
    static boolean check[][];
    static boolean over = false;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        input = s.toCharArray();
        d = new long[n+1][n+1];
        check = new boolean[n+1][n+1];

        long ans = go(0, n-1);
        if(ans >= 100000) {
            System.out.println(String.format("%05d\n", ans%100000));
        } else {
            System.out.println(ans);
        }
    }

    static long go(int i, int j) {

        if(i > j) {
            return 1;
        }
        if((j-i)%2==0) return 0;

        if(check[i][j]) {
            return d[i][j];
        }

        long ans = 0;
        for(int k = i+1; k <= j; k+=2) {
            for(int l = 0; l < 3; l++) {
                if(input[i] == open[l] || input[i] == '?') {
                    if(input[k] == close[l] || input[k] == '?') {
                        long temp= go(i+1, k-1)*go(k+1,j);
                        if(temp >= 100000) {
                            temp %= 100000;
                        }
                        ans += temp;
                    }
                }
            }
        }
        check[i][j] = true;
        d[i][j] = ans;
        return d[i][j];
    }
}
