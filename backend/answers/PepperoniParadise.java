import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class PepperoniParadise {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int counter = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            String toppings = st.nextToken();
            for(int j = 0; j < n; j++){
                if(toppings.charAt(j) == 'P' || toppings.charAt(j) == 'p'){
                    counter++;
                }
            }
        }
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        out.println(counter);
        out.close();
    }
}
