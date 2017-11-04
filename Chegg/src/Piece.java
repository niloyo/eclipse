
abstract class Piece {
	
	Color color;

	public Piece(Color color) {
		super();
		this.color = color;
	}

	public Color getColor() {
		return color;
	}
	public abstract String algebricName();
	
	public abstract String fenName();
	
	public abstract Square[]  movesFrom(Square square);
	
	

}
