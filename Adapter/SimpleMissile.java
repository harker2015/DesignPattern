// Instances of this class simulate rockets. The simulation depends mainly on the internal ballistics of the burning fuel.

public class SimpleMissile implements MissileSimulator {
    private double mass; // Initial mass of the rocket
    private double thrust; // Initial thrust of the rocket
    private double burnTime; // Burn time of the rocket fuel
    protected double simTime; // Simulation time counter

    // We create a model of a rocket.
    public SimpleMissile(double mass, double thrust, double burnTime) {
        this.mass = mass;
        this.thrust = thrust;
        this.burnTime = burnTime;
    }

    // We model the mass of the rocket as reducing linearly from the initial mass down to 0 during the life of the fuel.
    public double getMassInKg() {
        if (simTime > burnTime) return 0.0;
        return mass * (1.0 - (simTime / burnTime));
    }

    // We model the thrust of the rocket as being constant while there is fuel to be burnt.
    public double getThrustInNewtonsSec() {
        if (simTime > burnTime) return 0.0;
        return thrust;
    }

    // When the simulation updates its clock, we retain the current time.
    public void setSimulatedTime(double newTime) {
        simTime = newTime;
    }
}