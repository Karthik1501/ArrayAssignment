package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class QuesOne {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a string :");
		String str = sc.next();
		ArrayList<String> li = new ArrayList<>();
		
		for(int i=0;i<str.length();i++) {
			li.add(str.substring(i, i+1));
			for(int j=i+1;j<str.length();j++) {
				;
				String str1=str.substring(i, j+1);
				char[] ch1=str1.toCharArray();
				Arrays.sort(ch1);
				str1=String.valueOf(ch1);
				li.add(str1);
			}
			
		}
		
		int count = 0;
		System.out.println(li);
		
		for(int i=0;i<li.size();i++) {
			
//			String str1=li.get(i);
//			char[] ch1=str1.toCharArray();
//			Arrays.sort(ch1);
//			str1=String.valueOf(ch1);
			
			for(int j=i+1;j<li.size();j++) {
//				String str2=li.get(i);
//				char[] ch2=str1.toCharArray();
//				Arrays.sort(ch2);
//				str1=String.valueOf(ch2);
				
			    if(li.get(i).equals(li.get(j)) ){
			    	System.out.println("["+li.get(i)+","+li.get(j)+"]");
			    	count++;
			    	//li.remove();
			    }
			}
		}
		
		System.out.println(count);

	}

}
