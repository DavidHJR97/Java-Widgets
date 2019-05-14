import javax.swing.*; // controls ex JPanel 
import java.awt.*; // back end, listeners, etc
import java.awt.event.*; // event handlers 
import java.util.HashMap;


public class DH_encryption extends JPanel implements ActionListener  {
	private static String alpha = "abcdefghijklmnopqrstuvwxyz";
	private JTextField shiftFactor;
	
	private JTextArea inputTxt, outputTxt;
      
	private JButton encryptButton, decryptButton;
   
   	public DH_encryption(){
   		this.setLayout(new BorderLayout());
   		JPanel buildPanel = new JPanel();
   		buildPanel.setLayout(new FlowLayout());
   	    JPanel buttonPanel  = new JPanel();
   	    buttonPanel.setLayout(new FlowLayout()); 
   		
   	    // Creates the input text area 
   	    inputTxt = new JTextArea("Insert the text to be encrypted/decrypted here, then press the appropriate button.", 6, 40);
   	    inputTxt.setLineWrap(true);
   	    inputTxt.setWrapStyleWord(true);
   	    inputTxt.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
   	    
   	    // Adds scroll to the input text area 
   	    JScrollPane scroller = new JScrollPane(inputTxt);
   	    scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
   	    buildPanel.add(scroller);
   	    
   	    // Creates the output text area
   	    outputTxt = new JTextArea("Output text.",6, 40);
   	    outputTxt.setLineWrap(true);
   		outputTxt.setWrapStyleWord(true);
   	 	outputTxt.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
   	    
   	    // Adds scroll to the output textArea
   	    JScrollPane scroller2 = new JScrollPane(outputTxt);
   	    scroller2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
   	    buildPanel.add(scroller2);
   	    
   	    // Initializes the button 
   	    encryptButton = new JButton("Encrypt");
   	    decryptButton = new JButton("Decrypt");
   	    
   	    // Adds buttons to the panel 
   	    buttonPanel.add(encryptButton);
   	    buttonPanel.add(decryptButton);

   	    // creates shift factor label and adds to buttonPanel 
   	    buttonPanel.add(new JLabel("Shift Factor"));
   		buttonPanel.add(this.shiftFactor = new JTextField(5));
   	    buildPanel.add(buttonPanel);
   	    
   	    // Adds the panels to the app 
   	    this.add(buttonPanel, BorderLayout.CENTER);
   	    this.add(buildPanel, BorderLayout.NORTH);
   	    
   	    // Adds action listener to the button 
   	    decryptButton.addActionListener(this);
 	    encryptButton.addActionListener(this);
   	}

   	@Override
   	public void actionPerformed(ActionEvent e) {
   		if(e.getActionCommand().equals("Encrypt")){
   			try {
				encryptText();
			}
   			catch (NumberFormatException  ex) {
				ex.printStackTrace();
   			}
   		}
   		if (e.getActionCommand().equals("Decrypt")){
   			try {
   				decryptText();
   			} 
   			catch (NumberFormatException  ex) {
				ex.printStackTrace();
   			}
   		}
   			
   	}
   	
   	// method to encrypt the text, from stackoverflow
   	public void encryptText() {
   		String text = inputTxt.getText().toLowerCase();
		String encrypt = "";
   		int key = Integer.parseInt(shiftFactor.getText());
		for (int i = 0; i < text.length(); i++) {
			char valReplace = text.charAt(i);
			int charPos = alpha.indexOf(valReplace);
			if(charPos != -1){
				int keyValue = (key + charPos) % 26;
				valReplace = alpha.charAt(keyValue);
			}
			encrypt += valReplace;
		}
		outputTxt.setText(encrypt);
   	}
   	
   	// Method to decrypt the text, from stackoverflow, 
   	public void decryptText(){
		String decrypt = "";
   		String text = inputTxt.getText().toLowerCase();
   		int key = Integer.parseInt(shiftFactor.getText());
		for (int i = 0; i < text.length(); i++) {
			char valReplace = text.charAt(i);
			int charPos = alpha.indexOf(valReplace);
			if(charPos != -1){
				int keyValue = (charPos - key) % 26;
				if(keyValue < 0){
					keyValue = alpha.length() + keyValue;
				}
				valReplace = alpha.charAt(keyValue);
			}
			
			decrypt += valReplace;
		}
   		outputTxt.setText(decrypt);
   	}
}