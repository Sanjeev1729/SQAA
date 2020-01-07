package cardDeck;

public class Card {

	Suit cSuite;
	Point cPoint;
	public Card(Suit suite,Point point) {
		this.cSuite = suite;
		this.cPoint = point;
	}
	
	public Suit getSuit() {
		return cSuite;
	}
	
	public Point getPoint() {
		return cPoint;
	}
}
