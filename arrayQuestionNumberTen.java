import java.util.Arrays;

public class arrayQuestionNumberTen {

	public static void main(String[] args) {
//		MatrixAddition();
//		MatrixSubtraction();
//		MatrixMultiplication();
//		ScalarMultiplication();
//		TransposeMatrix();
//		FindSaddlePoint();
		RankOfMatrix();

	}

	// 1.Addition matrix
	public static void MatrixAddition() {
		int[][] arr1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[][] arr2 = { { 9, 8, 7 }, { 6, 5, 4 }, { 3, 2, 1 } };

		System.out.println("\n1.MatrixAddition");
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				System.out.print(arr1[i][j] + arr2[i][j] + " ");
			}
			System.out.println();
		}

	}  

	// 2.MatrixSubtraction
	public static void MatrixSubtraction() {
		int[][] arr1 = { { 11, 22, 34 }, { 41, 35, 46 }, { 87, 43, 31 } };
		int[][] arr2 = { { 4, 6, 8 }, { 2, 23, 43 }, { 34, 2, 1 } };

		System.out.println("\n2.MatrixSubtraction");
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				System.out.print(arr2[i][j] - arr1[i][j] + " ");
			}
			System.out.println();
		}
	}

	// 3.MatrixMultiplaycation
	public static void MatrixMultiplication() {
		int[][] arr1 = { { 2, 4 }, { 6, 3 } };
		int[][] arr2 = { { 12, 3, 4 }, { 4, 5, 2 } };

		int arr1Length = arr1[0].length, arr2Length = arr2.length;
		// check if it's N * N matrix
		if (arr1Length == arr2Length) {
			for (int i = 0; i < arr1Length; i++) {
				for (int j = 0; j < 3; j++) {
					int temp = 0;
					for (int k = 0; k < arr1Length; k++) {
						temp += arr1[i][k] * arr2[k][j];
					}
					System.out.print(temp + " ");
				}
				System.out.println();
			}
		} else
			System.out.println("It's not N*N matrix");
	}

	// 4.ScalarMultiplication
	public static void ScalarMultiplication() {
		int[][] arr1 = { { 1, 2, 3 }, { 6, 7, 4 } };
		int target = 4;

		System.out.println("\n4.ScalarMultiplication");
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr1[0].length; j++) {
				System.out.print(arr1[i][j] * target + " ");
			}
			System.out.println();
		}
	}

	// 5.MatrixTranspose
	public static void TransposeMatrix() {
		// N X N tranpoe
		int[][] arr1 = { { 1, 2, 3 }, { 5, 6, 7 }, { 9, 8, 4 } };
		for (int i = 0; i < arr1.length; i++) {
			for (int j = i; j < arr1.length; j++) {
				int temp = arr1[i][j];
				arr1[i][j] = arr1[j][i];
				arr1[j][i] = temp;
			}
			System.out.println(Arrays.toString(arr1[i]));
		}

//		// 2 X 3 tranpose
//		int[][] arr1 = {{1,2,3},
//				        {5,6,7}};
//		int[][] temp=new  int[arr1[0].length][arr1.length];
// 		for(int i=0;i<arr1.length;i++) {
//			for(int j=0;j<arr1[0].length;j++) {
//				
//				temp[j][i]=arr1[i][j];
//			
//			}	
//		}
// 		System.out.println(Arrays.deepToString(temp));

	}

	// 6.saddle point
	public static void FindSaddlePoint() {
		int arr[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 8, 6, 9 } };

		for (int i = 0; i < arr.length; i++) {
			int min = arr[i][0], min_col = 0;
			boolean flag = true;

			// find minimum element each rows
			for (int j = 1; j < arr[i].length; j++) {
				if (arr[i][j] < min) {
					min = arr[i][j];
					min_col = j;
				}

			}

			// find maximum element in each column
			for (int k = 0; k < arr.length; k++) {
				if (arr[k][min_col] > min) {
					flag = false;
				}
			}

			if (flag)
				System.out.print(min);
		}
	}

	
	//Rank of matrix check whether the given is identity/diagonal
	public static void RankOfMatrix() {
		int[][] rankOfMatrix= {{1,0,0},
								{0,1,0},
								{0,0,1}};
		boolean flag=true;
		for(int i=0;i<rankOfMatrix.length;i++) {
			for(int j=0;j<rankOfMatrix.length;j++) {
				if(i==j && rankOfMatrix[i][j]!=1 ) {
					flag=false;
					break;
					}
			    if(i!=j &&rankOfMatrix[i][j]!=0) {
					flag=false;
					break;
			    }
			}
		}
		if(flag==true)
			System.out.println("Given matrix is identity matrix");
		else
			System.out.println("Given matrix is not identity matrix");
	}
	
		
	
}
