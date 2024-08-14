import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ExponentiationII {
    public static long pow(long a, long b, long mod){
        long ans = 1;
        a = a % mod;
        while (b > 0) {
            if (b % 2 == 1) {
                ans = (ans * a) % mod;
            }
            a = (a * a) % mod;
            b /= 2;
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(in.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            long exp = pow(b, c,1000000006);
            System.out.println(pow(a, exp, 1000000007));
        }
    }
}
