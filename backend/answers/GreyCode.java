import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.StringTokenizer;

public class GreyCode {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        ArrayList<String> strs = new ArrayList<>();
        strs.add("0");
        strs.add("1");
        for(int i = 2; i < (1 << n); i = i << 1){
            for(int j = i - 1; j >= 0; j--){
                strs.add(strs.get(j));
            }
            for(int j = 0; j < i; j++){
                strs.set(j, "0" + strs.get(j));
            }
            for(int j = i; j < i * 2; j++){
                strs.set(j, "1" + strs.get(j));
            }
        }
        for (String str : strs) {
            System.out.println(str);
        }
    }
}
