import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ChainReaction {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[] b = new int[1000005];
		int[] dp = new int[1000005];
		for(int i = 0; i < n; i++){
			st = new StringTokenizer(in.readLine());
			int m = Integer.parseInt(st.nextToken());
			b[m] = Integer.parseInt(st.nextToken());
		}
		if(b[0] > 0){
			dp[0] = 1;
		}
		int max = 0;
		for(int i = 1; i < 1000005; i++){
			if(b[i] == 0){
				dp[i] = dp[i - 1];
			}
			else{
				if(b[i] >= i){
					dp[i] = 1;
				}
				else{
					dp[i] = dp[i - b[i] - 1] + 1;
				}
			}
			if(dp[i] > max){
				max = dp[i];
			}
		}
		System.out.println(n - max);
	}
}
