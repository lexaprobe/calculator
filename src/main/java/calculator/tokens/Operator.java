package calculator.tokens;

public class Operator extends Token {
  protected final String value;

  public Operator(String value) {
    this.value = value;
    type = TokenType.OPERATOR;
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
    int precendence = switch (value) {
      // BODMAS rule
      case "(", ")" -> 3;
      case "minus" -> 3;
      case "!" -> 3;
      case "^" -> 3;
      case "÷" -> 2;
      case "×" -> 2;
      case "+" -> 1;
      case "-" -> 1;
      default -> 0;
    };
    return precendence;
  }
}