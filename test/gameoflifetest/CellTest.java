package gameoflifetest;

import gameoflife.Cell;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CellTest {
	static Cell cell;
	@Test
	void getStatusTest() {
		cell = new Cell((double)5, (double)5, 3, 1);
		assertEquals(Cell.Status.DEAD,cell.getStatus());
	}

}
