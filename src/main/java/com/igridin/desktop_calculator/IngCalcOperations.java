package com.igridin.desktop_calculator;

import com.igridin.desktop_calculator.ClassicCalcOperations;

import javax.swing.*;
import java.util.ArrayList;


class IngCalcOperations extends IngCalcFrame {


    /**
     * Created by Igor Gridin on 14.12.16.
     * Алгоритм использования обратной польской нотации
     */

    private static ArrayList<String> opnStr = new ArrayList<>();   // source string in postfix notation
    private static StringBuilder digitStr = new StringBuilder();   // temporary space for digits, needs for isolate digits from math operations
    private static ArrayList<Character> stack = new ArrayList<>(); // stack of math operations for RPN algorithm (+,-,/,*,ln,root and etc)
    static ArrayList<String> calculationStack = new ArrayList<>(); // digits stack of calculation result
    private static double d1;
    private static double d2;
    private double memory = 0;                                      // Memory variable
    private static String str;
    static int bktCount = 0;                                        // bkt counter
    private final static int textFieldSize = 75;

    //  switch between classic and engineering calculators
    @Override
    void buttonTabPush() {
        frameStartPoint = getLocation();
        setVisible(false);
        new ClassicCalcOperations();

    }

    // Interest button handler
    @Override
    void buttonInterestPush() {
        equalsCheck = false;
        str = textArea.getText();

        if (str.equals("0") || errorCheck) {
            textArea.setText(str = "0");
        }
        if (str.length() < textFieldSize && str.length() > 0) {
            char c = str.charAt(str.length() - 1);
            if (Character.isDigit(c))
                textArea.setText(str += "%");
            button0.requestFocus();
        }
    }

    // Close parenthesis handler
    @Override
    void buttonBktClosePush() {
        equalsCheck = false;
        str = textArea.getText();
        if (str.equals("0") || errorCheck) {
            textField.setText(str = "0");
        } else if (str.length() < textFieldSize && bktCount > 0 && str.charAt(str.length() - 1) != '(') {
            str += ")";
            bktCount--;
            textArea.setText(str);
        }
        button0.requestFocus();
        bktCountShow();
    }

    // 1/x operation handler
    @Override
    void buttonOneDivXPush() {

        equalsCheck = false;
        str = textArea.getText();

        if (str.equals("0")) {
            textArea.setText("1÷");
            return;
        }

        if (str.length() < textFieldSize && str.length() > 0) {
            char c = str.charAt(str.length() - 1);
            if ((Character.isDigit(c) || c == 'п' || c == ')')) {
                str += "*" + "1÷";
            } else str += "1÷";
        }

        textArea.setText(str);
        button0.requestFocus();
    }

    // All trigonometry functions, exponent, square root, and open parenthesis handler
    @Override
    void buttonIngPush(String ingButton) {
        equalsCheck = false;
        str = textArea.getText();

        if (str.length() < textFieldSize) {
            if (ingButton.equals("√(") || ingButton.equals("tg(") || ingButton.equals("lg(") || ingButton.equals("sin(")
                    || ingButton.equals("cos(") || ingButton.equals("asin(") || ingButton.equals("acos(")
                    || ingButton.equals("atg(") || ingButton.equals("exp(") || ingButton.equals("(")
                    || ingButton.equals("ln(")) {
                bktCount++;
            }

            if (str.charAt(str.length() - 1) == '.') {
                return;
            }

            if (str.equals("0") || errorCheck) {
                textArea.setText(str = "");
            }

            if (str.length() > 0) {
                char c = str.charAt(str.length() - 1);
                if ((Character.isDigit(c) || c == 'п' || c == ')' || c == '%')) {
                    str += "*" + ingButton;
                } else str += ingButton;

            } else str += ingButton;

            if (ingButton.equals(")") && textArea.getText().equals("")) {
                str = "0";
            }

            textArea.setText(str);
        }
        button0.requestFocus();
        bktCountShow();
    }

    // Memory (MR,MC,M+,M-) handler
    @Override
    void memoryPush(String memoryOperation) {
        str = textArea.getText();
        double tempMemory = 0;
        boolean digitFlag = true;

        try {
            tempMemory = Double.parseDouble(str);
        } catch (NumberFormatException e) {
            digitFlag = false;
        }

        switch (memoryOperation) {
            case "mPlus":
                if (digitFlag)
                    memory += tempMemory;
                break;
            case "mMinus":
                if (digitFlag)
                    memory -= tempMemory;
                break;
            case "mR":
                if (memory != 0) {
                    calculationStack.clear();
                    calculationStack.add(memory + "");
                    textArea.setText("calculation");
                    bktCount = 0;
                }
                break;
            case "mC":
                memory = 0;
                break;
        }
        bktCountShow();
        button0.requestFocus();
    }


    // Numeric button handler
    @Override
    void buttonNumberPush(int digit) {
        equalsCheck = false;
        str = textArea.getText();

        if (str.equals("0") || errorCheck) {
            textArea.setText(digit + "");
            return;
        }

        String[] strings = str.split("\\D");
        int digitsLength = 0;
        char notZero = '1';
        if (strings.length > 0) {
            digitsLength = strings[strings.length - 1].length();
            notZero = strings[strings.length - 1].charAt(0);
        }


        if ((str.length() < textFieldSize && digitsLength < 15 && notZero != '0') || !Character.isDigit(str.charAt(str.length() - 1))) {
            Character c = str.charAt(str.length() - 1);
            if (c == ')' || c == '%' || c == 'п') {
                str += "*" + digit;
            } else {
                str += digit;
            }

            textArea.setText(str);
        }
        button0.requestFocus();
        bktCountShow();
    }


    // Symbol remove handler (BackSpace)
    @Override
    void buttonDigitRemovePush() {
        equalsCheck = false;
        str = textArea.getText();

        if (errorCheck || str.length() == 1) {
            buttonResetPush();
            return;
        }
        char c = str.charAt(str.length() - 1);
        if (c == '(') {
            bktCount--;
        }
        if (c == ')') {
            bktCount++;
        }
        str = str.substring(0, str.length() - 1);
        if (str.charAt(str.length() - 1) != 'п') {
            while (Character.isAlphabetic(str.charAt(str.length() - 1)) || str.charAt(str.length() - 1) == '√') {
                str = str.substring(0, str.length() - 1);
                if (str.isEmpty()) {
                    textArea.setText("0");
                    bktCountShow();
                    button0.requestFocus();
                    return;
                }
            }
        }
        textArea.setText(str);

        button0.requestFocus();
        bktCountShow();
    }


    // comma button handler
    @Override
    void buttonCommaPush() {
        equalsCheck = false;
        str = textArea.getText();

        String[] strings = str.split("\\d");

        if (str.length() < textFieldSize) {
            if (strings.length > 1) {
                if (!strings[strings.length - 1].contains(".") && Character.isDigit(str.charAt(str.length() - 1))) {
                    textArea.setText(str += ".");
                }
            } else {
                textArea.setText(str += ".");
            }
        }
        button0.requestFocus();
    }

    // Pow button handler
    @Override
    void buttonPowPush() {
        equalsCheck = false;
        str = textArea.getText();

        if (!errorCheck && str.length() < textFieldSize) {
            char c = str.charAt(str.length() - 1);
            if (Character.isDigit(c)) {
                textArea.setText(str += "^");
            } else if (c == '+' || c == '-' || c == '*' || c == '÷') {
                str = str.substring(0, str.length() - 1);
                textArea.setText(str += "^");
            }

        }
        if (textArea.getText().charAt(str.length() - 1) == ')' || textArea.getText().charAt(str.length() - 1) == '%') {
            textArea.setText(str += "^");
        }
        button0.requestFocus();
    }

    // Reset button handler
    @Override
    void buttonResetPush() {
        bktCount = 0;
        d1 = 0;
        d2 = 0;
        str = "0";
        equalsCheck = false;
        operationCheck = false;
        errorCheck = false;
        doubleOperationCheck = false;
        numCheck = false;
        textArea.setText(str);
        button0.requestFocus();
        bktCountShow();
    }

    //Math button handler
    @Override
    void buttonMathPush(char operationSymbol) {
        equalsCheck = false;
        str = textArea.getText();
        char c = str.charAt(str.length() - 1);
        if (c != '(' && c != '.' && str.length() < textFieldSize)
            if (c == '+' || c == '-' || c == '*' || c == '÷' || c == '^') {
                str = str.substring(0, str.length() - 1);
                textArea.setText(str += operationSymbol);
            } else textArea.setText(str += operationSymbol);
        button0.requestFocus();
        bktCountShow();
    }

    //Shows open parenthesis count and memory status
    private void bktCountShow() {
        StringBuilder sb = new StringBuilder();
        if (memory != 0) {
            sb.append("Mem  ");
        }

        for (int i = 0; i < bktCount; i++) {
            sb.append("(");
        }
        bktField.setText(sb.toString());
    }

    //Equals button handler
    @Override
    void buttonEqualsPush() {
        if (bktCount > 0) {
            JOptionPane.showMessageDialog(this,
                    "Количество скобок не согласовано.\n\nКоличество открытых скобок," +
                            "\nожидающих закрытия указано в левом верхнем углу.",
                    "Внимание", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (textArea.getText().contains("e") && !textArea.getText().contains("exp")) {
            JOptionPane.showMessageDialog(this,
                    "К сожалению значения с экспонентой считать не умею :(",
                    "Внимание", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {

            equalsCheck = true;
            opnStr.clear();
            stack.clear();
            calculationStack.clear();
            infixToOpn2(textArea.getText());
            calculation();

            if (calculationStack.get(0).equals("zero")) {
                JOptionPane.showMessageDialog(this,
                        "Деление на ноль",
                        "На ноль делить нельзя!", JOptionPane.ERROR_MESSAGE);
                calculationStack.clear();
                return;
            }

            if (calculationStack.get(0).equals("Infinity")) {
                JOptionPane.showMessageDialog(this,
                        "Достигнут предел вычислений",
                        "Больше не могу счиать, я устал :(", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (calculationStack.get(0).equals("NaN")) {
                JOptionPane.showMessageDialog(this,
                        "Вряд ли такое может быть, подумай головой",
                        "NaN :(", JOptionPane.WARNING_MESSAGE);
                return;
            }

            System.out.println("Ответ " + calculationStack.get(0));


            textArea.setText("calculation");    //вернуть!!!
            bktCount = 0;
            bktCountShow();
            button0.requestFocus();


        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(this,
                    "Использован недопустимый формат!",
                    "Ошибка", JOptionPane.ERROR_MESSAGE);
            button0.requestFocus();


        }
    }


    /////////////////////////////Reverse Polish notation (RPN) algorithm ////////////////////////////////////////

    //converts Infix notation to Postfix notation
    private void infixToOpn2(String str) {

        if (str.charAt(0) == '-') {
            str = '0' + str;
        }

        str = str.replace("asin", "g");
        str = str.replace("acos", "h");
        str = str.replace("atg", "j");
        str = str.replace("exp", "e");
        str = str.replace("п", "3.141 592 653 589 7");
        str = str.replace("lg", "l");
        str = str.replace("ln", "n");
        str = str.replace("sin", "s");
        str = str.replace("cos", "c");
        str = str.replace("tg", "t");


        try {
            for (Character c : str.toCharArray()) {
                if (Character.isDigit(c) || c == '.') {
                    digitStr.append(c);
                } else if (c == '^' || c == '÷' || c == 'e' || c == '√' || c == '*' || c == '+' || c == '-'
                        || c == 'l' || c == 'n' || c == 's' || c == 'c' || c == 't' || c == 'g' || c == 'h'
                        || c == 'j' || c == '%') {
                    digitsToOpnStr();
                    if (stack.size() > 0) {
                        while (stack.get(stack.size() - 1) == '^' || stack.get(stack.size() - 1) == '÷'
                                || stack.get(stack.size() - 1) == '%' || stack.get(stack.size() - 1) == '√'
                                || stack.get(stack.size() - 1) == '*' || stack.get(stack.size() - 1) == '+'
                                || stack.get(stack.size() - 1) == '-' || stack.get(stack.size() - 1) == 'e'
                                || stack.get(stack.size() - 1) == 'l' || stack.get(stack.size() - 1) == 'n'
                                || stack.get(stack.size() - 1) == 's' || stack.get(stack.size() - 1) == 'c'
                                || stack.get(stack.size() - 1) == 't' || stack.get(stack.size() - 1) == 'g'
                                || stack.get(stack.size() - 1) == 'h' || stack.get(stack.size() - 1) == 'j') {
                            if (compare(c, stack.get(stack.size() - 1)) < 1) {
                                opnStr.add(stack.get(stack.size() - 1).toString());
                                stack.remove(stack.size() - 1);
                                if (stack.size() == 0)
                                    break;
                            } else break;
                        }
                    }
                    stack.add(c);
                } else if (c == '(') {
                    digitsToOpnStr();
                    stack.add(c);
                } else if (c == ')') {
                    digitsToOpnStr();
                    while (stack.get(stack.size() - 1) != '(') {
                        opnStr.add(stack.get(stack.size() - 1).toString());
                        stack.remove(stack.size() - 1);
                    }
                    stack.remove(stack.size() - 1);
                }
            }
            digitsToOpnStr();
            if (stack.size() > 0) {
                for (int i = stack.size() - 1; i >= 0; i--) {
                    if (stack.get(i) == '(' || stack.get(i) == ')') {
                        throw new ArrayIndexOutOfBoundsException();
                    }
                    opnStr.add(stack.get(i).toString());
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Скобки не согласованы");
        }
    }

    //collects digits. Example (1,1,1 to 111)
    private void digitsToOpnStr() {
        if (digitStr.length() > 0) {
            opnStr.add(digitStr.toString());
            digitStr.delete(0, digitStr.length());
        }
    }

 // priority comparison of the math operations
    private int compare(char a, char b) {

        int result = 0; // 1 - high-priority / 0 - equals / -1 -lower-priority
        if (a == '^' || a == '√' || a == 'e' || a == 'l' || a == 'n' || a == 's' || a == 'c'
                || a == 't' || a == 'g' || a == 'h' || a == 'j' || a == '%') {
            if (b == '^' || b == '√' || b == 'e' || b == 'l' || b == 'n'
                    || b == 's' || b == 'c' || b == 't' || b == 'g' || b == 'h' || b == 'j' || b == '%') {
                result = 0;
            } else result = 1;
            return result;
        }

        if (a == '*' || a == '÷') {
            if (b == '*' || b == '÷') {
                result = 0;
                return result;
            }
            if (b == '-' || b == '+') {
                result = 1;
                return result;
            } else result = -1;
            return result;
        }

        if (a == '+' || a == '-') {
            if (b == '-' || b == '+') {
                result = 0;
                return result;
            } else result = -1;
            return result;
        }
        return result;
    }




    // reads each value from "opnStr", makes calculation and writes results to calculationStack
    private void calculation() {

        for (int i = 0; i < opnStr.size(); i++) {
            String s = opnStr.get(i);

            switch (s) {
                case "÷":
                    calcD1D2StackInitializator();

                    if (d2 == 0) {
                        calculationStack.clear();
                        calculationStack.add("zero");
                        return;
                    }
                    calculationStack.add((d1 / d2) + "");
                    break;

                case "*":
                    calcD1D2StackInitializator();
                    calculationStack.add((d1 * d2) + "");
                    break;

                case "+":
                    calcD1D2StackInitializator();
                    calculationStack.add(d1 + d2 + "");
                    break;

                case "-":
                    calcD1D2StackInitializator();
                    calculationStack.add((d1 - d2) + "");
                    break;
                case "^":
                    calcD1D2StackInitializator();
                    calculationStack.add((Math.pow(d1, d2)) + "");
                    break;
                case "√":
                    d2 = Double.parseDouble(calculationStack.get(calculationStack.size() - 1));
                    calculationStack.remove(calculationStack.size() - 1);
                    calculationStack.add((Math.sqrt(d2)) + "");
                    break;
                case "%":
                    if (i == opnStr.size() - 1) {
                        d2 = Double.parseDouble(calculationStack.get(calculationStack.size() - 1));
                        calculationStack.remove(calculationStack.size() - 1);
                        calculationStack.add((d2 / 100) + "");

                    } else if (opnStr.get(i + 1).equals("*") || opnStr.get(i + 1).equals("÷")) {
                        d2 = Double.parseDouble(calculationStack.get(calculationStack.size() - 1));
                        calculationStack.remove(calculationStack.size() - 1);
                        calculationStack.add((d2 / 100) + "");

                    } else if (opnStr.get(i + 1).equals("+") || opnStr.get(i + 1).equals("-")) {
                        d1 = Double.parseDouble(calculationStack.get(calculationStack.size() - 2));
                        d2 = Double.parseDouble(calculationStack.get(calculationStack.size() - 1));
                        calculationStack.remove(calculationStack.size() - 1);
                        calculationStack.add((d1 / 100) * d2 + "");

                    } else if (opnStr.get(i + 2).equals("+") || opnStr.get(i + 2).equals("-") || opnStr.get(i + 2).equals("%")) {
                        d2 = Double.parseDouble(calculationStack.get(calculationStack.size() - 1));
                        calculationStack.remove(calculationStack.size() - 1);
                        calculationStack.add((d2 / 100) + "");

                    } else if (opnStr.get(i + 2).equals("*") || opnStr.get(i + 2).equals("÷")) {
                        d2 = Double.parseDouble(calculationStack.get(calculationStack.size() - 1));
                        calculationStack.remove(calculationStack.size() - 1);
                        calculationStack.add((d2 / 100) + "");
                    } else {
                        d2 = Double.parseDouble(calculationStack.get(calculationStack.size() - 1));
                        calculationStack.remove(calculationStack.size() - 1);
                        calculationStack.add((d2 / 100) + "");
                    }
                    break;
                case "e":
                    d2 = Double.parseDouble(calculationStack.get(calculationStack.size() - 1));
                    calculationStack.remove(calculationStack.size() - 1);
                    calculationStack.add((Math.exp(d2)) + "");
                    break;

                case "n":
                    d2 = Double.parseDouble(calculationStack.get(calculationStack.size() - 1));
                    calculationStack.remove(calculationStack.size() - 1);
                    calculationStack.add((Math.log(d2)) + "");
                    break;

                case "l":
                    System.out.println("ld");
                    d2 = Double.parseDouble(calculationStack.get(calculationStack.size() - 1));
                    calculationStack.remove(calculationStack.size() - 1);
                    calculationStack.add((Math.log10(d2)) + "");
                    break;

                case "s":
                    d2 = Double.parseDouble(calculationStack.get(calculationStack.size() - 1));
                    calculationStack.remove(calculationStack.size() - 1);
                    calculationStack.add(Math.sin(Math.toRadians(d2)) + "");
                    break;

                case "c":
                    System.out.println("ld");
                    d2 = Double.parseDouble(calculationStack.get(calculationStack.size() - 1));
                    calculationStack.remove(calculationStack.size() - 1);
                    calculationStack.add(Math.cos(Math.toRadians(d2)) + "");
                    break;

                case "t":
                    System.out.println("ld");
                    d2 = Double.parseDouble(calculationStack.get(calculationStack.size() - 1));
                    if (d2 == 90 || d2 == 270) {
                        calculationStack.clear();
                        calculationStack.add("NaN");
                        return;
                    }

                    calculationStack.remove(calculationStack.size() - 1);
                    calculationStack.add(Math.tan(Math.toRadians(d2)) + "");

                    break;

                case "g":
                    d2 = Double.parseDouble(calculationStack.get(calculationStack.size() - 1));
                    calculationStack.remove(calculationStack.size() - 1);
                    calculationStack.add(Math.toDegrees(Math.asin(d2)) + "");
                    break;

                case "h":
                    d2 = Double.parseDouble(calculationStack.get(calculationStack.size() - 1));
                    calculationStack.remove(calculationStack.size() - 1);
                    calculationStack.add(Math.toDegrees(Math.acos(d2)) + "");
                    break;

                case "j":
                    d2 = Double.parseDouble(calculationStack.get(calculationStack.size() - 1));
                    calculationStack.remove(calculationStack.size() - 1);
                    calculationStack.add(Math.toDegrees(Math.atan(d2)) + "");
                    break;

                default:
                    calculationStack.add(s);
                    break;
            }

        }

    }

    // Helper for calculate method: takes last and previous elements of calculationStack, parses string values to double variables and removes them from calculationStack
    private void calcD1D2StackInitializator() {
        d1 = Double.parseDouble(calculationStack.get(calculationStack.size() - 2));
        d2 = Double.parseDouble(calculationStack.get(calculationStack.size() - 1));
        calculationStack.remove(calculationStack.size() - 1);
        calculationStack.remove(calculationStack.size() - 1);
    }

}


