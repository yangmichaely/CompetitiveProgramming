import java.io.*;
import java.util.StringTokenizer;

public class BurningMidnightOil {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int l = 1;
        int r = n;
        int min = Integer.MAX_VALUE;
        while (l <= r) {
            int m = (r + l) / 2;
            int x = m;
            int sum = 0;
            while(x != 0){
                sum += x;
                x /= k;
            }
            if (sum == n) {
                min = m;
                break;
            }
            if(sum > n){
                min = Math.min(min, m);
                r = m - 1;
            }
            else {
                l = m + 1;
            }
        }
        System.out.println(min);
    }
}
