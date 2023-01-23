
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MyMedia {
	private List<Movie> movieList = new ArrayList<>();
	private List<Book> bookList = new ArrayList<>();
	private List<Song> songList = new ArrayList<>();
	
	public MyMedia(List<Movie> listM, List<Book> listB, List<Song> listS) {
		this.movieList = listM;
		this.bookList = listB;
		this.songList = listS;
	}
	
	@Override
	public String toString() {
		String stringAll = "";
		
		List<Media> masterList = new ArrayList<>();
		masterList.addAll(movieList);
		masterList.addAll(bookList);
		masterList.addAll(songList);
		
		for (Media m : masterList) {
			stringAll += m.toString() + "\n";
		}
				
		return stringAll;
	}
	
	public List<?> sort(String orderType) {
		
		List<Media> masterList = new ArrayList<>();
		masterList.addAll(movieList);
		masterList.addAll(bookList);
		masterList.addAll(songList);
		
		Comparator<Media> compareByPrice = Comparator.comparing(Media::getPrice);
		Comparator<Media> compareByRating = Comparator.comparing(Media::getRating);
		Comparator<Media> compareByTitle = Comparator.comparing(Media::getTitle);
		Comparator<Movie> compareByDuration = Comparator.comparing(Movie::getDuration);
		Comparator<Book> compareByPages = Comparator.comparing(Book::getNoPages);
		Comparator<Song> compareByArtist = Comparator.comparing(Song::getArtist);
		Comparator<Book> compareByAuthor = Comparator.comparing(Book::getAuthor);

		
		// TODO add new Comparator object to compare author and artist
		// Make sure that you have the relevant getters for the method reference (add if necessary)
		
		
		// TODO complete the switch statement to include comparison object for author and artist
		switch (orderType.toLowerCase()) {
		case "price" : 
			masterList.sort(compareByPrice);
			break;
		case "rating" :
			masterList.sort(compareByRating);
			break;
		case "title" :
			masterList.sort(compareByTitle);
			break;
		case "duration" :
			movieList.sort(compareByDuration);
			return movieList;
		case "pages" :
			bookList.sort(compareByPages);
			return bookList;
		case "author" :
			bookList.sort(compareByAuthor);
			return bookList;
		case "artist" :
			songList.sort(compareByArtist);
			return songList;
		}
		
		return masterList;
	}
}
