public class ObjectMissileAdapter extends SimpleMissile {
	
	private RealisticBehaviour missile;

    public ObjectMissileAdapter(RealisticBehaviour m) {
        super(m.getMass(0), m.getThrust(0), m.getBurnTime());
        missile = m;
    }

    public double getMassInKg() {
        return missile.getMass(simTime);
    }

    public double getThrustInNewtonsSec() {
        return missile.getThrust(simTime);
    }

	public double getBurnTime() {
		return missile.getBurnTime();
	}
}