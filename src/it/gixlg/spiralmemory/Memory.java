package it.gixlg.spiralmemory;

import it.gixlg.spiralmemory.fillstrategy.IncrementalStrategy;
import it.gixlg.spiralmemory.fillstrategy.FillStrategy;

public class Memory {
	
	int side;
	private int[][] memorySpace;
	
	public Memory(int side) {
		this.side = side;
		generateMemorySpace();
	}

	private  void generateMemorySpace() {
		memorySpace = new int[side][side];
	}
	
	public void setMemoryValue(Coordinates coordinates, int value) {
		Coordinates gridCoordinates = coordinates
				.getChessboardCoordinatesFromMemory(coordinates, this.side / 2);
		int x = gridCoordinates.getX();
		int y = gridCoordinates.getY();
		memorySpace[y][x] = value;
	}

	public int getMemoryValue(Coordinates coordinates) {
		Coordinates gridCoordinates = coordinates
				.getChessboardCoordinatesFromMemory(coordinates, this.side / 2);
		int x = gridCoordinates.getX();
		int y = gridCoordinates.getY();
		return memorySpace[y][x];
	}

	public void printMemory() {
		for (int i = 0; i < side; i++) {
			for (int j = 0; j < side; j++) {
				System.out.printf("%5d ", memorySpace[i][j]);
			}
			System.out.println();
		}
	}
	
	boolean isMemoryBlockEmpty(Coordinates coordinates){
		return getMemoryValue(coordinates) == 0;
	}

}
