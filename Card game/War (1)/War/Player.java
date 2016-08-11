public class Player {
	
	private CardPile playerPile, playerWonPile;
	private String playerName;
	
	Player(String name) {
		playerName = name;
		playerPile = new CardPile();
		playerWonPile = new CardPile();
	}
	
	String getName() {
		return playerName;
	}
		
	Card playCard() {
		if (playerPile.getSize() == 0) {
			addCardsToPlayerWonPile();
		}
		
		if (playerPile.getSize() > 0) {
			return playerPile.nextCardOfPile();
		}
		
		return null;
	}
			
	int getPlayerCardsCount() {
		return playerPile.getSize() + playerWonPile.getSize();
	}
	
	void addCardsToPlayerWonPile() {
		playerPile.clearCardPile();
		playerPile.addCardsToPile(playerWonPile);
		playerWonPile.clearCardPile();
	}
	
	void collectCard(Card card) {
		playerWonPile.addCard(card);
	}
		
	void collectCards(CardPile cardPile) {
		playerWonPile.addCardsToPile(cardPile);
	}
}
