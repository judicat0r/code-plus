import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int dx[] = new int[]{0, 0, 1, -1};
        int dy[] = new int[]{1, -1, 0, 0};
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();

        int start = 0;
        for(int i = 8; i >= 0; i--) {
            int number = scanner.nextInt();
            if(number == 0) number = 9;
            start += number * Math.pow(10, i);
        }
        scanner.close();

        queue.add(start);
        map.put(start, 0);
        while(!queue.isEmpty()) {
            int now_num = queue.poll();
            String now = Integer.toString(now_num);
            int z = now.indexOf("9");
            int x = z/3;
            int y = z%3;
            
            for(int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if(nx >= 0 && nx < 3 && ny >= 0 && ny < 3) {
                    char[] next = now.toCharArray();
                    char temp = next[x*3+y];
                    next[x*3+y] = next[nx*3+ny];
                    next[nx*3+ny] = temp;
                    int num = Integer.parseInt(new String(next));

                    if(!map.containsKey(num)) {
                        map.put(num, map.get(now_num) + 1);
                        queue.add(num);
                    }
                }
            }
        }
        if(map.containsKey(123456789))
            System.out.println(map.get(123456789));
        else
            System.out.println("-1");
    }
}
