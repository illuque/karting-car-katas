package tddmicroexercises.tirepressuremonitoringsystem;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TestAlarm {

    @Mock
    private PsiChecker psiChecker;

    @Test
    public void whenPressure_isBelowMinLimit_thenAlarm_isOn() {
        when(psiChecker.popNextPressurePsiValue()).thenReturn(16.9);

        Alarm alarm = new Alarm(psiChecker);
        alarm.check();

        assertTrue(alarm.isAlarmOn());
    }

    @Test
    public void whenPressure_isAboveMaxLimit_thenAlarm_isOn() {
        when(psiChecker.popNextPressurePsiValue()).thenReturn(21.1);

        Alarm alarm = new Alarm(psiChecker);
        alarm.check();

        assertTrue(alarm.isAlarmOn());
    }

    @Test
    public void whenPressure_isOnMinLimit_thenAlarm_isOff() {
        when(psiChecker.popNextPressurePsiValue()).thenReturn(17.0);

        Alarm alarm = new Alarm(psiChecker);
        alarm.check();

        assertFalse(alarm.isAlarmOn());
    }

    @Test
    public void whenPressure_isOnMaxLimit_thenAlarm_isOff() {
        when(psiChecker.popNextPressurePsiValue()).thenReturn(21.0);

        Alarm alarm = new Alarm(psiChecker);
        alarm.check();

        assertFalse(alarm.isAlarmOn());
    }

    @Test
    public void whenPressure_isBetweenLimits_thenAlarm_isOff() {
        when(psiChecker.popNextPressurePsiValue()).thenReturn(19.0);

        Alarm alarm = new Alarm(psiChecker);
        alarm.check();

        assertFalse(alarm.isAlarmOn());
    }

}
