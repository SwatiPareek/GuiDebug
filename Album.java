import java.util.HashSet;

public class Album extends PhotoContainer {

	public static void main(String[] args) {
		Photo p1 = new Photo("test1.png", "abcdef");
		Photo p2 = new Photo("test2.png", "ghijklmnop", "2020-11-26", 5);
		Album a1 = new Album("Album1");
		System.out.println(a1.addPhoto(p1));
		System.out.println(a1.getPhotos());
	}

	// constructor
	public Album(String name) {
		super(name);
		this.name = name;
	}
}
