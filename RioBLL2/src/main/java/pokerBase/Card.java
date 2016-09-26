package pokerBase;

import java.util.Comparator;

import pokerEnums.eRank;
import pokerEnums.eSuits;

public class Card {
	
	private eSuits eSuit;
	private eRank eRank;
	private int icardnum;
	
	public Card(pokerEnums.eSuits eSuit, pokerEnums.eRank eRank, int icardnum){
		this.eSuit = eSuit;
		this.eRank = eRank; 
		this.icardnum = icardnum;
		
	}
	
	public eSuits getCardSuit(){
		return eSuit;
	}
	
	public eRank geteRank(){
		return eRank;
	}
	
	public int getCardNo(){
		return icardnum;
	}
	
	public static Comparator<Card> CardRank = new Comparator<Card>() {

		public int compare(Card c1, Card c2) {

		   int Cno1 = c1.geteRank().getiRankNbr();
		   int Cno2 = c2.geteRank().getiRankNbr();

		   /*For descending order*/
		   return Cno2 - Cno1;

	   }};
	   
	public int compareTo(Object o) {
	    Card c = (Card) o; 
	    return c.geteRank().compareTo(this.geteRank()); 

	}

	
	
}
