package amazonFilter;

public class TitleFilter implements Filter{

	@Override
	public void execute(String requestObject) {
		System.out.println("This is book title filter");
	}
}
