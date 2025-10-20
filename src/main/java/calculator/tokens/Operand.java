package calculator.tokens;

import java.math.BigDecimal;

public class Operand extends Token {
  private final BigDecimal value;

  public Operand(double value) {
    this.value = BigDecimal.valueOf(value);
    type = TokenType.NUMBER;
  }

  @Override
  public BigDecimal getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }
}
