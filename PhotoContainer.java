import java.util.ArrayList;

public abstract class PhotoContainer { // abstract parent class for Album and Library
	protected String name;
	protected ArrayList<Photo> photos;

	public PhotoContainer(String name) { // constructor for PhotoContainer
		this.name = name;
		photos = new ArrayList<Photo>();
	}

	// getter methods for field variables
	public String getName() {
		return name;
	}

	public ArrayList<Photo> getPhotos() {
		return photos;
	}

	// setter method for name
	public void setName(String name) {
		this.name = name;
	}

	// adds photo p to photos ArrayList
	public boolean addPhoto(Photo p) {
		if (p != null) {
			if (!(photos.contains(p))) {
				photos.add(p);
				return true;
			}
		}
		return false;
	}

	// returns true if p is in photos ArrayList, else it returns false
	public boolean hasPhoto(Photo p) {
		if (photos.contains(p))
			return true;
		return false;
	}

	// returns true if p is in photos ArrayList then removes it, else it returns
	// false
	public boolean removePhoto(Photo p) {
		if (photos.contains(p)) {
			photos.remove(p);
			return true;
		}
		return false;
	}

	// returns the number of photos in the photos ArrayList
	public int numPhotos() {
		return photos.size();
	}

	// equals method for Album objects
	public boolean equals(Object o) {
		if (o instanceof Album) {
			Album other = (Album) o;
			if (this.name.equals(other.name))
				return true;
		}
		return false;
	}

	// toString method for Albums
	public String toString() {
		return name + photos;
	}

	// hashcode method for name field
	public int hashCode() {
		return name.hashCode();
	}

	// method that retrieves photos based on their rating
	public ArrayList<Photo> getPhotos(int rating) {
		ArrayList<Photo> newphotos = new ArrayList<Photo>();
		if (rating > 5 || rating < 1)
			return null;

		for (Photo p : photos) {
			if (p.getRating() >= rating)
				newphotos.add(p);
		}
		return newphotos;
	}

	// method to retrieve photos of a certain year
	public ArrayList<Photo> getPhotosInYear(int year) {
		ArrayList<Photo> newphotos = new ArrayList<Photo>();
		if (year > 9999 || year < 0)
			return null;
		for (Photo p : photos) {
			if (DateLibrary.getYear(p.getDateTaken()) == year)
				newphotos.add(p);
		}
		return newphotos;
	}

	// method to retrieve photos of a certain month and year
	public ArrayList<Photo> getPhotosInMonth(int month, int year) {
		ArrayList<Photo> newphotos = new ArrayList<Photo>();
		if (year > 9999 || year < 0 || month > 12 || month < 1)
			return null;
		for (Photo p : photos) {
			if (DateLibrary.getYear(p.getDateTaken()) == year && DateLibrary.getMonth(p.getDateTaken()) == month)
				newphotos.add(p);
		}
		return newphotos;
	}

	// method to retrieve photos between two dates
	public ArrayList<Photo> getPhotosBetween(String beginDate, String endDate) {
		ArrayList<Photo> newphotos = new ArrayList<Photo>();

		if (DateLibrary.compare(beginDate, endDate) != 1 && DateLibrary.isValidDate(beginDate)
				&& DateLibrary.isValidDate(endDate)) {
			for (Photo p : photos) {
				if (DateLibrary.compare(p.getDateTaken(), beginDate) == 1
						&& DateLibrary.compare(endDate, p.getDateTaken()) == 1)
					newphotos.add(p);
			}
			return newphotos;
		}
		return null;
	}
}
