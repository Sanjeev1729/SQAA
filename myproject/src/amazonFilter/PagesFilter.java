package amazonFilter;

public class PagesFilter implements Filter {
     public void execute(String requestObj) {
    	 System.out.println("This is page based filter");
     }
}
