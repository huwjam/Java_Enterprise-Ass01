import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.*;

class YourPrimeTest {
	
	MyMedia myMedia;
	List<Book> sortBook;
	List<Song> sortSong;
	
	@BeforeEach
	void setUp() {
		// Declare all data to be used in testing
		// dummy songs 
		Song s1 = new Song("Fight The Power", "Public Enemy", 4, new Rap());
		Song s2 = new Song("Smell Like Teen Spirit", "Nirvana", 4, new Rock());
		Song s3 = new Song("Blinding Lights", "The Weeknd", 2, new Pop());
		Song s4 = new Song("We Belong Together", "Mariah Carey", 3, new Pop());
		Song s5 = new Song("Hey Jude", "The Beatles", 3, new Rock());
		
		// dummy books
		Book b1 = new Book("The Da Vinci Code", "Dan Brown", 2003, 1, 689, new Fantasy());
		Book b2 = new Book("Harry Potter and the Deathly Hallows", "J. K. Rowlings", 2007, 3, 607, new Fantasy());
		Book b3 = new Book("Show Dog", "Phil Knight", 2016, 5, 399, new Autobiography());
		Book b4 = new Book("The Fellowship of the Ring", "J. R. R. Tolkien", 1954, 2, 423, new Fantasy());
		Book b5 = new Book("Surely You're Jocking, Mr. Feynman", "Richard P. Feynman", 1985, 5, 356, new Autobiography());
		
		// create MyMedia object for testing purpose - add all media define here
		List<Movie> listMovie = new ArrayList<>();
		listMovie.add(new Movie());
		
		List<Book> listBook = new ArrayList<>();
		List<Book> listB = Arrays.asList(b1, b2, b3, b4, b5);
		listBook.addAll(listB);
		
		List<Song> listSong = new ArrayList<>();
		List<Song> listS = Arrays.asList(s1, s2, s3, s4, s5);
		listSong.addAll(listS);
		
		myMedia = new MyMedia(listMovie, listBook, listSong);
		
		// sorted list to be used for testing
		sortBook = Arrays.asList(b1, b2, b4, b3, b5);
		sortSong = Arrays.asList(s4, s2, s1, s5, s3);
	}
	
	@Test
	@DisplayName("Testing for constructor validation: Movie")
	void validityTestForMovie() {
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> Movie.of("The Godfather", "Marlon Brando, Al Pacino", 175.0, 1972, 4, new Rap()));
		assertEquals("Genre is invalid", exception.getMessage());
		
		exception = assertThrows(IllegalArgumentException.class, () -> Movie.of("The Godfather", "Marlon Brando, Al Pacino", 175.0, 1972, 4, new Rock()));
		assertEquals("Genre is invalid", exception.getMessage());
		
		exception = assertThrows(IllegalArgumentException.class, () -> Movie.of("The Godfather", "Marlon Brando, Al Pacino", 175.0, 1972, 4, new Pop()));
		assertEquals("Genre is invalid", exception.getMessage());
		
		exception = assertThrows(IllegalArgumentException.class, () -> Movie.of("The Godfather", "Marlon Brando, Al Pacino", 175.0, 1972, 4, new Fantasy()));
		assertEquals("Genre is invalid", exception.getMessage());
		
		exception = assertThrows(IllegalArgumentException.class, () -> Movie.of("The Godfather", "Marlon Brando, Al Pacino", 175.0, 1972, 4, new Autobiography()));
		assertEquals("Genre is invalid", exception.getMessage());
	}
	
	@Test
	@DisplayName("Testing for constructor validation: Song")
	void validityTestForSong() {
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> Song.of("Fight The Power", "Public Enemy", 4, new Drama()));
		assertEquals("Genre is invalid", exception.getMessage());
	  
		exception = assertThrows(IllegalArgumentException.class, () -> Song.of("Fight The Power", "Public Enemy", 4, new Comedy()));
		assertEquals("Genre is invalid", exception.getMessage());
	  
		exception = assertThrows(IllegalArgumentException.class, () -> Song.of("Fight The Power", "Public Enemy", 4, new Fantasy()));
		assertEquals("Genre is invalid", exception.getMessage());
	  
		exception = assertThrows(IllegalArgumentException.class, () -> Song.of("Fight The Power", "Public Enemy", 4, new Autobiography()));
		assertEquals("Genre is invalid", exception.getMessage());
	}
	
	@Test
	@DisplayName("Testing for constructor validation: Book")
	void validityTestForBook() {
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> Book.of("The Da Vinci Code", "Dan Brown", 2003, 1, 689, new Rap()));
		assertEquals("Genre is invalid", exception.getMessage());
	  
		exception = assertThrows(IllegalArgumentException.class, () -> Book.of("The Da Vinci Code", "Dan Brown", 2003, 1, 689, new Rock()));
		assertEquals("Genre is invalid", exception.getMessage());
	  
		exception = assertThrows(IllegalArgumentException.class, () -> Book.of("The Da Vinci Code", "Dan Brown", 2003, 1, 689, new Pop()));
		assertEquals("Genre is invalid", exception.getMessage());
		
		exception = assertThrows(IllegalArgumentException.class, () -> Book.of("The Da Vinci Code", "Dan Brown", 2003, 1, 689, new Drama()));
		assertEquals("Genre is invalid", exception.getMessage());
		
		exception = assertThrows(IllegalArgumentException.class, () -> Book.of("The Da Vinci Code", "Dan Brown", 2003, 1, 689, new Action()));
		assertEquals("Genre is invalid", exception.getMessage());
		
		exception = assertThrows(IllegalArgumentException.class, () -> Book.of("The Da Vinci Code", "Dan Brown", 2003, 1, 689, new Comedy()));
		assertEquals("Genre is invalid", exception.getMessage());
	}

	@Test
	@DisplayName("Testing the sorting orderByType: author")
	void sortOrderByTypeAuthor() {
		List<?> sortedList = myMedia.sort("author");
		assertTrue(sortBook.equals(sortedList), () -> "OrderByType author failed");
	}
	
	@Test
	@DisplayName("Testing the sorting orderByType: artist")
	void sortOrderByTypeArtist() {
		List<?> sortedList = myMedia.sort("artist");
		assertTrue(sortSong.equals(sortedList), () -> "OrderByType artist failed");
	}
	
}