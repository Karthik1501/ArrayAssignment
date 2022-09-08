
public class matrixMultiplay {

	public static void main(String[] args) {
		int arr1[][]= {{1,2},{3,4}};
		int arr2[][]= {{5,6,7},{8,9,10}};
		int res[][]=new int[2][3];
		for(int i=0;i<arr1.length;i++) {
			for(int j=0;j<3;j++) {
				res[i][j]=0;
				for(int k=0;k<arr2.length;k++) {
					res[i][j]+=arr1[i][k]*arr2[k][j];
				}
				System.out.print(res[i][j]+" ");
			}
			System.out.println();
		}
	}

}
