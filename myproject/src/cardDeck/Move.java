package cardDeck;

public class Move {
    private Player player;
    private Card card;
    
    public Move(Player player,Card card) {
    	this.player = player;
    	this.card = card;
    }
    
    public Player getPlayer() {
    	return player;
    }
    
    public Card getCard() {
    	return card;
    }
}
