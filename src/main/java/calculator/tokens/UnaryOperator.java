package calculator.tokens;

public class UnaryOperator extends Operator {
  public UnaryOperator(String value) {
    super(value);
    this.type = TokenType.UNARY;
  }
}
