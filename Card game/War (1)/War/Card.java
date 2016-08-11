import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;


class Card implements Deck {
	
	private int DECK_OF_CARDS_COUNT = 52;
	private Card[] deck;
	private int cardsCount;
	private int rank;
	private int suit;
	
	// Default constructor
	Card() {
		
	}
		
	// Parameterized constructor
	Card(int r, int s) {
		rank = r;
		suit = s;
	}
	
	int getRank() {
		return rank;
	}

	int getSuit() {
		return suit;
	}
		
    /**
     * This method creates or initilaises the deck of cards
     */	
	public void create( int numberOfSuits, int numberOfRanks ) {
		deck = new Card[DECK_OF_CARDS_COUNT];
		createCardDeck(numberOfSuits, numberOfRanks);		
	}
	
	/**
	 * This method randomly reorders the deck of cards
	 */
	public void shuffle() {
		int i = 0;
		while (i < cardsCount - 1) {
			int j = getRandomCardNumber(i, cardsCount - 1);
			Card nextCard = deck[i];
			deck[i] = deck[j];
			deck[j] = nextCard;
			i++;
		}
	}
	/**
     * This method deals with the card count with increment or decrement of cards and returns accordingly
    */
	public Card deal() {
		if (cardsCount == 0) { 
			return null;
		}
		cardsCount--;
		return deck[cardsCount];
	}
	
	int getCount() {
		return cardsCount;
	}
	/**
     * This method creates the card deck and checks for the new card count of the suits and ranks
    */
	private void createCardDeck(int numberOfSuits, int numberOfRanks) {
		int m = 0;
		for (int i = 1; i <= numberOfRanks; i++) {
			for (int j = 1; j <= numberOfSuits; j++) {
				deck[m] = new Card(i, j);
				m++;
			}
		}
		cardsCount = DECK_OF_CARDS_COUNT;
	}
	
	/**
     * This method initialises the random card numbers and return the corresponding random numbers 
     */

	public Card[] getDeck() {
		return deck;
	}
	
	private static int getRandomCardNumber(int min, int max) {
		Random random = new Random();
		int range = max - min + 1;
		return random.nextInt(range) + min;
	}
	/**
     * This method compares the cards which are up face and return the ranks of the players
     */
	public int compareFaceUpCards(Card card) {			
		int player1Rank = this.getRank();
		int player2Rank = card.getRank();
		
		if (player1Rank == 1) {
			player1Rank = 14;
		}
		
		if (player2Rank == 1) {
			player2Rank = 14;
		}
		
		return player1Rank - player2Rank;
	}

	public String toString() {
		String[] suits = new String[10];
		String name;
		String formattedString;
		int i;
		
		suits[0] = "Clubs";
		suits[1] = "Diamonds";
		suits[2] = "Hearts";
		suits[3] = "Spades";
				
		if (rank == 1) {
			name = "Ace";
		} else if (rank == 11) {
			name = "Jack";
		} else if (rank == 12) {
			name = "Queen";
		} else if (rank == 13) { 
			name = "King";
		} else {
			name = String.valueOf(rank);
		}
		
		formattedString = name + " of " + suits[suit - 1];
		
		i = formattedString.length();
		
		while (i < 20) {
			formattedString = formattedString + " ";
			i++;
		}
		return formattedString;
	}
		
	public boolean equals(Object ob) {
		Boolean isEquals =  false;
		if (ob instanceof Card) {
			Card otherPlayerCard = (Card)ob;
			isEquals = (suit == otherPlayerCard.suit && rank == otherPlayerCard.rank);
			return isEquals; 
		}
		return isEquals;
	}
	
}
