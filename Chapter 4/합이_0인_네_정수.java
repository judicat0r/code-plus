import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        int b[] = new int[n];
        int c[] = new int[n];
        int d[] = new int[n];

        for(int i=0; i<n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
            c[i] = sc.nextInt();
            d[i] = sc.nextInt();
        }

        int first[] = new int[n*n];
        int second[] = new int[n*n];
        int k=0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                first[k] = a[i]+b[j];
                second[k] = c[i]+d[j];
                k++;
            }
        }
        Arrays.sort(first);
        Arrays.sort(second);
        
        long zero = 0;
        int min = 0, max = n*n-1;
        long count1, count2;
        int temp1, temp2;
        
        while(min < n*n && max >= 0) {
            if(first[min] + second[max] < 0) min++;
            else if(first[min] + second[max] == 0) {
                count1 = 0;
                count2 = 0;
                temp1 = first[min];
                temp2 = second[max];
                for(; min < n*n; min++) {
                    if(first[min] == temp1) count1++;
                    else break;
                }
                for(; max >= 0; max--) {
                    if(second[max] == temp2) count2++;
                    else break;
                }
                zero += count1*count2;
            } else
                max--;
        }
        System.out.println(zero);
    }
}
