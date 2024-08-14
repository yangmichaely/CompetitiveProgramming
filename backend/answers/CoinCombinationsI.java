import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CoinCombinationsI {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(in.readLine());
        int[] coins = new int[n];
        for(int i = 0; i < n; i++){
            coins[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(coins);
        int[] dp = new int[x + 1];
        dp[0] = 1;
        int mod = 1000000007;
        for(int i = 1; i < x + 1; i++){
            dp[i] = 0;
            for(int j = 0; j < n; j++){
                if(coins[j] > i){
                    break;
                }
                dp[i] += dp[i - coins[j]];
                if(dp[i] >= mod){
                    dp[i] -= mod;
                }
            }
        }
        System.out.println(dp[x]);
    }
}
