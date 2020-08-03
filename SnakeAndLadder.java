import java.util.Random;

public class SnakeAndLadder {
	
	//Initializing Constant and Variable 
	int START_POSITION = 0;
	int noOFPLayers = 1;
	int position = START_POSITION;
	final int MAX_POSITION = 100;

	public static void main(String[] args) {
		SnakeAndLadder sl = new SnakeAndLadder();
		System.out.println("Players start position is "+ sl.START_POSITION);
		sl.game();
		System.out.println("Players final position is "+ sl.position);
	}
	
	//Here function game is used to run the game till the position reached maximum value   	
	private void game() {
		Random random = new Random();
		while(position != MAX_POSITION) {
			int diceRolled = this.rollDice();
			int options = random.nextInt(3); // To get the option where 0-NoPlay 1-Ladder 2-Sanke
			position = this.checkOption(options, diceRolled);
		}
	}
	
	 //Here the dice is rolled to get the value in between 1 to 6
	 private int rollDice() {
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
}

