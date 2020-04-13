package tddmicroexercises.telemetrysystem;

import org.junit.Assert;
import org.junit.Test;

import tddmicroexercises.telemetrysystem.impl.AwakeTelemetryClient;
import tddmicroexercises.telemetrysystem.impl.SleepTelemetryClientWrapper;
import tddmicroexercises.telemetrysystem.library.SleepTelemetryClient;

public class TelemetryDiagnosticControlsTest {

    private static class SleepTelemetryClientStubSpy extends SleepTelemetryClientWrapper {

        public SleepTelemetryClientStubSpy(SleepTelemetryClient sleepTelemetryClient) {
            super(sleepTelemetryClient);
        }

        @Override
        public String receive() {
            return "SleepTelemetryClientStubSpy Result";
        }

    }

    private static class AwakeTelemetryClientStubSpy extends AwakeTelemetryClient {

        @Override
        public String receive() {
            return "AwakeTelemetryClientStubSpy Result";
        }

    }

    @Test
    public void whenSleepTelemetryClient_thenDisconnectConnectAndReturnDiagnosisInfo() throws Exception {
        SleepTelemetryClientStubSpy sleepTelemetryClientStubSpy = new SleepTelemetryClientStubSpy(new SleepTelemetryClient());

        TelemetryDiagnosticControls telemetryDiagnosticControls = new TelemetryDiagnosticControls(sleepTelemetryClientStubSpy);
        telemetryDiagnosticControls.checkTransmission();

        Assert.assertEquals("SleepTelemetryClientStubSpy Result", telemetryDiagnosticControls.getDiagnosticInfo());
    }

    @Test
    public void whenAwakeTelemetryClient_thenReturnDiagnosisInfo() throws Exception {
        AwakeTelemetryClientStubSpy awakeTelemetryClientStubSpy = new AwakeTelemetryClientStubSpy();

        TelemetryDiagnosticControls telemetryDiagnosticControls = new TelemetryDiagnosticControls(awakeTelemetryClientStubSpy);
        telemetryDiagnosticControls.checkTransmission();

        Assert.assertEquals("AwakeTelemetryClientStubSpy Result", telemetryDiagnosticControls.getDiagnosticInfo());
    }

    @Test
    public void whenCheckNotCalled_thenEmptyDiagnosisInfo() {
        SleepTelemetryClientStubSpy sleepTelemetryClientStubSpy = new SleepTelemetryClientStubSpy(new SleepTelemetryClient());

        TelemetryDiagnosticControls telemetryDiagnosticControls = new TelemetryDiagnosticControls(sleepTelemetryClientStubSpy);

        Assert.assertEquals("", telemetryDiagnosticControls.getDiagnosticInfo());
    }

}
