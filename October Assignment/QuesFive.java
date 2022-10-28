package test;

import java.util.HashMap;
import java.util.Scanner;

public class QuesFive {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter length of Array");
		int len = sc.nextInt();
		System.out.println("Enter K value:");
		int k=sc.nextInt();
		HashMap<Integer,Integer> map = new HashMap<>();
		int[] arr=new int[len]; 
		
		for(int i=0;i<len;i++) {
			arr[i]=sc.nextInt();
		}
		
		
		for(int i=0;i<len;i++) {
			if(map.containsKey(arr[i]) ) {
				//System.out.println(arr[i]);
				if(k == map.get(arr[i])+1) {
					System.out.println(arr[i]);
					break;
				}
			}
			map.putIfAbsent(arr[i],1);
		}
		
		
	}

}
