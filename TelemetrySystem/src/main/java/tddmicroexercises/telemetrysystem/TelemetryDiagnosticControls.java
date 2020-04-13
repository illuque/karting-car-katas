package tddmicroexercises.telemetrysystem;

import tddmicroexercises.telemetrysystem.library.TelemetryClient;

public class TelemetryDiagnosticControls {

    private final TelemetryClientConnector telemetryConnector;
    private String diagnosticInfo = "";

    public TelemetryDiagnosticControls(TelemetryClientConnector telemetryConnector) {
        this.telemetryConnector = telemetryConnector;
    }

    public String getDiagnosticInfo() {
        return diagnosticInfo;
    }

    public void checkTransmission() throws Exception {
        diagnosticInfo = "";

        telemetryConnector.send(TelemetryClient.DIAGNOSTIC_MESSAGE);
        diagnosticInfo = telemetryConnector.receive();
    }
}
