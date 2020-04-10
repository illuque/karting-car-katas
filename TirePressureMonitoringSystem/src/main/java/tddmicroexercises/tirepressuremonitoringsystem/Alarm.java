package tddmicroexercises.tirepressuremonitoringsystem;

public class Alarm {
    static final double LOW_PRESSURE_THRESHOLD = 17;
    static final double HIGH_PRESSURE_THRESHOLD = 21;

    private PsiChecker psiChecker;

    private boolean switchedOn;

    Alarm(PsiChecker psiChecker) {
        this.psiChecker = psiChecker;
    }

    public void check() {
        this.switchedOn = isBelowPressure(psiChecker) || isOverPressure(psiChecker);
    }

    public boolean isAlarmOn() {
        return switchedOn;
    }

    private boolean isBelowPressure(PsiChecker psiChecker) {
        return psiChecker.popNextPressurePsiValue() < LOW_PRESSURE_THRESHOLD;
    }

    private boolean isOverPressure(PsiChecker psiChecker) {
        return psiChecker.popNextPressurePsiValue() > HIGH_PRESSURE_THRESHOLD;
    }

}
