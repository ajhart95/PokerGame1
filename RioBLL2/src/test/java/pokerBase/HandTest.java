package pokerBase;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import pokerEnums.eSuits;
import pokerEnums.eRank;

public class HandTest {

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

	}
	
	@Test
	public void TestRoyalFlush() {	
		HandScore hs = new HandScore();
		ArrayList<Card> RoyalFlush = new ArrayList<Card>();
		RoyalFlush.add(new Card(eSuits.DIAMONDS, eRank.ACE, 0));
		RoyalFlush.add(new Card(eSuits.DIAMONDS, eRank.KING, 0));
		RoyalFlush.add(new Card(eSuits.DIAMONDS, eRank.QUEEN, 0));
		RoyalFlush.add(new Card(eSuits.DIAMONDS, eRank.JACK, 0));
		RoyalFlush.add(new Card(eSuits.DIAMONDS, eRank.TEN, 0));
		Collections.sort(RoyalFlush, Card.CardRank);
		
		Hand h = new Hand();									//I cannot get this error to go away. The ArraryList<Card> 
		assertTrue (h.isHandRoyalFlush(RoyalFlush, hs));			//type and Hand type in Hand.java don't match. Following 
																					//tests contain same error
				
	}
	@Test
	public void TestFourOfAKind() {	
		HandScore hs = new HandScore();
		ArrayList<Card> FourOfAKind = new ArrayList<Card>();
		FourOfAKind.add(new Card(eSuits.DIAMONDS, eRank.ACE, 0));
		FourOfAKind.add(new Card(eSuits.HEARTS, eRank.ACE, 0));
		FourOfAKind.add(new Card(eSuits.CLUBS, eRank.ACE, 0));
		FourOfAKind.add(new Card(eSuits.SPADES, eRank.ACE, 0));
		FourOfAKind.add(new Card(eSuits.SPADES, eRank.TEN, 0));
		Collections.sort(FourOfAKind, Card.CardRank);
		
		Hand h = new Hand();
		assertTrue (h.isHandFourOfAKind(FourOfAKind, hs));
		
	}
	@Test
	public void TestStraightFlush() {	
		HandScore hs = new HandScore();
		ArrayList<Card> StraightFlush = new ArrayList<Card>();
		StraightFlush.add(new Card(eSuits.DIAMONDS, eRank.NINE, 0));
		StraightFlush.add(new Card(eSuits.DIAMONDS, eRank.EIGHT, 0));
		StraightFlush.add(new Card(eSuits.DIAMONDS, eRank.QUEEN, 0));
		StraightFlush.add(new Card(eSuits.DIAMONDS, eRank.JACK, 0));
		StraightFlush.add(new Card(eSuits.DIAMONDS, eRank.TEN, 0));
		Collections.sort(StraightFlush, Card.CardRank);
		
		Hand h = new Hand();
		assertTrue (h.isHandStraightFlush(StraightFlush, hs));
	}
	
}
