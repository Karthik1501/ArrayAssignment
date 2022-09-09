import java.util.*;

public class leftRotateAndRightRotate {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		// leftRotate
		int[] leftRotate= {1,2,3,4,5};
	    System.out.println("How many times you want left rotate:");
	    int numberOfTime=sc.nextInt();
		for(int j=0;j<numberOfTime;j++) {
			int temp=leftRotate[0];
			for(int i=1;i<leftRotate.length;i++) {
				leftRotate[i-1]=leftRotate[i];
			}
			leftRotate[leftRotate.length-1]=temp;
		}
		System.out.println(Arrays.toString(leftRotate));
		
		
		
		// rigthRotate
		int[] rigthRotate= {1,2,3,4,5};
	    System.out.println("How many times you want right rotate:");
	    int number_OfTime=sc.nextInt();
		for(int j=0;j<number_OfTime;j++) {
			int temp=rigthRotate[rigthRotate.length-1];
			for(int i=rigthRotate.length-1;i>0;i--) {
				rigthRotate[i]=rigthRotate[i-1];
			}
			rigthRotate[0]=temp;
		}
		System.out.println(Arrays.toString(rigthRotate));
	}

}
