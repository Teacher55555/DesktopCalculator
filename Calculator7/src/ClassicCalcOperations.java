
import java.text.DecimalFormat;

/**
 * Created by Igor Gridin on 23.12.16.
 * This class describes all the functions of classic calculator
 *
 **/
class ClassicCalcOperations extends ClassicCalcFrame {

    private static double d1;
    private static double d2;
    static double result;
    private static String str;                       //source string
    private static String first_operand = "0";       //first operand in String
    private static String second_operand = "0";      //second operand in String
    private static char operationChar;               //operation symbol (+/-*)
    private final static int textFieldSize = 15;


    //  switch between classic and engineering calculators
    @Override
    void buttonTabPush() {

        frameStartPoint = getLocation();
        setVisible(false);
        new IngCalcOperations();


    }

    // main calculate method
    @Override
    void calculate() {
        if (!errorCheck) {
            try {
                if (equalsCheck) {
                    d1 = result;
                } else {
                    d1 = Double.parseDouble(first_operand);
                    d2 = Double.parseDouble(second_operand);
                }

                if (operationChar == '÷') {
                    result = d1 / d2;
                }

                if (operationChar == '*') {
                    result = d1 * d2;
                }
                if (operationChar == '-') {
                    result = d1 - d2;
                }
                if (operationChar == '+') {
                    result = d1 + d2;
                }

                first_operand = "";
                second_operand = "";
                str = String.valueOf(result);
                if (str.matches("^.+E-1[0-9][0-9]") || str.matches("^.+E1[0-9][0-9]")
                        || str.equals("Infinity")) {
                    throw new ArithmeticException();
                }
            } catch (ArithmeticException e) {
                errorCheck = true;
                textField.setText("error");
            } catch (NumberFormatException e) {
                errorCheck = true;
                textField.setText("error");
            }

            System.out.println(result);
        }
    }

    // Interest button handler
    @Override
    void buttonInterestPush() {
        if (!errorCheck && !textField.getText().equals("0") && !textField.getText().equals("0.")) {
            d2 = Double.parseDouble(textField.getText());
            d1 = Double.parseDouble(first_operand);
            DecimalFormat df = new DecimalFormat("0.############");

            if (first_operand.equals("0") || operationChar == '*' || operationChar == '÷') {
                textField.setText(String.valueOf(df.format(d2 / 100)));
            } else {
                textField.setText(String.valueOf(df.format(d1 / 100 * d2)));
            }
        } else {
            buttonResetPush();
            textField.setText("0");
        }
        button0.requestFocus();
    }

    // Numeric button handler
    @Override
    void buttonNumberPush(int digit) {
        str = textField.getText();
        if (errorCheck) {
            first_operand = "error";
        }
        errorCheck = false;

        if (operationCheck || equalsCheck || str.equals("0")) {
            textField.setText(str = "");
            operationCheck = false;
            equalsCheck = false;
        }
        if (str.length() < textFieldSize) {
            str += digit;
            textField.setText(str);
        }
        numCheck = true;
        button0.requestFocus();
    }

    // comma button handler
    @Override
    void buttonCommaPush() {
        if (!textField.getText().contains(".")) {
            if (textField.getText().length() < textFieldSize - 1) {
                str = textField.getText() + ".";
                textField.setText(str);
            }
        }
        equalsCheck = false;
        button0.requestFocus();
    }

    // Reset button handler
    @Override
    void buttonResetPush() {
        d1 = 0;
        d2 = 0;
        str = "0";
        first_operand = "0";
        second_operand = "0";
        operationChar = ' ';
        equalsCheck = false;
        operationCheck = false;
        errorCheck = false;
        doubleOperationCheck = false;
        numCheck = false;
        textField.setText(str);
        button0.requestFocus();
    }

    // + , - , / , * button handler
    @Override
    void buttonMathPush(char operationSymbol) {
        if (!errorCheck || (first_operand.equals("0") && second_operand.equals("0"))) {
            if (doubleOperationCheck && numCheck) {
                second_operand = textField.getText();
                calculate();
                textField.setText("calculation");
            }
            first_operand = textField.getText();
            operationChar = operationSymbol;
            operationCheck = true;
            equalsCheck = false;
            doubleOperationCheck = true;
            numCheck = false;
            button0.requestFocus();
        }
    }

    // Equals button handler
    @Override
    void buttonEqualsPush() {
        if (!errorCheck || (first_operand.equals("0") && second_operand.equals("0"))) {
            second_operand = textField.getText();
            if (operationChar != ' ') {
                calculate();
                textField.setText("calculation");
            }

            equalsCheck = true;
            doubleOperationCheck = false;
            numCheck = false;
            operationCheck = false;
        }
        button0.requestFocus();
    }
}

