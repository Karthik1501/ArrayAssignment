
public class spiralMatrix {

	public static void main(String[] args) {
		// spiralMatrix
		int[][] spMatrix= {
				{4,3,2,1},
				{5,14,13,12},
				{6,15,16,11},
				{7,8,9,10}};
		
		int colStart=0,colEnd=spMatrix.length-1;
		int rowStart=0,rowEnd=spMatrix.length-1;
		
		while(colEnd>colStart && rowEnd>rowStart) {
			for(int i=colEnd;i>=colStart;i--) {
				System.out.print(spMatrix[colStart][i]+" ");
			}
			
			colStart++;
			
			for(int j=colStart;j<=rowEnd;j++) {
				System.out.print(spMatrix[j][rowStart]+" ");
			}
			
			rowStart++;
			
			for(int k=rowStart;k<=colEnd;k++) {
				System.out.print(spMatrix[colEnd][k]+" ");
			}
			rowEnd--;
			
			for(int l=rowEnd;l>=rowStart;l--) {
				System.out.print(spMatrix[l][colEnd]+" ");
			}
			
			colEnd--;
		}
		
	}

}
