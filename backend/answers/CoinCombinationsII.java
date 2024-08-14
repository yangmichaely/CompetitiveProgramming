import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CoinCombinationsII {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int[] coins = new int[n];
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < n; i++) {
			coins[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(coinCombinationsII(n, x, coins));
	}

	public static int coinCombinationsII(int n, int x, int[] coins) {
		int mod = 1000000007;
		int[] dp = new int[x + 1];
		dp[0] = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= x; j++) {
				if (j - coins[i] >= 0) {
					dp[j] += dp[j - coins[i]];
					dp[j] %= mod;
				}
			}
		}
		return dp[x];
	}
}
