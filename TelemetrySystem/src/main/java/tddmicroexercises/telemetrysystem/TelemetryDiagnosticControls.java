package tddmicroexercises.telemetrysystem;

import tddmicroexercises.telemetrysystem.library.SleepTelemetryClient;
import tddmicroexercises.telemetrysystem.library.TelemetryClient;

public class TelemetryDiagnosticControls {

    private final TelemetryClient telemetryClient;
    private String diagnosticInfo = "";

    public TelemetryDiagnosticControls(TelemetryClient telemetryClient) {
        this.telemetryClient = telemetryClient;
    }

    public String getDiagnosticInfo() {
        return diagnosticInfo;
    }

    public void checkTransmission() throws Exception {
        diagnosticInfo = "";

        if (telemetryClient instanceof SleepTelemetryClient) {
            telemetryClient.disconnect();
            telemetryClient.connect();
        }

        telemetryClient.send(TelemetryClient.DIAGNOSTIC_MESSAGE);
        diagnosticInfo = telemetryClient.receive();
    }
}
