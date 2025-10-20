package calculator.tokens;

public class Function extends Token {
  private final String value;

  public Function(String value) {
    this.value = value;
    type = TokenType.FUNCTION;
  }

  @Override
  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return value;
  }

  @Override
  public int precedence() {
    return 1;
  }
}
