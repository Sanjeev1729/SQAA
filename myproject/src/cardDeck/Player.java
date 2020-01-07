package cardDeck;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {
     private  String pName = "";
     List<Card> hand = new ArrayList<Card>();
     public abstract boolean canPlay();
     public abstract boolean willPlay();
     
     public Player(String name) {
    	 this.pName = name;
     }
     
     public void addCard(Card card) {
    	 hand.add(card);
     }
     
     public String getPlayerName() {
    	 return pName;
     }
     
     public int getTotalPoints() {
    	 return 0;
     }
}
