import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Number Of Ladders: ");
		int numLadder = input.nextInt();

		System.out.print("Number Of Snakes: ");
		int numSnake = input.nextInt();

		Game play = new Game(numLadder, numSnake);
		play.newGame();
		input.close();
	}

}
