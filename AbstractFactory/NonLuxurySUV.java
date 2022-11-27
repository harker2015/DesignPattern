public class NonLuxurySUV implements SUV {
	private String name;
	private double engineSize;
	private double price;
	private double co2Emissions;

	public NonLuxurySUV(String sName, double sEngineSize, double sPrice, double sCo2Emissions) {
		name = sName;
		engineSize = sEngineSize;
		price = sPrice;
		co2Emissions = sCo2Emissions;
	}
	
	public String getSUVName() {
		return name;
	}
	
	public String getSUVFeatures() {
		return "Non-Luxury SUV Features ";
	}
	
	public double getSUVEngineSize() {
		return engineSize;
	}
	
	public double getSUVPrice() {
		return price;
	}
	
	public double getSUVCO2Emissions() {
		return co2Emissions;
	}

} // End of class