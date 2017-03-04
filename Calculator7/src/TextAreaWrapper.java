import javax.swing.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by Igor Gridin on 23.12.16.
 **/
public class TextAreaWrapper extends JTextArea {

    // adds a space after every three digits and replace "," to "." for users easy view.
    // Example: 123343+334234.23434324/2567 -> 123 343+334 234.23434324/2 567
    String capacity(String t) {
        boolean isFirstDigit = false;

        t = t.replace(",", ".");

        if (t.length() < 4) {
            return t;
        }
        if (t.contains("E-")) {
            return t.replace("E", "e");
        }
        if (t.contains("E")) {
            return t.replace("E", "e+");
        }


        if (Character.isDigit(t.charAt(0))) {
            isFirstDigit = true;
        }

        ArrayList<String> digitList = new ArrayList<>();
        ArrayList<String> otherslist = new ArrayList<>();

        StringBuilder result = new StringBuilder();
        String[] others = t.split("\\d|\\.+");


        String[] digits = t.split("[a-z+*п÷%√()-]+|\\^+");


        for (String x : digits) {
            if (!x.isEmpty()) {
                digitList.add(x);
            }
        }

        for (String x : others) {
            if (!x.isEmpty()) {
                otherslist.add(x);
            }
        }

        for (int i = 0; i < digitList.size(); i++) {
            StringBuilder tempDigits = new StringBuilder();
            ArrayList<Character> charlist = new ArrayList<>();
            String digitStr = digitList.get(i);
            String fraction = "";
            if (digitStr.contains(".")) {
                fraction = digitStr.substring(digitStr.indexOf('.'));
                digitStr = digitStr.substring(0, digitStr.indexOf('.'));
            }
            char[] chars = digitStr.toCharArray();

            for (char c : chars) {
                charlist.add(c);
            }
            for (int j = charlist.size() - 3; j >= 0; j -= 3) {
                charlist.add(j, ' ');
            }
            for (Character c : charlist) {
                tempDigits.append(c);
            }

            digitList.set(i, tempDigits.append(fraction).toString().trim());
        }


        int count = 0;
        if (isFirstDigit) {
            for (String digit : digitList) {
                result.append(digit);
                if (count < otherslist.size())
                    result.append(otherslist.get(count++));
            }
        } else {
            for (String other : otherslist) {
                result.append(other);
                if (count < digitList.size())
                    result.append(digitList.get(count++));
            }
        }


        if (IngCalcOperations.equalsCheck && !Character.isDigit(result.charAt(result.length() - 1))) {
            result.insert(0, result.charAt(result.length() - 1));
            result.setLength(result.length() - 1);
        }


        return result.toString();
    }

    @Override
    public void setText(String t) {
        if (t.equals("calculation") && !FrameForm.errorCheck) {
            DecimalFormat df = new DecimalFormat("0.##########");
            double d = Double.parseDouble(IngCalcOperations.calculationStack.get(0));
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
        if (FrameForm.errorCheck) {

            t = "Не определено";
        }


        t = capacity(t);

        t = t.replace(".", ",");
        super.setText(t);
    }


    @Override
    public String getText() {
        if (!FrameForm.errorCheck) {
            String t = super.getText();
            t = t.replace(",", ".");
            t = t.replace(" ", "");

//            if (t.contains("e+") || t.contains("e-")){
//            }


            return t;
        }
        return "0";
    }
}
