package View;

import Controller.GameFrameController;
import Model.Sprite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyListener;
import java.awt.image.ImageObserver;

import static java.lang.Thread.sleep;

public class GameFrame extends JFrame implements Runnable {
    private GameFrameController gfc;

    private BackgroundPanel gamePanel;

    public GameFrame(){
        super("The Garage");
        this.setResizable(false);







        gamePanel=new BackgroundPanel( Toolkit.getDefaultToolkit().getImage(getClass().getResource("/background_0.png")),BackgroundPanel.SCALED);

        this.gfc= new GameFrameController(this);
        int panelWidth=(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        int panelHeight=(int)(panelWidth*0.46);
        this.setMinimumSize(new Dimension(panelWidth,panelHeight));
        gamePanel.setMinimumSize(new Dimension(panelWidth,panelHeight));
        gamePanel.setPreferredSize(new Dimension(panelWidth,panelHeight));
        gamePanel.setLayout(null);
        add(gamePanel);

        revalidate();
        repaint();
        setVisible(true);

        new Thread(this).start();
    }

    public BackgroundPanel getGamePanel() {
        return gamePanel;
    }

    public static void main(String[] args) {
        new GameFrame();
    }

    @Override
    public void run(){
        for(;;){
            repaint();
        }
    }
}

