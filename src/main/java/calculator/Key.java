package calculator;

import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;

public class Key extends Button {
  public Key(String text) {
    super(text);
  }

  /**
   * Return the associated <code>KeyCode</code> for this Key's text value.
   */
  public KeyCode getKeyCode(String text) {
    switch (text) {
      // case "x!": return KeyCode.EXCLAMATION_MARK;
      case ".": return KeyCode.PERIOD;
      // case "^": return KeyCode.CIRCUMFLEX;
      // case "(": return KeyCode.LEFT_PARENTHESIS;
      // case ")": return  KeyCode.RIGHT_PARENTHESIS;
      case "DEL": return KeyCode.BACK_SPACE;
      // case "AC": return KeyCode.ESCAPE;
      case "=": return KeyCode.ENTER;
      // case "+": return KeyCode.PLUS;
      // case "-": return KeyCode.MINUS;
      // case "×": return KeyCode.ASTERISK;
      // case "÷": return KeyCode.SLASH;
      case "1": return KeyCode.DIGIT1;
      case "2": return KeyCode.DIGIT2;
      case "3": return KeyCode.DIGIT3;
      case "4": return KeyCode.DIGIT4;
      case "5": return KeyCode.DIGIT5;
      case "6": return KeyCode.DIGIT6;
      case "7": return KeyCode.DIGIT7;
      case "8": return KeyCode.DIGIT8;
      case "9": return KeyCode.DIGIT9;
      case "0": return KeyCode.DIGIT0;
      default: return null;
    }
  }
}
