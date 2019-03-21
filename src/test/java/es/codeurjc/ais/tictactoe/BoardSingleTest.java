package es.codeurjc.ais.tictactoe;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BoardSingleTest {
	
	private Board board;
	private final int numberOfCells = 9;
	
	@BeforeClass
	public static void message() {
		System.out.println("Ejecutando BoardSingle test.\n" + 
	                       "Sólo quería recordar los BeforeClass");
	}
	
	
	@Before
	public void setup() {
		board = new Board();
	}
	
	@Test
	public void GivenBoard_whenEnableAllCells_thenAllCellsEnabled() {
		board.enableAll();
		for (int i = 0; i < numberOfCells; i++) {
			assertTrue(board.getCell(i).active);
		}
	}
	
	@Test
	public void GivenBoard_whenDisableAllCells_thenAllCellsDisabled() {
		board.disableAll();
		for (int i = 0; i < numberOfCells; i++) {
			assertFalse(board.getCell(i).active);
		}
	}
	
	@Test
	public void GivenBoard_whenAllCellsDrawn_thenCheckDrawn() {
		for (int i = 0; i < numberOfCells; i++) {
			board.getCell(i).value = "X";
		}
		assertTrue(board.checkDraw());
	}
	@Test
	public void GivenBoard_whenNoneCellsDrawn_thenCheckDrawnFalse() {
		assertFalse(board.checkDraw());
	}

}
