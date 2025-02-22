package TrabajoIntegrador.exception;

public class InvalidDbConnection extends RuntimeException  {
    public InvalidDbConnection(String message) {
        super(message);
    }
    public InvalidDbConnection(String message, Throwable cause) {
        super(message, cause);
    }
}
