package it.gixlg.spiralmemory.endstrategy;

import it.gixlg.spiralmemory.Coordinates;
import it.gixlg.spiralmemory.Memory;

public class GreaterThanStrategyEnd implements EndStrategy {

	private Memory memory;
	private int numToStop;

	public GreaterThanStrategyEnd(Memory memory, int numToStop) {
		super();
		this.memory = memory;
		this.numToStop = numToStop;
	}

	@Override
	public boolean isEnd(Coordinates position) {
		return memory.getMemoryValue(position) > numToStop;
	}

}
