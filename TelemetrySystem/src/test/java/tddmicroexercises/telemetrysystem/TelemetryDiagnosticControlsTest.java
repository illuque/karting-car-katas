package tddmicroexercises.telemetrysystem;

import org.junit.Assert;
import org.junit.Test;

import tddmicroexercises.telemetrysystem.library.SleepTelemetryClient;

public class TelemetryDiagnosticControlsTest {

    private static class SleepTelemetryClientStubSpy extends SleepTelemetryClient {

        private int connectCounter = 0;
        private int disconnectCounter = 0;

        @Override
        public String receive() {
            return "SleepTelemetryClientStubSpy Result";
        }

        @Override
        public void connect() {
            this.connectCounter++;
        }

        @Override
        public void disconnect() {
            this.disconnectCounter++;
        }

    }

    private static class AwakeTelemetryClientStubSpy extends AwakeTelemetryClient {

        private int connectCounter = 0;
        private int disconnectCounter = 0;

        @Override
        public String receive() {
            return "AwakeTelemetryClientStubSpy Result";
        }

        @Override
        public void connect() {
            this.connectCounter++;
        }

        @Override
        public void disconnect() {
            this.disconnectCounter++;
        }

    }

    @Test
    public void whenSleepTelemetryClient_thenDisconnectConnectAndReturnDiagnosisInfo() throws Exception {
        SleepTelemetryClientStubSpy sleepTelemetryClientStubSpy = new SleepTelemetryClientStubSpy();

        TelemetryDiagnosticControls telemetryDiagnosticControls = new TelemetryDiagnosticControls(sleepTelemetryClientStubSpy);
        telemetryDiagnosticControls.checkTransmission();

        Assert.assertEquals("SleepTelemetryClientStubSpy Result", telemetryDiagnosticControls.getDiagnosticInfo());
        Assert.assertEquals(1, sleepTelemetryClientStubSpy.connectCounter);
        Assert.assertEquals(1, sleepTelemetryClientStubSpy.disconnectCounter);
    }

    @Test
    public void whenAwakeTelemetryClient_thenReturnDiagnosisInfo() throws Exception {
        AwakeTelemetryClientStubSpy awakeTelemetryClientStubSpy = new AwakeTelemetryClientStubSpy();

        TelemetryDiagnosticControls telemetryDiagnosticControls = new TelemetryDiagnosticControls(awakeTelemetryClientStubSpy);
        telemetryDiagnosticControls.checkTransmission();

        Assert.assertEquals("AwakeTelemetryClientStubSpy Result", telemetryDiagnosticControls.getDiagnosticInfo());
        Assert.assertEquals(0, awakeTelemetryClientStubSpy.connectCounter);
        Assert.assertEquals(0, awakeTelemetryClientStubSpy.disconnectCounter);
    }

    @Test
    public void whenCheckNotCalled_thenEmptyDiagnosisInfo() {
        SleepTelemetryClientStubSpy sleepTelemetryClientStubSpy = new SleepTelemetryClientStubSpy();

        TelemetryDiagnosticControls telemetryDiagnosticControls = new TelemetryDiagnosticControls(sleepTelemetryClientStubSpy);

        Assert.assertEquals("", telemetryDiagnosticControls.getDiagnosticInfo());
    }

}
