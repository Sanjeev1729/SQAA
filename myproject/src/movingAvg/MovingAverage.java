package movingAvg;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
    private Queue<Integer> q;
    private double sum;
    private int maxSize;
	
	public MovingAverage(int size) {
		q = new LinkedList<>();
		sum = 0.0;
		maxSize = size;
	}
	
	public double next(int val) {
		if(q.size()==maxSize) {
			sum-=q.remove();
		}
		q.add(val);
		sum+=val;
		return sum/q.size();
	}
}
