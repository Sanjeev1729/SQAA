package cardDeck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    List<Card> cards = new ArrayList<Card>();
    
    public Deck(){
    	createDeck();
    	shuffleCards();
    }
    
    public void createDeck() {
		for(Suit s : Suit.values()) {
			for(Point p : Point.values()) {
				cards.add(new Card(s,p));
			}
		}
		
	}

	public void shuffleCards() {
    	Collections.shuffle(cards);
    }
    
    public Card drawCard() {
    	if(cards.size()==0)
    		throw new RuntimeException("Cards Not Available");
    	Card card = cards.remove(cards.size()-1);
    	return card;
    }
    
}
