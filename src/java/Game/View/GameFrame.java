package Game.View;

import Game.Controller.GameFrameController;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame implements Runnable {
    private GameFrameController gfc;

    private static BackgroundPanel gamePanel;
    private static BackgroundPanel shopPanel;
    private static BackgroundPanel endPanel;
    public GameFrame(String chefName){
        super("The Garage");
        this.setResizable(false);
        this.setLayout(null);

        int panelWidth=(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        int panelHeight=(int)(panelWidth*0.46);
        this.setMinimumSize(new Dimension(panelWidth,panelHeight));

        gamePanel=new BackgroundPanel( Toolkit.getDefaultToolkit().getImage(getClass().getResource("/background_0.png")),BackgroundPanel.SCALED);
        shopPanel=new BackgroundPanel( Toolkit.getDefaultToolkit().getImage(getClass().getResource("/shop_0.png")),BackgroundPanel.SCALED);
        endPanel=new BackgroundPanel( Toolkit.getDefaultToolkit().getImage(getClass().getResource("/endgame/background_0.png")),BackgroundPanel.SCALED);

        this.gfc= new GameFrameController(this,chefName);

        gamePanel.setBounds(0,0,panelWidth,panelHeight);
        gamePanel.setLayout(null);

        shopPanel.setBounds(0,0,panelWidth,panelHeight);
        shopPanel.setLayout(null);

        endPanel.setBounds(0,0,panelWidth,panelHeight);
        endPanel.setLayout(null);

        setGameVisible();

        add(gamePanel);
        add(shopPanel);
        add(endPanel);

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

    public BackgroundPanel getEndPanel() {
        return endPanel;
    }

    public static void setGameVisible(){
        gamePanel.setVisible(true);
        shopPanel.setVisible(false);
        endPanel.setVisible(false);
    }
    public static void setEndgameVisible(){
        gamePanel.setVisible(false);
        shopPanel.setVisible(false);
        endPanel.setVisible(true);
    }

    public static void setShopVisible(){
        gamePanel.setVisible(false);
        shopPanel.setVisible(true);
        endPanel.setVisible(false);
    }

    @Override
    public void run(){
        for(;;){
            repaint();
        }
    }
}

