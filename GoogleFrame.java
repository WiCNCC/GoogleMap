package gm;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class GoogleFrame extends JFrame {


	private static final long serialVersionUID = 1L;
	Image mapImage;
	GoogleMap googleMap;
	ImageIcon mapIcon;
	JLabel centerLabel;



	public GoogleFrame() {

		try {
			URL url = new URL("http://stargate.ncc.edu/~steve/kitty.jpg");
			System.out.println(url);
			mapImage = ImageIO.read(url);// read the image data store it
		}
		catch (IOException ie) {
			System.out.println("Error" + ie.getMessage());
		}

		// make map icon which will be used later in label to display picture
		mapIcon= new ImageIcon(mapImage); 




		// instantiate your google marker data structure object here
		DoublyLinkedQueue markers = new DoublyLinkedQueue();

		//two restaurants 
		GoogleMarker marker1 = new GoogleMarker(40.771987, -73.526527, "red", "A", "restaraunt"); //panera
		GoogleMarker marker2 = new GoogleMarker(40.767439, -73.525688, "red", "B", "restaraunt"); //Pizza

		//two fun places
		GoogleMarker marker3 = new GoogleMarker(40.777740, -73.558709, "blue", "A", "bank"); //skyzone
		GoogleMarker marker4 = new GoogleMarker(40.779745, -73.559442, "blue", "B", "bank"); //bounce

		//two movie theaters
		GoogleMarker marker5 = new GoogleMarker(40.778513, -73.555835, "green", "A", "theater"); 
		GoogleMarker marker6 = new GoogleMarker(40.773610, -73.557698, "green", "B", "theater"); //amc theater

		markers.enqueue(marker1);
		markers.enqueue(marker2);
		markers.enqueue(marker3);
		markers.enqueue(marker4);
		markers.enqueue(marker5);
		markers.enqueue(marker6);


		// instantiate your google map object here and pass above object to the 
		// GoogleMap constructor, this call below will need to be modified
		// if you want to pass some other data/arguments to the constructor you may

		googleMap = new GoogleMap(markers);

		JPanel mainPanel = new JPanel();

		JFrame frame = new JFrame("");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setLocation(430, 100);

		JPanel otherPanel = new JPanel();


		JLabel lbl = new JLabel("Select one of the possible choices and click OK");
		lbl.setVisible(true);

		mainPanel.add(lbl);

		String[] choices = { "restaraunt","bank", "theater"};

		final JComboBox<String> cb = new JComboBox<String>(choices);

		cb.setVisible(true);




		/* make a button and add an actionListener to it
		 when that button is pressed it will read data from textbox or
		 drop down box and use it with a call to the getMap method, use the data
		 returned from getMap method to make
		 a mapIcon and pass it to the setIcon method of centerLabel
		 kind of like this:

		 		mapIcon= new ImageIcon(goomap.getMap());
				centerLabel.setIcon(mapIcon);

		 */  
		JButton btn = new JButton("OK");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("dkjfdjk " + cb.getSelectedItem());
				mapIcon = new ImageIcon(googleMap.getMap((String)cb.getSelectedItem()));
				centerLabel.setIcon(mapIcon);
			}
		}
				);

		// add the above widgets you made to the top panel
		otherPanel.add(cb);
		otherPanel.add(btn);
		otherPanel.setVisible(true);

		//otherPanel.setLayout(new BorderLayout());

		centerLabel = new JLabel(mapIcon);

		// add the top panel to the mainpanel in the NORTH position
		mainPanel.add(otherPanel, BorderLayout.NORTH);
		//add(panel);
		mainPanel.add(centerLabel, BorderLayout.CENTER);
		add(mainPanel);
		
		mainPanel.setVisible(true);

		

	}



}