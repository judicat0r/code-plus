import java.io.*;
import java.util.*;

public class Main {
    
    static List<String> list = new ArrayList<>();
        
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int l = scanner.nextInt();
        int c = scanner.nextInt();

        char[] ch = new char[c];
        
        for(int i = 0; i < c; i++) {
            ch[i] = scanner.next().charAt(0);
        }
        scanner.close();
        Arrays.sort(ch);

        go(l, ch, "", 0);

        Collections.sort(list);

        for(String s : list) {
            System.out.println(s);
        }
    }

    static void go(int n, char[] ch, String password, int index) {
        if(n == password.length()) {
            if(check(password)) {
                list.add(password);
            }
            return;
        }
        if(index >= ch.length)
            return;
        else {
            go(n, ch, password + ch[index], index+1);
            go(n, ch, password, index+1);
        }
    }

    static boolean check(String password) {
        int mo = 0, ja = 0;
        char[] chars = password.toCharArray();

        for(int i = 0; i < chars.length; i++) {
            if(chars[i] == 'a' || chars[i] == 'e' || chars[i] == 'o' 
            || chars[i] == 'u' || chars[i] == 'i') {
                mo++;
            }
            else
                ja++;
        }

        if(mo >= 1 && ja >= 2)
            return true;
        else
            return false;
    }
}
