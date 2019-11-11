package Game.Controller;

import Game.Model.Media;
import Game.View.BackgroundPanel;
import Game.View.GameFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static java.lang.Thread.sleep;


public class EndPanelController extends MouseAdapter implements Runnable{
    private BackgroundPanel endPanel;

    private JLabel animFrames[];
    private JLabel thepolicefoundyou;

    private JLabel totalbagssold;
    private JLabel firstdots;
    private JLabel bagsSoldLabel;
    private long bagsSold;

    private JLabel succesfullingredientsadded;
    private JLabel seconddots;
    private JLabel succesfullIngredientsLabel;
    private long successfullIngredient;

    private JLabel moneymade;
    private JLabel thirddots;
    private JLabel moneymadeLabel;
    private long moneyMade;

    private JPanel exitGame;

    @Override
    public void mousePressed(MouseEvent e){
        if (e.getSource().equals(exitGame)){
            System.exit(0);
        }
    }
    Thread a;
    public EndPanelController() {
        this.endPanel=GameFrameController.gf.getEndPanel();
        bagsSold=GameFrameController.getSuccessfulBags();
        successfullIngredient=GameFrameController.getSuccessfulIngredientsAdded();
        moneyMade=GameFrameController.getMoneyMade();
        Media media=GameFrameController.media;
        animFrames=new JLabel[3];

        exitGame=new JPanel();
        JLabel b=new JLabel("EXIT GAME");
        b.setFont(new Font(Font.SANS_SERIF,Font.BOLD,(int)GameFrameController.media.getImageResizeRatio()*6));
        b.setBounds((int)media.getImageResizeRatio()*155,(int)media.getImageResizeRatio()*86,(int)media.getImageResizeRatio()*47,(int)media.getImageResizeRatio()*7);
        b.setForeground(Color.white);
        exitGame.setBounds((int)media.getImageResizeRatio()*120,(int)media.getImageResizeRatio()*100,(int)media.getImageResizeRatio()*47,(int)media.getImageResizeRatio()*12);
        exitGame.setBackground(Color.black);
        exitGame.setBorder(BorderFactory.createLineBorder(Color.red,4));
        exitGame.addMouseListener(this);
        exitGame.add(b);
        endPanel.add(exitGame);



        thepolicefoundyou=new JLabel("The police has found you!!");
        thepolicefoundyou.setFont(new Font(Font.SANS_SERIF,Font.BOLD,(int)GameFrameController.media.getImageResizeRatio()*6));
        thepolicefoundyou.setBounds((int)media.getImageResizeRatio()*135,(int)media.getImageResizeRatio()*45,(int)media.getImageResizeRatio()*90,(int)media.getImageResizeRatio()*10);
        thepolicefoundyou.setForeground(Color.red);
        endPanel.add(thepolicefoundyou);



        totalbagssold=new JLabel("Total bags sold");
        totalbagssold.setFont(new Font(Font.SANS_SERIF,Font.BOLD,(int)GameFrameController.media.getImageResizeRatio()*5));
        totalbagssold.setBounds((int)media.getImageResizeRatio()*108,(int)media.getImageResizeRatio()*60,(int)media.getImageResizeRatio()*38,(int)media.getImageResizeRatio()*7);
        totalbagssold.setForeground(Color.orange);

        firstdots=new JLabel(".................................");
        firstdots.setFont(new Font(Font.SANS_SERIF,Font.BOLD,(int)GameFrameController.media.getImageResizeRatio()*4));
        firstdots.setBounds((int)media.getImageResizeRatio()*147,(int)media.getImageResizeRatio()*62,(int)media.getImageResizeRatio()*38,(int)media.getImageResizeRatio()*5);
        firstdots.setForeground(Color.orange);

        bagsSoldLabel=new JLabel(""+ bagsSold);
        bagsSoldLabel.setFont(new Font(Font.SANS_SERIF,Font.BOLD,(int)GameFrameController.media.getImageResizeRatio()*5));
        bagsSoldLabel.setBounds((int)media.getImageResizeRatio()*185,(int)media.getImageResizeRatio()*60,(int)media.getImageResizeRatio()*47,(int)media.getImageResizeRatio()*7);
        bagsSoldLabel.setForeground(Color.orange);
        endPanel.add(totalbagssold);
        endPanel.add(firstdots);
        endPanel.add(bagsSoldLabel);



        succesfullingredientsadded=new JLabel("Successful Ingredients Added");
        succesfullingredientsadded.setFont(new Font(Font.SANS_SERIF,Font.BOLD,(int)GameFrameController.media.getImageResizeRatio()*5));
        succesfullingredientsadded.setBounds((int)media.getImageResizeRatio()*72,(int)media.getImageResizeRatio()*73,(int)media.getImageResizeRatio()*74,(int)media.getImageResizeRatio()*7);
        succesfullingredientsadded.setForeground(Color.orange);

        seconddots=new JLabel(".................................");
        seconddots.setFont(new Font(Font.SANS_SERIF,Font.BOLD,(int)GameFrameController.media.getImageResizeRatio()*4));
        seconddots.setBounds((int)media.getImageResizeRatio()*147,(int)media.getImageResizeRatio()*75,(int)media.getImageResizeRatio()*38,(int)media.getImageResizeRatio()*5);
        seconddots.setForeground(Color.orange);

        succesfullIngredientsLabel=new JLabel(""+successfullIngredient);
        succesfullIngredientsLabel.setFont(new Font(Font.SANS_SERIF,Font.BOLD,(int)GameFrameController.media.getImageResizeRatio()*5));
        succesfullIngredientsLabel.setBounds((int)media.getImageResizeRatio()*185,(int)media.getImageResizeRatio()*73,(int)media.getImageResizeRatio()*47,(int)media.getImageResizeRatio()*7);
        succesfullIngredientsLabel.setForeground(Color.orange);
        endPanel.add(succesfullingredientsadded);
        endPanel.add(seconddots);
        endPanel.add(succesfullIngredientsLabel);



        moneymade=new JLabel("Money Made");
        moneymade.setFont(new Font(Font.SANS_SERIF,Font.BOLD,(int)GameFrameController.media.getImageResizeRatio()*5));
        moneymade.setBounds((int)media.getImageResizeRatio()*114,(int)media.getImageResizeRatio()*86,(int)media.getImageResizeRatio()*32,(int)media.getImageResizeRatio()*7);
        moneymade.setForeground(Color.orange);

        thirddots=new JLabel(".................................");
        thirddots.setFont(new Font(Font.SANS_SERIF,Font.BOLD,(int)GameFrameController.media.getImageResizeRatio()*4));
        thirddots.setBounds((int)media.getImageResizeRatio()*147,(int)media.getImageResizeRatio()*88,(int)media.getImageResizeRatio()*38,(int)media.getImageResizeRatio()*5);
        thirddots.setForeground(Color.orange);

        moneymadeLabel=new JLabel(""+moneyMade);
        moneymadeLabel.setFont(new Font(Font.SANS_SERIF,Font.BOLD,(int)GameFrameController.media.getImageResizeRatio()*5));
        moneymadeLabel.setBounds((int)media.getImageResizeRatio()*185,(int)media.getImageResizeRatio()*86,(int)media.getImageResizeRatio()*47,(int)media.getImageResizeRatio()*7);
        moneymadeLabel.setForeground(Color.orange);
        endPanel.add(moneymade);
        endPanel.add(thirddots);
        endPanel.add(moneymadeLabel);



        animFrames[0]=new JLabel();
        animFrames[0].setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/endgame/background_0.png")).getScaledInstance(GameFrameController.gf.getWidth(),GameFrameController.gf.getHeight(),0)));
        animFrames[0].setBounds(0,0,GameFrameController.gf.getWidth(),GameFrameController.gf.getHeight());
        animFrames[1]=new JLabel();
        animFrames[1].setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/endgame/background_1.png")).getScaledInstance(GameFrameController.gf.getWidth(),GameFrameController.gf.getHeight(),0)));
        animFrames[1].setBounds(0,0,GameFrameController.gf.getWidth(),GameFrameController.gf.getHeight());
        animFrames[2]=new JLabel();
        animFrames[2].setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/endgame/background_2.png")).getScaledInstance(GameFrameController.gf.getWidth(),GameFrameController.gf.getHeight(),0)));
        animFrames[2].setBounds(0,0,GameFrameController.gf.getWidth(),GameFrameController.gf.getHeight());

        endPanel.add(animFrames[0]);
        endPanel.add(animFrames[1]);
        endPanel.add(animFrames[2]);

        for(int n=0;n<endPanel.getComponentCount();n++){
            endPanel.getComponent(n).setVisible(false);
        }

        a=new Thread(this);
        a.setName("EndgameThread");
    }
    public void startEndgameSequence(){
        GameFrame.setEndgameVisible();
        a.start();
    }
    @Override
    public void run() {
        moneyMade=GameFrameController.getMoneyMade();
        successfullIngredient=GameFrameController.getSuccessfulIngredientsAdded();
        bagsSold=GameFrameController.getSuccessfulBags();

        try{sleep(1100);}catch (InterruptedException e){}
        animFrames[1].setVisible(true);
        try{sleep(200);}catch (InterruptedException e){}
        animFrames[1].setVisible(false);
        animFrames[2].setVisible(true);
        thepolicefoundyou.setVisible(true);

        try{sleep(1000);}catch (InterruptedException e){}
        {
            totalbagssold.setVisible(true);
            try{sleep(300);}catch (InterruptedException e){}
            firstdots.setVisible(true);
            try{sleep(300);}catch (InterruptedException e){}
            bagsSoldLabel.setVisible(true);
            for(int n=1;n<=bagsSold;n++){
                bagsSoldLabel.setText(""+n);
                try{sleep(50);}catch (InterruptedException e){}
            }
        }

        try{sleep(1000);}catch (InterruptedException e){}
        {
            succesfullingredientsadded.setVisible(true);
            try{sleep(300);}catch (InterruptedException e){}
            seconddots.setVisible(true);
            try{sleep(300);}catch (InterruptedException e){}
            succesfullIngredientsLabel.setVisible(true);
            for(int n=1;n<=successfullIngredient;n++){
                succesfullIngredientsLabel.setText(""+n);
                try{sleep(30);}catch (InterruptedException e){}
            }
        }

        try{sleep(1000);}catch (InterruptedException e){}
        {
            moneymade.setVisible(true);
            try{sleep(300);}catch (InterruptedException e){}
            thirddots.setVisible(true);
            try{sleep(300);}catch (InterruptedException e){}
            moneymadeLabel.setVisible(true);
            for(int n=1;n<=moneyMade;n++){
                moneymadeLabel.setText(""+n);
                try{sleep(1);}catch (InterruptedException e){}
            }
        }

        try{sleep(1000);}catch (InterruptedException e){}
        exitGame.setVisible(true);



    }
}
