// David Hernandez
// Generic GUI App 

import javax.swing.*; // controls ex JPanel 
import java.awt.*; // back end, listeners, etc

public class DH_WidgetAppTest extends JFrame{
	private Container contents;

	public static void main(String [] args) {
		DH_WidgetAppTest ga = new DH_WidgetAppTest();
		ga.setVisible(true);
		ga.pack();
	}
	
	public DH_WidgetAppTest()
	{
		setTitle("4 Widgets");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contents = getContentPane(); // gets a handle to the frame itself
		this.setLayout(new GridLayout(2,2));
	
		JPanel inv = new DH_Investment();
		this.add(inv);
		
		JPanel mp3 = new DH_MP3();
		this.add(mp3);
		
		JPanel pic = new DH_carBuilder();
		this.add(pic);
		
		JPanel shape = new DH_encryption();
		this.add(shape);
	}
}