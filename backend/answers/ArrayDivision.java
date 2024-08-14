import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ArrayDivision {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine());
		long[] nums = new long[n];
		for(int i = 0; i < n; i++){
			nums[i] = Long.parseLong(st.nextToken());
		}
		long l = 1;
		long r = Long.MAX_VALUE;
		while(l < r){
			long m = (l + r) / 2;
			if(possible(nums, k, m)){
				r = m;
			}
			else{
				l = m + 1;
			}
		}
		System.out.println(l);
	}

	public static boolean possible(long[] nums, int k, long max){
		int cnt = 0;
		long cur = 0;
		for (long num : nums) {
			if (num > max) {
				return false;
			}
			if (cur + num > max) {
				cnt++;
				cur = 0;
			}
			cur += num;
		}
		if(cur > 0){
			cnt++;
		}
		return cnt <= k;
	}
}
