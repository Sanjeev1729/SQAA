package hit.counter;

import java.util.LinkedList;
import java.util.Queue;

public class HitCounter {
   private Queue<Integer> queue;
   
   public HitCounter() {
	   queue = new LinkedList<Integer>();
   }
   
   public void hit(int timeStamp) {
	   remove(timeStamp);
	   queue.add(timeStamp);
   }
   
   public int getHits(int timeStamp) {
	   remove(timeStamp);
	   return queue.size();
   }
   
   public void remove(int timeStamp) {
	   while(!queue.isEmpty() && timeStamp-queue.peek()>=300) {
		   queue.poll();
	   }
   }
   
}
