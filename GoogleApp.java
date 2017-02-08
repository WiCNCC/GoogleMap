package gm;

// Zermina Ejaz N00831354
// array unordered list from CSCII

import java.awt.Dimension;

import javax.swing.JFrame;

public class GoogleApp {

	public static void main(String[] args) {
		
		GoogleFrame gf = new GoogleFrame();
		
		gf.setTitle("Google Map");
		gf.setVisible(true);
		gf.setSize(new Dimension(1024, 768));
		gf.setResizable(false);
		gf.setLocationRelativeTo(null);
		gf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}