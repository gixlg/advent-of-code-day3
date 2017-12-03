package it.gixlg.spiralmemory.fillstrategy;

import it.gixlg.spiralmemory.Coordinates;
import it.gixlg.spiralmemory.Memory;

public class SumNeighborsStrategy implements FillStrategy {

	private Memory memory;
	private static final Coordinates ORIGIN = new Coordinates(0, 0);

	public SumNeighborsStrategy(Memory memory) {
		super();
		this.memory = memory;
	}

	@Override
	public int getValue(Coordinates position) {
		if (position.equals(ORIGIN))
			return 1;
		return getNeighborsSum(position);
	}

	private int getNeighborsSum(Coordinates position) {
		int x = position.getX();
		int y = position.getY();
		int sum = 0;
		for (int j = -1; j <= 1; j++)
			for (int i = -1; i <= 1; i++) {
				if (i != 0 || j != 0){
					sum += memory.getMemoryValue(new Coordinates(x+i, y+j));;
				}
			}
		return sum;
	}

}
