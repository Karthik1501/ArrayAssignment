import java.util.Arrays;

public class clockWiseRotate {

	public static void main(String[] args) {
		// clockRotate
		int[][] arr = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++)
				if (i != j) {
					int temp = arr[i][j];
					arr[i][j] = arr[j][i];
					arr[j][i] = temp;
				}
			//System.out.println(arr[i]);
		}

		//System.out.println(Arrays.deepToString(arr));

		int mid = arr.length / 2;
		for (int i = 0; i < arr.length; i++) {
			int[] temp= arr[i];
			for(int j=temp.length-1;j>=0;j--) {
				System.out.print(temp[j]+" ");
			}
			System.out.println();

		}
		//System.out.println(Arrays.deepToString(arr));
	}

}
