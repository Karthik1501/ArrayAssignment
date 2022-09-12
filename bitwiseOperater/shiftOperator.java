
public class shiftOperator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num=4;
		int c=2;
		boolean flage=true;
		while(c*c<=num) {
			if(num%2==0) {
				flage=false;
			}
		    c++;
		}
		if(flage==true)
			System.out.println("isPrime");
		else System.out.println("Not prime");
	}

}
