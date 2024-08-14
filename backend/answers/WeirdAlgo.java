import java.util.Scanner;

public class WeirdAlgo {
	public static void main(String[] args) {
		Scanner myObj = new Scanner(System.in);
		long n = myObj.nextLong();
		System.out.print(n);
		while(n != 1){
			if(n % 2 == 0){
				n /= 2;
			}
			else{
				n = 3 * n + 1;
			}
			System.out.print(" " + n);
		}
	}
}