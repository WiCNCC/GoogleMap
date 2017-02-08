package gm;

// Zermina Ejaz N00831354
//got eventlistener code from stockoverflow. some help from daniel and Aaron
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
public class GoogleMap {

	Image mapImage;
	double latitudeCenter;
	double longitudeCenter;
	int imageScale;
	int zoomLevel;
	String strURL;
	DoublyLinkedQueue theList;
	
	// this constructor's parameter needs to be changed to the google data
	// structure you made and possibly other data
	GoogleMap(DoublyLinkedQueue list) 
	{
		theList = list;

		// this center is NCC, can be changed later
		latitudeCenter = 40.730543;
		longitudeCenter = -73.591663;
		imageScale = 1;
		zoomLevel = 15;
		

	
	}

	
	public Image getMap(String category) {
		
		
		// call the method in your data structure that will take in the search term (category)
		// and return only those markers' string and other data needed to center the map
		String markerString = theList.search(category);
		
		// change latitudeCenter and longitudeCenter vars
		latitudeCenter = theList.getLatitudeCenter();
		longitudeCenter = theList.getLongitudeCenter();
		
		
		// start of url
		strURL = "http://maps.googleapis.com/maps/api/staticmap?center=" + latitudeCenter + "," + longitudeCenter + "&zoom="
				+ zoomLevel + "&size=1024x1024";
		
		
		// concatenate marker strings to strURL
		strURL += markerString;
		
		// finally concatenate the following to strURL
		strURL += "&sensor=false&scale=" + imageScale;

		// leave this print statement to print final url being used
		System.out.println(strURL);

		try {
			URL url = new URL(strURL);
			mapImage = ImageIO.read(url); // read back png image data from Google 
		}
		catch (IOException ie) {
		}
		
		return mapImage;
	}
}
