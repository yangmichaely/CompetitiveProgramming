import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PizzaSlices {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int pizzas = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(in.readLine());
        int people = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(in.readLine());
        int slices = Integer.parseInt(st.nextToken());
        if(pizzas * 8 % people == 0 && slices * people <= pizzas * 8){
            System.out.print("TRUE");
        }
        else{
            System.out.print("FALSE");
        }
    }
}
