import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Formatter;

/**
 * Created by Igor Gridin on 23.12.16.
 **/
abstract class FrameForm extends JFrame {

    // Coordinates of the first window on start
    static Point frameStartPoint = new Point(600, 250);

    //flags
    static boolean doubleOperationCheck = false;
    static boolean operationCheck = false;
    static boolean errorCheck = false;
    static boolean equalsCheck = false;
    static boolean numCheck = false;
    static boolean isClassicForm = true;

    //Engineering buttons
    JButton buttonBktOpen = new javax.swing.JButton();
    JButton buttonBktClose = new javax.swing.JButton();
    JButton buttonRoot = new javax.swing.JButton();
    JButton buttonDelete = new javax.swing.JButton();
    JButton buttonPow = new javax.swing.JButton();
    JButton buttonExp = new javax.swing.JButton();
    JButton buttonOneDivX = new javax.swing.JButton();
    JPanel separatorPanel = new javax.swing.JPanel();
    JButton buttonMr = new javax.swing.JButton();
    JButton buttonMc = new javax.swing.JButton();
    JButton buttonMPlus = new javax.swing.JButton();
    JButton buttonMMinus = new javax.swing.JButton();
    JButton buttonPi = new javax.swing.JButton();
    JButton buttonLog = new javax.swing.JButton();
    JButton buttonLn = new javax.swing.JButton();
    JButton buttonSin = new javax.swing.JButton();
    JButton buttonCos = new javax.swing.JButton();
    JButton buttonTg = new javax.swing.JButton();
    JButton buttonAsin = new javax.swing.JButton();
    JButton buttonAcos = new javax.swing.JButton();
    JButton buttonAtan = new javax.swing.JButton();

    //Base buttons
    JButton button0 = new JButton();
    JButton button1 = new JButton();
    JButton button5 = new JButton();
    JButton button2 = new JButton();
    JButton button3 = new JButton();
    JButton button4 = new JButton();
    JButton button6 = new JButton();
    JButton button7 = new JButton();
    JButton button8 = new JButton();
    JButton button9 = new JButton();
    JButton buttonAdd = new JButton();
    JButton buttonC = new JButton();
    JButton buttonDiv = new JButton();
    JButton buttonEquals = new JButton();
    JButton buttonInterest = new JButton();
    JButton buttonMult = new JButton();
    JButton buttonSub = new JButton();
    JButton buttonSw = new JButton();
    JButton buttonzap = new JButton();
    JPanel digitsPanel = new JPanel();
    JPanel gradientPanel = new JPanel();

    //Result fields
    static TextFieldWrapper textField = new TextFieldWrapper();  //Classic calculator
    static TextAreaWrapper textArea = new TextAreaWrapper();     //Engineering calculator
    static JTextField bktField = new JTextField();              // for brackets count and memory status show for engineering calculator

    // Button actions methods
    void buttonEqualsActionPerformed(ActionEvent evt) {
        buttonEqualsPush();
    }

    void buttonSubActionPerformed(ActionEvent evt) {
        buttonMathPush('-');
    }

    void button7ActionPerformed(ActionEvent evt) {
        buttonNumberPush(7);
    }

    void button9ActionPerformed(ActionEvent evt) {
        buttonNumberPush(9);
    }

    void buttonSwActionPerformed(ActionEvent evt) {
        buttonTabPush();
    }

    void button8ActionPerformed(ActionEvent evt) {
        buttonNumberPush(8);
    }

    void buttonAddActionPerformed(ActionEvent evt) {
        buttonMathPush('+');
    }

    void buttonInterestActionPerformed(ActionEvent evt) {
        buttonInterestPush();
    }

    void buttonzapActionPerformed(ActionEvent evt) {
        buttonCommaPush();
    }

    void buttonCActionPerformed(ActionEvent evt) {
        buttonResetPush();
    }

    void button1ActionPerformed(ActionEvent evt) {
        buttonNumberPush(1);
    }

    void button2ActionPerformed(ActionEvent evt) {
        buttonNumberPush(2);
    }

    void button3ActionPerformed(ActionEvent evt) {
        buttonNumberPush(3);
    }

    void button4ActionPerformed(ActionEvent evt) {
        buttonNumberPush(4);
    }

    void button5ActionPerformed(ActionEvent evt) {
        buttonNumberPush(5);
    }

    void button6ActionPerformed(ActionEvent evt) {
        buttonNumberPush(6);
    }

    void button0ActionPerformed(java.awt.event.ActionEvent evt) {
        buttonNumberPush(0);
    }

    void buttonMultActionPerformed(ActionEvent evt) {
        buttonMathPush('*');
    }

    void buttonDivActionPerformed(ActionEvent evt) {
        buttonMathPush('÷');
    }

    void buttonCosActionPerformed(java.awt.event.ActionEvent evt) {
        buttonIngPush("cos(");
    }

    void buttonTgActionPerformed(java.awt.event.ActionEvent evt) {
        buttonIngPush("tg(");
    }

    void buttonBktCloseActionPerformed(java.awt.event.ActionEvent evt) {
        buttonBktClosePush();
    }

    void buttonPowActionPerformed(java.awt.event.ActionEvent evt) {
        buttonPowPush();
    }

    void buttonBktOpenActionPerformed(java.awt.event.ActionEvent evt) {
        buttonIngPush("(");
    }

    void buttonRootActionPerformed(java.awt.event.ActionEvent evt) {
        buttonIngPush("√(");
    }

    void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        buttonDigitRemovePush();
    }

    void buttonExpActionPerformed(java.awt.event.ActionEvent evt) {
        buttonIngPush("exp(");
    }

    void buttonOneDivXActionPerformed(java.awt.event.ActionEvent evt) {
        buttonOneDivXPush();
    }

    void buttonMrActionPerformed(java.awt.event.ActionEvent evt) {
        memoryPush("mR");
    }

    void buttonPiActionPerformed(java.awt.event.ActionEvent evt) {
        buttonIngPush("п");
    }

    void buttonLogActionPerformed(java.awt.event.ActionEvent evt) {
        buttonIngPush("lg(");
    }

    void buttonLnActionPerformed(java.awt.event.ActionEvent evt) {
        buttonIngPush("ln(");
    }

    void buttonMcActionPerformed(java.awt.event.ActionEvent evt) {
        memoryPush("mC");
    }

    void buttonSinActionPerformed(java.awt.event.ActionEvent evt) {
        buttonIngPush("sin(");
    }

    void buttonMPlusActionPerformed(java.awt.event.ActionEvent evt) {
        memoryPush("mPlus");
    }

    void buttonAsinActionPerformed(java.awt.event.ActionEvent evt) {
        buttonIngPush("asin(");
    }

    void buttonAcosActionPerformed(java.awt.event.ActionEvent evt) {
        buttonIngPush("acos(");
    }

    void buttonAtanActionPerformed(java.awt.event.ActionEvent evt) {
        buttonIngPush("atg(");
    }

    void buttonMMinusActionPerformed(java.awt.event.ActionEvent evt) {
        memoryPush("mMinus");
    }

    //  Form methods
    void buttonOneDivXPush() {
    }

    void buttonIngPush(String ingButton) {
    }

    void buttonBktClosePush() {
    }

    void buttonPowPush() {
    }

    void memoryPush(String memoryOperation) {
    }

    abstract void buttonInterestPush();

    abstract void buttonNumberPush(int digit);    //static

    abstract void buttonCommaPush();

    abstract void buttonResetPush();        //static

    abstract void buttonMathPush(char operationSymbol);

    abstract void buttonEqualsPush();

    void buttonTabPush() {
    }

    void buttonDigitRemovePush() {
        String str = textField.getText();
        if (errorCheck || str.length() == 1) {
            buttonResetPush();
        } else if (str.charAt(str.length() - 2) == '-' || str.charAt(str.length() - 2) == '+') {
            textField.setText(str.substring(0, str.length() - 3));
        } else {
            textField.setText(str.substring(0, str.length() - 1));
        }
        button0.requestFocus();
    }

    void setClipboard(boolean copy_or_paste) {

        if (copy_or_paste) {
            StringSelection ss = new StringSelection(textField.getText());
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
        } else {
            BigDecimal bd;
            try {
                String str = Toolkit.getDefaultToolkit().getSystemClipboard()
                        .getData(new DataFlavor(String.class, "String Flavor")) + "";
                try {
                    str = str.replace(",", ".");
                    str = str.replace("e", "E");
                    bd = new BigDecimal(str);
                    if (bd.toString().length() >= 28) {
//                        System.out.println(bd);
                        textField.setText(new Formatter().format("%.18E", bd).toString());

                    } else textField.setText(bd.toString());
                } catch (NumberFormatException e) {
                    errorCheck = true;
                    textField.setText("Ошибка вставки");
                }
            } catch (UnsupportedFlavorException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    void calculate() {
    }

    //HotKeys

    {
        button0.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int k = e.getKeyChar();
                if (k == '0') buttonNumberPush(0);
                if (k == '1') buttonNumberPush(1);
                if (k == '2') buttonNumberPush(2);
                if (k == '3') buttonNumberPush(3);
                if (k == '4') buttonNumberPush(4);
                if (k == '5') buttonNumberPush(5);
                if (k == '6') buttonNumberPush(6);
                if (k == '7') buttonNumberPush(7);
                if (k == '8') buttonNumberPush(8);
                if (k == '9') buttonNumberPush(9);
                if (!e.isControlDown() && !e.isMetaDown() && k == 'c' || k == 'C') buttonResetPush();
                if (k == ',' || k == '.') buttonCommaPush();
                if (k == '*') buttonMathPush('*');
                if (k == '+') buttonMathPush('+');
                if (k == '/') buttonMathPush('÷');
                if (k == '-') buttonMathPush('-');
                if (k == '%') buttonInterestPush();
                if (k == '(') buttonIngPush("(");
                if (k == 'x' || k == 'X') buttonOneDivXPush();
                if (k == 'e' || k == 'E') buttonIngPush("exp(");
                if (k == 'r' || k == 'R') buttonIngPush("√(");
                if (k == 'p' || k == 'P') buttonIngPush("п");
                if (e.isShiftDown() && e.getKeyCode() == KeyEvent.VK_S) buttonIngPush("asin(");
                if (e.isShiftDown() && e.getKeyCode() == KeyEvent.VK_O) buttonIngPush("acos(");
                if (e.isShiftDown() && e.getKeyCode() == KeyEvent.VK_T) buttonIngPush("atg(");
                if (!e.isShiftDown()) {
                    if (k == 's' || k == 'S') buttonIngPush("sin(");
                    if (k == 'o' || k == 'O') buttonIngPush("cos(");
                    if (k == 't' || k == 'T') buttonIngPush("tg(");
                }
                if (k == 'l' || k == 'L') buttonIngPush("lg(");
                if (k == 'n' || k == 'M') buttonIngPush("ln(");
                if (k == ')') buttonBktClosePush();
                if (k == '^') buttonPowPush();
                if (k == 'q' || k == 'Q') {
                    buttonTabPush();
                }
                if (k == KeyEvent.VK_ENTER || e.getKeyChar() == '=') buttonEqualsPush();
                if (k == KeyEvent.VK_BACK_SPACE) buttonDigitRemovePush();
                if (k == KeyEvent.VK_ESCAPE) System.exit(0);
                if (e.isMetaDown() && k == 'c' || e.isControlDown() && e.getKeyCode() == KeyEvent.VK_C)
                    setClipboard(true);
                if (e.isMetaDown() && k == 'v' || e.isControlDown() && e.getKeyCode() == KeyEvent.VK_V)
                    setClipboard(false);
                if (e.isMetaDown() && k == 'v' || e.isControlDown() && k == 'v') setClipboard(false);
            }
        });
    }
}



















