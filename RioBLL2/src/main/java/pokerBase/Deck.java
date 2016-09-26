package pokerBase;

import java.util.ArrayList;
import java.util.Collections;


import pokerEnums.eRank; 
import pokerEnums.eSuits;

public class Deck{
	ArrayList<Card> deck = new ArrayList<Card>();

	public Deck(){			//Fills the deck with cards
		int iCardNbr = 1;
		for (eSuits eSuit : eSuits.values()){
			for (eRank eRank : eRank.values())
				deck.add(new Card(eSuit, eRank, iCardNbr++));
		}
		
		Collections.shuffle(deck);		//Shuffles the deck
		
	}
	
	public Card Draw(){
		if (deck.size() ==0){		//Prevents from over overdrawing the deck
			return null;
		}
		return deck.remove(0);		//Draws a card from the shuffled deck
	}

	public int GetDeckSize(){
		return deck.size();			//Returns the size of the deck
	}
	
}

