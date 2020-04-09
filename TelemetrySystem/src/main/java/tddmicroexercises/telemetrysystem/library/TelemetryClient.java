package tddmicroexercises.telemetrysystem.library;

public interface TelemetryClient {

    String DIAGNOSTIC_MESSAGE = "ST#D";

    void disconnect();

    void connect() throws Exception;

    void send(String message);

    String receive();

}
