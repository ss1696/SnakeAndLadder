import java.util.Random;
import java.util.HashMap;

public class SnakeAndLadder {
	
	//Initializing Constant and Variable 
	int START_POSITION = 0;
	int noOFPLayers = 1;
	int position = START_POSITION;
	final int MAX_POSITION = 100;
	int diceRollsCount;
	
	HashMap<Integer,Integer> positionResult = new HashMap<Integer,Integer>();

	public static void main(String[] args) {
		SnakeAndLadder sl = new SnakeAndLadder();
		sl.game();
		sl.displayDiceRoll_Position();
	}
	
	//Here function game is used to run the game till the position reached maximum value   	
	private void game() {
		Random random = new Random();
		while(position != MAX_POSITION) {
			int diceRolled = this.rollDice();
			int options = random.nextInt(3); // To get the option where 0-NoPlay 1-Ladder 2-Sanke
			position = this.checkOption(options, diceRolled);
			positionResult.put(diceRollsCount, position);
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
	private int checkOption(int options, int  diceRolled) {
		switch(options) {
		case 1:
			if((position + diceRolled) <= MAX_POSITION) {
				position = position + diceRolled;		// ladder position should be less than max position  
				return position;
			} else {
				return position;
			}
		case 2:
			if((position - diceRolled) < 0) {
				position = 0;
				return position;				// if snake position is less than 0 than position remains 0
			} else {
				position = position - diceRolled;
				return position;
			}	
		default:
			return position;	
		}
	}

	// Displaying the dice roll and the position of the player 
	private void displayDiceRoll_Position() {
		for (int rollDice = 1; rollDice <= diceRollsCount; rollDice++) {
			System.out.println("Player after " + rollDice + " dice roll is at position "+positionResult.get(rollDice));
		}
		
	}
}

