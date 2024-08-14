import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ToBeOrNotToBe {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = in.readLine();
        if(str.contains("BE")){
            System.out.println("YES");
            return;
        }
        if(str.contains("Be")){
            System.out.println("YES");
            return;
        }
        if(str.contains("be")){
            System.out.println("YES");
            return;
        }
        if(str.contains("bE")){
            System.out.println("YES");
            return;
        }
        System.out.println("NO");
    }
}
