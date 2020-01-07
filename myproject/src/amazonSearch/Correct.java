public interface Filterable {
    String filter(String comment);
}

public class BasicFilter implements Filterable {
    @Override
    public String filter(String comment) {
        System.out.println("Basic filter");
        return comment;
    }
}

public class FilterDecorator implements Filterable {
    protected Filterable filterable;

    public FilterDecorator(Filterable filter) {
        this.filterable = filter;
    }

    @Override
    public String filter(String comment) {
        return this.filterable.filter(comment);
    }
}

public class AbusiveWordFilter extends FilterDecorator {

    public AbusiveWordFilter(Filterable filter) {
        super(filter);
    }
    @Override
    public String filter(String comment) {
        System.out.println("Removing abusing stuff");
        return super.filter(comment);
    }
}

public class SpecialCharFilter extends FilterDecorator {

    public SpecialCharFilter(Filterable filter) {
        super(filter);
    }

    @Override
    public String filter(String comment) {
        System.out.println("Removing special characters");
        return super.filter(comment);
    }
}

public class FilterMain {
    public static void main(String[] args) {
        Filterable filterable = new AbusiveWordFilter(new SpecialCharFilter(new BasicFilter()));
        filterable.filter("something");
    }
}