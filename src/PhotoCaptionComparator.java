
/**
 * Homework 3
 * Harshil Pareek, hp3be
 */

import java.util.Comparator;

public class PhotoCaptionComparator implements Comparator<Photo> {

	/**
	 * Compares two Photo objects based on their caption values. If both are equal,
	 * the method compares their rating values.
	 * 
	 * @return difference between the captions or ratings.
	 */
	public int compare(Photo a, Photo b) {
		if (a.getCaption().equals(b.getCaption()))
			return b.getRating() - a.getRating();
		return a.getCaption().compareTo(b.getCaption());
	}
}
