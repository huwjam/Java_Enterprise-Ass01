

public class Book extends Media {

	private String author;
	private int noPages;
	
	public Book(String title, String author, int year, int rating, int noPages, Genre genre) {
		this.title = title;
		this.author = author;
		this.year = year;
		this.rating = rating;
		this.noPages = noPages;
		this.genre = genre;
	}
	
	public int getNoPages() {
		return noPages;
	}
	
	public String getAuthor() {
		return author;
	}
	
	@Override
	public String toString() {
		return (this.title + " by " + this.author + " price at = " + this.price);
	}
	
	// TODO complete the static factory of() method
	// Return a new object if the genre is correct, or throw an IllegalArgumentException with the message "Genre is invalid"
	public static Book of(String title, String author, int year, int rating, int noPages, Genre genre) {
		if (genre == null || !genre.isValidForBooks()) {
		    throw new IllegalArgumentException("Genre is invalid");
		}
	    return new Book(title, author, year, rating, noPages, genre);
	}
}

