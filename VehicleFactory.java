public abstract class VehicleFactory {
  public static final String LUXURY_VEHICLE = "Luxury";
  public static final String NON_LUXURY_VEHICLE = "Non-Luxury";


  public abstract Car getCar(String name);
  public abstract SUV getSUV(String name);

  public static VehicleFactory getVehicleFactory(String type) {
    if (type.equals(VehicleFactory.LUXURY_VEHICLE))
      return LuxuryVehicleFactory.getInstance();
    if (type.equals(VehicleFactory.NON_LUXURY_VEHICLE))
      return NonLuxuryVehicleFactory.getInstance();

    return LuxuryVehicleFactory.getInstance();
  }

} // End of class


