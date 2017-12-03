package it.gixlg.spiralmemory;

public class Coordinates {

	private int x;
	private int y;

	public Coordinates(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Coordinates getMemoryCoordinatesFromChessboard(
			Coordinates chessboard, int side) {
		int x = chessboard.getX();
		int y = chessboard.getY();

		return new Coordinates(x - side, y - side);
	}

	public Coordinates getChessboardCoordinatesFromMemory(
			Coordinates chessboard, int side) {
		int x = chessboard.getX();
		int y = chessboard.getY();

		return new Coordinates(x + side, y + side);
	}

	public Coordinates getNewCoordinatesFromDirection(Direction direction) {
		Coordinates newCoordinates = null;
		switch (direction) {
		case LEFT:
			newCoordinates = new Coordinates(this.x - 1, this.y);
			break;
		case RIGHT:
			newCoordinates = new Coordinates(this.x + 1, this.y);
			break;
		case UP:
			newCoordinates = new Coordinates(this.x, this.y - 1);
			break;
		case DOWN:
			newCoordinates = new Coordinates(this.x, this.y + 1);
			break;

		}
		return newCoordinates;
	}
	
	public boolean equals(Coordinates coordinates) {
		if (coordinates.getX() != this.x) return false;
		if (coordinates.getY() != this.y) return false;
		return true;
	}

}
