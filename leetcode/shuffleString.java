package leetcode;

public class shuffleString {

	public static void main(String[] args) {
		String s="codeleet";
		int[] indices= {4,5,6,7,0,2,1,3};
	       String result = "";
	        for(int i=0;i<s.length();i++){
	            for(int j=0;j<s.length();j++){
	                if(i==indices[j]){
	                    result+=s.charAt(j);
	                    break;
	                }
	            }
	        }
	        //return result;
	        System.out.println(result);
	}

}
