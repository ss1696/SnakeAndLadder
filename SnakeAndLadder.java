import java.util.Random;

public class SnakeAndLadder {
	
	//Initializing
	//CONSTANT 
	int START_POSITION = 0;
	int NO_OF_PLAYER = 1;

	public static void main(String[] args) {
	
		//Here the dice is rolled to get the value in between 1 to 6
		Random random = new Random();
		int diceRolled = random.nextInt(6) + 1;
		System.out.println("Player got "+diceRolled);		
	}

}

