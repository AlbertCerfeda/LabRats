/*
         * To change this license header, choose License Headers in Project Properties.
         * To change this template file, choose Tools | Templates
         * and open the template in the editor.
         */
        package MainMenu.Controller;

import Game.View.GameFrame;
import MainMenu.Model.Model;
import MainMenu.View.NewGamePage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author utente
 */
public class newGameController implements ActionListener{
    private NewGamePage ngp;
    private Model m;
    private String s;

    public newGameController (NewGamePage ngp, Model m){
        this.ngp=ngp;
        this.m=m;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        JButton source=(JButton)ae.getSource();
        s = ngp.chefTextField.getText();
        if(s == null || s.length()==0 || s==" "){
            source.setBackground(Color.RED);
        }
        else{
            source.setBackground(Color.GREEN);
            try {
                m.saveName(s);
            } catch (IOException ex) {
                Logger.getLogger(newGameController.class.getName()).log(Level.SEVERE, null, ex);
            }

            new GameFrame(s);
            ngp.dispose();
        }
        }



}