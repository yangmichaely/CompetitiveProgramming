import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LearnFromMath {
    public static boolean compositeChecker(int n){
        for(int i = 2; i <= (int) Math.sqrt(n); i++){
            if(n % i == 0){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        for(int i = 4; i < n; i++){
            if(compositeChecker(i)){
                if(compositeChecker(n - i)){
                    System.out.println(i + " " + (n - i));
                    return;
                }
            }
        }
    }
}
