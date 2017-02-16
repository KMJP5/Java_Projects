import java.util.Random;
import java.util.Scanner;

public class Game {
	Scanner input = new Scanner(System.in);

	private Cell[] board;
	private int ladderNum;
	private int snakeNum;
	private Random r = new Random();

	public Game(int l, int s) {
		ladderNum = l;
		snakeNum = s;
		board = new Cell[100];
		for (int i = 0; i < board.length; i++) {
			board[i] = new Cell();
		}
	}

	private void setLadderPos() {
		int top = 0;
		int bot = 0;
		for (int i = 0; i < ladderNum; i++) {
			System.out.print("Ladder Top Position: ");
			top = input.nextInt();

			System.out.print("Ladder Bottom Position: ");
			bot = input.nextInt();
			board[bot].initL();
			board[bot].getLb().setPos(bot);
			board[bot].getLb().getLt().setPos(top);
		}
	}

	private void setSnakePos() {
		int head = 0;
		int tail = 0;
		for (int i = 0; i < snakeNum; i++) {
			System.out.print("Snake Head Position: ");
			head = input.nextInt();

			System.out.print("Snake Tail Position: ");
			tail = input.nextInt();
			board[head].initS();
			board[head].getSh().setPos(head);
			board[head].getSh().getSt().setPos(tail);
		}
	}

	public void newGame() {
		String action = null;
		int move = 0;
		int p1Current = -1;
		int p2Current = -1;
		int p1New = 0;
		int p2New = 0;
		int pos = 0;
		
		setLadderPos();
		setSnakePos();

		System.out.println("Action: ");
		action = input.next();
		while (!action.equals("exit")) {

			switch (action) {

			case "r1":
				move = r.nextInt(6) + 1;
				p1New = move + p1Current;

				if (p1Current != -1)
					board[p1Current].setDisplay("0");

				if (board[p1New].getLb() != null) {
					pos = board[p1New].getLb().getLt().getPos();
					// //
					if (board[pos].getDisplay().equals("2"))
						p2Current = -1;
					// //
					board[pos].setDisplay("1");
					p1Current = pos;

				} else if (board[p1New].getSh() != null) {
					pos = board[p1New].getSh().getSt().getPos();
					// //
					if (board[pos].getDisplay().equals("2"))
						p2Current = -1;
					// //
					board[pos].setDisplay("1");
					p1Current = pos;

				} else {
					// //
					if (board[p1New].getDisplay().equals("2"))
						p2Current = -1;
					// //
					board[p1New].setDisplay("1");
					p1Current = p1New;
				}

				System.out.println(move);

				if (checkWinner(p1Current)) {
					System.out.println("Player 1 Won!");
					print();
					action = "exit";
					break;
				}

				break;

			case "r2":
				move = r.nextInt(6) + 1;
				p2New = move + p2Current;

				if (p2Current != -1)
					board[p2Current].setDisplay("0");

				if (board[p2New].getLb() != null) {
					pos = board[p2New].getLb().getLt().getPos();
					// //
					if (board[pos].getDisplay().equals("1"))
						p1Current = -1;
					// //
					board[pos].setDisplay("2");
					p2Current = pos;

				} else if (board[p2New].getSh() != null) {
					pos = board[p2New].getSh().getSt().getPos();
					// //
					if (board[pos].getDisplay().equals("1"))
						p1Current = -1;
					// //
					board[pos].setDisplay("2");
					p2Current = pos;

				} else {
					// //
					if (board[p2New].getDisplay().equals("1"))
						p1Current = -1;
					// //
					board[p2New].setDisplay("2");
					p2Current = p2New;
				}
				System.out.println(move);

				if (checkWinner(p2Current)) {
					System.out.println("Player 2 Won!");
					print();
					action = "exit";
					break;
				}

				break;

			case "print":
				print();
				break;

			case "exit":
				break;

			default:
				continue;
			}

			System.out.println("Action: ");
			action = input.next();
		}
	}

	public void print() {
		int k = 90;
		for (int i = 0; i < 10; i++) {
			System.out.printf("\t");
			for (int j = k; j < 10 + k; j++) {
				System.out.printf("%s ", board[j].getDisplay());
			}
			k -= 10;
			System.out.println();
		}
	}

	public boolean checkWinner(int pos) {
		if (pos == 99)
			return true;
		else
			return false;
	}
}
