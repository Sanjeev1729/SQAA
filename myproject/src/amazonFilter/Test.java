package amazonFilter;

public class Test {
     public static void main(String args[]) {
    	 FilterManager filterManager = new FilterManager();
    	 filterManager.setFilter(new PagesFilter());
    	 filterManager.setFilter(new TitleFilter());
     }
}
