package tddmicroexercises.tirepressuremonitoringsystem;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestAlarm {

    @Test
    public void whenPressure_isBelowMinLimit_thenAlarm_isOn() {
        double currentPressure = 16.9;

        Alarm alarm = new Alarm();
        alarm.check();

        assertTrue(alarm.isAlarmOn());
    }

    @Test
    public void whenPressure_isAboveMaxLimit_thenAlarm_isOn() {
        double currentPressure = 21.1;

        Alarm alarm = new Alarm();
        alarm.check();

        assertTrue(alarm.isAlarmOn());
    }

    @Test
    public void whenPressure_isOnMinLimit_thenAlarm_isOff() {
        double currentPressure = 17.0;

        Alarm alarm = new Alarm();
        alarm.check();

        assertFalse(alarm.isAlarmOn());
    }

    @Test
    public void whenPressure_isOnMaxLimit_thenAlarm_isOff() {
        double currentPressure = 21.0;

        Alarm alarm = new Alarm();
        alarm.check();

        assertFalse(alarm.isAlarmOn());
    }

    @Test
    public void whenPressure_isBetweenLimits_thenAlarm_isOff() {
        double currentPressure = 19.0;

        Alarm alarm = new Alarm();
        alarm.check();

        assertFalse(alarm.isAlarmOn());
    }

}
