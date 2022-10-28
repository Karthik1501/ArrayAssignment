package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class QuesThree {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter length of array:");
		int len = sc.nextInt();
		int[] arr = new int[len];
		for(int i=0;i<len;i++) {
			arr[i]=sc.nextInt();
		}
		int[] set=new int[2];
		
		int max=0;
		for(int i=0;i<len;i++) {
			int sum=arr[i];
			for(int j=i+1;j<len;j++) {
				
			    sum+=arr[j]; 
			    
			    if(sum==0) {
			    	 if(max<j-i) {
			    		 max=j-i;
			    		 set[0]=i;
			    		 set[1]=j;
			    	 }
			    	  		    	
			    }
			     	
			}	
			
		}
         
//		for(int ind = set[0];ind<=set[1];ind++)
//			System.out.print(arr[ind]+" ");
		System.out.println((set[1]-set[0])+1);
		
	}

}
