package it.gixlg.spiralmemory;

import it.gixlg.spiralmemory.endstrategy.EqualToStrategyEnd;
import it.gixlg.spiralmemory.endstrategy.GreaterThanStrategyEnd;
import it.gixlg.spiralmemory.fillstrategy.IncrementalStrategy;
import it.gixlg.spiralmemory.fillstrategy.SumNeighborsStrategy;

public class Main {

	static final int PUZZLE_INPUT = 277678;

	public static void main(String[] args) throws Exception {
		double sqrt = Math.sqrt(PUZZLE_INPUT);
		int side = (int) Math.ceil(sqrt);
		
		Memory memory = new Memory(side);
		
		MemoryManager memoryManager = new MemoryManager(memory);
		//memoryManager.setFillStrategy(new IncrementalStrategy());							//PART 1
		memoryManager.setFillStrategy(new SumNeighborsStrategy(memory));					//PART 2

		//memoryManager.setEndStrategy(new EqualToStrategyEnd(memory, PUZZLE_INPUT));		//PART 1
		memoryManager.setEndStrategy(new GreaterThanStrategyEnd(memory, PUZZLE_INPUT));		//PART 2

		memoryManager.fillMemory(PUZZLE_INPUT);

	}

}
