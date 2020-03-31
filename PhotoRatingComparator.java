
/**
 * Homework 3
 * Harshil Pareek, hp3be
 */

import java.util.Comparator;

public PhotoRatingComparator implements Comparator<Photo> {

	/**
	 * Compares two Photo objects based on their rating values. If both are equal,
	 * the method compares their caption values.
	 * 
	 * @return difference between the captions or ratings.
	 */
	public int compare(Photo a, Photo b) {
		if (a.getRating() == b.getRating())
			return a.getCaption().compareTo(b.getCaption());
		return b.getRating() - a.getRating();
	}
}
