public class Cell {
	private int pos;
	private String display;
	private LadderTop lt;
	private LadderBottom lb;
	private SnakeHead sh;
	private SnakeTail st;

	public LadderTop getLt() {
		return lt;
	}

	public LadderBottom getLb() {
		return lb;
	}

	public SnakeHead getSh() {
		return sh;
	}

	public SnakeTail getSt() {
		return st;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public Cell() {
		setDisplay("0");
	}

	public void initS() {
		sh = new SnakeHead();
	}

	public void initL() {
		lb = new LadderBottom();
	}
}
