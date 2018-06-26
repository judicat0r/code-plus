import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int c = Integer.parseInt(input[2]);

        boolean ans[] = new boolean[c+1];
        boolean checked[][] = new boolean[a+1][b+1];
        Queue<Pair> queue = new LinkedList<>();
        Pair start = new Pair(0, 0);
        
        queue.add(start);
        checked[0][0] = true;
        ans[c] = true;

        while(!queue.isEmpty()) {
            Pair now = queue.poll();
            int na = now.a;
            int nb = now.b;
            int nc = c - na - nb;

            // x -> y
            nb += na; na = 0;
            if(nb >= b) {
                na = nb - b;
                nb = b;
            }
            if(!checked[na][nb]) {
                checked[na][nb] = true;
                queue.add(new Pair(na, nb));
                if(na == 0) {
                    ans[nc] = true;
                }
            }
            // x -> z
            na = now.a; nb = now.b; nc = c - na - nb;
            nc += na; na = 0;
            if(nc >= c) {
                na = nc - c;
                nc = c;
            }
            if(!checked[na][nb]) {
                checked[na][nb] = true;
                queue.add(new Pair(na, nb));
                if(na == 0) {
                    ans[nc] = true;
                }
            }
            //y -> x
            na = now.a; nb = now.b; nc = c - na - nb;
            na += nb; nb = 0;
            if(na >= a) {
                nb += na - a;
                na = a;
            }
            if(!checked[na][nb]) {
                checked[na][nb] = true;
                queue.add(new Pair(na, nb));
                if(na == 0) {
                    ans[nc] = true;
                }
            }
            //y -> z
            na = now.a; nb = now.b; nc = c - na - nb;
            nc += nb; nb = 0;
            if(nc >= c) {
                nb += nc - c;
                nc = c;
            }
            if(!checked[na][nb]) {
                checked[na][nb] = true;
                queue.add(new Pair(na, nb));
                if(na == 0) {
                    ans[nc] = true;
                }
            }
            //z -> x
            na = now.a; nb = now.b; nc = c - na - nb;
            na += nc; nc = 0;
            if(na >= a) {
                nc += na - a;
                na = a;
            }
            if(!checked[na][nb]) {
                checked[na][nb] = true;
                queue.add(new Pair(na, nb));
                if(na == 0) {
                    ans[nc] = true;
                }
            }
            //z -> y
            na = now.a; nb = now.b; nc = c - na - nb;
            nb += nc; nc = 0;
            if(nb >= b) {
                nc += nb - b;
                nb = b;
            }
            if(!checked[na][nb]) {
                checked[na][nb] = true;
                queue.add(new Pair(na, nb));
                if(na == 0) {
                    ans[nc] = true;
                }
            }
        }
        for(int i = 0; i <= c; i++) {
            if(ans[i]) bw.write(i + " ");
        }
        bw.flush();
        bw.close();
        br.close();

    }  
}

class Pair {
    int a;
    int b;

    Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }
}
