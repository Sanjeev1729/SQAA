package mypack;

public class box {
 
	 private void displayMsg() {
		 System.out.println("This is outer class");
	 }
 
  public class largeBox extends box{
	  
	  private void displayMsg() {
		 System.out.println("This is inner class");
	  }
  }
  public static void main(String args[]) {
	  box obj = new box();
	  obj.displayMsg();
	  System.out.println();
  }
}
