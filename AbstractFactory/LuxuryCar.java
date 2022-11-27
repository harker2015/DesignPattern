public class LuxuryCar implements Car {
	private String name;
	private double engineSize;
	private double price;
	private double co2Emissions;

	public LuxuryCar(String cName, double cEngineSize, double cPrice, double cCo2Emissions) {
		name = cName;
		engineSize = cEngineSize;
		price = cPrice;
		co2Emissions = cCo2Emissions;
	}
	
	public String getCarName() {
		return name;
	}
	public String getCarFeatures() {
		return "Luxury Car Features ";
	}
	
	public double getCarEngineSize() {
		return engineSize;
	}
	
	public double getCarPrice() {
		return price;
	}
	
	public double getCarCO2Emissions() {
		return co2Emissions;
	}

} // End of class


