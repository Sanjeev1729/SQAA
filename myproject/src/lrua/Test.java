package lrua;

public class Test {
    public static void main(String args[]) {
    /*	LRU lru = new LRU(3);
    	lru.set(1, 10);
    	lru.set(2,20);
    	lru.set(3, 30);
    	System.out.println("Value of 2 is "+lru.get(2));
    	lru.set(5, 50);
    	System.out.println("Value of 5 is "+lru.get(5)); */
    	
    	LRUQ1 lruq1 = new LRUQ1(3);
    	lruq1.set("apple");
    	lruq1.set("mango");
    	lruq1.set("apple");
    	lruq1.set("kiwi");
    	lruq1.set("lichie");
    	
    	System.out.println("The value for apple is "+lruq1.get("apple"));
    	System.out.println("The value for apple is "+lruq1.get("mango"));
    	System.out.println("The value for apple is "+lruq1.get("kiwi"));
    	System.out.println("The value for apple is "+lruq1.get("lichie"));

    }
}
