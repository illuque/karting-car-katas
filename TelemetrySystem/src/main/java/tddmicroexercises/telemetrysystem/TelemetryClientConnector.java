package tddmicroexercises.telemetrysystem;

public interface TelemetryClientConnector {

    void send(String message) throws Exception;

    String receive();

}
