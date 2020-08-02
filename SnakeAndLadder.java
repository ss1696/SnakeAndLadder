import java.util.Random;

public class SnakeAndLadder {
	
	//Initializing Constant and Variable 
	private final int START_POSITION = 0;
	private final int MAX_POSITION = 100;
	private int position;
	private int[] players;
	private int diceRollsCount;
	private int player1;
	private int player2;

	public static void main(String[] args) {
		SnakeAndLadder sl = new SnakeAndLadder();
		sl.game(2);
		sl.showWin();
	}
	
	//Constructor
	SnakeAndLadder() {
		players = new int[2];
	}
	
	//Here function game is used to run the game till the position reached maximum value   	
	private void game(int noOfPlayers) {
		int i = 0;
		position = START_POSITION;
		while(  players[i] < MAX_POSITION && players[i+1] < MAX_POSITION ) {
			diceRollsCount++;
			//For player1 Position
			position = player1;
			player1 = checkOption(player1);
			players[i] = player1;
			System.out.println("Player 1 after " + diceRollsCount + " dice roll is at position "+players[i]);
			//For player2 Position
			position = player2;
			player2 = checkOption(player2);
			players[i+1] = player2;
			System.out.println("Player 2 after " + diceRollsCount + " dice roll is at position "+players[i+1]);
		}
	}
	
	 //Here the dice is rolled to get the value in between 1 to 6
	 private int rollDice() {
		diceRollsCount++;
		Random random = new Random();
		int diceRolled = random.nextInt(6) + 1;
		return diceRolled;
	 }

	//Here the function checkOption is used to return the position of player	
	private int checkOption(int position) {
		Random random = new Random();
		int options = random.nextInt(3); 		                // To get the option where 0-NoPlay 1-Ladder 2-Sanke
		int diceRolled = this.rollDice();
		switch(options) {
		case 1:
			if((position + diceRolled) <= MAX_POSITION) {
				position = position + diceRolled;		// ladder position should be less than max position  
				position = checkOption(position);
				return position;
			} else {
				return position;
			}
		case 2:
			position = position - diceRolled;
			if(position < 0) {
				position = 0;
				return position;				// if snake position is less than 0 than position remains 0
			} else {
				return position;
			}	
		default:
			return position;	
		}
	}

	//Here this function is used to show which player wins ......
	private void showWin() {
		int i = 0;
		if(players[i] > players[i+1]) {
			System.out.println("Player 1 wins by "+(players[i] - players[i+1])+" points.");
		} else {
			System.out.println("Player 2 wins by "+(players[i+1] - players[i])+" points.");
		}
	}
}

