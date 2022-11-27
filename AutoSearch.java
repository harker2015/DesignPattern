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

	private String[] brands = {"Ford", "Nissan", "Opel", "Audi", "BMW", "Lexus"};
	private String[] luxuryCategories = {"Luxury", "Non-Luxury"};
	private String[] vehicleTypes = {"Car", "SUV"};

	private JComboBox<String> categoryComboBox, vehTypeComboBox, vehBrandComboBox;

	private JLabel categoryLabel, typeLabel, brandLabel, nameLabel, 
	       featuresLabel, engineSizeLabel, priceLabel, emissionsLabel;

	private JLabel nameValueLabel, featuresValueLabel, engineSizeValueLabel, priceValueLabel, emissionsValueLabel;

	public AutoSearch() {
		super("AutoSearch Motor Guide");

		categoryComboBox = new JComboBox<String>(luxuryCategories);

		vehTypeComboBox = new JComboBox<String>(vehicleTypes);

		vehBrandComboBox = new JComboBox<String>();
		vehBrandComboBox.setModel(new DefaultComboBoxModel<String>(brands));

		categoryLabel = new JLabel("Vehicle Category:");
		typeLabel = new JLabel("Vehicle Type:");
		brandLabel = new JLabel("Vehicle Brand:");

		nameLabel = new JLabel("Model Name:");
		featuresLabel = new JLabel("Features:");
		engineSizeLabel = new JLabel("Engine Size:");
		priceLabel = new JLabel("Price:");
		emissionsLabel = new JLabel("CO2 Emissions:");

		//Create the open button
		JButton openButton = new JButton(AutoSearch.SEARCH);
		openButton.setMnemonic(KeyEvent.VK_S);
		JButton exitButton = new JButton(AutoSearch.EXIT);
		exitButton.setMnemonic(KeyEvent.VK_X);

		JPanel topPanel = new JPanel(new BorderLayout());

		JPanel comboBoxPanel = new JPanel();
		comboBoxPanel.setLayout(new GridLayout(3, 2));

		comboBoxPanel.add(categoryLabel);
		comboBoxPanel.add(categoryComboBox);

		comboBoxPanel.add(typeLabel);
		comboBoxPanel.add(vehTypeComboBox);

		comboBoxPanel.add(brandLabel);
		comboBoxPanel.add(vehBrandComboBox);

		JPanel buttonPanel = new JPanel();

		buttonPanel.add(openButton);
		buttonPanel.add(exitButton);

		openButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String vhCategory = getSelectedCategory();
				String vhType = getSelectedType();
				String vhBrand = getSelectedBrand();

				if (vhCategory.equals("Luxury")) {
					if (vhType.equals("SUV")) {
						if (vhBrand.equals("Audi")) {
							updateValuesForSUV(new LuxurySUV("Q5", 1720.0, 46180.00, 172.0));
						}
						else if (vhBrand.equals("BMW")) {
							updateValuesForSUV(new LuxurySUV("X3", 1995.0, 55830.00, 135.0));
						}
						else if (vhBrand.equals("Lexus")) {
							updateValuesForSUV(new LuxurySUV("NX 300", 1998.0, 43950.00, 116.0));						
						}
						else updateValuesForSUV(null);
					}
					else if (vhType.equals("Car")) {
						if (vhBrand.equals("Audi")) {
							updateValuesForCar(new LuxuryCar("A4", 1798.0, 35720.00, 151.0));
						}
						else if (vhBrand.equals("BMW")) {
							updateValuesForCar(new LuxuryCar("3", 1598.0, 35190.00, 137.0));
						}
						else if (vhBrand.equals("Lexus")) {
							updateValuesForCar(new LuxuryCar("IS 300", 1598.0, 37950.00, 99.0));						
						}
						else updateValuesForCar(null);
					}
				}
				else if (vhCategory.equals("Non-Luxury")) {
					if (vhType.equals("SUV")) {
						if (vhBrand.equals("Ford")) {
							updateValuesForSUV(new NonLuxurySUV("Kuga", 1995.0, 0.0, 139.0));
						}
						else if (vhBrand.equals("Nissan")) {
							updateValuesForSUV(new NonLuxurySUV("Qashqai", 1198.0, 24695.00, 99.0));
						}
						else if (vhBrand.equals("Opel")) {
							updateValuesForSUV(new NonLuxurySUV("Mokka", 1695.0, 26045.00, 120.0));						
						}
						else updateValuesForCar(null);
					}
					else if (vhType.equals("Car")) {
						if (vhBrand.equals("Ford")) {
							updateValuesForCar(new NonLuxuryCar("Focus", 1595.0, 19645.00, 115.0));
						}
						else if (vhBrand.equals("Nissan")) {
							updateValuesForCar(new NonLuxuryCar("Note", 1198.0, 16195.00, 92.0));
						}
						else if (vhBrand.equals("Opel")) {
							updateValuesForCar(new NonLuxuryCar("Corsa", 1295.0, 16550.00, 110.0));						
						}
						else updateValuesForCar(null);
					}
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

		resultPanel.add(nameLabel);
		resultPanel.add(nameValueLabel = new JLabel(""));

		resultPanel.add(featuresLabel);
		resultPanel.add(featuresValueLabel = new JLabel(""));

		resultPanel.add(engineSizeLabel);
		resultPanel.add(engineSizeValueLabel = new JLabel(""));

		resultPanel.add(priceLabel);
		resultPanel.add(priceValueLabel = new JLabel(""));

		resultPanel.add(emissionsLabel);
		resultPanel.add(emissionsValueLabel = new JLabel(""));

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

		frame.setSize(400, 300);
		frame.setVisible(true);
	}

	public String getSelectedCategory() {
		return (String)categoryComboBox.getSelectedItem();
	}

	public String getSelectedType() {
		return (String)vehTypeComboBox.getSelectedItem();
	}

	public String getSelectedBrand() {
		return (String)vehBrandComboBox.getSelectedItem();
	}

	public void updateValuesForCar(Car carDetails) {
		if (carDetails == null) {
			nameValueLabel.setText("");
			engineSizeValueLabel.setText("");
			priceValueLabel.setText("");
			emissionsValueLabel.setText("");
		}
		else {
			nameValueLabel.setText(carDetails.getCarName());
			engineSizeValueLabel.setText(carDetails.getCarEngineSize() + " cc");
			DecimalFormat cf = new DecimalFormat("€##,###.00");
			priceValueLabel.setText(cf.format(carDetails.getCarPrice()));
			emissionsValueLabel.setText(carDetails.getCarCO2Emissions() + " gm CO2");
		}
	}

	public void updateValuesForSUV(SUV suvDetails) {
		if (suvDetails == null) {
			nameValueLabel.setText("");
			engineSizeValueLabel.setText("");
			priceValueLabel.setText("");
			emissionsValueLabel.setText("");
		}
		else {
			nameValueLabel.setText(suvDetails.getSUVName());
			engineSizeValueLabel.setText(suvDetails.getSUVEngineSize() + " cc");
			DecimalFormat cf = new DecimalFormat("€##,###.00");
			priceValueLabel.setText(cf.format(suvDetails.getSUVPrice()));
			emissionsValueLabel.setText(suvDetails.getSUVCO2Emissions() + " gm CO2");
		}

	}


} // End of class AutoSearch