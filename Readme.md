Hello! Hier i used Swing GUI widget toolkit for Java.
It has two modes. First - classic mode, works like Apple's MacOS native calculator and second - engineering mode.
Here i used Reverse Polish notation (RPN) algorithm.

You are welcome to comment on the code and let me know what needs to be improved.

The project is managed by [Maven](https://maven.apache.org/). To compile:

`mvn compile`

to run:

`mvn exec:java -Dexec.mainClass="com.igridin.desktop_calculator.DesktopCalculator"`

Version 1.0-SNAPSHOT
Implemented tasks:

Standard Calculator:
- all functions of the standard desktop Apple calculator
- restriction on entering numbers
- grouping numbers into digits
- scaling the font size depending on the number of digits
- result formatting, adding exponent
- error handling (divide by zero, calculation limit, etc.)
- the ability to enter from the keyboard
- erasing one character (BackSpace)
- work with copy-paste

Engineering Calculator
- implemented reverse polish notation algorithm
- restriction on entering numbers
- grouping numbers into digits
- write (read) value to memory (from memory), memory usage indicator
- indicator of the number of open brackets
- protection against various user errors:
    - the number of commas in the value
    - incorrect expression entry (For example: 13123+34-)
    - automatic substitution of the sign "*" and "(" when using trigonometric functions in the format "*<function>("
    - inconsistent number of brackets
    - ban on writing to the memory of the equation, only the value is allowed to be written
    - etc.
- the ability to enter from the keyboard
- erasing one character (BackSpace) or function completely with bracket
- error handling (divide by zero, calculation limit, etc.)
