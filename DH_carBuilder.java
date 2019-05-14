// David Hernandez


import javax.swing.*; // controls ex JPanel 
import java.awt.*; // back end, listeners, etc
import java.awt.event.*; // event handlers 

public class DH_carBuilder extends JPanel  implements ActionListener{
	JTextArea buildText;		
	JButton buildButton;
	
	JComboBox makeMenu;
	JComboBox modelMenu;
	
	String [] makeList;
	String [][] modelList;
	
	JCheckBox option_Stereo, option_Bluetooth, option_sunroof, option_ejectionseat;
	
	JRadioButton color_red, color_black, color_purple, color_white;
	JRadioButton trans_Manual, trans_Automatic;
	
	ButtonGroup colorGroup,transGroup;
	
	public DH_carBuilder() {
		this.setLayout(new BorderLayout());
		JPanel titlePanel = new JPanel();
		JPanel carPanel = new JPanel();
		JPanel optionsPanel = new JPanel();
		JPanel colorPanel = new JPanel();
		JPanel transPanel = new JPanel();
		JPanel buildPanel = new JPanel();
		JPanel centerPanel = new JPanel();
		
		// Title of the app 
		JLabel titleLabel = new JLabel("MY NEW CAR");
		
		// Make and Model Selection
		makeList = new String []{"Ford", "Toyota", "Chevy"};
		modelList = new String [3][];
		modelList[0] = new String[] {"Mustang", "F-150", "Escape", "Fusion"};
		modelList[1] = new String[] {"Avalon", "Pirus", "Camry"};
		modelList[2] = new String[] {"Corvette", "Silverado", "Camero"};
		
		makeMenu = new JComboBox(makeList);
		modelMenu = new JComboBox(modelList[0]);
		
		carPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		carPanel.add(makeMenu);
		carPanel.add(modelMenu);
		
		// Options 
		option_Stereo = new JCheckBox("Super Surround Stereo");
		option_Bluetooth = new JCheckBox("Bluetooth 5.0");
		option_sunroof = new JCheckBox("Tinted Sunroof");
		option_ejectionseat = new JCheckBox("Passenger Ejection Seat");
		
		optionsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		optionsPanel.add(option_Stereo);
		optionsPanel.add(option_Bluetooth);
		optionsPanel.add(option_sunroof);
		optionsPanel.add(option_ejectionseat);
		
		// Color
		colorGroup = new ButtonGroup();
		color_red = new JRadioButton("Fire White");
		color_black = new JRadioButton("Midnight Black");
		color_purple = new JRadioButton("Royal Purple");
		color_white = new JRadioButton("Pearl White");
		colorGroup.add(color_red);
		colorGroup.add(color_black);
		colorGroup.add(color_purple);
		colorGroup.add(color_white);
		colorPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		colorPanel.add(color_red);
		colorPanel.add (color_black);
		colorPanel.add(color_purple);
		colorPanel.add(color_white);
		color_red.setSelected(true);
		
		// Transmission
		transGroup = new ButtonGroup();
		trans_Manual = new JRadioButton("Six Speed Manual Transmisison");
		trans_Automatic = new JRadioButton("HydroSmooth Variable Automatic Transmission");
		transGroup.add(trans_Manual);
		transGroup.add(trans_Automatic);
		transPanel.add(trans_Manual);
		transPanel.add(trans_Automatic);
		trans_Manual.setSelected(true);
		
		// build my car
		buildText = new JTextArea(6,60);
		buildText.setText("");
		buildButton = new JButton("Build my car!");
		
		buildPanel.setLayout(new BorderLayout());
		JPanel upperPanel= new JPanel(new GridLayout(1,1));
		JPanel lowerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		upperPanel.add(buildText);
		lowerPanel.add(buildButton);
		buildPanel.add(upperPanel, BorderLayout.NORTH);
		buildPanel.add(lowerPanel, BorderLayout.SOUTH);
		
		// Put it all together
		centerPanel.setLayout(new GridLayout(9,1));
		centerPanel.add(carPanel);
		JLabel optionLabel = new JLabel("Select your options!");
		JPanel optionLabelPanel = new JPanel();
		optionLabelPanel.add(optionLabel);
		centerPanel.add(optionLabelPanel);
		centerPanel.add(optionsPanel);
		
		JLabel colorLabel = new JLabel("Select your color!");
		JPanel colorLabelPanel = new JPanel();
		colorLabelPanel.add(colorLabel);
		centerPanel.add(colorLabelPanel);
		centerPanel.add(colorPanel);
		
		JLabel transLabel = new JLabel("Select your Transmission");
		JPanel transLabelPanel = new JPanel();
		transLabelPanel.add(transLabel);
		centerPanel.add(transLabelPanel);
		centerPanel.add(transPanel);
		
		titlePanel.add(titleLabel);
		
		this.add(titlePanel, BorderLayout.NORTH);
		this.add(centerPanel, BorderLayout.CENTER);
		this.add(buildPanel, BorderLayout.SOUTH);
		
		
		// Listeners
		makeMenu.addActionListener(this);
		modelMenu.addActionListener(this);
		option_Stereo.addActionListener(this);
		option_Bluetooth.addActionListener(this);
		option_sunroof.addActionListener(this);
		option_ejectionseat.addActionListener(this);
		color_red.addActionListener(this);
		color_black.addActionListener(this);
		color_purple.addActionListener(this);
		color_white.addActionListener(this);
		trans_Manual.addActionListener(this);
		trans_Automatic.addActionListener(this);
		buildButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {		
		buildText.setText("");
		if(arg0.getSource() == makeMenu) {
			int i = makeMenu.getSelectedIndex();
			modelMenu.removeAllItems();
			for(String s: modelList[i]) {
				modelMenu.addItem(s);
			}
		}
		if(arg0.getSource() == buildButton) {
			buildText.append("Make: " + String.valueOf(makeMenu.getSelectedItem()) + "\n");
			buildText.append("Model: " + String.valueOf(modelMenu.getSelectedItem() + "\n"));
			if(option_Stereo.isSelected() ||
					option_Bluetooth.isSelected() ||
					option_sunroof.isSelected() || 
					option_ejectionseat.isSelected() ) {
				buildText.append("Options: \n");
				if(option_Stereo.isSelected() ) {
					buildText.append(option_Stereo.getText() + "\n");
				}
				if(option_Bluetooth.isSelected() ) {
					buildText.append(option_Bluetooth.getText() + "\n");
				}
				if(option_sunroof.isSelected() ) {
					buildText.append(option_sunroof.getText() + "\n");
				}
				if(option_ejectionseat.isSelected() ) {
					buildText.append(option_ejectionseat.getText() + "\n");
				}
			}
			buildText.append("Color: ");
			if(color_red.isSelected() ) buildText.append(color_red.getText() + "\n");
			if(color_black.isSelected() ) buildText.append(color_black.getText() + "\n");
			if(color_purple.isSelected() ) buildText.append(color_purple.getText() + "\n");
			if(color_white.isSelected() ) buildText.append(color_white.getText() + "\n");
			
			buildText.append("Transmission : ");
			if(trans_Manual.isSelected() ) buildText.append(trans_Manual.getText() + "\n");
			if(trans_Automatic.isSelected() ) buildText.append(trans_Automatic.getText() + "\n");
		}
	}
}