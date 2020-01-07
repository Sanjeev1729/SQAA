package amazonPackage;

import java.util.HashMap;
import java.util.Map;

public class Locker {
	public HashMap<Integer,Integer> small;
	public HashMap<Integer,Integer> medium;
	public HashMap<Integer,Integer> large;
	int s,x,l;
	int sCount,xCount,lCount;
	Locker()
	{
		small = new HashMap<Integer,Integer>();
		medium = new HashMap<Integer,Integer>();
		large = new HashMap<Integer,Integer>();
		s = 50;
		x = 100;
		l = 150;
		sCount = 0;
		xCount = 0;
		lCount = 0;
	}
	
	public void  setLocker(Item item) {
		Integer itemId = item.id;
		ItemSize size = item.size;
		if(size.equals(ItemSize.small) && sCount!=s) {
			if(!small.containsValue(itemId)) {
				small.put(sCount, itemId);
				sCount++;
			}
		}
		else if(size.equals(ItemSize.medium) && xCount!=x || (size.equals(ItemSize.small) && sCount==s )) {
			if(!medium.containsValue(itemId)) {
				medium.put(xCount, itemId);
				xCount++;
			}
		}
		else if(size.equals(ItemSize.large) && lCount!=l || (size.equals(ItemSize.small) && sCount==s ) || (size.equals(ItemSize.medium) && xCount==x )){
			if(!large.containsValue(itemId)) {
				large.put(xCount, itemId);
				lCount++;
			}
		}else {
			System.out.println("All the lcokers are Full");
		}
	}
	
	public int getLocker(Item item) {
		Integer itemId = item.id;
		ItemSize size = item.size;
		if(size.equals(ItemSize.small)) {
			if(small.containsValue(itemId)) {
				for(Map.Entry<Integer, Integer> entry : small.entrySet()) {
					if(itemId.equals(entry.getValue())) {
						sCount--;
						return entry.getKey();
					}
				}
			}
		}
		if(size.equals(ItemSize.medium) || size.equals(ItemSize.small)) {
			if(medium.containsValue(itemId)) {
				for(Map.Entry<Integer, Integer> entry :medium.entrySet()) {
					if(itemId.equals(entry.getValue())) {
						if(size.equals(ItemSize.medium)) {
						  xCount--;	
						  return entry.getKey();
						}
					}
				}
			}
		}
		if(size.equals(ItemSize.large)|| size.equals(ItemSize.medium) || size.equals(ItemSize.small) ) {
			if(large.containsValue(size)) {
				for(Map.Entry<Integer,Integer> entry : large.entrySet()) {
					if(size.equals(entry.getValue())) {
						lCount--;
						return entry.getKey();
					}
				}
			}
		}
		return -1;
	}
}
