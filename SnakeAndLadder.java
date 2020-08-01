import java.util.Random;

public class SnakeAndLadder {
	
	//Initializing Constant and Variable 
	int START_POSITION = 0;
	int noOfPlayer = 1;

	public static void main(String[] args) {
		SnakeAndLadder sl = new SnakeAndLadder();
		sl.rollDice();	
	}
	
	// Here player rolls a dice to get the number between 1 to 6
	private int rollDice() {
		Random random = new Random();
		int diceRolled = random.nextInt(6) + 1;
		return diceRolled;
	}
	
}

