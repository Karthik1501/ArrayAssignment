package leetcode;

import java.util.*;

public class rotateString {
	public static void main(String[] args) {
			String s="abcde",goa="cdeab";
	     
	        for(int i=0;i<s.length();i++){
	          char ch=s.charAt(0);
	          s=s.substring(1,s.length())+ch;
	            if(s.equals(goa))
	            	System.out.println("true");
	        }
	        
	      System.out.println("false");
	   	}

}
