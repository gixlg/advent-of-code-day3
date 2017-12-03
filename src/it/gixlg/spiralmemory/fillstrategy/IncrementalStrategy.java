package it.gixlg.spiralmemory.fillstrategy;

import it.gixlg.spiralmemory.Coordinates;

public class IncrementalStrategy implements FillStrategy {

	private int counter = 1;

	@Override
	public int getValue(Coordinates position) {
		return counter++;
	}
}
