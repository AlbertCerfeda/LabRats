/*
         * To change this license header, choose License Headers in Project Properties.
         * To change this template file, choose Tools | Templates
         * and open the template in the editor.
         */
        package MainMenu.View;

import Game.View.BackgroundPanel;
import MainMenu.Controller.startController;

import javax.swing.*;

public class StartPage extends JFrame {

    private startController controller;
    private BackgroundPanel bp1;

    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nameGameLabel;
    private javax.swing.JButton newGameButton;
    private javax.swing.JButton tutorialButton;

    public StartPage() {

        initComponents();
        controller = new startController(this);
        newGameButton.addActionListener(controller);
        tutorialButton.addActionListener(controller);

        setVisible(true);



    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        newGameButton = new javax.swing.JButton();
        tutorialButton = new javax.swing.JButton();
        nameGameLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        newGameButton.setText("New Game");

        tutorialButton.setText("Tutorial");

        nameGameLabel.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        nameGameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameGameLabel.setText("Lab Rats");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                        .addGap(144, 144, 144)
                                                        .addComponent(newGameButton))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGap(152, 152, 152)
                                                        .addComponent(tutorialButton)
                                                        .addGap(10, 10, 10)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(91, 91, 91)
                                                .addComponent(nameGameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(99, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(72, Short.MAX_VALUE)
                                .addComponent(nameGameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(newGameButton)
                                .addGap(29, 29, 29)
                                .addComponent(tutorialButton)
                                .addGap(54, 54, 54))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }
    public static void main(String args[]) {
        new StartPage();
    }
}