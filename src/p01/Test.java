package p01;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1+2+3+4.....+100
		
		int input=0;
		int output=0;
		
		
		//IPO
		//O=I+O
		for(input=1; input<100; input++) {
		output+=input;
		
		System.out.println(output);
		}
		System.out.println("1부터 100까지 합은:"+output);
	}

}
