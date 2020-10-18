import java.util.*;

public class LotteryGameMain {

	public static void main(String[] args) {


		/*
		 * GENERATE UNIQUE RANDOM NUMBERS The program generate 10 unique random numbers
		 * using the Random class
		 */
		Random rand = new Random();
		int[] arrayRandNumbers = new int[10];

		for (int i = 0; i < arrayRandNumbers.length; i++) {
			int randNumber = generateRandomNumber(rand);
			if (!isDuplicate(arrayRandNumbers, randNumber)) {
				arrayRandNumbers[i] = randNumber;
			} else {
				i--;
			}
		}
		System.out.println("Welcome to the new *Hacktoberfest* LOTTERY GAME!"
				+ "\n The lottery is divided in three games, are you ready to start?");
		System.out.println("press any letter and enter to continue");
		
		Scanner scan = new Scanner(System.in);

		System.out.println(" GAME 1) BONUS GAME: test your luck."
				+ "\nfour prizes will be drawn randomly. If two prizes match, you win!");

		/*
		 * BONUS GAME the program display four prizes sum that the user can win to the
		 * additional lottery winning the sums are generated based on specific
		 * probabilities if the same sum appears more than once the user wins that sum
		 */

		int[] arrayBonus = new int[4];

		System.out.println("\n" + "BONUS NUMBERS.");

		for (int i = 0; i < arrayBonus.length; i++) { // generate random numbers that will determine our probabilities
			float chance = rand.nextFloat() * 100;

			if (chance < 60.0) { // the sum 10 has 60% chance that will be displayed
				arrayBonus[i] = 10;
				System.out.println(arrayBonus[i] + " euro");
			} else if (chance < 80.0) { // the sum 20 has 20% chance that will be displayed
				arrayBonus[i] = 20;
				System.out.println(arrayBonus[i] + " euro");

			} else if (chance < 90.0) { // the sum 50 has 10% chance that will be displayed
				arrayBonus[i] = 50;
				System.out.println(arrayBonus[i] + " euro");

			} else if (chance < 97.5) { // the sum 200 has 7.5% chance that will be displayed
				arrayBonus[i] = 200;
				System.out.println(arrayBonus[i] + " euro");

			} else { // the sum 1000 will be displayed if the remaining 2.5% is generated (between
						// 97.5 and 100)
				arrayBonus[i] = 1000;
				System.out.println(arrayBonus[i] + " euro\n");
			}
		}

		int sumBonus = 0;
		for (int i = 0; i < arrayBonus.length; i++) {
			for (int j = i + 1; j < arrayBonus.length; j++) {
				if ((arrayBonus[i] == arrayBonus[j]) && (arrayBonus[i] != sumBonus)) {
					sumBonus += arrayBonus[i];
				}
			}
		}
		if (sumBonus == 0) {
			System.out.println("\nToday is not your day. You won: 0 euro");
		} else {
			System.out.println("\nYou are super lcuky today!! \n*****************\n You won " + sumBonus
					+ " euro\n*****************");
		}

	}

	/* METHOD: generate random integer number */
	public static int generateRandomNumber(Random rand) {
		return rand.nextInt(99) + 1;
	}

	/* METHOD: checks if random number is in the array */
	public static boolean isDuplicate(int[] array, int randNumber) {
		boolean isDuplicate = true;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == randNumber) {
				isDuplicate = true;
				break;
			} else {
				isDuplicate = false;
			}
		}
		return isDuplicate;
	}

	
}
