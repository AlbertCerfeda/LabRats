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
    private BackgroundPanel shopPanel;
    public GameFrame(){
        super("The Garage");
        this.setResizable(false);
        this.setLayout(null);

        gamePanel=new BackgroundPanel( Toolkit.getDefaultToolkit().getImage(getClass().getResource("/background_0.png")),BackgroundPanel.SCALED);
        shopPanel=new BackgroundPanel( Toolkit.getDefaultToolkit().getImage(getClass().getResource("/shop_0.png")),BackgroundPanel.SCALED);

        this.gfc= new GameFrameController(this);
        int panelWidth=(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        int panelHeight=(int)(panelWidth*0.46);
        this.setMinimumSize(new Dimension(panelWidth,panelHeight));
        gamePanel.setBounds(0,0,panelWidth,panelHeight);
        gamePanel.setLayout(null);

        shopPanel.setBounds(0,0,panelWidth,panelHeight);
        shopPanel.setLayout(null);

        //TODO: Change temporary code
        gamePanel.setVisible(false);
        shopPanel.setVisible(true);

        add(gamePanel);
        add(shopPanel);

        revalidate();
        repaint();
        setVisible(true);




        Thread thread=new Thread(this);
        thread.setName("RepaintThread");
        thread.start();

    }

    public BackgroundPanel getGamePanel() {
        return gamePanel;
    }

    public BackgroundPanel getShopPanel() {
        return shopPanel;
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

