import java.util.Random;

public class SnakeAndLadder {
	
	//Initializing
	//CONSTANT 
	int START_POSITION = 0;
	int NO_OF_PLAYER = 1;
	//Variable
	int position = START_POSITION;

	public static void main(String[] args) {
		
		SnakeAndLadder sl = new SnakeAndLadder();
		sl.checkOption();
	}
	
	 //Here the dice is rolled to get the value in between 1 to 6
	 private int rollDice() {
		Random random = new Random();
		int diceRolled = random.nextInt(6) + 1;
		return diceRolled;
	 }
	
	//Here the function checkOption is used to get Option
	 	/*
	 	 * 0- Noplay
	 	 * 1- Ladder
	 	 * 2- Snake
	 	 */
	private void checkOption() {
		
		int diceRolled = this.rollDice();
		Random random = new Random();
		int options = random.nextInt(3);
		
		switch(options) {
		case 0:
			System.out.println("There is NOPLAY for the player..");
			break ;		
		case 1:
				position = position + diceRolled;
				break ;
		case 2:
				position = position - diceRolled;
				if(position < 0) {
					position = 0;
					System.out.println(position);
				} else {
					System.out.println(position);
				}
				break ;
		}
	}
}

