package pokerEnums;

public enum eSuits {
	DIAMONDS(1), HEARTS(2), SPADES(3), CLUBS(4);
	
	private int Suits;
	
	eSuits (int Suits){
		this.Suits = Suits;
	}
	
	public int getSuits(){
		return Suits;
	
	}
	
}
