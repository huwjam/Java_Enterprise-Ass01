

abstract class Genre {
	// the superclass for our NotSpotify project
	// variable(s):
	//  price (double)
	// 
	// method(s):
	//  setPrice(int rating) - abstract method for genre sub-types
	double price = 0.0;
	abstract double setPrice(int rating);
	boolean isValidForSongs;
    public boolean isValidForSongs() {
        return isValidForSongs;
    }
    boolean isValidForMovies;
    public boolean isValidForMovies() {
        return isValidForMovies;
    }
    boolean isValidForBooks;
    public boolean isValidForBooks() {
        return isValidForBooks;
    }
}