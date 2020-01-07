package webPageVisit;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Users {
	private LinkedHashMap<Integer,Integer> lhm;
	
	public Users() {
		lhm = new LinkedHashMap<Integer,Integer>();
	}
	
	void logUser(int id) {
		if(lhm.get(id)!=null) {
			Integer value = lhm.get(id);
			lhm.put(id,value++);
		}else {
		    lhm.put(id, 1);
		}		
	}
	int firstUniqueVisitor() {
        Iterator<Map.Entry<Integer, Integer>> itr = lhm.entrySet().iterator(); 
        while(itr.hasNext()) {
        	Map.Entry<Integer, Integer> entry = itr.next(); 
        	if(entry.getValue()==1) {
        		return entry.getKey();
        	}
        }
		return -1;
	}
}
