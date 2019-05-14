import javax.imageio.ImageIO;
import javax.swing.*; // controls ex JPanel 
import java.awt.*; // back end, listeners, etc 
import java.awt.event.*; // event handlers
import java.awt.image.BufferedImage;

import sun.audio.*;
import java.io.*;

public class DH_MP3 extends JPanel implements ActionListener {
	JButton play, stop, pause;
	AudioStream as;
	BufferedImage playImg, pauseImage, stopImage;
	
	public DH_MP3()
	{
		this.setLayout(new BorderLayout());
		JPanel buttonPanel = new JPanel();
		
		buttonPanel.setLayout(new FlowLayout());
	
		try {
			as = new AudioStream(this.getClass().getResourceAsStream("DH_music.wav"));
			playImg = ImageIO.read(new File("DH_playImg.png"));
			play = new JButton(new ImageIcon (((new ImageIcon(playImg).getImage().getScaledInstance(100, 100, 50)))));
			play.setBorder(null);
			stopImage = ImageIO.read(new File("DH_stopImage.jpg"));
			stop = new JButton(new ImageIcon (((new ImageIcon(stopImage).getImage().getScaledInstance(100, 100, 50)))));
			stop.setBorder(null);
			pauseImage = ImageIO.read(new File("DH_pauseImage.png"));
			pause = new JButton(new ImageIcon (((new ImageIcon(pauseImage).getImage().getScaledInstance(100, 100, 50)))));
			pause.setBorder(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		buttonPanel.add(play);
		buttonPanel.add (stop);
		buttonPanel.add(pause);
		this.add(buttonPanel, BorderLayout.CENTER);
		
		play.addActionListener(this);
		stop.addActionListener(this);
		pause.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ae){
		if(ae.getSource() == play)
		{
			AudioPlayer.player.start(as);
		
		}
		else if(ae.getSource() == stop){
			
			AudioPlayer.player.stop(as);
			try{
				as = new AudioStream(this.getClass().getResourceAsStream("DH_music.wav"));
				
			}catch (IOException e) {
				e.printStackTrace();
			} 
		}
		else if (ae.getSource() == pause){
			AudioPlayer.player.stop(as);
		}	
	}
}