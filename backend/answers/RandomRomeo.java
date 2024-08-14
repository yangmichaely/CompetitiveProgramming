import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.Comparator;

public class RandomRomeo {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        long n = Long.parseLong(st.nextToken());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long d = Long.parseLong(st.nextToken());
        st = new StringTokenizer(in.readLine());
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            long bruh = Long.parseLong(st.nextToken());
            if (bruh >= a - d && bruh <= b + d) {
                ans.add(i);
            }
        }
        if(!ans.isEmpty()) {
            ans.sort(Comparator.naturalOrder());
            for (int an : ans) {
                System.out.print(an + " ");
            }
        }
    }
}
