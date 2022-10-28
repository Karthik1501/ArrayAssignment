package test;

import java.util.HashMap;
import java.util.Scanner;

public class QuesFour {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter length of array :");
		int len = sc.nextInt();
		HashMap<Integer,Integer> map1=new HashMap<>();
		HashMap<Integer,Integer> map2=new HashMap<>();
		System.out.println("Enter first array elements");
		for(int index =0;index<len;index++) {
			int temp=sc.nextInt();
			map1.put(temp,map1.getOrDefault(map1.get(temp),0)+1);
		}
		System.out.println("Enter second array elements");
		for(int index =0;index<len;index++) {
			int temp=sc.nextInt();
			map2.put(temp,map2.getOrDefault(map2.get(temp),0)+1);
		}
		
		if(map1.equals(map2))
			System.out.println("Equal");
		else
			System.out.println("Not Equal");
	}

}
