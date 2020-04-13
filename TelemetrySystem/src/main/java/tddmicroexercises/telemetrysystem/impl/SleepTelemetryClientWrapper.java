package tddmicroexercises.telemetrysystem.impl;

import tddmicroexercises.telemetrysystem.TelemetryClientConnector;
import tddmicroexercises.telemetrysystem.library.SleepTelemetryClient;

public class SleepTelemetryClientWrapper implements TelemetryClientConnector {

    private SleepTelemetryClient sleepTelemetryClient;

    public SleepTelemetryClientWrapper(SleepTelemetryClient sleepTelemetryClient) {
        this.sleepTelemetryClient = sleepTelemetryClient;
    }

    @Override
    public void send(String message) throws Exception {
        this.sleepTelemetryClient.disconnect();
        this.sleepTelemetryClient.connect();

        this.sleepTelemetryClient.send(message);
    }

    @Override
    public String receive() {
        return this.sleepTelemetryClient.receive();
    }
}
