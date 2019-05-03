package Controller;

import Model.Media;
import Model.SpriteContainer;
import Model.Sprite;
import View.GameFrame;

import javax.swing.*;
import java.util.ArrayList;

public class GameFrameController {
    public static Media media;
    public static GameFrame gf;

    public static ArrayList<JLabel> animatedElements;
    public static ArrayList<JLabel> animatedContainers;
    public static ArrayList<JLabel> staticSprites;

    public GameFrameController(GameFrame gfr){
        media = new Media();
        gf=gfr;

        animatedElements=new ArrayList<JLabel>();
        animatedContainers=new ArrayList<JLabel>();
        staticSprites=new ArrayList<JLabel>();
        initializeSprites();

        //gfr.repaint();
    }
    private void initializeSprites(){
        int nContainer=0;
        int nStatic=0;
        int nElement=0;
        gf.getGamePanel().removeAll();
        staticSprites=new ArrayList<>();
        animatedContainers=new ArrayList<>();
        animatedElements=new ArrayList<>();

        /////////////////////////////////////////////
        //CARDBOARD//
        staticSprites.add(new JLabel(""));
        staticSprites.get(nStatic).setIcon(new Sprite(media.getCardboard(),"cardboard",0.35,0.8));
        staticSprites.get(nStatic).setBounds(
                (int)(new ImageIcon(media.getBackground()[0]).getIconWidth()*((Sprite)staticSprites.get(nStatic).getIcon()).getxPercent()),
                (int)(new ImageIcon(media.getBackground()[0]).getIconHeight()*((Sprite)staticSprites.get(nStatic).getIcon()).getyPercent()),
                /*width*/(int)staticSprites.get(nStatic).getIcon().getIconWidth(),
                /*height*/(int)staticSprites.get(nStatic).getIcon().getIconHeight());
        gf.getGamePanel().add(staticSprites.get(nStatic));
        nStatic++;
        //////////////////////////////////////////////
        //MUTANK//
        animatedContainers.add(new JLabel(""));
        animatedContainers.get(nContainer).setIcon(new SpriteContainer(media.getMuTank(),"muTank",0.38,0.72,-1,0));
        animatedContainers.get(nContainer).setBounds(
                (int)(new ImageIcon(media.getBackground()[0]).getIconWidth()*((Sprite)animatedContainers.get(nContainer).getIcon()).getxPercent()),
                (int)(new ImageIcon(media.getBackground()[0]).getIconHeight()*((Sprite)animatedContainers.get(nContainer).getIcon()).getyPercent()),
                /*width*/(int)animatedContainers.get(nContainer).getIcon().getIconWidth(),
                /*height*/(int)animatedContainers.get(nContainer).getIcon().getIconHeight());
        gf.getGamePanel().add(animatedContainers.get(nContainer));
        nContainer++;
        //////////////////////////////////////////////
        //HCLTANK//
        animatedContainers.add(new JLabel(""));
        animatedContainers.get(nContainer).setIcon(new SpriteContainer(media.getHclTank(),"hclTank",0.45,0.68,-1,0));
        animatedContainers.get(nContainer).setBounds(
                (int)(new ImageIcon(media.getBackground()[0]).getIconWidth()*((Sprite)animatedContainers.get(nContainer).getIcon()).getxPercent()),
                (int)(new ImageIcon(media.getBackground()[0]).getIconHeight()*((Sprite)animatedContainers.get(nContainer).getIcon()).getyPercent()),
                /*width*/(int)animatedContainers.get(nContainer).getIcon().getIconWidth(),
                /*height*/(int)animatedContainers.get(nContainer).getIcon().getIconHeight());
        gf.getGamePanel().add(animatedContainers.get(nContainer));
        nContainer++;
        //////////////////////////////////////////////
        //CSTANK//
        animatedContainers.add(new JLabel(""));
        animatedContainers.get(nContainer).setIcon(new SpriteContainer(media.getCsTank(),"csTank",0.51,0.73,-1,0));
        animatedContainers.get(nContainer).setBounds(
                (int)(new ImageIcon(media.getBackground()[0]).getIconWidth()*((Sprite)animatedContainers.get(nContainer).getIcon()).getxPercent()),
                (int)(new ImageIcon(media.getBackground()[0]).getIconHeight()*((Sprite)animatedContainers.get(nContainer).getIcon()).getyPercent()),
                /*width*/(int)animatedContainers.get(nContainer).getIcon().getIconWidth(),
                /*height*/(int)animatedContainers.get(nContainer).getIcon().getIconHeight());
        gf.getGamePanel().add(animatedContainers.get(nContainer));
        nContainer++;
        //////////////////////////////////////////////
        //TRAY//
        animatedContainers.add(new JLabel(""));
        animatedContainers.get(nContainer).setIcon(new SpriteContainer(media.getTray(),"tray",0.4,0.52,100,0));
        animatedContainers.get(nContainer).setBounds(
                (int)(new ImageIcon(media.getBackground()[0]).getIconWidth()*((Sprite)animatedContainers.get(nContainer).getIcon()).getxPercent()),
                (int)(new ImageIcon(media.getBackground()[0]).getIconHeight()*((Sprite)animatedContainers.get(nContainer).getIcon()).getyPercent()),
                /*width*/(int)animatedContainers.get(nContainer).getIcon().getIconWidth(),
                /*height*/(int)animatedContainers.get(nContainer).getIcon().getIconHeight());
        gf.getGamePanel().add(animatedContainers.get(nContainer));
        nContainer++;
        //////////////////////////////////////////////
        //VAN//
        animatedContainers.add(new JLabel(""));
        animatedContainers.get(nContainer).setIcon(new SpriteContainer(media.getVan(),"van",0.76,0.11,100,0));
        animatedContainers.get(nContainer).setBounds(
                (int)(new ImageIcon(media.getBackground()[0]).getIconWidth()*((Sprite)animatedContainers.get(nContainer).getIcon()).getxPercent()),
                (int)(new ImageIcon(media.getBackground()[0]).getIconHeight()*((Sprite)animatedContainers.get(nContainer).getIcon()).getyPercent()),
                /*width*/(int)animatedContainers.get(nContainer).getIcon().getIconWidth(),
                /*height*/(int)animatedContainers.get(nContainer).getIcon().getIconHeight());
        gf.getGamePanel().add(animatedContainers.get(nContainer));
        nContainer++;
        ////////////////////////////////////////////////////
        //MU//
        animatedElements.add(new JLabel(""));
        animatedElements.get(nElement).setIcon(new SpriteContainer(media.getMu(),"mu",0.06,0.2,100,0));
        animatedElements.get(nElement).setBounds(
                (int)(new ImageIcon(media.getBackground()[0]).getIconWidth()*((Sprite)animatedElements.get(nElement).getIcon()).getxPercent()),
                (int)(new ImageIcon(media.getBackground()[0]).getIconHeight()*((Sprite)animatedElements.get(nElement).getIcon()).getyPercent()),
                /*width*/(int)animatedElements.get(nElement).getIcon().getIconWidth(),
                /*height*/(int)animatedElements.get(nElement).getIcon().getIconHeight());
        gf.getGamePanel().add(animatedElements.get(nElement));
        nElement++;
        ////////////////////////////////////////////////////
        //HCL//
        animatedElements.add(new JLabel(""));
        animatedElements.get(nElement).setIcon(new SpriteContainer(media.getHcl(),"hcl",0.3,0.2,100,0));
        animatedElements.get(nElement).setBounds(
                (int)(new ImageIcon(media.getBackground()[0]).getIconWidth()*((Sprite)animatedElements.get(nElement).getIcon()).getxPercent()),
                (int)(new ImageIcon(media.getBackground()[0]).getIconHeight()*((Sprite)animatedElements.get(nElement).getIcon()).getyPercent()),
                /*width*/(int)animatedElements.get(nElement).getIcon().getIconWidth(),
                /*height*/(int)animatedElements.get(nElement).getIcon().getIconHeight());
        gf.getGamePanel().add(animatedElements.get(nElement));
        nElement++;
        ////////////////////////////////////////////////////
        //CS//
        animatedElements.add(new JLabel(""));
        animatedElements.get(nElement).setIcon(new SpriteContainer(media.getCs(),"cs",0.16,0.32,100,0));
        animatedElements.get(nElement).setBounds(
                (int)(new ImageIcon(media.getBackground()[0]).getIconWidth()*((Sprite)animatedElements.get(nElement).getIcon()).getxPercent()),
                (int)(new ImageIcon(media.getBackground()[0]).getIconHeight()*((Sprite)animatedElements.get(nElement).getIcon()).getyPercent()),
                /*width*/(int)animatedElements.get(nElement).getIcon().getIconWidth(),
                /*height*/(int)animatedElements.get(nElement).getIcon().getIconHeight());
        gf.getGamePanel().add(animatedElements.get(nElement));
        nElement++;
        /////////////////////////////////////////////
        //TABLE//
        staticSprites.add(new JLabel(""));
        staticSprites.get(nStatic).setIcon(new Sprite(media.getTable(),"table",0.03,0.5));
        staticSprites.get(nStatic).setBounds(
                (int)(new ImageIcon(media.getBackground()[0]).getIconWidth()*((Sprite)staticSprites.get(nStatic).getIcon()).getxPercent()),
                (int)(new ImageIcon(media.getBackground()[0]).getIconHeight()*((Sprite)staticSprites.get(nStatic).getIcon()).getyPercent()),
                /*width*/(int)staticSprites.get(nStatic).getIcon().getIconWidth(),
                /*height*/(int)staticSprites.get(nStatic).getIcon().getIconHeight());
        gf.getGamePanel().add(staticSprites.get(nStatic));
        nStatic++;
        ////////////////////////////////////////////////////
        //POSTIT//
        staticSprites.add(new JLabel(""));
        staticSprites.get(nStatic).setIcon(new Sprite(media.getPostit(),"postit",0.61,0.22));
        staticSprites.get(nStatic).setBounds(
                (int)(new ImageIcon(media.getBackground()[0]).getIconWidth()*((Sprite)staticSprites.get(nStatic).getIcon()).getxPercent()),
                (int)(new ImageIcon(media.getBackground()[0]).getIconHeight()*((Sprite)staticSprites.get(nStatic).getIcon()).getyPercent()),
                /*width*/(int)staticSprites.get(nStatic).getIcon().getIconWidth(),
                /*height*/(int)staticSprites.get(nStatic).getIcon().getIconHeight());
        gf.getGamePanel().add(staticSprites.get(nStatic));
        nStatic++;
        //FRIDGE//
        animatedContainers.add(new JLabel(""));
        animatedContainers.get(nContainer).setIcon(new SpriteContainer(media.getFridge(),"fridge",0.46,0.11,100,0));
        animatedContainers.get(nContainer).setBounds(
                (int)(new ImageIcon(media.getBackground()[0]).getIconWidth()*((Sprite)animatedContainers.get(nContainer).getIcon()).getxPercent()),
                (int)(new ImageIcon(media.getBackground()[0]).getIconHeight()*((Sprite)animatedContainers.get(nContainer).getIcon()).getyPercent()),
                /*width*/(int)animatedContainers.get(nContainer).getIcon().getIconWidth(),
                /*height*/(int)animatedContainers.get(nContainer).getIcon().getIconHeight());
        gf.getGamePanel().add(animatedContainers.get(nContainer));
        nContainer++;
        ////////////////////////////////////////////////////


        gf.setVisible(true);
    }
}
