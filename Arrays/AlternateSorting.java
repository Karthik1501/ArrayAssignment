import java.util.*;
public class AlternateSorting {

	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5,6,7};
		Arrays.sort(arr);
        int mid=arr.length/2;
        
        if(mid%2==0) {
        	mid=mid-1;
        }
        
        int left=mid,right=mid+1;
       
		while(left>=0 && right<arr.length) {
        	System.out.print(arr[left--]+" "+arr[right++]+" ");
        }
        if(left==0)
        	System.out.println(arr[left]);
	}

}
