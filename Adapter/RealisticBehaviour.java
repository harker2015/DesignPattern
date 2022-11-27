// A physical model of a rocket for use in ballistics simulations.

public class RealisticBehaviour {
	
    private double burnArea; // Burn area
    private double burnRate; // Rate at which fuel is burnt
    private double initialFuelMass; // Initial mass of the fuel powering the rocket
    private double totalMass; // Mass of the rocket and the fuel powering it

    private double totalBurnTime; // The total burn time

    private static double SPECIFIC_IMPULSE = 620.0; // Expressed in newtons per kilogram
    private static double FUEL_DENSITY = 1800.0; // Expressed in kilograms per metre squared

    public RealisticBehaviour(double burnArea, double burnRate, double fuelMass, double totalMass) {
        this.burnArea = burnArea;
        this.burnRate = burnRate;
        this.initialFuelMass = fuelMass;
        this.totalMass = totalMass;

        double initialFuelVolume = fuelMass / FUEL_DENSITY; // initial fuel volume
        this.totalBurnTime = initialFuelVolume / (burnRate * burnArea);
    }

    // Calculates the remaining mass of the missile after a portion of its fuel has been burnt off
    // This portion will be determined by the time elapsed since the rocket was ignited.
    
    public double getMass(double timeSinceIgnition) {
        if (timeSinceIgnition > totalBurnTime) return totalMass - initialFuelMass;
        double burntFuelVolume = burnRate * burnArea * timeSinceIgnition; // Calculate the burnt fuel volume
        return totalMass - burntFuelVolume * FUEL_DENSITY;
    }

    // Calculates the current thrust of the rocket based on the time elapsed since ignition.
    
    public double getThrust(double timeSinceIgnition) {
        if (timeSinceIgnition > totalBurnTime) return 0;
        return FUEL_DENSITY * SPECIFIC_IMPULSE * burnRate * burnArea;
    }

    // Returns the length of time that the missile's fuel will burn for.
    
    public double getBurnTime() {
        return totalBurnTime;
    }
}