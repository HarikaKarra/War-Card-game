public class War {
	public static void main(String [] args) {
		PlayCardGame game = new PlayCardGame();
		game.playGame();
		Player winner = game.findWinner();
		
		if (winner != null) {
			System.out.println("\nThe winner of the war is: "+ winner.getName());
		} else {
			System.out.println("\nThe war ended in a tie !!");
		}
	}
}
