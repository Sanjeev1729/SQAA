package movingAvg;

public class Test {
	 public static void main(String args[]) {
         MovingAverage mvg = new MovingAverage(3);
         System.out.println(mvg.next(1));
         System.out.println(mvg.next(3));
         System.out.println(mvg.next(1));
         System.out.println(mvg.next(5));

	 }     
}
