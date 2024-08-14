import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DinnerBone {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            ArrayList<Integer> input = new ArrayList<>();
            StringTokenizer s = new StringTokenizer(in.readLine());
            int h = Integer.parseInt(s.nextToken());
            StringTokenizer str = new StringTokenizer(in.readLine());
            for(int j = 0; j < h; j++){
                input.add(Integer.parseInt(str.nextToken()));
            }

            System.out.println(Arrays.toString(max(input)));

        }
    }
    public static int calc (ArrayList<Integer> input, int lbound, int rbound){
        int coeff = Math.abs(rbound - lbound + 1) * (int) Math.pow(-1, rbound - lbound - 1);
        int sum = 0;
        for (int i = lbound; i < rbound + 1; i++) {
            sum += (int) Math.pow(input.get(i), 3);
        }
        return coeff * sum;
    }

    public static int[] max(ArrayList<Integer> a){
        int cur = Integer.MIN_VALUE, max = 0;
        int cur1 = Integer.MAX_VALUE;
        for (int i = 0; i < a.size() - 1; i++) {
            max = calc(a, 0, i);
            if (cur < max) {
                cur = max;
            }
            if (cur1 > max){
                cur1 = max;
            }
            if (max < 0){
                max = 0;
            }
        }
        return new int[]{cur1, cur};
    }
}
