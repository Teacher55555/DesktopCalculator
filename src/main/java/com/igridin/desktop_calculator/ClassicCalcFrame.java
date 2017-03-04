package com.igridin.desktop_calculator;

import com.igridin.desktop_calculator.FrameForm;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Igor Gridin on 23.12.16.
 *
 * This code was automatically created by NetBeans GUI Form Editor
 * I just modified some fields, like class constructor, buttons initialization and etc.
 **/


abstract class ClassicCalcFrame extends FrameForm {


   //  Creates new form ClassicCalcFrame

    public ClassicCalcFrame() {

        initComponents();
        setLocation(frameStartPoint);
        setAlwaysOnTop(true);
        setVisible(true);
        isClassicForm = true;
        button0.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */

    private void initComponents() {

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Калькулятор");
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        setResizable(false);
        setSize(new Dimension(300, 200));

        gradientPanel.setBackground(new Color(33, 59, 104));

        textField.setEditable(false);
        textField.setBackground(null);
        textField.setFont(new Font("Arial", 0, 40)); // NOI18N
        textField.setForeground(new Color(255, 255, 255));
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setText("0");
        textField.setAutoscrolls(false);
        textField.setBorder(null);
        textField.setDragEnabled(false);
        textField.setHighlighter(null);
        textField.setOpaque(false);
        textField.setDisabledTextColor(Color.WHITE);
        textField.setEnabled(false);

        GroupLayout gradientPanelLayout = new GroupLayout(gradientPanel);
        gradientPanel.setLayout(gradientPanelLayout);
        gradientPanelLayout.setHorizontalGroup(
                gradientPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, gradientPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(textField, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE))
        );
        gradientPanelLayout.setVerticalGroup(
                gradientPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, gradientPanelLayout.createSequentialGroup()
                                .addGap(0, 18, Short.MAX_VALUE)
                                .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );

        digitsPanel.setBackground(new Color(127, 127, 127));

        button0.setBackground(new Color(225, 225, 225));
        button0.setFont(new Font("Arial", 0, 24)); // NOI18N
        button0.setText("0");
        button0.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)));
        button0.setBorderPainted(false);
        button0.setFocusPainted(false);
        button0.setOpaque(true);
        button0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button0ActionPerformed(evt);
            }
        });

        buttonzap.setBackground(new Color(225, 225, 225));
        buttonzap.setFont(new Font("Arial", 0, 24)); // NOI18N
        buttonzap.setText(",");
        buttonzap.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)));
        buttonzap.setBorderPainted(false);
        buttonzap.setFocusPainted(false);
        buttonzap.setOpaque(true);
        buttonzap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonzapActionPerformed(evt);
            }
        });

        buttonC.setBackground(new Color(225, 225, 225));
        buttonC.setFont(new Font("Arial", 0, 24)); // NOI18N
        buttonC.setText("C");
        buttonC.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)));
        buttonC.setBorderPainted(false);
        buttonC.setFocusPainted(false);
        buttonC.setOpaque(true);
        buttonC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCActionPerformed(evt);
            }
        });

        buttonEquals.setBackground(new Color(255, 153, 0));
        buttonEquals.setFont(new Font("Arial", 1, 24)); // NOI18N
        buttonEquals.setForeground(new Color(255, 255, 255));
        buttonEquals.setText("=");
        buttonEquals.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)));
        buttonEquals.setBorderPainted(false);
        buttonEquals.setFocusPainted(false);
        buttonEquals.setOpaque(true);
        buttonEquals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEqualsActionPerformed(evt);
            }
        });

        button1.setBackground(new Color(225, 225, 225));
        button1.setFont(new Font("Arial", 0, 24)); // NOI18N
        button1.setText("1");
        button1.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)));
        button1.setBorderPainted(false);
        button1.setFocusPainted(false);
        button1.setOpaque(true);
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        button2.setBackground(new Color(225, 225, 225));
        button2.setFont(new Font("Arial", 0, 24)); // NOI18N
        button2.setText("2");
        button2.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)));
        button2.setBorderPainted(false);
        button2.setFocusPainted(false);
        button2.setOpaque(true);
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        button3.setBackground(new Color(225, 225, 225));
        button3.setFont(new Font("Arial", 0, 24)); // NOI18N
        button3.setText("3");
        button3.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)));
        button3.setBorderPainted(false);
        button3.setFocusPainted(false);
        button3.setOpaque(true);
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });

        buttonAdd.setBackground(new Color(255, 153, 0));
        buttonAdd.setFont(new Font("Arial", 1, 24)); // NOI18N
        buttonAdd.setForeground(new Color(255, 255, 255));
        buttonAdd.setText("+");
        buttonAdd.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)));
        buttonAdd.setBorderPainted(false);
        buttonAdd.setFocusPainted(false);
        buttonAdd.setOpaque(true);
        buttonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddActionPerformed(evt);
            }
        });

        button4.setBackground(new Color(225, 225, 225));
        button4.setFont(new Font("Arial", 0, 24)); // NOI18N
        button4.setText("4");
        button4.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)));
        button4.setBorderPainted(false);
        button4.setFocusPainted(false);
        button4.setOpaque(true);
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });

        button5.setBackground(new Color(225, 225, 225));
        button5.setFont(new Font("Arial", 0, 24)); // NOI18N
        button5.setText("5");
        button5.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)));
        button5.setBorderPainted(false);
        button5.setFocusPainted(false);
        button5.setOpaque(true);
        button5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button5ActionPerformed(evt);
            }
        });

        button6.setBackground(new Color(225, 225, 225));
        button6.setFont(new Font("Arial", 0, 24)); // NOI18N
        button6.setText("6");
        button6.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)));
        button6.setBorderPainted(false);
        button6.setFocusPainted(false);
        button6.setOpaque(true);
        button6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button6ActionPerformed(evt);
            }
        });

        buttonSub.setBackground(new Color(255, 153, 0));
        buttonSub.setFont(new Font("Arial", 1, 24)); // NOI18N
        buttonSub.setForeground(new Color(255, 255, 255));
        buttonSub.setText("–");
        buttonSub.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)));
        buttonSub.setBorderPainted(false);
        buttonSub.setFocusPainted(false);
        buttonSub.setOpaque(true);
        buttonSub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSubActionPerformed(evt);
            }
        });

        button7.setBackground(new Color(225, 225, 225));
        button7.setFont(new Font("Arial", 0, 24)); // NOI18N
        button7.setText("7");
        button7.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)));
        button7.setBorderPainted(false);
        button7.setFocusPainted(false);
        button7.setOpaque(true);
        button7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button7ActionPerformed(evt);
            }
        });

        button8.setBackground(new Color(225, 225, 225));
        button8.setFont(new Font("Arial", 0, 24)); // NOI18N
        button8.setText("8");
        button8.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        button8.setBorderPainted(false);
        button8.setFocusPainted(false);
        button8.setHorizontalTextPosition(SwingConstants.CENTER);
        button8.setOpaque(true);
        button8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button8ActionPerformed(evt);
            }
        });

        button9.setBackground(new Color(225, 225, 225));
        button9.setFont(new Font("Arial", 0, 24)); // NOI18N
        button9.setText("9");
        button9.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153)));
        button9.setBorderPainted(false);
        button9.setFocusPainted(false);
        button9.setOpaque(true);
        button9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button9ActionPerformed(evt);
            }
        });

        buttonMult.setBackground(new Color(255, 153, 0));
        buttonMult.setFont(new Font("Arial", 1, 24)); // NOI18N
        buttonMult.setForeground(new Color(255, 255, 255));
        buttonMult.setText("×");
        buttonMult.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153)));
        buttonMult.setBorderPainted(false);
        buttonMult.setFocusPainted(false);
        buttonMult.setOpaque(true);
        buttonMult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMultActionPerformed(evt);
            }
        });

        buttonSw.setBackground(new Color(225, 225, 225));
        buttonSw.setFont(new Font("Arial", 0, 14)); // NOI18N
        buttonSw.setText("Инженерный");
        buttonSw.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)));
        buttonSw.setBorderPainted(false);
        buttonSw.setFocusPainted(false);
        buttonSw.setOpaque(true);
        buttonSw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSwActionPerformed(evt);
            }
        });

        buttonInterest.setBackground(new Color(225, 225, 225));
        buttonInterest.setFont(new Font("Arial", 0, 20)); // NOI18N
        buttonInterest.setText("%");
        buttonInterest.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)));
        buttonInterest.setBorderPainted(false);
        buttonInterest.setFocusPainted(false);
        buttonInterest.setOpaque(true);
        buttonInterest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInterestActionPerformed(evt);
            }
        });

        buttonDiv.setBackground(new Color(255, 153, 0));
        buttonDiv.setFont(new Font("Arial", 1, 24)); // NOI18N
        buttonDiv.setForeground(new Color(255, 255, 255));
        buttonDiv.setText("÷");
        buttonDiv.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        buttonDiv.setBorderPainted(false);
        buttonDiv.setFocusPainted(false);
        buttonDiv.setOpaque(true);
        buttonDiv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDivActionPerformed(evt);
            }
        });

        GroupLayout digitsPanelLayout = new GroupLayout(digitsPanel);
        digitsPanel.setLayout(digitsPanelLayout);
        digitsPanelLayout.setHorizontalGroup(
                digitsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(digitsPanelLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(digitsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(digitsPanelLayout.createSequentialGroup()
                                                .addComponent(button0, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                                .addGap(1, 1, 1)
                                                .addComponent(buttonzap, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(digitsPanelLayout.createSequentialGroup()
                                                .addGroup(digitsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(button1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(button4, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(button7, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
                                                .addGap(1, 1, 1)
                                                .addGroup(digitsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(button5, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(button2, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(button8, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(buttonSw, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE))
                                .addGap(1, 1, 1)
                                .addGroup(digitsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(buttonInterest, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttonC, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(button3, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(button6, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(button9, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
                                .addGap(1, 1, 1)
                                .addGroup(digitsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(buttonEquals, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttonAdd, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttonSub, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttonMult, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttonDiv, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
                                .addGap(1, 1, 1))
        );
        digitsPanelLayout.setVerticalGroup(
                digitsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(digitsPanelLayout.createSequentialGroup()
                                .addGap(1, 1, 1) // тут
                                .addGroup(digitsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, digitsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(buttonInterest, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(buttonSw, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(buttonDiv, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
                                .addGap(1, 1, 1)
                                .addGroup(digitsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(button7, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(button8, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(button9, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttonMult, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
                                .addGap(1, 1, 1)
                                .addGroup(digitsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(button4, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(button5, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(button6, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttonSub, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
                                .addGap(1, 1, 1)
                                .addGroup(digitsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(button1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(button2, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(button3, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttonAdd, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
                                .addGap(1, 1, 1)
                                .addGroup(digitsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(button0, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttonzap, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttonC, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttonEquals, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
                                .addGap(1, 1, 1))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(gradientPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(digitsPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(gradientPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(digitsPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );


        pack();
    }

}

