package it.gixlg.spiralmemory;

public enum Direction {
	RIGHT, UP, LEFT, DOWN;

	public Direction next() {
		Direction next = null;
		switch (this) {
		case LEFT:
			next = DOWN;
			break;
		case RIGHT:
			next = UP;
			break;
		case UP:
			next = LEFT;
			break;
		case DOWN:
			next = RIGHT;
			break;

		}
		return next;
	}

	public Direction previous() {
		Direction previous = null;
		switch (this) {
		case DOWN:
			previous = LEFT;
			break;
		case UP:
			previous = RIGHT;
			break;
		case LEFT:
			previous = UP;
			break;
		case RIGHT:
			previous = DOWN;
			break;

		}
		return previous;
	}
}
