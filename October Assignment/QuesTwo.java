package test;

import java.util.ArrayList;
import java.util.Scanner;

public class QuesTwo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> list= new ArrayList<>();
		System.out.println("Enter length of array:");
		int len = sc.nextInt();
		for(int i=0;i<len;i++) {
			list.add(sc.nextInt());
		}
		ArrayList<Integer> res = new ArrayList<>();
		
		int max=0;
		int i=1;
		
		for(int j=0;j<list.size() && i<list.size();) {
			
			if(list.get(j)<list.get(i)) {
				max=list.get(j);
			    j++;
			    i++;
			}
			else
			{
				if(max<=list.get(j))
				   res.add(list.get(j));
				j=i;
				i=i+1;
			}
		}
		res.add(list.get(list.size()-1));
		System.out.println(res);
	}

}
