import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;

        while(true) {
            sb = new StringBuilder(br.readLine());
            String[] numbers = sb.toString().split(" ");
            if(Integer.parseInt(numbers[0]) == 0)
                break;

            int n = Integer.parseInt(numbers[0]);
            int arr[] = new int[n];
            int d[] = new int[n];

            for(int i = 0; i < n; i++) 
                arr[i] = Integer.parseInt(numbers[i + 1]);

            for(int i = 0; i < n; i++) {
                if(i < n - 6)
                    d[i] = 0;
                else
                    d[i] = 1;
            }
            List<List<Integer>> ans = new ArrayList<>();

            do {
                List<Integer> current = new ArrayList<>();
                for(int i = 0; i < n; i++) {
                    if(d[i] == 1)
                        current.add(arr[i]);
                }
                ans.add(current);                                
            } while (next_permutation(d));
            Collections.sort(ans, new Comparator<List<Integer>>() {
                @Override
                public int compare(List<Integer> o1, List<Integer> o2) {
                    for(int i = 0; i < Math.min(o1.size(), o2.size()); i++) {
                        int c = o1.get(i).compareTo(o2.get(i));
                        if(c != 0)
                            return c;
                    }
                    return Integer.compare(o1.size(), o2.size());
                }
            });
            for(List<Integer> current : ans) {
                for(int i = 0; i < current.size(); i++)
                    System.out.print(current.get(i) + " ");
                System.out.println();
            }
            System.out.println();
        }
    }

    static boolean next_permutation(int[] arr) {
        
        int i = arr.length - 1;

        while(i > 0 && arr[i] <= arr[i-1])
            i--;

        if(i <= 0)
            return false;

        int j = arr.length - 1;
        
        while(arr[j] <= arr[i-1])
            j--;
        
        int temp = arr[j];
        arr[j] = arr[i-1];
        arr[i-1] = temp;

        j = arr.length - 1;

        while(i < j) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++; j--;
        }
        return true;
    }
}
