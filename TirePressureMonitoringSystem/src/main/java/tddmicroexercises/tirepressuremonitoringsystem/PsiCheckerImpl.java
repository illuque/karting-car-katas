package tddmicroexercises.tirepressuremonitoringsystem;

public class PsiCheckerImpl implements PsiChecker {

    private Sensor sensor;

    public PsiCheckerImpl(Sensor sensor) {
        this.sensor = sensor;
    }

    @Override
    public double popNextPressurePsiValue() {
        return sensor.popNextPressurePsiValue();
    }
}
