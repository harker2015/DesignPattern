public class ClassMissileAdapter extends RealisticBehaviour implements MissileSimulator {
    private double time;

    public ClassMissileAdapter(double burnArea, double burnRate, double fuelMass, double totalMass) {
        super(burnArea, burnRate, fuelMass, totalMass);
    }

    public double getMassInKg() {
        return getMass(time);
    }

    public double getThrustInNewtonsSec() {
        return getThrust(time);
    }

    public void setSimulatedTime(double time) {
        this.time = time;
    }
}