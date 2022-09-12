import java.util.*;
public class DegreeOfArray {

	public static void main(String[] args) {
		List<List<Integer>> nli=new ArrayList<>();
		int[] nums= {1,2,3};
		nli.add(new ArrayList<>());
		for(int i=0;i<nums.length;i++) {
		
			
			for(int j=i;j<nums.length;j++) {
				List<Integer> li=new ArrayList<>();
				//li.add(j);
				for(int k=i;k<=j;k++) {
					//System.out.print(nums[k]+" ");
					li.add(nums[k]);
				}
				
				//System.out.println();
				nli.add(li);
			}
			//System.out.println();
			
		}
		
		System.out.println(nli);
		
		//System.out.print(nli);
	}

}
