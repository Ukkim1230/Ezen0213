package p0212;


public class FinalTest {//String 은 상속불가
	final int I = 1;
	int i;
	public static void main(String[] args) {
		final int i = 1;
		//i = 2;
		System.out.println(i);
		FinalTest ft = new FinalTest();
		System.out.println(ft.I);
	}

}
