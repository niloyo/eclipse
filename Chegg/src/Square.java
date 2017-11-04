
public class Square {
	private char file;
	private char rank;
	 public Square(char file, char rank){
		 this.file = file;
		 this.rank = rank;
	 }
	 
	 public Square(String name) {
		 
	 }
	 
	 public String toString() {
		 
		 return null;
	 }
	 
	 public Boolean equals(Square second) {
		 
		 if(second.getFile() == file && second.getRank() == rank) return true;
		 
		 return false;
		 
	 }

	public char getFile() {
		return file;
	}

	public void setFile(char file) {
		this.file = file;
	}

	public char getRank() {
		return rank;
	}

	public void setRank(char rank) {
		this.rank = rank;
	}
}
