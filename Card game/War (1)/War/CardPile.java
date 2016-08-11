
public class CardPile {
	
	private Card[] pile;
	private int startIndex, endIndex;
	private int DECK_OF_CARDS_COUNT = 52;
	
	CardPile() {
		pile = new Card[DECK_OF_CARDS_COUNT];
		startIndex = 0; 
		endIndex = 0;
	}
	
	int getSize() {
		return endIndex - startIndex;
	}
		
	void addCard(Card card) {
		pile[endIndex] = card;
		endIndex++;
	}
	
	void addCardsToPile(CardPile p) {
		while (p.getSize() > 0) {
			addCard(p.nextCardOfPile());
		}
	}
	
	void clearCardPile() {
		startIndex = 0; 
		endIndex = 0;
	}
	
	Card nextCardOfPile() {
		Card card = pile[startIndex];
		startIndex++;
		return card;
	}	
}
