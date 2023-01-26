

public class Movie extends Media {

	private String cast;
	private double duration;
	
	public Movie(String title, String cast, double duration, int year, int rating, Genre genre) {
		this.title = title;
		this.cast = cast;
		this.duration = duration;
		this.year = year;
		this.rating = rating;
		this.genre = genre;
	}
	
	public Movie() {
		// TODO Auto-generated constructor stub
	}

	public double getDuration() {
		return duration;
	}
	
	@Override
	public String toString() {
		return (this.title + " with " + this.cast + " price at = " + this.price);
	}

	// TODO complete the static factory of() method
	// Return a new object if the genre is correct, or throw an IllegalArgumentException with the message "Genre is invalid"
	public static Movie of(String title, String cast, double duration, int year, int rating, Genre genre) {
		if (genre == null || !genre.isValidForMovies()) {
	    throw new IllegalArgumentException("Genre is invalid");
	}
    return new Movie(title, cast, duration, year, rating, genre);
}
}
