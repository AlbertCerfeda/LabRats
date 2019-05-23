/*
         * To change this license header, choose License Headers in Project Properties.
         * To change this template file, choose Tools | Templates
         * and open the template in the editor.
         */
        package MainMenu.Controller;

import MainMenu.View.NewGamePage;
import MainMenu.View.StartPage;
import MainMenu.View.TutorialPage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author utente
 */
public class startController implements ActionListener{
    private StartPage st;

    public startController (StartPage st){
        this.st=st;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        JButton b=(JButton) ae.getSource();
        String s=b.getText();
        System.out.println(s);
        if (s.equals("New Game")){
            new NewGamePage();
            st.dispose();
        }

        else {
            TutorialPage f3 = new TutorialPage();
            f3.setVisible(true);
            st.dispose();
        }

    }


}