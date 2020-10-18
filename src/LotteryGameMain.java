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

		System.out.println(
				"\n\rGAME 2) GUESS WINNING NUMBERS \n Try to guess 5 out of the 10 winning numbers that will be drawn later in the game");

		/*
		 * USER INTERACTION The user is asked to enter 5 numbers if the input number was
		 * already entered the program ignores it and ask to enter a new number
		 */
		System.out.println("Enter 5 lucky numbers");
		System.out.println("\nwinning numbers");

		int[] userArray = new int[5];
		for (int i = 0; i < userArray.length; i++) {
			System.out.print((i + 1) + "> Enter " + " here: ");
			int userInput = scan.nextInt();
			userArray[i] = userInput;
		}

		int numbMatch = countMatches(userArray, arrayRandNumbers);

		System.out.println("\nLucky numbers");
		displayArray(userArray);
		System.out.println("\nwinning numbers");
		displayArray(arrayRandNumbers);

//MATCH NUMBERS
		/*
		 * WINNING PRIZES DEPENDING ON HOW MANY MATCHES depending on how many numbers
		 * the user matched, the user wins the following prizes
		 */
		System.out.println("\n\r" + "NUMBERS MATCHED");

		int sumMatch = 0;

		switch (numbMatch) {
		case 0:
			System.out.println("You didn't match any of the lottery numbers. You will be more lucky next time!");
			break;
		case 1:
			sumMatch = 100;
			System.out.println("Total numbers matched: " + numbMatch + ". Incredible! You won " + sumMatch + " euro");
			break;
		case 2:
			sumMatch = 200;
			System.out.println("Total numbers matched: " + numbMatch + ". Incredible! You won " + sumMatch + " euro");
			break;
		case 3:
			sumMatch = 300;
			System.out.println("Total numbers matched: " + numbMatch + ". Incredible! You won " + sumMatch + " euro");
			break;
		case 4:
			sumMatch = 400;
			System.out.println("Total numbers matched: " + numbMatch + ". Incredible! You won " + sumMatch + " euro");
			break;
		case 5:
			sumMatch = 500;
			System.out.println("Total numbers matched: " + numbMatch + ". Incredible! You won " + sumMatch + " euro");
			break;
		}
		
		System.out.println(
				"\n\r3) GUESS SUM of WINNING GAME \nlet's test your mathematical skills. Hei, do not cheat! Try to do this without calculator.");

		/*
		 * USER GUESS THE SUM OF THE INITIAL 10 RANDOM NUMBERS the program checks if the
		 * sum entered by the user is equal to the sum of all random numbers
		 */
		System.out.print("Guess what is the sum of the winning numbers: ");
		int guessSum = 0;
		int randNumbSum = sumNumbers(arrayRandNumbers);
		guessSum = scan.nextInt();

		if (randNumbSum == guessSum) {
			System.out.println("You guessed the the total sum of the winning numbers.Congrats, you won");
		} else {
			System.out.println("Nice try!. The sum was " + randNumbSum);
		}

		System.out.println("\n Thank you for playing with me");
		System.out.println("Made with <3 by Deborah");

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
	
	/* METHOD : display winning numbers (random numbers */
	public static void displayArray(int[] array) {
		for (int numbers : array) {
			System.out.print(numbers + " ");
		}
	}

	/* METHOD: sum the winning numbers */
	public static int sumNumbers(int[] array) {
		int sum = 0;
		for (int number : array) {
			sum += number;
		}
		return sum;

	}

	/* METHOD: check matches */
	public static int countMatches(int[] luckyArray, int[] winArray) {
		int matches = 0;
		for (int i = 0; i < winArray.length; i++) {
			for (int j = 0; j < luckyArray.length; j++) {
				if (winArray[i] == luckyArray[j]) {
					matches++;
				}
			}
		}
		return matches;
	}

}
