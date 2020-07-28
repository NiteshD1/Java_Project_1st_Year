package enormous;

import java.sql.Array;
import java.util.Scanner;

public class Enormous {

	public static void main(String[] args) {
	 Scanner s=new Scanner(System.in);
	 int n=s.nextInt();
	 int k=s.nextInt();
	 int arr[]=new int[n];
	 int counter=0;
	 for(int i=0;i<n;i++) {
		 arr[i]=s.nextInt();
		 if(arr[i]%k==0) {
			 counter++;
		 } 
	 }
       System.out.println(counter);
       counter=0;
	}

}


