package Controller;

import Model.CountdownRunnable;
import Model.Media;
import Model.SpriteContainer;
import Model.Sprite;
import View.GameFrame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameFrameController {
    public static Media media;
    public static GameFrame gf;

    public static ArrayList<JLabel> animatedCookers;

    public static ArrayList<JLabel> animatedContainers;

    public static ArrayList<JLabel> staticSprites;

    private static int secsForNextIngredient=30;
    private static int secsForPolice=40;
    private static int secsForProportion=40;

    private static long millisForCookCycle=1000;
    private static long unitsCookedForCookCycle=1;
    private static long millisForTotalCookCycle=0;

    private static int succesfulIngredientsAdded=0;


    private static boolean labHasExploded=false;


    ///////////////////////
    ////COUNTDOWN LABELS///
    public final static String INGREDIENT_COUNTDOWN="ingredient";
    public final static String POLICE_COUNTDOWN="police";
    public final static String PROPORTION_COUNTDOWN="proportion";
    public final static String TRAY_COUNTDOWN="tray";
    public final static String COOK_CYCLE="cookCycle";
    private static JTextArea policeCountdownLabel;
    private static CountdownRunnable policeCountdownRunnable;
    private static JTextArea ingredientCountdownLabel;
    private static CountdownRunnable ingredientCountdownRunnable;
    private static JTextArea proportionsCountdownLabel;
    private static CountdownRunnable proportionsCountdownRunnable;
    private static JTextArea trayCountdownLabel;
    private static CountdownRunnable trayCountdownRunnable;
    private static CountdownRunnable cookCycleCountdownRunnable;
    //////////////////////////
    /*private static JTextArea trayCountdownLabel;
    private static ArrayList<CountdownRunnable> trayCookingQueue;
    private static CountdownRunnable trayAllCookedCountdownRunnable;*/

    private static CookerManagerThread cookermanagerthread;
    private DragNDropListener dragndroplistener;
    public GameFrameController(GameFrame gfr){
        media = new Media();
        gf=gfr;

        animatedCookers=new ArrayList<JLabel>();
        animatedContainers=new ArrayList<JLabel>();
        staticSprites=new ArrayList<JLabel>();
        gf.getGamePanel().removeAll();
        initializeCountdownLabels();
        initializeSprites();

        dragndroplistener=new DragNDropListener();
        animatedCookers.forEach((g)-> g.addMouseListener(dragndroplistener));
        animatedContainers.forEach((g)-> g.addMouseListener(dragndroplistener));
        staticSprites.forEach((g)-> g.addMouseListener(dragndroplistener));

        SpriteContainer mu=(SpriteContainer)animatedCookers.get(0).getIcon();
        SpriteContainer hcl=(SpriteContainer)animatedCookers.get(1).getIcon();
        SpriteContainer cs=(SpriteContainer)animatedCookers.get(2).getIcon();
        SpriteContainer tray=(SpriteContainer)animatedContainers.get(3).getIcon();
        SpriteContainer fridge=(SpriteContainer)animatedContainers.get(4).getIcon();
        SpriteContainer van=(SpriteContainer)animatedContainers.get(5).getIcon();
        cookermanagerthread=new CookerManagerThread(mu,cs,hcl,tray,fridge,van);
    }
    private void initializeCountdownLabels(){
        initializePoliceCountdownLabel();
        initializeIngredientCountdownLabel();
        initializeProportionsCountdownLabel();
        initializeTrayCountdownLabel();
    }
    private void initializePoliceCountdownLabel(){
        policeCountdownLabel=new JTextArea("");
        policeCountdownLabel.setFont(new Font(Font.SANS_SERIF,Font.BOLD,(int)media.getImageResizeRatio()*6));
        policeCountdownLabel.setEditable(false);
        policeCountdownLabel.setHighlighter(null);
        policeCountdownLabel.setForeground(Color.red);
        policeCountdownLabel.setBounds((int)media.getImageResizeRatio()*120,0,(int)media.getImageResizeRatio()*117,(int)media.getImageResizeRatio()*15);
        policeCountdownLabel.setBorder(BorderFactory.createLineBorder(Color.white,1));

        gf.getGamePanel().add(policeCountdownLabel);
    }
    private void initializeIngredientCountdownLabel(){
        ingredientCountdownLabel=new JTextArea("");
        ingredientCountdownLabel.setFont(new Font(Font.SANS_SERIF,Font.BOLD,(int)media.getImageResizeRatio()*5));
        ingredientCountdownLabel.setEditable(false);
        ingredientCountdownLabel.setHighlighter(null);
        ingredientCountdownLabel.setForeground(Color.red);
        ingredientCountdownLabel.setBounds((int)media.getImageResizeRatio()*20,(int)media.getImageResizeRatio()*98,(int)media.getImageResizeRatio()*63,(int)media.getImageResizeRatio()*7);
        ingredientCountdownLabel.setBorder(BorderFactory.createLineBorder(Color.white,1));

        gf.getGamePanel().add(ingredientCountdownLabel);
    }
    private void initializeProportionsCountdownLabel(){
        proportionsCountdownLabel=new JTextArea("");
        proportionsCountdownLabel.setFont(new Font(Font.SANS_SERIF,Font.BOLD,(int)media.getImageResizeRatio()*5));
        proportionsCountdownLabel.setEditable(false);
        proportionsCountdownLabel.setHighlighter(null);
        proportionsCountdownLabel.setForeground(Color.red);
        proportionsCountdownLabel.setBounds((int)media.getImageResizeRatio()*20,(int)media.getImageResizeRatio()*103,(int)media.getImageResizeRatio()*85,(int)media.getImageResizeRatio()*7);
        proportionsCountdownLabel.setBorder(BorderFactory.createLineBorder(Color.white,1));

        gf.getGamePanel().add(proportionsCountdownLabel);
    }
    private void initializeTrayCountdownLabel(){
        trayCountdownLabel=new JTextArea("");
        trayCountdownLabel.setFont(new Font(Font.SANS_SERIF,Font.BOLD,(int)media.getImageResizeRatio()*5));
        trayCountdownLabel.setEditable(false);
        trayCountdownLabel.setHighlighter(null);
        trayCountdownLabel.setForeground(Color.cyan);
        trayCountdownLabel.setBounds((int)media.getImageResizeRatio()*115,(int)media.getImageResizeRatio()*83,(int)media.getImageResizeRatio()*15,(int)media.getImageResizeRatio()*7);
        trayCountdownLabel.setBorder(BorderFactory.createLineBorder(Color.white,1));

        gf.getGamePanel().add(trayCountdownLabel);
    }

    public static boolean isPoliceCountdownActive(){
        if(policeCountdownRunnable==null){
            return false;
        }
        else{
            return true;
        }
    }
    public static boolean isIngredientCountdownActive(){
        if(ingredientCountdownRunnable==null){
            return false;
        }
        else{
            return true;
        }
    }
    public static boolean isProportionsCountdownActive(){
        if(proportionsCountdownRunnable==null){
            return false;
        }
        else{
            return true;
        }
    }
    public static boolean isTraysCountdownActive(){
        if(trayCountdownRunnable==null){
            return false;
        }
        else{
            return true;
        }
    }
    public static boolean isCookCycleCountdownActive(){
        if(cookCycleCountdownRunnable==null){
            return false;
        }
        else{
            return true;
        }
    }

    public static void resetCountdownRunnable(String IDENTIFIER){
        switch(IDENTIFIER){
            case INGREDIENT_COUNTDOWN:
                if(isIngredientCountdownActive()) ingredientCountdownRunnable.makeItStop();
                ingredientCountdownRunnable=new CountdownRunnable(INGREDIENT_COUNTDOWN,secsForNextIngredient*1000,ingredientCountdownLabel,"Add next ingredient! - ",CountdownRunnable.XXsFORMAT);
                break;
            case POLICE_COUNTDOWN:
                if(isPoliceCountdownActive()) policeCountdownRunnable.makeItStop();
                policeCountdownRunnable=new CountdownRunnable(POLICE_COUNTDOWN,secsForPolice*1000,policeCountdownLabel,"HURRY UP! THE POLICE IS ON ITS WAY\n\t",CountdownRunnable.XXsFORMAT);
                break;
            case PROPORTION_COUNTDOWN:
                if(isProportionsCountdownActive()) proportionsCountdownRunnable.makeItStop();
                proportionsCountdownRunnable=new CountdownRunnable(INGREDIENT_COUNTDOWN,secsForProportion*1000,proportionsCountdownLabel,"Fix the proportions! - ",CountdownRunnable.XXsFORMAT);
                break;
            case TRAY_COUNTDOWN:
                if(isTraysCountdownActive()) trayCountdownRunnable.makeItStop();
                trayCountdownRunnable=new CountdownRunnable(TRAY_COUNTDOWN,millisForTotalCookCycle,trayCountdownLabel,"",CountdownRunnable.XXsFORMAT);
                break;
            case COOK_CYCLE:
                if(isCookCycleCountdownActive()) cookCycleCountdownRunnable.makeItStop();
                cookCycleCountdownRunnable=new CountdownRunnable(COOK_CYCLE,millisForCookCycle,null,"",CountdownRunnable.XXsFORMAT);
                break;
        }
    }
    public static void registerCountdownEnd(CountdownRunnable runnable){
        switch(runnable.getIdentifier()){
            case INGREDIENT_COUNTDOWN: //When the next ingredient countdown arrives at 0
                makeLabExplode();
                ingredientCountdownRunnable=null;
                break;
            case POLICE_COUNTDOWN: //When the police arrival countdown ends
                //TODO: Game is over. Show reportage with statistics
                break;
            case PROPORTION_COUNTDOWN: //When the proportion countdown ends
                makeLabExplode();
                proportionsCountdownRunnable=null;
                break;
            case TRAY_COUNTDOWN: //When the tray countdown ends
                trayCountdownRunnable=null;
                System.out.println("TRAY_COUNTDOWN END");
                break;
            case COOK_CYCLE: //When the cook cycle countdown ends
                cookCycleCountdownRunnable=null;
                System.out.println("COOK_CYCLE END");
                cookermanagerthread.cookCycleDone();
                break;
        }
    }

    public static void proportionsAreWrong(){
        resetCountdownRunnable(PROPORTION_COUNTDOWN);
    }
    public static void makeLabExplode(){
        labHasExploded=true;
        resetCountdownRunnable(POLICE_COUNTDOWN);
        if(isProportionsCountdownActive()) proportionsCountdownRunnable.makeItStop();
        if(isIngredientCountdownActive()) ingredientCountdownRunnable.makeItStop();
        proportionsCountdownRunnable=null;
        ingredientCountdownRunnable=null;

        //TODO: Delete the tray cooking queue
    }
    public static boolean hasLabExploded(){
        return labHasExploded;
    }
    public static void addSuccessfulIngredient(){
        succesfulIngredientsAdded++;

        int secDecrease=succesfulIngredientsAdded/3;
        if(secsForNextIngredient-secDecrease>=5){
            secsForNextIngredient-=secDecrease;
        }
        if(isIngredientCountdownActive()){
            ingredientCountdownRunnable.makeItStop();
        }
            resetCountdownRunnable(INGREDIENT_COUNTDOWN);


    }

    private void initializeSprites(){
        int nContainer=0;
        int nStatic=0;
        int nCooker=0;

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
        animatedContainers.get(nContainer).setIcon(new SpriteContainer(media.getMuTank(),"muTank",0.38,0.72,-1,100,animatedContainers.get(nContainer)));

        gf.getGamePanel().add(animatedContainers.get(nContainer));

        nContainer++;

        //////////////////////////////////////////////
        //HCLTANK//


        animatedContainers.add(new JLabel(""));
        animatedContainers.get(nContainer).setIcon(new SpriteContainer(media.getHclTank(),"hclTank",0.45,0.68,-1,100,animatedContainers.get(nContainer)));

        gf.getGamePanel().add(animatedContainers.get(nContainer));
        nContainer++;
        //////////////////////////////////////////////
        //CSTANK//


        animatedContainers.add(new JLabel(""));
        animatedContainers.get(nContainer).setIcon(new SpriteContainer(media.getCsTank(),"csTank",0.51,0.73,-1,100,animatedContainers.get(nContainer)));

        gf.getGamePanel().add(animatedContainers.get(nContainer));

        nContainer++;
        //////////////////////////////////////////////
        //TRAY//


        animatedContainers.add(new JLabel(""));
        animatedContainers.get(nContainer).setIcon(new SpriteContainer(media.getTray(),"tray",0.4,0.52,100,90,animatedContainers.get(nContainer)));

        gf.getGamePanel().add(animatedContainers.get(nContainer));

        nContainer++;
        //////////////////////////////////////////////
        //POSTIT//
        staticSprites.add(new JLabel(""));
        staticSprites.get(nStatic).setIcon(new Sprite(media.getPostit(),"postit",0.61,0.22,staticSprites.get(nStatic)));

        gf.getGamePanel().add(staticSprites.get(nStatic));
        nStatic++;
        ///////////////////////////////////////////////
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
        //FRIDGE//


        animatedContainers.add(new JLabel(""));
        animatedContainers.get(nContainer).setIcon(new SpriteContainer(media.getFridge(),"fridge",0.46,0.11,100,0,animatedContainers.get(nContainer)));

        gf.getGamePanel().add(animatedContainers.get(nContainer));

        nContainer++;
        ////////////////////////////////////////////////////
        //VAN//


        animatedContainers.add(new JLabel(""));
        animatedContainers.get(nContainer).setIcon(new SpriteContainer(media.getVan(),"van",0.76,0.11,100,0,animatedContainers.get(nContainer)));

        gf.getGamePanel().add(animatedContainers.get(nContainer));

        nContainer++;
        ////////////////////////////////////////////////////


        gf.setVisible(true);
    }

    public static Media getMedia() {
        return media;
    }
    public static JTextArea getPoliceCountdownLabel() {
        return policeCountdownLabel;
    }
    public static CountdownRunnable getPoliceCountdownRunnable() {
        return policeCountdownRunnable;
    }
    public static JTextArea getIngredientCountdownLabel() {
        return ingredientCountdownLabel;
    }
    public static CountdownRunnable getIngredientCountdownRunnable() {
        return ingredientCountdownRunnable;
    }
    public static JTextArea getProportionsCountdownLabel() {
        return proportionsCountdownLabel;
    }
    public static CountdownRunnable getProportionsCountdownRunnable() {
        return proportionsCountdownRunnable;
    }

    public static ArrayList<JLabel> getAnimatedContainers() {
        return animatedContainers;
    }

    public static CountdownRunnable getTrayCountdownRunnable() {
        return trayCountdownRunnable;
    }

    public static CountdownRunnable getCookCycleCountdownRunnable() {
        return cookCycleCountdownRunnable;
    }

    public static CookerManagerThread getCookermanagerthread() {
        return cookermanagerthread;
    }

    public DragNDropListener getDragndroplistener() {
        return dragndroplistener;
    }

    public static int getSecsForNextIngredient() {
        return secsForNextIngredient;
    }

    public static ArrayList<JLabel> getAnimatedCookers() {
        return animatedCookers;
    }

    public static long getUnitsCookedForCookCycle() {
        return unitsCookedForCookCycle;
    }

    public static GameFrame getGf() {
        return gf;
    }
    public static void setMillisForTotalCookCycle(long millisForTotalCookCycle) {
        GameFrameController.millisForTotalCookCycle=millisForTotalCookCycle;
    }

    public static long getMillisForCookCycle() {
        return millisForCookCycle;
    }

    public static long getMillisForTotalCookCycle() {
        return millisForTotalCookCycle;
    }
}
