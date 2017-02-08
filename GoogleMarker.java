package gm;
//Zermina Ejaz N00831354
public class GoogleMarker {
	
	// will need instance variables to store latitude, longitude, color, label (name), category
	
	private double latitude;
	private double longitude;
	private String color;
	private String label;
	private String category;
	

	// will need appropriate parameterized constructor, accessors and mutators
	public GoogleMarker(double l, double lg, String c, String lab, String cat){
		latitude = l;
		longitude = lg;
		color = c;
		label = lab;
		category = cat;
		
	}
	
	public double getLatitude() {
		return latitude;
	}


	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}


	public double getLongitude() {
		return longitude;
	}


	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getLabel() {
		return label;
	}


	public void setLabel(String label) {
		this.label = label;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}



	// will need toString that outputs in format of ex.
	
	// &markers=color:red%7Clabel:A%7C40.729961,-73.590879
	
	// A is the value of the label or name
	// there is "%7C" separating the value of the color and the word label
	// there is "%7C" separating the value of the label and the latitude
	
		public String toString() { 
		String str = "&markers=color:" + color + "%7Clabel:" + label + "%7C" + latitude + "," + longitude;
		
		return str;
		
	}
}
