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

    public static ArrayList<JLabel> animatedCookers;

    public static ArrayList<JLabel> animatedContainers;

    public static ArrayList<JLabel> staticSprites;

    private static int originalsecsForNextIngredient;
    private static int secsForNextIngredient=30;

    private static int succesfulIngredientsAdded=0;

    private static boolean labHasExploded=false;

    private DragNDropListener dragndroplistener;
    public GameFrameController(GameFrame gfr){
        media = new Media();
        gf=gfr;

        animatedCookers=new ArrayList<JLabel>();
        animatedContainers=new ArrayList<JLabel>();
        staticSprites=new ArrayList<JLabel>();
        initializeSprites();

        dragndroplistener=new DragNDropListener();
        animatedCookers.forEach((g)-> g.addMouseListener(dragndroplistener));
        animatedContainers.forEach((g)-> g.addMouseListener(dragndroplistener));
        staticSprites.forEach((g)-> g.addMouseListener(dragndroplistener));

        SpriteContainer mu=(SpriteContainer)animatedCookers.get(0).getIcon();
        SpriteContainer hcl=(SpriteContainer)animatedCookers.get(1).getIcon();
        SpriteContainer cs=(SpriteContainer)animatedCookers.get(2).getIcon();
        new Thread(new CookerManagerThread(mu,cs,hcl)).start();

    }
    public static void makeLabExplode(){
        labHasExploded=true;
    }
    public static boolean hasLabExploded(){
        return labHasExploded;
    }
    public static void addSuccesfulIngredient(){
        succesfulIngredientsAdded++;

        int secDecrease=succesfulIngredientsAdded/3;
        if(originalsecsForNextIngredient-secDecrease>=5){
            secsForNextIngredient-=secDecrease;
        }

    }

    private void initializeSprites(){
        int nContainer=0;
        int nStatic=0;
        int nCooker=0;

        gf.getGamePanel().removeAll();
        staticSprites=new ArrayList<>();
        animatedContainers=new ArrayList<>();
        animatedCookers=new ArrayList<>();

        /////////////////////////////////////////////
        //CARDBOARD//
        staticSprites.add(new JLabel(""));
        staticSprites.get(nStatic).setIcon(new Sprite(media.getCardboard(),"cardboard",0.35,0.8,staticSprites.get(nStatic)));

        gf.getGamePanel().add(staticSprites.get(nStatic));
        nStatic++;
        //////////////////////////////////////////////
        //MUTANK//


        animatedContainers.add(new JLabel(""));
        animatedContainers.get(nContainer).setIcon(new SpriteContainer(media.getMuTank(),"muTank",0.38,0.72,-1,0,animatedContainers.get(nContainer)));

        gf.getGamePanel().add(animatedContainers.get(nContainer));

        nContainer++;

        //////////////////////////////////////////////
        //HCLTANK//


        animatedContainers.add(new JLabel(""));
        animatedContainers.get(nContainer).setIcon(new SpriteContainer(media.getHclTank(),"hclTank",0.45,0.68,-1,0,animatedContainers.get(nContainer)));

        gf.getGamePanel().add(animatedContainers.get(nContainer));
        nContainer++;
        //////////////////////////////////////////////
        //CSTANK//


        animatedContainers.add(new JLabel(""));
        animatedContainers.get(nContainer).setIcon(new SpriteContainer(media.getCsTank(),"csTank",0.51,0.73,-1,0,animatedContainers.get(nContainer)));

        gf.getGamePanel().add(animatedContainers.get(nContainer));

        nContainer++;
        //////////////////////////////////////////////
        //TRAY//


        animatedContainers.add(new JLabel(""));
        animatedContainers.get(nContainer).setIcon(new SpriteContainer(media.getTray(),"tray",0.4,0.52,100,0,animatedContainers.get(nContainer)));

        gf.getGamePanel().add(animatedContainers.get(nContainer));

        nContainer++;
        //////////////////////////////////////////////
        //VAN//


        animatedContainers.add(new JLabel(""));
        animatedContainers.get(nContainer).setIcon(new SpriteContainer(media.getVan(),"van",0.76,0.11,100,0,animatedContainers.get(nContainer)));

        gf.getGamePanel().add(animatedContainers.get(nContainer));

        nContainer++;
        ////////////////////////////////////////////////////
        //MUCOOKER//


        animatedCookers.add(new JLabel(""));
        animatedCookers.get(nCooker).setIcon(new SpriteContainer(media.getMu(),"muCooker",0.06,0.2,100,0,animatedCookers.get(nCooker)));

        gf.getGamePanel().add(animatedCookers.get(nCooker));

        nCooker++;
        ////////////////////////////////////////////////////
        //HCLCOOKER//


        animatedCookers.add(new JLabel(""));
        animatedCookers.get(nCooker).setIcon(new SpriteContainer(media.getHcl(),"hclCooker",0.3,0.2,100,0,animatedCookers.get(nCooker)));

        gf.getGamePanel().add(animatedCookers.get(nCooker));

        nCooker++;
        ////////////////////////////////////////////////////
        //CSCOOKER//


        animatedCookers.add(new JLabel(""));
        animatedCookers.get(nCooker).setIcon(new SpriteContainer(media.getCs(),"csCooker",0.16,0.32,100,0,animatedCookers.get(nCooker)));

        gf.getGamePanel().add(animatedCookers.get(nCooker));

        nCooker++;
        /////////////////////////////////////////////
        //TABLE//
        staticSprites.add(new JLabel(""));
        staticSprites.get(nStatic).setIcon(new Sprite(media.getTable(),"table",0.03,0.5,staticSprites.get(nStatic)));

        gf.getGamePanel().add(staticSprites.get(nStatic));
        nStatic++;
        ////////////////////////////////////////////////////
        //POSTIT//
        staticSprites.add(new JLabel(""));
        staticSprites.get(nStatic).setIcon(new Sprite(media.getPostit(),"postit",0.61,0.22,staticSprites.get(nStatic)));

        gf.getGamePanel().add(staticSprites.get(nStatic));
        nStatic++;
        //FRIDGE//


        animatedContainers.add(new JLabel(""));
        animatedContainers.get(nContainer).setIcon(new SpriteContainer(media.getFridge(),"fridge",0.46,0.11,100,0,animatedContainers.get(nContainer)));

        gf.getGamePanel().add(animatedContainers.get(nContainer));

        nContainer++;
        ////////////////////////////////////////////////////


        gf.setVisible(true);
    }
}
