import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int S = 0;

        while(T-- > 0) {
            StringTokenizer tokens = new StringTokenizer(br.readLine());
            String command = tokens.nextToken();

            if(command.contains("add")) {
                int number = Integer.parseInt(tokens.nextToken());
                number--;
                S = (S | (1 << number));
            }
            else if(command.contains("remove")) {
                int number = Integer.parseInt(tokens.nextToken());
                number--;
                S = (S & ~(1 << number));
            }
            else if(command.contains("toggle")) {
                int number = Integer.parseInt(tokens.nextToken());
                number--;
                S = (S ^ (1 << number));
            }
            else if(command.contains("check")) {
                int number = Integer.parseInt(tokens.nextToken());
                number--;
                if((S & (1 << number)) != 0) {
                    bw.write("1\n");
                } else {
                    bw.write("0\n");
                }
            }
            else if(command.contains("all")) {
                S = (1 << 20) - 1;
            }
            else {
                S = 0;
            }
        }
        bw.flush();
        bw.close();
        br.close();
        
    }
}
