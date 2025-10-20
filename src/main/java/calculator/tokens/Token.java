package calculator.tokens;

public abstract class Token {
  protected TokenType type;

  public abstract Object getValue();
  
  @Override
  public abstract String toString();

  public TokenType getType() {
    return type;
  }

  public int precedence() {
    return 0;
  }
}
