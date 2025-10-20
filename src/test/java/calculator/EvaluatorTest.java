package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import calculator.errors.MathError;
import calculator.errors.SyntaxError;
import java.math.BigDecimal;
import java.math.RoundingMode;
import org.junit.jupiter.api.Test;

/**
 * Test suite for the <code>calculator.Evaluator</code> class.
 */
class EvaluatorTest {
  
  // To do: add tests for negative numbers

  @Test
  void testBasicAddition() {
    try {
      assertEquals(BigDecimal.TWO, Evaluator.evaluate("1 + 1"));
    } catch (SyntaxError | MathError e) {
      fail(e.getMessage() + " -> " + e.getReason());
    }
  }

  @Test
  void testBasicSubtraction() {
    try {
      assertEquals(BigDecimal.ONE, Evaluator.evaluate("2 - 1"));
    } catch (SyntaxError | MathError e) {
      fail(e.getMessage() + " -> " + e.getReason());
    }
  }

  @Test
  void testBasicMultiplication() {
    try {
      assertEquals(BigDecimal.valueOf(4), Evaluator.evaluate("2 × 2"));
    } catch (SyntaxError | MathError e) {
      fail(e.getMessage() + " -> " + e.getReason());
    }
  }

  @Test
  void testBasicDivision() {
    try {
      assertEquals(BigDecimal.valueOf(3), Evaluator.evaluate("9 ÷ 3"));
    } catch (SyntaxError | MathError e) {
      fail(e.getMessage() + " -> " + e.getReason());
    }
  }

  @Test
  void testMultiDigitAdd() {
    try {
      assertEquals(BigDecimal.valueOf(579), Evaluator.evaluate("123 + 456"));
    } catch (SyntaxError | MathError e) {
      fail(e.getMessage() + " -> " + e.getReason());
    }
  }

  @Test
  void testMultiDigitSub() {
    try {
      assertEquals(BigDecimal.valueOf(78), Evaluator.evaluate("123 - 45"));
    } catch (SyntaxError | MathError e) {
      fail(e.getMessage() + " -> " + e.getReason());
    }
  }

  @Test
  void testMultiDigitMult() {
    try {
      assertEquals(BigDecimal.valueOf(56088), Evaluator.evaluate("123 × 456"));
    } catch (SyntaxError | MathError e) {
      fail(e.getMessage() + " -> " + e.getReason());
    }
  }

  @Test
  void testMultiDigitDiv() {
    try {
      assertEquals(BigDecimal.valueOf(4), Evaluator.evaluate("100 ÷ 25"));
    } catch (SyntaxError | MathError e) {
      fail(e.getMessage() + " -> " + e.getReason());
    }
  }

  @Test
  void testDecimalAdd() {
    try {
      assertEquals(BigDecimal.TWO, Evaluator.evaluate("1.1 + 0.9"));
    } catch (SyntaxError | MathError e) {
      fail(e.getMessage() + " -> " + e.getReason());
    }
  }

  @Test
  void testDecimalSub() {
    try {
      assertEquals(BigDecimal.valueOf(0.40964), Evaluator.evaluate("1.08764 - 0.678"));
    } catch (SyntaxError | MathError e) {
      fail(e.getMessage() + " -> " + e.getReason());
    }
  }

  @Test
  void testDecimalMult() {
    try {
      assertEquals(BigDecimal.valueOf(117.012), Evaluator.evaluate("8.4 × 13.93"));
    } catch (SyntaxError | MathError e) {
      fail(e.getMessage() + " -> " + e.getReason());
    }
  }

  @Test
  void testDecimalDiv() {
    try {
      assertEquals(BigDecimal.valueOf(26.12), Evaluator.evaluate("65.3 ÷ 2.5"));
    } catch (SyntaxError | MathError e) {
      fail(e.getMessage() + " -> " + e.getReason());
    }
  }

  @Test
  void testIrrationalAdd() {
    try {
      BigDecimal irr = Evaluator.evaluate("π + e").setScale(9, RoundingMode.HALF_UP);
      assertEquals(irr, BigDecimal.valueOf(5.859874482));
    } catch (SyntaxError | MathError e) {
      fail(e.getMessage() + " -> " + e.getReason());
    }
  }

  @Test
  void testIrrationalSub() {
    try {
      BigDecimal irr = Evaluator.evaluate("π - e").setScale(10, RoundingMode.HALF_UP);
      assertEquals(irr, BigDecimal.valueOf(0.4233108251));
    } catch (SyntaxError | MathError e) {
      fail(e.getMessage() + " -> " + e.getReason());
    }
  }

  @Test
  void testIrrationalMult() {
    try {
      BigDecimal irr = Evaluator.evaluate("π × e").setScale(9, RoundingMode.HALF_UP);
      assertEquals(irr, BigDecimal.valueOf(8.539734223));
    } catch (SyntaxError | MathError e) {
      fail(e.getMessage() + " -> " + e.getReason());
    }
  }

  @Test
  void testIrrationalDiv() {
    try {
      BigDecimal irr = Evaluator.evaluate("π ÷ e").setScale(8, RoundingMode.HALF_UP);
      assertEquals(irr, BigDecimal.valueOf(1.15572735));
    } catch (SyntaxError | MathError e) {
      fail(e.getMessage() + " -> " + e.getReason());
    }
  }

  @Test
  void testParenSurround() {
    try {
      assertEquals(BigDecimal.TWO, Evaluator.evaluate("( 1 + 1 )"));
    } catch (SyntaxError | MathError e) {
      fail(e.getMessage() + " -> " + e.getReason());
    }
  }

  @Test
  void testParenNoLeft() {
    assertThrows(SyntaxError.class, () -> {
      Evaluator.evaluate(" 1 + 1 )");
    });
  }

  @Test
  void testParenNoRight() {
    assertThrows(SyntaxError.class, () -> {
      Evaluator.evaluate("( 1 + 1 ");
    });
  }

  @Test
  void testParenNoExpr() {
    assertThrows(SyntaxError.class, () -> {
      Evaluator.evaluate("( )");
    });
  }

  @Test
  void testParenSingleSurround() {
    try {
      assertEquals(BigDecimal.ONE, Evaluator.evaluate("( 2 ) - 1"));
    } catch (SyntaxError | MathError e) {
      fail(e.getMessage() + " -> " + e.getReason());
    }
  }

  @Test
  void testManyParen() {
    try {
      assertEquals(BigDecimal.valueOf(3), Evaluator.evaluate("( ( ( ( 9 ) ) ÷ ( ( 3 ) ) ) )"));
    } catch (SyntaxError | MathError e) {
      fail(e.getMessage() + " -> " + e.getReason());
    }
  }

  @Test
  void testParenFullValid() {
    try {
      assertEquals(BigDecimal.valueOf(14), Evaluator.evaluate("2 × ( 3 + 4 )"));
    } catch (SyntaxError | MathError e) {
      fail(e.getMessage() + " -> " + e.getReason());
    }
  }

  @Test
  void testOrderOfOperations() {
    try {
      assertEquals(BigDecimal.valueOf(14), Evaluator.evaluate("10 + 4 × 2 ÷ 2"));
    } catch (SyntaxError | MathError e) {
      fail(e.getMessage() + " -> " + e.getReason());
    }
  }

  @Test
  void testUnknownToken() {
    assertThrows(SyntaxError.class, () -> {
      Evaluator.evaluate("1 plus ");
    });
  }

  @Test
  void testBadOperandType() {
    assertThrows(SyntaxError.class, () -> {
      Evaluator.evaluate("1 + ");
    });
  }

  @Test
  void testDivByZero() {
    assertThrows(MathError.class, () -> {
      Evaluator.evaluate("1 ÷ 0");
    });
  }

  @Test
  void testNegativeNumberSingle() {
    try {
      assertEquals(BigDecimal.valueOf(-1), Evaluator.evaluate("- 1"));
    } catch (SyntaxError | MathError e) {
      fail(e.getMessage() + " -> " + e.getReason());
    }
  }

  @Test
  void testNegativeNumberMultiple() {
    try {
      assertEquals(BigDecimal.ONE, Evaluator.evaluate("- 1 + 2"));
    } catch (SyntaxError | MathError e) {
      fail(e.getMessage() + " -> " + e.getReason());
    }
  }

  @Test
  void testBasicSinFunction() {
    try {
      assertEquals(BigDecimal.ONE, Evaluator.evaluate("sin ( 90 )"));
    } catch (SyntaxError | MathError e) {
      fail(e.getMessage() + " -> " + e.getReason());
    }
  }

  @Test
  void testBasicCosFunction() {
    try {
      assertEquals(BigDecimal.valueOf(0.5), Evaluator.evaluate("cos ( 60 )"));
    } catch (SyntaxError | MathError e) {
      fail(e.getMessage() + " -> " + e.getReason());
    }
  }

  @Test
  void testBasicTanFunction() {
    try {
      assertEquals(BigDecimal.ZERO, Evaluator.evaluate("tan ( 180 )"));
    } catch (SyntaxError | MathError e) {
      fail(e.getMessage() + " -> " + e.getReason());
    }
  }
}