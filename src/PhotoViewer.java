import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Collections;

import javax.swing.*;

public class PhotoViewer extends JFrame {

	private PhotoContainer imageLibrary;
	private JButton previous_button;
	private JButton next_button;
	private FlowLayout layout = new FlowLayout();
	private JRadioButton migrate1Button;
	private JRadioButton migrate2Button;
	private JRadioButton migrate3Button;
	private JRadioButton migrate4Button;
	private JRadioButton migrate5Button;

	// getter-method for imageLibrary
	public PhotoContainer getImageLibrary() {
		return imageLibrary;
	}

	// setter-method for imageLibrary
	public void setImageLibrary(PhotoContainer imageLibrary) {
		this.imageLibrary = imageLibrary;
	}

	public static void main(String[] args) {

		PhotoViewer myViewer = new PhotoViewer();

		String imageDirectory = "images\\"; // for Windows
		Photo p1 = new Photo(imageDirectory + "img1.jpg", "Kevin Durant's jumpshot in the 2012 NBA finals",
				"2012-06-14", 5);
		p1.loadImageData(imageDirectory + " img1.jpg ");
		Photo p2 = new Photo(imageDirectory + "img2.jpg", "Russell Westbrook's dunk", "2014-11-27", 4);
		p2.loadImageData(imageDirectory + " img2.jpg ");
		Photo p3 = new Photo( imageDirectory + "img3.jpg","Beautiful Hawaiian hills overlooking the ocean",
				"2007-09-08", 3);
		p3.loadImageData(imageDirectory + " img3.jpg ");
		Photo p4 = new Photo( imageDirectory + "img4.jpg", "Kobe Bryant's game winner over the Phoenix Suns",
				" 2006-04-17", 5);
		p4.loadImageData(imageDirectory + " img4.jpg ");
		Photo p5 = new Photo(imageDirectory + "img5.jpg",  "Waterfalls and mountains","1997-02-24", 2);
		p5.loadImageData(imageDirectory + " img5.jpg ");

		myViewer.setImageLibrary(new Library("Test Library", 1));
		myViewer.getImageLibrary().addPhoto(p1);
		myViewer.getImageLibrary().addPhoto(p2);
		myViewer.getImageLibrary().addPhoto(p3);
		myViewer.getImageLibrary().addPhoto(p4);
		myViewer.getImageLibrary().addPhoto(p5);

		// use Collections . sort () to sort the photos based on the
		// written compareTo () method
		Collections.sort(myViewer.getImageLibrary().getPhotos());
		// Invoke and start the GUI
		javax.swing.SwingUtilities.invokeLater(() -> myViewer.createAndShowGUI());
	}

	private void createAndShowGUI() {
		this.setTitle("Display for Photos");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addComponentsToPane(this.getContentPane());
		// Display the window.
		this.pack(); // automatically aligns widgets together to make it aesthetically pleasing
		this.setSize(800, 600); // dimensions
		this.setVisible(true);
	}

	private void addComponentsToPane(Container pane) {
		
		class nextButtonListener implements ActionListener { // ** INNER CLASS **
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		}
		class previousButtonListener implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		}

		JPanel panel1 = new JPanel(); // Previous/next buttons

		panel1.setLayout(layout);
		layout.setAlignment(FlowLayout.CENTER);

		previous_button = new JButton("Previous");
		next_button = new JButton("Next");
		previous_button.setActionCommand("click");
		next_button.setActionCommand("click");
		previous_button.addActionListener(new previousButtonListener());
		next_button.addActionListener(new nextButtonListener()); // add ActionListener

		panel1.add(previous_button);
		panel1.add(next_button);

		JPanel panel2 = new JPanel(); // Ratings 1-5 buttons

		migrate1Button = new JRadioButton("1");
		migrate2Button = new JRadioButton("2");
		migrate3Button = new JRadioButton("3");
		migrate4Button = new JRadioButton("4");
		migrate5Button = new JRadioButton("5");

		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(migrate1Button);
		buttonGroup.add(migrate2Button);
		buttonGroup.add(migrate3Button);
		buttonGroup.add(migrate4Button);
		buttonGroup.add(migrate5Button);

		panel2.add(migrate1Button);
		panel2.add(migrate2Button);
		panel2.add(migrate3Button);
		panel2.add(migrate4Button);
		panel2.add(migrate5Button);

	

		int index = 0;
		Photo ph = imageLibrary.getPhotos().get(index);
		ph.loadImageData(ph.getFilename());
		BufferedImage myBufferedImage = ph.getImageData();
		ImageIcon icon = new ImageIcon(ph.getImageData());
		JLabel lbl = new JLabel();
		lbl.setIcon(icon);
		pane.add(lbl);

		// add this panel to the content pane
		pane.add(panel1, BorderLayout.NORTH);
		pane.add(panel2, BorderLayout.SOUTH);
	}
}
