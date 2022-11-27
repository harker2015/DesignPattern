import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Scanner;

public class RocketController extends JFrame{

	private JLabel burnAreaLabel = new JLabel("Enter burn area (m2): ");
	private JLabel burnRateLabel = new JLabel("Enter burn rate (kg/sec): ");
	private JLabel fuelMassLabel = new JLabel("Enter fuel mass (kg): ");
	private JLabel totalMassLabel = new JLabel("Enter total mass (kg): ");
	
	private JTextField burnAreaTextField = new JTextField(10);
	private JTextField burnRateTextField = new JTextField(10);
	private JTextField fuelMassTextField = new JTextField(10);
	private JTextField totalMassTextField = new JTextField(10);

	private JButton runButton = new JButton("Run");
	
	private JCheckBox useAdvanced = new JCheckBox("Use advanced simulator:");
	
	private JTextArea resultsArea = new JTextArea(20, 40);
	private JScrollPane resultsPane = new JScrollPane(resultsArea);

	private JPanel parameterPanel, buttonPanel, resultsPanel;
	
	MissileSimulator ms;

	public RocketController(){
		super("Rocket Simulator");
		initComponents();
	}

	public void initComponents(){

		Container cont = getContentPane();

		cont.setLayout(new BorderLayout());

		// Set up components for input parameters
		
		parameterPanel = new JPanel(new GridLayout(5, 2));

		parameterPanel.add(burnAreaLabel);
		parameterPanel.add(burnAreaTextField);
		burnAreaTextField.setHorizontalAlignment(JTextField.RIGHT);
		parameterPanel.add(burnRateLabel);
		parameterPanel.add(burnRateTextField);
		burnRateTextField.setHorizontalAlignment(JTextField.RIGHT);
		parameterPanel.add(fuelMassLabel);
		parameterPanel.add(fuelMassTextField);
		fuelMassTextField.setHorizontalAlignment(JTextField.RIGHT);
		parameterPanel.add(totalMassLabel);
		parameterPanel.add(totalMassTextField);
		totalMassTextField.setHorizontalAlignment(JTextField.RIGHT);
		// The checkbox indicates whether we are using the simple or the advanced simulator
		parameterPanel.add(useAdvanced);

		cont.add(parameterPanel, BorderLayout.NORTH);

		buttonPanel = new JPanel();
		buttonPanel.add(runButton);

		cont.add(buttonPanel, BorderLayout.CENTER);

		resultsPanel = new JPanel();
		resultsPanel.add(resultsPane);

		cont.add(resultsPanel, BorderLayout.SOUTH);
		
		runButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				boolean invalidField = false;
				double burnArea = 0.0, burnRate = 0.0, fuelMass = 0.0, totalMass = 0.0;
				
				// Check that parameters entered in are valid numbers
				try {
					burnArea = Double.parseDouble(burnAreaTextField.getText());
				}
				catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(RocketController.this, "ERROR: Value for burn area must be a valid double");
					invalidField = true;
				}
				
				try {
					burnRate = Double.parseDouble(burnRateTextField.getText());
				}
				catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(RocketController.this, "ERROR: Value for burn rate must be a valid double");
					invalidField = true;
				}

				try {
					fuelMass = Double.parseDouble(fuelMassTextField.getText());
				}
				catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(RocketController.this, "ERROR: Value for fuel mass must be a valid double");
					invalidField = true;
				}

				try {
					totalMass = Double.parseDouble(totalMassTextField.getText());
				}
				catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(RocketController.this, "ERROR: Value for total mass must be a valid double");
					invalidField = true;
				}
				
				// The fuel mass cannot be greater than the total mass of the rocket
				if (fuelMass >= totalMass) {
					JOptionPane.showMessageDialog(RocketController.this, "ERROR: Fuel mass must be less than total mass");
					invalidField = true;					
				}
				
				if (!invalidField) {
					if (!useAdvanced.isSelected()) {
						// Using SimpleMissile

						// Calculating burn time, assuming fuel density is 1800kg/m2
						double burnTime = (fuelMass / 1800.0) * burnRate * burnArea;
						
						// Calculating thrust, assuming same fuel density and specific impulse of 620 newtons/kg
						double thrust = 1800.0 * 620.0 * burnRate * burnArea;
						
						// Create simple simulator using these parameters
						ms = new SimpleMissile(totalMass, thrust, burnTime);
						
						// Counter to update time during rocket's life
						double counter = 0.0;
						
						// Repeated each second
						while (counter < burnTime) {
							// Display mass and thrust each second
							resultsArea.append("At time " + counter + "seconds:\n\n");
							resultsArea.append("Mass: " + ms.getMassInKg() + "kg\n");
							resultsArea.append("Thrust: " + ms.getThrustInNewtonsSec() + "newtons/sec\n\n");
							counter += 1.0;
							// Update simulator's clock
							ms.setSimulatedTime(counter);
						}
						
						// Closing values when rocket has crashed
						ms.setSimulatedTime(burnTime);
						resultsArea.append("At time " + burnTime + "seconds:\n\n");
						resultsArea.append("Mass: " + ms.getMassInKg() + "kg\n");
						resultsArea.append("Thrust: " + ms.getThrustInNewtonsSec() + "newtons/sec\n");
					}
					else {
						// Here you can insert the code for using the advanced simulator with an adapter.
					}
				}
			}

		});

	}
	
	public static void main(String[] args) {
		RocketController c = new RocketController();
		c.setSize(470, 550);
		c.setVisible(true);

	}
}