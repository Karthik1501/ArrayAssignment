package leetcode;
import java.util.*;
public class firstLetterAppearTwice {

	public static void main(String[] args) {
		String s= "nwcn";
		HashMap<Character,Integer> checkChar = new HashMap<>();
		   char c=' ';
		     for(int i=0;i<s.length();i++){   
		         if(checkChar.containsKey(s.charAt(i))) {
		        	 c=s.charAt(i);
		        	 break;
		         }
		         else
		        	 checkChar.put(s.charAt(i), 1);
		     }
		     System.out.println(c);
	}

}
