
public class PlayCardGame {
	
	private Player player1, player2;
	int maxTurns = 80;
	
	Player findWinner() {
		if (player1.getPlayerCardsCount() > player2.getPlayerCardsCount()) {
			return player1;
		} else if (player2.getPlayerCardsCount() > player1.getPlayerCardsCount()) {
			return player2;
		}
		return null;
	}
	/**
     * This method will display the how we play and how game works..
     */
	
	public void playGame() {
		
		Card card = new Card();		
		
		card.create(4, 13);
		
		card.shuffle();
		
		player1 = new Player("Player 1");
		player2 = new Player("Player 2");
		
		while (card.getCount() >= 2) {
			player1.collectCard(card.deal());
			player2.collectCard(card.deal());
		}
		
		player1.addCardsToPlayerWonPile();
		player2.addCardsToPlayerWonPile();
		
		CardPile cardPile = new CardPile();
		int turn;
		
		for (turn=1; turn<=maxTurns; turn++) {
			
			if (player1.getPlayerCardsCount() < 1 || player2.getPlayerCardsCount() < 1)
			break;
			
			Card player1Card = player1.playCard();
			Card player2Card = player2.playCard();
			
			System.out.println("\nPlayers Turn " + turn + ": ");
			System.out.print(player1.getName() + ": " + player1Card);
			System.out.print(player2.getName() + ": " + player2Card);
			
			if (player1Card.compareFaceUpCards(player2Card) > 0) {
				player1.collectCard(player1Card); 
				player1.collectCard(player2Card);
			} else if (player1Card.compareFaceUpCards(player2Card) < 0) {
				player2.collectCard(player1Card); 
				player2.collectCard(player2Card);
			} else {
				cardPile.clearCardPile();
				cardPile.addCard(player1Card);
				cardPile.addCard(player2Card);
				
				boolean isTurnOver = false;
				
				while (!isTurnOver) {
				
					int num = player1Card.getRank();
					
					if (player1.getPlayerCardsCount() < num || player2.getPlayerCardsCount() < num)
					break;
					
					System.out.print("\nLet's have a war! Players place the " + num + " card(s) of their pile face down \n");
					System.out.println("\n");
					for (int i = 0; i < num; i++) {
						player1Card = player1.playCard(); 
						player2Card = player2.playCard();
						cardPile.addCard(player1Card);
						cardPile.addCard(player2Card);
					}
					
					System.out.print(player1.getName()+": "+ player1Card + " ");
					System.out.print(player2.getName()+": " + player2Card + " ");
					
					if (player1Card.compareFaceUpCards(player2Card) > 0) { 
						player1.collectCards(cardPile);
						isTurnOver = true;
					} else if (player1Card.compareFaceUpCards(player2Card) < 0) { 
						player2.collectCards(cardPile);
						isTurnOver = true;
					}
				}
			}
			System.out.println("\n");
			System.out.println("Total cards remain after the this turn with " + player1.getName() + " are: " + player1.getPlayerCardsCount() + 
					" and  with " + player2.getName() + " are: " + player2.getPlayerCardsCount());
		}
	}
}
