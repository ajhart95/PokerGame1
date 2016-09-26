/**
 * 
 */
package pokerBase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import pokerEnums.eRank;


public class DeckTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void BuildDeck(){
		Deck test_deck = new Deck();
		assertEquals(test_deck.GetDeckSize(), 52);
		
	}
	@Test
	public void DeckOverDraw()  {
		Card over_draw = null;
		Deck test_draw = new Deck();
		
		for(int i = 0; i< 54; i++){
			test_draw.Draw();
		}
		assertNull(test_draw.Draw());
	}
}
