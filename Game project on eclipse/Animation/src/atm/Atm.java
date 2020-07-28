package atm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Atm {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int x=Integer.parseInt(s[0]);
		float y=Float.parseFloat(s[1]);
		if(x%5==0 && x<y-0.50) {
			System.out.println(y-x-0.50);
		}
		else
			System.out.println(y);
			
			System.exit(0);
			
	}

}
