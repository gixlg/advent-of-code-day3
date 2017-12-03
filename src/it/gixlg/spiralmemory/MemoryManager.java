package it.gixlg.spiralmemory;

import it.gixlg.spiralmemory.endstrategy.EndStrategy;
import it.gixlg.spiralmemory.fillstrategy.IncrementalStrategy;
import it.gixlg.spiralmemory.fillstrategy.FillStrategy;

public class MemoryManager {

	Coordinates currentLocation = null;
	Memory memory;
	FillStrategy fillStrategy;
	EndStrategy endStrategy;
	Direction direction = Direction.UP;

	public MemoryManager(Memory memory) {
		this.memory = memory;
	}

	public void setFillStrategy(FillStrategy fillStrategy) {
		this.fillStrategy = fillStrategy;
	}

	public void setEndStrategy(EndStrategy endStrategy) {
		this.endStrategy = endStrategy;
	}

	public void fillMemory(int num) throws Exception {
		Coordinates startPosition = new Coordinates(0, 0);
		memory.setMemoryValue(startPosition,
				fillStrategy.getValue(startPosition));

		currentLocation = startPosition;
		while (!endStrategy.isEnd(currentLocation)) {
			
			currentLocation = this.getNextPosition();
			int newValue = fillStrategy.getValue(currentLocation);
			memory.setMemoryValue(currentLocation, newValue);
			
		}
		memory.printMemory();
		System.out.println("The Manhattan Distance from origin is "
				+ getManhattanDistanceFromOrigin(currentLocation));
		System.out.println("The value is "
				+ memory.getMemoryValue(currentLocation));
	}

	public Coordinates getNextPosition() {
		Coordinates nextPosition = currentLocation
				.getNewCoordinatesFromDirection(direction);
		if (memory.isMemoryBlockEmpty(nextPosition)) {
			direction = direction.next();
			return nextPosition;
		} else {
			direction = direction.previous();
			return this.getNextPosition();
		}
	}

	public int getManhattanDistanceFromOrigin(Coordinates position) {
		int deltaX = position.getX();
		int deltaY = position.getY();
		return Math.abs(deltaX) + Math.abs(deltaY);
	}

}
