
public class NumTest {

	public static void main(String[] args) {

String = "Rain Feature";
		int num = 12; 
		int reversedNo = 0;
		
		while(num != 0){
			int dig  = num%10;
			reversedNo = reversedNo * 10 + dig;
			num = num / 10;
		} 
	 	System.out.println("reversed No: "+ reversedNo);
	}

}
