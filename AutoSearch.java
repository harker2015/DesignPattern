import java.io.*;
import java.io.*;
import java.text.DecimalFormat;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class AutoSearch extends JFrame {

	public static final String newline = "\n";
	public static final String SEARCH = "Search";
	public static final String EXIT = "Exit";
	public static final String CAR = "Car";
	public static final String SUV = "SUV";
	public static final String LUXURY_VEHICLE = "Luxury";
	public static final String NON_LUXURY_VEHICLE = "Non-Luxury";
	
	private String[] brands = {"Ford", "Nissan", "Opel", "Audi", "BMW", "Lexus"};

	private JComboBox<String> cmbVehicleCategory, cmbVehicleType, cmbVehicleBrand;

	private JLabel lblVehicleCategory, lblVehicleType, lblVehicleBrand, lblCarName, lblCarFeatures, lblCarEngineSize, lblCarPrice, 
		lblCarCO2Emissions;
	
	private JLabel lblCarNameValue, lblCarFeaturesValue, lblCarEngineSizeValue, lblCarPriceValue, lblCarCO2EmissionsValue;

	public AutoSearch() {
		super("AutoSearch Motor Guide");

		cmbVehicleCategory = new JComboBox<String>();
		cmbVehicleCategory.addItem(AutoSearch.LUXURY_VEHICLE);
		cmbVehicleCategory.addItem(AutoSearch.NON_LUXURY_VEHICLE);

		cmbVehicleType = new JComboBox<String>();
		cmbVehicleType.addItem(AutoSearch.CAR);
		cmbVehicleType.addItem(AutoSearch.SUV);

		cmbVehicleBrand = new JComboBox<String>();
		cmbVehicleBrand.setModel(new DefaultComboBoxModel<String>(brands));

		lblVehicleCategory = new JLabel("Vehicle Category:");
		lblVehicleType = new JLabel("Vehicle Type:");
		lblVehicleBrand = new JLabel("Vehicle Brand:");
		
		lblCarName = new JLabel("Model Name:");
		lblCarFeatures = new JLabel("Features:");
		lblCarEngineSize = new JLabel("Engine Size:");
		lblCarPrice = new JLabel("Price:");
		lblCarCO2Emissions = new JLabel("CO2 Emissions:");

		//Create the open button
		JButton openButton = new JButton(AutoSearch.SEARCH);
		openButton.setMnemonic(KeyEvent.VK_S);
		JButton exitButton = new JButton(AutoSearch.EXIT);
		exitButton.setMnemonic(KeyEvent.VK_X);

		JPanel topPanel = new JPanel(new BorderLayout());

		JPanel comboBoxPanel = new JPanel();
		comboBoxPanel.setLayout(new GridLayout(3, 2));
		
		comboBoxPanel.add(lblVehicleCategory);
		comboBoxPanel.add(cmbVehicleCategory);
		
		comboBoxPanel.add(lblVehicleType);
		comboBoxPanel.add(cmbVehicleType);
		
		comboBoxPanel.add(lblVehicleBrand);
		comboBoxPanel.add(cmbVehicleBrand);

		JPanel buttonPanel = new JPanel();

		buttonPanel.add(openButton);
		buttonPanel.add(exitButton);
		
		openButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String vhCategory = getSelectedCategory();
				String vhType = getSelectedType();
				String vhBrand = getSelectedBrand();
				
				VehicleFactory vf = VehicleFactory.getVehicleFactory(vhCategory);
				
				if (vhType.equals(AutoSearch.CAR)) {
			        Car c = vf.getCar(vhBrand);
			        updateValuesForCar(c);
			    }
				else if (vhType.equals(AutoSearch.SUV)) {
			        SUV s = vf.getSUV(vhBrand);
			        updateValuesForSUV(s);
			    }
				
			}
		});
		
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
		
		topPanel.add(comboBoxPanel, BorderLayout.NORTH);
		topPanel.add(buttonPanel, BorderLayout.SOUTH);
		
		JPanel resultPanel = new JPanel(new GridLayout(5,2));
		
		resultPanel.add(lblCarName);
		resultPanel.add(lblCarNameValue = new JLabel(""));
		
		resultPanel.add(lblCarFeatures);
		resultPanel.add(lblCarFeaturesValue = new JLabel(""));

		resultPanel.add(lblCarEngineSize);
		resultPanel.add(lblCarEngineSizeValue = new JLabel(""));

		resultPanel.add(lblCarPrice);
		resultPanel.add(lblCarPriceValue = new JLabel(""));

		resultPanel.add(lblCarCO2Emissions);
		resultPanel.add(lblCarCO2EmissionsValue = new JLabel(""));

		//Add the buttons and the log to the frame
		Container contentPane = getContentPane();

		contentPane.add(topPanel, BorderLayout.NORTH);
		contentPane.add(resultPanel, BorderLayout.CENTER);

	}

	public static void main(String[] args) {
		JFrame frame = new AutoSearch();

		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		}
				);

		//frame.pack();
		frame.setSize(400, 300);
		frame.setVisible(true);
	}
	
	public String getSelectedCategory() {
		return (String)cmbVehicleCategory.getSelectedItem();
	}
	
	public String getSelectedType() {
		return (String)cmbVehicleType.getSelectedItem();
	}
	
	public String getSelectedBrand() {
		return (String)cmbVehicleBrand.getSelectedItem();
	}
	
	public void updateValuesForCar(Car carDetails) {
		if (carDetails == null) {
			lblCarNameValue.setText("");
			lblCarEngineSizeValue.setText("");
			lblCarPriceValue.setText("");
			lblCarCO2EmissionsValue.setText("");
		}
		else {
			lblCarNameValue.setText(carDetails.getCarName());
			lblCarEngineSizeValue.setText(carDetails.getCarEngineSize() + " cc");
			DecimalFormat cf = new DecimalFormat("€##,###.00");
			lblCarPriceValue.setText(cf.format(carDetails.getCarPrice()));
			lblCarCO2EmissionsValue.setText(carDetails.getCarCO2Emissions() + " gm CO2");
		}
	}
	
	public void updateValuesForSUV(SUV suvDetails) {
		if (suvDetails == null) {
			lblCarNameValue.setText("");
			lblCarEngineSizeValue.setText("");
			lblCarPriceValue.setText("");
			lblCarCO2EmissionsValue.setText("");
		}
		else {
			lblCarNameValue.setText(suvDetails.getSUVName());
			lblCarEngineSizeValue.setText(suvDetails.getSUVEngineSize() + " cc");
			DecimalFormat cf = new DecimalFormat("€##,###.00");
			lblCarPriceValue.setText(cf.format(suvDetails.getSUVPrice()));
			lblCarCO2EmissionsValue.setText(suvDetails.getSUVCO2Emissions() + " gm CO2");
		}
		
	}
	

} // End of class AutoSearch