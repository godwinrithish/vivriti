//online link: https://onlinegdb.com/d_xYYBZ6F 

import java.util.*;
public class Main
{
	public static void main(String[] args) {
	    Scanner s = new Scanner(System.in);
	    System.out.println("enter the size of list");
	    int size = s.nextInt();
        int[] arr = new int[size];
        int sum = 0;
        System.out.println("enter the values");
		for(int i=0; i<size; i++){
            arr[i] = s.nextInt();
            sum+=arr[i];
		}
         System.out.println("Average = " + sum/size);
		
		
		
	}
}
