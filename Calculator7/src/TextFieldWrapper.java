import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by Igor Gridin on 23.12.16.
 **/

class TextFieldWrapper extends JTextField {

    // adds a space after every three digits and replace "," to "." for users easy view.
    // Example: 123 456 789; 123 7; 12; 565 545;

   private String capacity(String t) {

        if ((t.length() < 4) || FrameForm.errorCheck) {
            return t;
        }
        if (t.contains("E-")) {
            return t.replace("E", "e");
        }
        if (t.contains("E")) {
            return t.replace("E", "e+");
        }

        ArrayList<Character> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        String fraction = "";

        t = t.replaceAll(" ", "");
        t = t.replace(",", ".");
        if (t.contains(".")) {
            fraction = t.substring(t.indexOf('.'), t.length());
            t = t.substring(0, t.indexOf('.'));
        }
        char[] chars = t.toCharArray();

        for (char c : chars) {
            list.add(c);
        }
        for (int i = list.size() - 3; i >= 0; i -= 3) {
            list.add(i, ' ');
        }
        for (Character c : list) {
            sb.append(c);
        }

        sb.append(fraction);
        return sb.toString();
    }

    // Makes a right format result representation
    @Override
    public void setText(String t) {

        if (!FrameForm.errorCheck) {

            if (t.equals("calculation") && !FrameForm.errorCheck) {
                DecimalFormat df = new DecimalFormat("0.##########");   //0.##########
                double d = ClassicCalcOperations.result;
                String str = df.format(d);

                if (String.valueOf(d).matches("^.?[0-9]+[.][0-9]+E-[1-9][0-9]")
                        || String.valueOf(d).matches("^.?[0-9]+[.][0-9]+E-[1-9][0-9][0-9]")
                        || String.valueOf(d).matches("^.?[0-9]+[.][0-9]+E[2-9][0-9]")
                        || String.valueOf(d).matches("^.?[0-9]+[.][0-9]+E[1-9][0-9][0-9]")
                        || str.length() > 15
                        ) {
                    t = String.format("%.8e", d);
                } else {
                    t = str;
                }

            }
        } else {

            t = "Не определено";
        }


        t = capacity(t);

        setFontSize(t);
        t = t.replace(".", ",");
        super.setText(t);
    }

    // Replace spaces and "," to "." for further processing
    @Override
    public String getText() {
        if (!FrameForm.errorCheck) {
            String t = super.getText();
            t = t.replace(",", ".");
            return t.replace(" ", "");
        }
        return "0";
    }

    // tracks how many digits in number and changes the font size of number
    private void setFontSize(String t) {

        int reduceSize = 0;
        int strLength = t.length();
        if (t.contains(",") || t.contains(".")) {
            reduceSize = 2;
        }
        if (FrameForm.isClassicForm) {
            if (FrameForm.errorCheck) {
                FrameForm.textField.setFont(new Font("Arial", Font.PLAIN, 28));
            } else if (strLength < 11) {
                FrameForm.textField.setFont(new Font("Arial", Font.PLAIN, 40));
            } else if (strLength == 11) {
                FrameForm.textField.setFont(new Font("Arial", Font.PLAIN, 39 - reduceSize));
            } else if (strLength == 12) {
                FrameForm.textField.setFont(new Font("Arial", Font.PLAIN, 37 - reduceSize));
            } else if (strLength == 13) {
                FrameForm.textField.setFont(new Font("Arial", Font.PLAIN, 33 - reduceSize));
            } else if (strLength == 14) {
                FrameForm.textField.setFont(new Font("Arial", Font.PLAIN, 31 - reduceSize));
            } else if (strLength == 15) {
                FrameForm.textField.setFont(new Font("Arial", Font.PLAIN, 28 - reduceSize));
            } else if (strLength == 16) {
                FrameForm.textField.setFont(new Font("Arial", Font.PLAIN, 27 - reduceSize));
            } else if (strLength == 17) {
                FrameForm.textField.setFont(new Font("Arial", Font.PLAIN, 25 - reduceSize));
            } else if (strLength == 18) {
                FrameForm.textField.setFont(new Font("Arial", Font.PLAIN, 23 - reduceSize));
            } else if (strLength == 19) {
                FrameForm.textField.setFont(new Font("Arial", Font.PLAIN, 21 - reduceSize));
            } else if (strLength == 20) {
                FrameForm.textField.setFont(new Font("Arial", Font.PLAIN, 21 - reduceSize));
            } else if (strLength == 21) {
                FrameForm.textField.setFont(new Font("Arial", Font.PLAIN, 20 - reduceSize));
            } else if (strLength == 22) {
                FrameForm.textField.setFont(new Font("Arial", Font.PLAIN, 19 - reduceSize));
            } else if (strLength == 23) {
                FrameForm.textField.setFont(new Font("Arial", Font.PLAIN, 18 - reduceSize));
            } else if (strLength == 24) {
                FrameForm.textField.setFont(new Font("Arial", Font.PLAIN, 18 - reduceSize));
            } else if (strLength == 25) {
                FrameForm.textField.setFont(new Font("Arial", Font.PLAIN, 17 - reduceSize));
            } else if (strLength == 26) {
                FrameForm.textField.setFont(new Font("Arial", Font.PLAIN, 16 - reduceSize));
            } else if (strLength == 27) {
                FrameForm.textField.setFont(new Font("Arial", Font.PLAIN, 16 - reduceSize));
            } else if (strLength == 28) {
                FrameForm.textField.setFont(new Font("Arial", Font.PLAIN, 15 - reduceSize));
            } else if (strLength == 29) {
                FrameForm.textField.setFont(new Font("Arial", Font.PLAIN, 15 - reduceSize));
            } else if (strLength == 30) {
                FrameForm.textField.setFont(new Font("Arial", Font.PLAIN, 14 - reduceSize));
            }

        }
    }
}






