import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        
        while((input = br.readLine()) != null ) {
        StringTokenizer tokens = new StringTokenizer(input);
        int m = Integer.parseInt(tokens.nextToken());
        int n = Integer.parseInt(tokens.nextToken());
        
        System.out.println(m + n);
        	
        }
    }
}
