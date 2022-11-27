public class NonLuxuryVehicleFactory extends VehicleFactory {

	private static NonLuxuryVehicleFactory instance;
	
	public static NonLuxuryVehicleFactory getInstance() {
		if (instance == null) {
			instance = new NonLuxuryVehicleFactory();
			return instance;
		}
		else return instance;
	};
	
	private NonLuxuryVehicleFactory() { }

	private String[] brands = {"Opel", "Nissan", "Ford"};

	public Car getCar(String name) {
		if (name.equals("Opel")) {
			return new NonLuxuryCar("Corsa", 1295.0, 16550.00, 110.0);
		}
		else if (name.equals("Nissan")) {
			return new NonLuxuryCar("Note", 1198.0, 16195.00, 92.0);
		}
		else if (name.equals("Ford")) {
			return new NonLuxuryCar("Focus", 1595.0, 19645.00, 115.0);
		}
		else return new NonLuxuryCar("N-C", 0.0, 0.0, 0.0);
	}
	public SUV getSUV(String name) {
		if (name.equals("Opel")) {
			return new NonLuxurySUV("Mokka", 1695.0, 26045.00, 120.0);
		}
		else if (name.equals("Nissan")) {
			return new NonLuxurySUV("Qashqai", 1198.0, 24695.00, 99.0);
		}
		else if (name.equals("Ford")) {
			return new NonLuxurySUV("Kuga", 1995.0, 0.0, 139.0);
		}
		else return new NonLuxurySUV("N-S", 0.0, 0.0, 0.0);
	}
	
	public String[] getBrands() {
		return brands;
	}
} // End of class


