

public class Pop extends Genre {
	 public Pop() {
	        isValidForSongs = true;
	    }
	//TODO complete method override
	@Override
	double setPrice(int rating) {
		if (rating > 3) {
			return 2.99;
		} else if (rating == 3) {
			return 1.99;
		} 
		return 0.00;
	}
}
