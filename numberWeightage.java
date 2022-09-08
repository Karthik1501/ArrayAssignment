import java.util.*;

public class numberWeightage {

	public static void main(String[] args) {
		// numberWeightage
		int arr[]= {49,36,8,10,12};
		int weightage[][] = new int[arr.length][2];
		for(int i=0;i<arr.length;i++) {
			int temp=0;
			if(arr[i]==Math.pow((int)Math.sqrt(arr[i]), 2))
				temp+=5;
			if(arr[i]%6==0 && arr[i]%4==0)
				temp+=4;
			if(arr[i]%2==0)
				temp+=3;
			
		weightage[i][0]=arr[i];
		weightage[i][1]=temp;
		}
		Arrays.sort(weightage,new Comparator<int[]>() {
			public int compare(int[] a,int[] b) {
				if(a[1] > b[1])
					return -1;
				else
					return 1;
			}
		});
     System.out.println(Arrays.deepToString(weightage));   
	}

}
