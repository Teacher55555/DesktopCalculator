package com.igridin.desktop_calculator;

import com.igridin.desktop_calculator.ClassicCalcOperations;

/**
 * Created by Igor Gridin on 15.12.16.
 **/


/* Here is the tree of classes:

            FrameForm
          /           \
  ClassicCalcFrame    IngCalcFrame
        /                \
ClassicCalcOperations    IngCalcOperations

TextFiledWrapper is a wrapper for "Jtextfield" for classic calculator result field
TextAreaWrapper is a wrapper for JtextArea for Engineering calculator result field
Main class is a starter for classic calc form

*/
public class DesktopCalculator
{
    public static void main(String[] args) {
        new ClassicCalcOperations();
    }
}
