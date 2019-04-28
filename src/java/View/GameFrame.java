package View;

import Controller.GameFrameController;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

import static java.lang.Thread.sleep;

public class GameFrame extends JFrame {
    private GameFrameController gfc;

    private BackgroundPanel gamePanel;
    public GameFrame(){

        super("The Garage");
        this.setResizable(false);
        this.gfc= new GameFrameController(this);


        int panelWidth=(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        int panelHeight=(int)(panelWidth*0.46);

        this.setMinimumSize(new Dimension(panelWidth,panelHeight));

        gamePanel=new BackgroundPanel(gfc.media.getBackground(), BackgroundPanel.SCALED);

        gamePanel.setPreferredSize(new Dimension(panelWidth,panelHeight));
        gamePanel.setMinimumSize(new Dimension(panelWidth,panelHeight));
        gamePanel.setLayout(null);
        ///FAKE LABEL TO MAKE THE PANEL REFRESH//////////
        JLabel a = new JLabel("A");
        gamePanel.add(a);
        a.setBounds(100,100,100,100);
        ////////////////////////////////////////////////
        ///Setting every sprites coordinates
        //TODO: Do it
        //////////////////
        add(gamePanel);

        revalidate();
        repaint();
        setVisible(true);
    }

    public static void main(String[] args) {
        new GameFrame();
    }
}

