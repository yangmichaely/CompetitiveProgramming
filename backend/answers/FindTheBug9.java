import java.io.*;
import java.util.*;

/**
 * This is a new one.
 * <p>
 * https://dmoj.ca/problem/rgpc17p5
 * <p>
 * I'm passing almost all the tests, but the big kahuna tests are giving me a
 * memory limit exceeded! Can you help me reduce my memory consumption?
 */
public class FindTheBug9 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer st = new StringTokenizer(br.readLine());

        final int n = Integer.parseInt(st.nextToken());
        final int m = Integer.parseInt(st.nextToken());

        final String a = br.readLine();
        final String b = br.readLine();

        // dp[i][j] = # of moves to change the first i characters of a to the
        // first j characters of b
        final int[][] dp = new int[2][m + 1];

        // Base case time!
        // Delete i characters from a to get to the empty string
//        for (int i = 0; i < 2; i++) {
//            dp[i][0] = i;
//        }

        // Delete j characters from b to get to the empty string
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= n; i++) {
            dp[1][0] = i;
            for (int j = 1; j <= m; j++) {
                // Make everything up to the last character, and add the last
                // character
                dp[1][j] = dp[1][j - 1] + 1;

                // Delete the last character given and make the needed prefix
                dp[1][j] = Math.min(dp[1][j], dp[0][j] + 1);

                // Use the n-th character as a swap
                // If the last characters are equal, we don't need to pay a
                // cost for the swap and can just use one prefix to make the
                // other.
                final int cost = a.charAt(i - 1) == b.charAt(j - 1) ? 0 : 1;
                dp[1][j] = Math.min(dp[1][j], dp[0][j - 1] + cost);
            }
            for (int h = 0; h <= m; h++) {
                dp[0][h] = dp[1][h];
            }
        }

        long ans = 0;
        for (int i = 1; i < m; i++) {
            ans += dp[1][i];
        }

        System.out.println(ans);
    }
}