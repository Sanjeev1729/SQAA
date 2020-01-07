package amazonPackage;

public class LockerController {
	public static void main(String args[]) {
		Locker locker = new Locker();
		Item sItem = new Item(1, ItemSize.small);
		Item mItem = new Item(5, ItemSize.medium);
		Item lItem = new Item(10, ItemSize.large);
		mItem = new Item(12, ItemSize.medium);
		locker.setLocker(sItem);
		locker.setLocker(mItem);
		locker.setLocker(lItem);
		locker.setLocker(mItem);
		System.out.println("The locker id for item id 12 is " + locker.getLocker(mItem));
	}
}
