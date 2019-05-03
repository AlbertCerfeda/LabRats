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
        run();
    }

    public BackgroundPanel getGamePanel() {
        return gamePanel;
    }

    public static void main(String[] args) {
        new GameFrame();
    }

    @Override
    public void run(){
        /*for(;;){
            Sprite sprite;
            JLabel label;
            for(int n=0;n<GameFrameController.animatedElements.size();n++){
                label=GameFrameController.animatedElements.get(n);
                sprite=(Sprite)label.getIcon();

                label.setBounds((int)sprite.getX(),(int)sprite.getY(),label.getWidth(),label.getHeight());
            }

            for(int n=0;n<GameFrameController.staticSprites.size();n++){
                label=GameFrameController.staticSprites.get(n);
                sprite=(Sprite)label.getIcon();

                label.setBounds((int)sprite.getX(),(int)sprite.getY(),label.getWidth(),label.getHeight());
            }
            for(int n=0;n<GameFrameController.animatedContainers.size();n++){
                label=GameFrameController.animatedContainers.get(n);
                sprite=(Sprite)label.getIcon();

                label.setBounds((int)sprite.getX(),(int)sprite.getY(),label.getWidth(),label.getHeight());
            }

            repaint();
        }*/
    }
}

