package calculator.errors;

public class SyntaxError extends RuntimeException implements CalculatorError {
  private final String reason;

  public SyntaxError() {
    super("Syntax ERROR");
    reason = "";
  }

  public SyntaxError(String message) {
    super("Syntax ERROR");
    reason = message;
  }

  public String getReason() {
    return reason;
  }
}
