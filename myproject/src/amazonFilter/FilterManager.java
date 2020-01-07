package amazonFilter;

public class FilterManager {
    FilterChain filterChain;
    
    public void FilterChain() {
    	filterChain = new FilterChain();
    }
    
    public void setFilter(Filter filter) {
    	filterChain.addFilter(filter);
    }
}
