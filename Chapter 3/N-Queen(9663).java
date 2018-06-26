import java.io.*;
import java.util.*;

public class Main {
    static boolean check_col[] = new boolean[15];
    static boolean check_dig[] = new boolean[40];
    static boolean check_dig2[] = new boolean[40];
    static int n;
    static int nqueen(int row) {
        if(row == n) {
            return 1;
        }
        else {
            int answer = 0;
            for(int col = 0; col < n; col++) {
                if(check(row, col)) {
                    check_col[col] = true;
                    check_dig[row+col] = true;
                    check_dig2[row-col+n] = true;
                    answer += nqueen(row+1);
                    check_col[col] = false;
                    check_dig[row+col] = false;
                    check_dig2[row-col+n] = false;
                }
            }
            return answer;
        }
    }

    static boolean check(int row, int col) {
        if(check_col[col])
            return false;
        if(check_dig[row+col])
            return false;
        if(check_dig2[row-col+n])
            return false;
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        scanner.close();
        System.out.println(nqueen(0));
    }
}
