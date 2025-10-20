package calculator.errors;

public class MathError extends RuntimeException implements CalculatorError {
  private final String reason;

  public MathError() {
    super("Math ERROR");
    reason = "";
  }

  public MathError(String message) {
    super("Math ERROR");
    reason = message;
  }

  public String getReason() {
    return reason;
  }
}
