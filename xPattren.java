
public class xPattren {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="PROGRAM";
		int len=str.length()-1;
		for(int i=0;i<str.length();i++) {
			for(int j=0;j<str.length();j++) {
				if(i==j || j==len-i) {
					System.out.print(str.charAt(j));
				}
				else
					System.out.print(" ");
			}
			System.out.println();
		}
	}

}
