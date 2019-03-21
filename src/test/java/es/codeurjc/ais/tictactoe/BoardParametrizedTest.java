package es.codeurjc.ais.tictactoe;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class BoardParametrizedTest {

	private Board board;
	enum Type {WIN, LOOSE};
	
	@Parameters(name="{index}")
	public static Collection<Object[]> data(){
		
	    Object[][] data = {
	    		{ 0,1,2,"X", Type.WIN},
	    		{ 0,4,8,"X", Type.WIN},
	    		{ 2,5,8,"X", Type.WIN},
	    		{ 0,2,4,"X", Type.LOOSE},
	    		{ 0,4,7,"Y", Type.LOOSE},
	    		{ 2,5,1,"X", Type.LOOSE}
	    		};
	    
	    return Arrays.asList(data);
	}
	
	@Parameter(0) public int cellId0;
	@Parameter(1) public int cellId1;
	@Parameter(2) public int cellId2;
	@Parameter(3) public String playerName;
	@Parameter(4) public Type type;
	
	
	@Before
	public void setUp() {
		board = new Board();		
	}
	
	
	@Test
	public void GivenBoardWithWinnerCombinaionAndPlayer_thenPlayerWins() {
		Assume.assumeTrue(type == Type.WIN);
		board.getCell(cellId0).value = playerName;
		board.getCell(cellId1).value = playerName;
		board.getCell(cellId2).value = playerName;
		assertNotNull("El jugador " + playerName + " debería de haber ganado!",board.getCellsIfWinner(playerName));
	}
	
	@Test
	public void GivenBoardFillWithWinnerX_thenWinnerXplayer() {
		Assume.assumeTrue(type == Type.LOOSE);
		board.getCell(cellId0).value = playerName;
		board.getCell(cellId1).value = playerName;
		board.getCell(cellId2).value = playerName;
		assertNull("El jugador " + playerName + " no debería de haber ganado!",board.getCellsIfWinner(playerName));
	}
}
