package tddmicroexercises.tirepressuremonitoringsystem;

public class Alarm {
    static final double LOW_PRESSURE_THRESHOLD = 17;
    static final double HIGH_PRESSURE_THRESHOLD = 21;

    private Sensor sensor;

    private boolean switchedOn;

    Alarm(Sensor sensor) {
        this.sensor = sensor;
    }

    public void check() {
        this.switchedOn = isBelowPressure(sensor) || isOverPressure(sensor);
    }

    public boolean isAlarmOn() {
        return switchedOn;
    }

    private boolean isBelowPressure(Sensor sensor) {
        return sensor.popNextPressurePsiValue() < LOW_PRESSURE_THRESHOLD;
    }

    private boolean isOverPressure(Sensor sensor) {
        return sensor.popNextPressurePsiValue() > HIGH_PRESSURE_THRESHOLD;
    }

}
