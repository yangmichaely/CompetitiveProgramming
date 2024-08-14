import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class SubarraySumII {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        StringTokenizer s = new StringTokenizer(in.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s.nextToken());
        }

        long sum = 0;
        long ans = 0;
        Map<Long, Long> freq = new HashMap<>();
        freq.put(0L, 1L);

        for(int i = 0; i < n; i++){
            sum += arr[i];
            long targSubArr = sum - target;
            if(freq.containsKey(targSubArr)){
                ans += freq.get(targSubArr);
            }
            freq.put(sum, freq.getOrDefault(sum, 0L) + 1);
        }
        out.println(ans);
        out.close();
    }
}
