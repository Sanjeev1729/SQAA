package mypack;

public class A {

	private Integer a=10;
	
	private  void getMsg() {
		System.out.println("I am private method");
	}
	
	public int getInteger() {
		return a;
	}
	
	public void setInteger(int a) {
		this.a = a;
		System.out.println("A class value"+a);
	}
}
