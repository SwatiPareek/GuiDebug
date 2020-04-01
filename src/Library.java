// Harshil Pareek (hp3be)
// 02/02/2020

import java.util.ArrayList;
import java.util.HashSet;

public class Library extends PhotoContainer {

	// main method
	public static void main(String[] args) {
		// initializing Photo objects
		Photo ph1 = new Photo("ph1.png", "abcdef");
		// Photo ph2 = new Photo("ph2.png", "ghijklmnop", 5);
		Photo ph3 = new Photo("ph1.png", "abcdef");
		// Photo ph4 = new Photo("ph4.png", "hdheqdhiqo", 2);

		// initializing Library objects
		Library album1 = new Library("Beach trip", 151929);
		Library album2 = new Library("Graduation", 285752);

		// tests to assess the code

		// should return true
		System.out.println(album1.addPhoto(ph1));

		// should return false
		System.out.println(album1.addPhoto(ph3));

		// returns contents of photos
		System.out.println(album1.getPhotos());

		// should return true
		System.out.println(album2.addPhoto(ph1));
		// System.out.println(album2.addPhoto(ph2));
		// System.out.println(album1.addPhoto(ph4));
		System.out.println(album1.hasPhoto(ph1));

		// should return 2
		System.out.println(album2.numPhotos());
		System.out.println(album1.numPhotos());

		// should return false
		// System.out.println(album1.deletePhoto(ph2));

		// sets name to Graduation
		album1.setName("Soccer game");

		// should return false
		System.out.println(album1.equals(album2));

		// returns the contents of album 1 in a formatted string
		System.out.println(album1.toString());

		// returns common photos between the two albums
		System.out.println(commonPhotos(album1, album2));

		// should return 0.5
		System.out.println(similarity(album1, album2));
		System.out.println(album1.createAlbum());
		System.out.println(album1.getAlbums());
	}

	// field variables
	private int id;
	private HashSet<Album> albums;

	// Library constructor
	public Library(String name, int id) {
		super(name);
		this.name = name;
		this.id = id;
		this.albums = new HashSet<Album>();
	}

	// Accessor methods
	public int getId() {
		return id;
	}

	private HashSet<Album> getAlbums() {
		return albums;
	}

	// method that deletes p from photos if photos contains p
	public boolean removePhoto(Photo p) {
		for (int i = 0; i < photos.size(); i++) {
			if (photos.get(i).equals(p)) {
				photos.remove(i); // removes p from photos
				for (Album a : albums) {
					if (a.getPhotos().contains(p))
						a.removePhoto(p);
				}
				return true;
			}
		}
		return false; // meaning p is not in photos
	}

	/**
	 * Method that determines whether two libraries are equal according to their
	 * respective id numbers.
	 * 
	 * @param Object o that is used for comparison with another object
	 * @return true if both id's are equal and false if they are not
	 */

	public boolean equals(Object o) {
		if (o instanceof Library) {
			Library other = (Library) o;
			return this.id == other.id;
		}
		return false;
	}

	// method that returns a formatted description of a library
	public String toString() {
		return ("Name: " + name + " ID: " + id + " Photos: " + photos + " Albums: " + albums);
	}

	// method that finds the common photos between both libraries
	private static ArrayList<Photo> commonPhotos(Library a, Library b) {
		ArrayList<Photo> newList = new ArrayList<Photo>();
		for (int i = 0; i < a.photos.size(); i++) { // nested for-loop to access all elements
			for (int j = 0; j < b.photos.size(); j++) {
				if (a.photos.get(i).equals(b.photos.get(j))) {
					newList.add(a.photos.get(i)); // adds common photos to new ArrayList
				}
			}
		}
		return newList;
	}

	// method that compute a scale as to how similar two libraries are
	private static double similarity(Library a, Library b) {
		if (a.photos.size() == 0 || b.photos.size() == 0) {
			return 0.0;
		}
		if (a.photos.size() > b.photos.size()) { // if the photos for b is smaller it is used in the equation
			return ((double) commonPhotos(a, b).size() / b.photos.size());
		}
		return ((double) commonPhotos(a, b).size() / a.photos.size());
	}

	// method to create a new album with a name as a parameter
	private boolean createAlbum() {
		for (Album a : albums) {
			if (a.getName().equals("Soccer game"))
				return false;
		}
		Album newalbum = new Album("Soccer game");
		albums.add(newalbum);
		return true;
	}

	// removes album with the name albumName
	private boolean removeAlbum(String albumName) {
		for (Album a : albums) {
			if (a.getName().equals(albumName)) {
				albums.remove(a);
				return true;
			}
		}
		return false;
	}

	// adds a photo to an existing album
	public boolean addPhotoToAlbum(Photo p, String albumName) {
		for (Album a : albums) {
			if (albumName.equals(a.getName())) {
				if (photos.contains(p) && !(a.getPhotos().contains(albumName))) {
					a.addPhoto(p);
					return true;
				}
			}
		}
		return false;
	}

	// removes a photo object from an album
	public boolean removePhotoFromAlbum(Photo p, String albumName) {
		for (Album a : albums) {
			if (a.getPhotos().contains(p)) {
				albums.remove(a);
				return true;
			}
		}
		return false;
	}

	// gets an album by its name
	private Album getAlbumByName(String albumName) {
		for (Album a : albums) {
			if (a.getName().equals(albumName))
				return a;
		}
		return null;
	}
}
