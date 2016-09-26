package pokerEnums;

public enum eCardPlace {FIRSTCARD(1), SECONDCARD(2), THIRDCARD(3), FOURTHCARD(4), FIFTHCARD(5);
	private int CardNo;
	
	eCardPlace(int CardPlace){
		this.CardNo = CardPlace;
	}
	public int getCardNo(){
		return CardNo;
	}
}
