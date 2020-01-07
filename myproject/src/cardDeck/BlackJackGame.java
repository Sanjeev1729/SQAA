package cardDeck;

import java.util.ArrayList;

//https://leetcode.com/discuss/interview-question/object-oriented-design/159168/design-blackjack-game

public class BlackJackGame {
	
	  public Player player;
	  public BlackJackGame(String playerName){
		   player = new BlackJackPlayer(playerName);
	  }
	  
	  private Deck deckOfCards = new Deck();
	  
	  private Dealer dealer = new Dealer("Mat");
	  
	  private Card hiddenDealerCard = null;
	  
	  ArrayList<Move> moves = new ArrayList<Move>();
	  
	  private void play() {
		  hiddenDealerCard = deckOfCards.drawCard();
		  giveNewCard(dealer);
		  giveNewCard(player);
		  while(player.canPlay() && player.willPlay() && !gameEnded()) {
			  giveNewCard(player);
		  }
		  if(!gameEnded()) {
			  giveCard(dealer,hiddenDealerCard);
			  while(dealer.canPlay() && !gameEnded()) {
				  giveNewCard(dealer);
			  }
		  }
		  showGameWinner();
	  }
	  
	
	public void giveNewCard(Player player) {
		  giveCard(player, deckOfCards.drawCard());
	  }
	  
	  public void giveCard(Player player,Card card) {
		  Move move = new Move(player,card);
		  moves.add(move);
		  player.addCard(card);
	  }
	  
	  public static void main(String args[]) {
    	  BlackJackGame blackJackGame = new BlackJackGame("Samuel");
    	  blackJackGame.play();
      }
      
	  public boolean gameEnded() {
		  if (player.getTotalPoints() >= 21) {
				return true;
			} else if (dealer.getTotalPoints() >= 21) {
				return true;
			}
		  return false;
	  }
	  
	  private void showGameWinner() {
			if(player.getTotalPoints()>21) {
				System.out.println(player.getPlayerName() + "has lost the game");
			}
			else if(dealer.getTotalPoints()>21) {
				System.out.println(dealer.getPlayerName() + "has lost the game");
			}else{
				Player winner = (player.getTotalPoints()>dealer.getTotalPoints())?player:dealer;
				System.out.println("Winner is"+winner.getPlayerName());
			}
	  }

}
