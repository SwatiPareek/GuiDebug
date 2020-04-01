import java.awt.image.BufferedImage;
import java.io.File;


import javax.imageio.ImageIO;

public class Photo implements Comparable<Photo> {

	public static void main(String[] args) {
		Photo test1 = new Photo("test1.png", "abcdef");
		Photo test2 = new Photo("test2.png", "ghijklmnop", "2020-11-26", 5);

		System.out.println(test2.getDateTaken());
	}

	// field variables
	private final String caption;
	private final String filename;
	private int rating;
	private String dateTaken;
	protected BufferedImage imageData;

	// constructor for Photo object
	public Photo(String filename, String caption) {
		this.filename = filename;
		this.caption = caption;
		this.dateTaken = "1901-01-01";
		this.rating = 1;
	}

	// overloaded constructor for Photo object
	public Photo(String filename, String caption, String dateTaken, int rating) {
		this.filename = filename;
		this.caption = caption;
		if (rating >= 1 && rating <= 5) {
			this.rating = rating;
		}
		else this.rating = 1; 
		if (DateLibrary.isValidDate(dateTaken)) {
			this.dateTaken = dateTaken;
		}
		else this.dateTaken = "1901-01-01";
	}

	// getter methods
	public String getCaption() {
		return caption;
	}

	public String getFilename() {
		return filename;
	}

	public int getRating() {
		return rating;
	}

	public String getDateTaken() {
		return dateTaken;
	}
	public BufferedImage getImageData() {
		return imageData;
	}

	// setter methods
	public boolean setRating(int newRating) {
		if (newRating != rating && newRating >= 1 && newRating <= 5) {
			rating = newRating;
			return true;
		} else {
			return false;
		}
	}
	public void setImageData(BufferedImage imageData) {
		this.imageData = imageData;
	}

	// modified equals method based on the comparisons of filenames and captions
	public boolean equals(Object o) {
		if (o instanceof Photo) {
			Photo other = (Photo) o;
			return this.caption.equals(other.caption) & this.filename.equals(other.filename);
		}
		return false;
	}

	// modified hashCode function
	public int hashCode() {
		return filename.hashCode();
	}

	// modified toString method
	public String toString() {
		return ("File Name: " + filename + ", Caption: " + caption + ", Rating: " + rating);
	}

	public int compareTo(Photo p) {
		if (dateTaken.equals(p.getDateTaken()))
			return caption.compareTo(p.getCaption());
		return dateTaken.compareTo(p.getDateTaken());
	}

	public boolean loadImageData(String filename) {
		try {
			BufferedImage img = ImageIO.read(new File(filename));
			imageData = img;
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
