import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import org.junit.Test;

/*
 * This class provides the unit tests to test the functionality 
 * of methods defined in Deck Interface and few others.
 */
public class TestWarJUnit {
	  
   @Test
   public void testCreateDeck() {
	   Card card = new Card();	
	   //create deck of cards
	   // '4' being numberOfSuits and '13' being numberOfRanks
	   card.create(4, 13);
	   // inorder to check the creation of deck of cards,
	   // we are just fetching the total count of cards by getCount method
	   // and comparing with 52 (deck of cards)
	   int numberOfCards = card.getCount();
	   assertEquals("The total cards in a deck should be 52", numberOfCards, 52);
   }
   
   @Test
   public void testShuffleDeck() {
	   Card card = new Card();	
	   //create deck of cards
	   //'4' being numberOfSuits and '13' being numberOfRanks
	   card.create(4, 13);
	   Card[] beforeDeck = card.getDeck();
	   //get the first card of deck before shuffling
	   Card cardBeforeShuffle = beforeDeck[0];
	   //Now shuffle the deck and retrieve the first element again,
	   //They both should not be equal
	   card.shuffle();
	   Card[] afterDeck = card.getDeck();
	   Card cardAfterShuffle = afterDeck[0];
	   assertNotSame("Test is passed since the first elements of deck are different after shuffling"
	   		+ cardBeforeShuffle, cardAfterShuffle);  
   }
   
   @Test
   public void testDeal() {
	   Card card = new Card();		
	   card.create(4, 13);		
	   //Deal a card from the deck
	   Card deal = card.deal(); 
	   assertNotNull("Deal card should be retrieved", deal);
   }
   
   @Test
   public void testPlayGame() {
	   PlayCardGame game = new PlayCardGame();
	   game.playGame();
	   Player winner = game.findWinner();
	   assertNotNull("The player card pile should never be null if the game is played", (winner.playCard()));
   }
}