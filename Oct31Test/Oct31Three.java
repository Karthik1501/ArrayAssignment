package test;

import java.util.*;

public class Oct31Three {
	
   static Set<String> set = new HashSet<>();
   String comb="";
    
	public static void main(String[] args) {

		String s = "XYBYAXBY";
		System.out.println(new Oct31Three().findCombination(s,0));
		System.out.println("Number of pair :"+ set.size());
		
	}
	
    public Set<String> findCombination(String s,int index) {
    	
    	if(comb.length()>1) {
    		checkSequence(comb,s.substring(index-1));
    		//return set;
    	}
    		
    	
    	for(int i=index;i<s.length();i++) {
    		
    		comb+=s.charAt(i);
    		findCombination(s,i+1);
    		comb=comb.substring(0,comb.length()-1);
    		
    	}
		return set;
    		
    }
    
    
    public boolean checkSequence(String combi, String s) {
  
    	int indx=-1;
    	boolean flag = true;
    	
    	for(int i=0;i<combi.length();i++) {
    		
    		s=s.substring(indx+1);
    		
    		indx=s.indexOf(combi.charAt(i));
    		
    		if(indx==-1) {
    			flag=false;
    			break;
    		}
    		
    	}
    	
    	if(flag) {
    		set.add(combi);
    		return true;
    	}
    	
    	return false;
    	
    	
    }
    
    
    

}
