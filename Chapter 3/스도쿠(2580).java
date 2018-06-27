import java.io.*;
import java.util.*;

public class Main {
    static int[][] sdoku = new int[9][9];
    static boolean check_row[][] = new boolean[9][10];
    static boolean check_col[][] = new boolean[9][10];
    static boolean check_squ[][] = new boolean[9][10];

    static void go(int n) {
        if(n == 81) {
            for(int i = 0; i < 9; i++) {
                for(int j = 0; j < 9; j++) {
                    System.out.print(sdoku[i][j] + " ");
                }
                System.out.println();
            }
            System.exit(0);
        }
        int x = n/9; int y = n%9;
        if(sdoku[x][y] != 0)
            go(n + 1);
        else {
            for(int i = 1; i <= 9; i++) {
                if(!check_row[x][i] && !check_col[y][i] && !check_squ[square(x, y)][i]) {
                    check_row[x][i] = true;
                    check_col[y][i] = true;
                    check_squ[square(x, y)][i] = true;
                    sdoku[x][y] = i;
                    go(n + 1);
                    sdoku[x][y] = 0;
                    check_row[x][i] = false;
                    check_col[y][i] = false;
                    check_squ[square(x, y)][i] = false;
                }
            }
        }
    }

    static int square(int i, int j) {
        return (i/3)*3+(j/3);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                sdoku[i][j] = scanner.nextInt();
                if(sdoku[i][j] != 0) {
                    check_row[i][sdoku[i][j]] = true;
                    check_col[j][sdoku[i][j]] = true;
                    check_squ[square(i, j)][sdoku[i][j]] = true;
                }
            }
        }
        scanner.close();
        go(0);        
    }
}
