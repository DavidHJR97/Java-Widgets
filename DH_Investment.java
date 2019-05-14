// David Hernandez
// Future Investment Application 

import javax.swing.*; // controls ex JPanel 
import java.awt.*; // back end, listeners, etc
import java.awt.event.*; // event handlers 
import java.text.DecimalFormat;

public class DH_Investment extends JPanel implements ActionListener{
	
	private JLabel month, yearlyRate, year, futureValue;
	private JTextField monthly, yearRate, numOfYears, futureV;
	JButton calculate, exit;
	
	public DH_Investment() {
		this.setLayout(new BorderLayout());
		// Creates panels for app 
		JPanel titlePanel = new JPanel();
		JPanel monthPanel = new JPanel();
		JPanel yearlyRatePanel = new JPanel();
		JPanel yearlyPanel = new JPanel();
		JPanel futurePanel = new JPanel();
		JPanel centerPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		
		// Sets the Title for the app 
		JLabel titleLabel = new JLabel("Future Investment");
		titlePanel.add(titleLabel);
		centerPanel.setLayout(new GridLayout(4,4));
		// Initializes the labels and text fields 
		month = new JLabel("Monthly Investment: ");
		monthly = new JTextField(10);
		yearlyRate = new JLabel("Year Rate Interest: ");
		yearRate = new JTextField(10);
		year = new JLabel("Number of Years: ");
		numOfYears = new JTextField(10);
		futureValue = new JLabel("Future Value:");
		futureV = new JTextField(10);
		
		// Adds to the center panel 
		monthPanel.add(month);
		monthPanel.add(monthly);
		centerPanel.add(monthPanel);
		
		// Adds to the center panel 
		yearlyRatePanel.add(yearlyRate);
		yearlyRatePanel.add(yearRate);
		centerPanel.add(yearlyRatePanel);
		
		// Adds to the center panel 
		yearlyPanel.add(year);
		yearlyPanel.add(numOfYears);
		centerPanel.add(yearlyPanel);
		
		// Adds to the center panel 
		futurePanel.add(futureValue);
		futurePanel.add(futureV);
		centerPanel.add(futurePanel);
		
		// Initializes the buttons and adds them to the button panel 
		calculate = new JButton("Calculate");
		exit = new JButton("Exit");
		buttonPanel.setLayout(new FlowLayout()); 
		buttonPanel.add(calculate);
		buttonPanel.add(exit);
		
		// Adds the panels to the app 
		this.add(titlePanel, BorderLayout.NORTH);
		this.add(centerPanel, BorderLayout.CENTER);
		this.add(buttonPanel, BorderLayout.SOUTH);
		
		// Adds action listener to the buttons 
		calculate.addActionListener(this);
		exit.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Calculate")) { // if calculate is press, it will call the getFutureValue method 
			double monthlyInvestment = Double.parseDouble(monthly.getText());
			double yearlyRInterest = Double.parseDouble(yearRate.getText());
			int years = Integer.parseInt(numOfYears.getText());
			int months = years * 12;
			double monthlyInvestmentR = yearlyRInterest / 12 / 100;
			double futureEarned = getFutureValue(monthlyInvestment, months, monthlyInvestmentR);
			DecimalFormat format = new DecimalFormat("0.00");
			futureV.setText(String.valueOf("$"+format.format(futureEarned)));  
		}
		if(e.getActionCommand().equals("Exit")) {
			System.exit(0);
		}
	}
	
	// Method to calculate the ivestment 
	public static double getFutureValue(double monthlyInvestment, int months, double monthlyInvestmentR) {
		double futureEarned = 0.0;
		for(int i = 0; i < months; i++) {
			futureEarned = (futureEarned + monthlyInvestment) * 
					(1 + monthlyInvestmentR);
		}
		return futureEarned;
	}
}