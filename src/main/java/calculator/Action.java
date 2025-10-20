package calculator;

import java.math.BigDecimal;

/**
 * This enum represents the possible 'action' buttons that can be pressed on the calculator.
 */
public enum Action {
  // cache[0] is the currently displayed expression
  // cache[1] is the last evaluated answer;
  EQUALS {
    @Override
    public String[] execute(String[] cache) {
      String expr = cache[0].trim();
      if (expr.length() == 0) {
        return cache;
      }
      BigDecimal result = Evaluator.evaluate(expr);
      if (result == null) {
        System.exit(0);
      }
      return new String[] {cache[0], Util.formatBigDecimal(result)};
    }
  },
  DEL {
    @Override
    public String[] execute(String[] cache) {
      String expr = cache[0].trim();
      int exprLength = expr.length();
      if (exprLength == 0) {
        return cache;
      }
      return new String[] {expr.substring(0, expr.length() - 1), cache[1]};
    }
  },
  AC {
    @Override
    public String[] execute(String[] cache) {
      return new String[] {"", ""};
    }
  },
  ANS {
    @Override
    public String[] execute(String[] cache) {
      return new String[] {cache[1], cache[1]};
    }
  };

  public abstract String[] execute(String[] cache);
}
