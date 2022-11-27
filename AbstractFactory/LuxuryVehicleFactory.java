public class LuxuryVehicleFactory extends VehicleFactory {
	
	private static LuxuryVehicleFactory instance;
	
	public static LuxuryVehicleFactory getInstance() {
		if (instance == null) {
			instance = new LuxuryVehicleFactory();
			return instance;
		}
		else return instance;
	};
	
	private LuxuryVehicleFactory() { }

	private String[] brands = {"Audi", "BMW", "Lexus"};

	public Car getCar(String name) {
		if (name.equals("Audi")) {
			return new LuxuryCar("A4", 1798.0, 35720.00, 151.0);
		}
		else if (name.equals("BMW")) {
			return new LuxuryCar("3", 1598.0, 35190.00, 137.0);
		}
		else if (name.equals("Lexus")) {
			return new LuxuryCar("IS 300", 1598.0, 37950.00, 99.0);
		}
		else return new LuxuryCar("L-C", 0.0, 0.0, 0.0);
	}
	
	public SUV getSUV(String name) {
		if (name.equals("Audi")) {
			return new LuxurySUV("Q5", 1720.0, 46180.00, 172.0);
		}
		else if (name.equals("BMW")) {
			return new LuxurySUV("X3", 1995.0, 55830.00, 135.0);
		}
		else if (name.equals("Lexus")) {
			return new LuxurySUV("NX 300", 1998.0, 43950.00, 116.0);
		}
		else return new LuxurySUV("L-S", 0.0, 0.0, 0.0);
	}
	
	public String[] getBrands() {
		return brands;
	}
	
} // End of class