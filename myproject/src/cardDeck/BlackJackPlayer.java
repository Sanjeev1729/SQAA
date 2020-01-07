package cardDeck;

public class BlackJackPlayer extends Player{

	public BlackJackPlayer(String name){
		super(name);
	}

	public boolean canPlay() {
		if(getTotalPoints()<21)
		     return true;
		return false;
	}
	
	public boolean willPlay() {
		if(getTotalPoints()<17)
			return true;
		return false;
	}

}
