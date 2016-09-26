package pokerBase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import pokerEnums.eRank;
import pokerEnums.eSuits;
import pokerEnums.eCardPlace;
import pokerEnums.eHandStrength;

public class Hand {
	
	private UUID HandID;
	private Boolean bScored;
	
	private static ArrayList<Card> CardsInHand;
	Deck test = new Deck();
	
	public Hand(){		//Draws five cards from deck
		for (int i = 0; i<5; i++){
			CardsInHand.add(test.Draw());
		}
	
	}
	public ArrayList<Card> getCardsInHand(){		//Sorts the cards in the hand in order to evaluate the hand
		Collections.sort(CardsInHand, Card.CardRank);
		return CardsInHand;
	}

	private int setHandStrength(int handStrength) {
		return handStrength;
	}
	
	private static boolean isHandFlush(Hand h, HandScore hs) {		//Evaluates the hand for a flush
		boolean bIsFlush = false;
		if (h.getCardsInHand().get(eCardPlace.FIRSTCARD.getCardNo()).getCardSuit() == h.getCardsInHand()
				.get(eCardPlace.SECONDCARD.getCardNo()).getCardSuit() && h.getCardsInHand().get(eCardPlace.FIRSTCARD.getCardNo()).getCardSuit() == h.getCardsInHand()
						.get(eCardPlace.THIRDCARD.getCardNo()).getCardSuit() && h.getCardsInHand().get(eCardPlace.FIRSTCARD.getCardNo()).getCardSuit() == h.getCardsInHand()
								.get(eCardPlace.FOURTHCARD.getCardNo()).getCardSuit() && h.getCardsInHand().get(eCardPlace.FIRSTCARD.getCardNo()).getCardSuit() == h.getCardsInHand()
										.get(eCardPlace.FIFTHCARD.getCardNo()).getCardSuit()) {
			bIsFlush = true;
			hs.setHandStrength(eHandStrength.Flush.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardPlace.FIRSTCARD.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(null);
			hs.setKickers(kickers);

		}
		return bIsFlush;
	}

	private static boolean isStraight(Hand h, HandScore hs) { 		//Evaluates the hand for a straight
		boolean bIsStraight = false;
		if (h.getCardsInHand().get(eCardPlace.FIRSTCARD.getCardNo()).geteRank().getiRankNbr() == h.getCardsInHand()
				.get(eCardPlace.SECONDCARD.getCardNo()).geteRank().getiRankNbr() + 1 && h.getCardsInHand().get(eCardPlace.FIRSTCARD.getCardNo()).geteRank().getiRankNbr() == h.getCardsInHand()
				.get(eCardPlace.THIRDCARD.getCardNo()).geteRank().getiRankNbr() + 2 && h.getCardsInHand().get(eCardPlace.FIRSTCARD.getCardNo()).geteRank().getiRankNbr() == h.getCardsInHand()
				.get(eCardPlace.FOURTHCARD.getCardNo()).geteRank().getiRankNbr() + 3 && h.getCardsInHand().get(eCardPlace.FIRSTCARD.getCardNo()).geteRank().getiRankNbr() == h.getCardsInHand()
				.get(eCardPlace.FIFTHCARD.getCardNo()).geteRank().getiRankNbr() + 4) {
			bIsStraight = true;
			hs.setHandStrength(eHandStrength.Straight.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardPlace.FIFTHCARD.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(null);
			hs.setKickers(kickers);
		}
		
		else if (h.getCardsInHand().get(eCardPlace.FIFTHCARD.getCardNo()).geteRank() == eRank.ACE
				&& h.getCardsInHand().get(eCardPlace.FIRSTCARD.getCardNo()).geteRank() == eRank.TWO
				&& h.getCardsInHand().get(eCardPlace.SECONDCARD.getCardNo()).geteRank() == eRank.THREE
				&& h.getCardsInHand().get(eCardPlace.THIRDCARD.getCardNo()).geteRank() == eRank.FOUR
				&& h.getCardsInHand().get(eCardPlace.FOURTHCARD.getCardNo()).geteRank() == eRank.FIVE) {
			
			bIsStraight = true;
			hs.setHandStrength(eHandStrength.Straight.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardPlace.FOURTHCARD.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(null);
			hs.setKickers(kickers);
				

		}

		return bIsStraight;
	}

	public static boolean isHandRoyalFlush(Hand h, HandScore hs) {		//Evaluates the hand for a royal flush

		boolean isRoyalFlush = false;
		
		if (h.getCardsInHand().get(eCardPlace.FIRSTCARD.getCardNo()).geteRank() == eRank.TEN
				&& h.getCardsInHand().get(eCardPlace.SECONDCARD.getCardNo()).geteRank() == eRank.JACK
				&& h.getCardsInHand().get(eCardPlace.THIRDCARD.getCardNo()).geteRank() == eRank.QUEEN
				&& h.getCardsInHand().get(eCardPlace.FOURTHCARD.getCardNo()).geteRank() == eRank.KING
				&& h.getCardsInHand().get(eCardPlace.FIFTHCARD.getCardNo()).geteRank() == eRank.ACE
				
				&& h.getCardsInHand().get(eCardPlace.FIRSTCARD.getCardNo()).getCardSuit() == h.getCardsInHand() .get(eCardPlace.SECONDCARD.getCardNo()).getCardSuit() 
				&& h.getCardsInHand().get(eCardPlace.FIRSTCARD.getCardNo()).getCardSuit() == h.getCardsInHand().get(eCardPlace.THIRDCARD.getCardNo()).getCardSuit() 
				&& h.getCardsInHand().get(eCardPlace.FIRSTCARD.getCardNo()).getCardSuit() == h.getCardsInHand().get(eCardPlace.FOURTHCARD.getCardNo()).getCardSuit() 
				&& h.getCardsInHand().get(eCardPlace.FIRSTCARD.getCardNo()).getCardSuit() == h.getCardsInHand().get(eCardPlace.FIFTHCARD.getCardNo()).getCardSuit())
		{
			isRoyalFlush = true;
			hs.setHandStrength(eHandStrength.RoyalFlush.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardPlace.FIFTHCARD.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(null);
			hs.setKickers(kickers);
		}
		
		return isRoyalFlush;
	}

	public static boolean isHandStraightFlush(Hand h, HandScore hs) {		//Evaluates the hand for a straight flush
		boolean isStraightFlush = false;

		if (h.getCardsInHand().get(eCardPlace.FIRSTCARD.getCardNo()).geteRank().getiRankNbr() == h.getCardsInHand().get(eCardPlace.SECONDCARD.getCardNo()).geteRank().getiRankNbr() + 1 
				&& h.getCardsInHand().get(eCardPlace.FIRSTCARD.getCardNo()).geteRank().getiRankNbr() == h.getCardsInHand().get(eCardPlace.THIRDCARD.getCardNo()).geteRank().getiRankNbr() + 2 
				&& h.getCardsInHand().get(eCardPlace.FIRSTCARD.getCardNo()).geteRank().getiRankNbr() == h.getCardsInHand().get(eCardPlace.FOURTHCARD.getCardNo()).geteRank().getiRankNbr() + 3 
				&& h.getCardsInHand().get(eCardPlace.FIRSTCARD.getCardNo()).geteRank().getiRankNbr() == h.getCardsInHand().get(eCardPlace.FIFTHCARD.getCardNo()).geteRank().getiRankNbr() + 4
				
				&& h.getCardsInHand().get(eCardPlace.FIRSTCARD.getCardNo()).getCardSuit() == h.getCardsInHand() .get(eCardPlace.SECONDCARD.getCardNo()).getCardSuit() 
				&& h.getCardsInHand().get(eCardPlace.FIRSTCARD.getCardNo()).getCardSuit() == h.getCardsInHand().get(eCardPlace.THIRDCARD.getCardNo()).getCardSuit() 
				&& h.getCardsInHand().get(eCardPlace.FIRSTCARD.getCardNo()).getCardSuit() == h.getCardsInHand().get(eCardPlace.FOURTHCARD.getCardNo()).getCardSuit() 
				&& h.getCardsInHand().get(eCardPlace.FIRSTCARD.getCardNo()).getCardSuit() == h.getCardsInHand().get(eCardPlace.FIFTHCARD.getCardNo()).getCardSuit())
		{
			isStraightFlush = true;
			hs.setHandStrength(eHandStrength.StraightFlush.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardPlace.FIFTHCARD.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(null);
			hs.setKickers(kickers);
		}
		
		return isStraightFlush;
	}

	public static boolean isHandFourOfAKind(Hand h, HandScore hs) {		//Evaluates the hand for a four of a kind

		boolean bHandCheck = false;

		if (h.getCardsInHand().get(eCardPlace.FIRSTCARD.getCardNo()).geteRank() == h.getCardsInHand()
				.get(eCardPlace.FOURTHCARD.getCardNo()).geteRank()) {
			bHandCheck = true;
			hs.setHandStrength(eHandStrength.FourOfAKind.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardPlace.FIRSTCARD.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(eCardPlace.FIFTHCARD.getCardNo()));
			hs.setKickers(kickers);

		} else if (h.getCardsInHand().get(eCardPlace.SECONDCARD.getCardNo()).geteRank() == h.getCardsInHand()
				.get(eCardPlace.FIFTHCARD.getCardNo()).geteRank()) {
			bHandCheck = true;
			hs.setHandStrength(eHandStrength.FourOfAKind.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardPlace.SECONDCARD.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(eCardPlace.FIRSTCARD.getCardNo()));
			hs.setKickers(kickers);
		}

		return bHandCheck;
	}

	public static boolean isHandFullHouse(Hand h, HandScore hs) {		//Evaluates the hand for a full house

		boolean isFullHouse = false;
		
		if (h.getCardsInHand().get(eCardPlace.FIRSTCARD.getCardNo()).geteRank() == h.getCardsInHand()
				.get(eCardPlace.THIRDCARD.getCardNo()).geteRank() && h.getCardsInHand().get(eCardPlace.FOURTHCARD.getCardNo()).geteRank() == h.getCardsInHand()
						.get(eCardPlace.FIFTHCARD.getCardNo()).geteRank()) {
			isFullHouse = true;
			hs.setHandStrength(eHandStrength.FullHouse.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardPlace.FIRSTCARD.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(h.getCardsInHand().get(eCardPlace.FOURTHCARD.getCardNo()).geteRank().getiRankNbr());
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(null);
			hs.setKickers(kickers);
		}
		
		if (h.getCardsInHand().get(eCardPlace.FIRSTCARD.getCardNo()).geteRank() == h.getCardsInHand()
				.get(eCardPlace.SECONDCARD.getCardNo()).geteRank() && h.getCardsInHand().get(eCardPlace.THIRDCARD.getCardNo()).geteRank() == h.getCardsInHand()
						.get(eCardPlace.FIFTHCARD.getCardNo()).geteRank()) {
			isFullHouse = true;
			hs.setHandStrength(eHandStrength.FullHouse.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardPlace.FOURTHCARD.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(h.getCardsInHand().get(eCardPlace.FIRSTCARD.getCardNo()).geteRank().getiRankNbr());
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(null);
			hs.setKickers(kickers);
		}
		
		return isFullHouse;

	}


	public static boolean isHandThreeOfAKind(Hand h, HandScore hs) {		//Evaluates the hand for a three of a kind

		boolean isThreeOfAKind = false;
		
		if (h.getCardsInHand().get(eCardPlace.FIRSTCARD.getCardNo()).geteRank() == h.getCardsInHand()
				.get(eCardPlace.THIRDCARD.getCardNo()).geteRank()) {
			isThreeOfAKind = true;
			hs.setHandStrength(eHandStrength.ThreeOfAKind.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardPlace.FIRSTCARD.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(eCardPlace.FIFTHCARD.getCardNo()));
			hs.setKickers(kickers);

		} else if (h.getCardsInHand().get(eCardPlace.SECONDCARD.getCardNo()).geteRank() == h.getCardsInHand()
				.get(eCardPlace.FOURTHCARD.getCardNo()).geteRank()) {
			isThreeOfAKind = true;
			hs.setHandStrength(eHandStrength.ThreeOfAKind.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardPlace.SECONDCARD.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(eCardPlace.FIFTHCARD.getCardNo()));
			hs.setKickers(kickers);
		}
		
		else if (h.getCardsInHand().get(eCardPlace.THIRDCARD.getCardNo()).geteRank() == h.getCardsInHand()
				.get(eCardPlace.FIFTHCARD.getCardNo()).geteRank()) {
			isThreeOfAKind = true;
			hs.setHandStrength(eHandStrength.ThreeOfAKind.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardPlace.THIRDCARD.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(eCardPlace.SECONDCARD.getCardNo()));
			hs.setKickers(kickers);
		}
		return isThreeOfAKind;
	}

	public static boolean isHandTwoPair(Hand h, HandScore hs) {		//Evaluates the hand for a two pair

		boolean isTwoPair = false;
		
		if (h.getCardsInHand().get(eCardPlace.FIRSTCARD.getCardNo()).geteRank() == h.getCardsInHand()
				.get(eCardPlace.SECONDCARD.getCardNo()).geteRank() && h.getCardsInHand().get(eCardPlace.THIRDCARD.getCardNo()).geteRank() == h.getCardsInHand()
						.get(eCardPlace.FOURTHCARD.getCardNo()).geteRank()) {
			isTwoPair = true;
			hs.setHandStrength(eHandStrength.TwoPair.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardPlace.FIRSTCARD.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(eCardPlace.FIFTHCARD.getCardNo()));
			hs.setKickers(kickers);

		} else if (h.getCardsInHand().get(eCardPlace.SECONDCARD.getCardNo()).geteRank() == h.getCardsInHand()
				.get(eCardPlace.THIRDCARD.getCardNo()).geteRank() && h.getCardsInHand().get(eCardPlace.FOURTHCARD.getCardNo()).geteRank() == h.getCardsInHand()
						.get(eCardPlace.FIFTHCARD.getCardNo()).geteRank()) {
			isTwoPair = true;
			hs.setHandStrength(eHandStrength.TwoPair.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardPlace.FOURTHCARD.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(eCardPlace.FIRSTCARD.getCardNo()));
			hs.setKickers(kickers);
		}
		
		else if (h.getCardsInHand().get(eCardPlace.FIRSTCARD.getCardNo()).geteRank() == h.getCardsInHand()
				.get(eCardPlace.SECONDCARD.getCardNo()).geteRank() && h.getCardsInHand().get(eCardPlace.FOURTHCARD.getCardNo()).geteRank() == h.getCardsInHand()
						.get(eCardPlace.FIFTHCARD.getCardNo()).geteRank()) {
			isTwoPair = true;
			hs.setHandStrength(eHandStrength.TwoPair.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardPlace.FIFTHCARD.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(eCardPlace.THIRDCARD.getCardNo()));
			hs.setKickers(kickers);
		}
		return isTwoPair;
	}

	public static boolean isHandPair(Hand h, HandScore hs) {	//Evaluates the hand for a pair
		boolean isPair = false;
		
		if (h.getCardsInHand().get(eCardPlace.FIRSTCARD.getCardNo()).geteRank() == h.getCardsInHand()
				.get(eCardPlace.SECONDCARD.getCardNo()).geteRank()) {
			isPair = true;
			hs.setHandStrength(eHandStrength.Pair.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardPlace.FIRSTCARD.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(eCardPlace.FIFTHCARD.getCardNo()));
			hs.setKickers(kickers);
		}
		
		if (h.getCardsInHand().get(eCardPlace.SECONDCARD.getCardNo()).geteRank() == h.getCardsInHand()
				.get(eCardPlace.THIRDCARD.getCardNo()).geteRank()) {
			isPair = true;
			hs.setHandStrength(eHandStrength.Pair.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardPlace.SECONDCARD.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(eCardPlace.FIFTHCARD.getCardNo()));
			hs.setKickers(kickers);
		}
		
		if (h.getCardsInHand().get(eCardPlace.THIRDCARD.getCardNo()).geteRank() == h.getCardsInHand()
				.get(eCardPlace.FOURTHCARD.getCardNo()).geteRank()) {
			isPair = true;
			hs.setHandStrength(eHandStrength.Pair.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardPlace.THIRDCARD.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(eCardPlace.FIFTHCARD.getCardNo()));
			hs.setKickers(kickers);
		}
		
		if (h.getCardsInHand().get(eCardPlace.FOURTHCARD.getCardNo()).geteRank() == h.getCardsInHand()
				.get(eCardPlace.FIFTHCARD.getCardNo()).geteRank()) {
			isPair = true;
			hs.setHandStrength(eHandStrength.Pair.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardPlace.FOURTHCARD.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(eCardPlace.THIRDCARD.getCardNo()));
			hs.setKickers(kickers);
		}
		
		return isPair;
	}
																			//Evaluates the hand for a high card
	public static boolean isHandHighCard(Hand h, HandScore hs) {			//Always returns true because there is always a high card
		hs.setHandStrength(eHandStrength.HighCard.getHandStrength());
		hs.setHiHand(h.getCardsInHand().get(eCardPlace.FIFTHCARD.getCardNo()).geteRank().getiRankNbr());
		hs.setLoHand(0);
		ArrayList<Card> kickers = new ArrayList<Card>();
		kickers.add(h.getCardsInHand().get(eCardPlace.FOURTHCARD.getCardNo()));
		hs.setKickers(kickers);	
		return true;
		
	}
	
	
}
