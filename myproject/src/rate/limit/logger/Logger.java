package rate.limit.logger;

import java.util.HashMap;
import java.util.Map;

public class Logger {

     private HashMap<String,Integer> hmp;
     public Logger() {
    	 hmp = new HashMap<String,Integer>();
     }
	 public boolean shouldPrintMessage(int timeStamp,String message) {
		 if(hmp.containsKey(message)==true && hmp.get(message)>10) {
			 hmp.put(message, timeStamp);
			 return true;
		 }
		 return false;
	 }
}
