package amazonFilter;

import java.util.ArrayList;

public class FilterChain {
   ArrayList<Filter> filters = new ArrayList<Filter>();
   
   public void addFilter(Filter filter) {
	   filters.add(filter);
   }
   
   public void execute(String requestObj) {
	   for(Filter filter : filters) {
		   filter.execute(requestObj);
	   }
   }
}
