package test;

import java.util.ArrayList;

public class Oct31One {

	
	public static void main(String []args) {
		int[] num = {1,2,3,4};
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i=0;i<num.length;i++) {
			int sum=1;
			for(int j=0;j<num.length;j++) {
				if(i!=j)
					sum*=num[j];
			}
			list.add(sum);
		}
		System.out.println(list);
	}
}
