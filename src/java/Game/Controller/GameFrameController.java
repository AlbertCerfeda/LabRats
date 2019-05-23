package Game.Controller;

import Game.Model.CountdownRunnable;
import Game.Model.Media;
import Game.Model.SpriteContainer;
import Game.Model.Sprite;
import Game.View.GameFrame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameFrameController {
    public static Media media;
    public static GameFrame gf;

    //////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////GAMEPANEL DATA////////////////////////////////////////////////////////////////////////////////
    public static ArrayList<JLabel> animatedCookers;
    public static ArrayList<JLabel> animatedContainers;
    public static ArrayList<JLabel> regularSprites;

    private JLabel nameLabel;
    private String name="Albert";

    //STATS//
    private static int secsForNextIngredient=30;
    private static int secsForPolice=40;
    private static int secsForProportion=40;

    private static long millisForCookCycle=1000;
    private static long unitsCookedForCookCycle=1;
    private static long millisForCoolingCycle=1000;
    private static long unitsCooledForCoolingCycle=1;
    private static long moneyForCookedUnit=10;

    private static int successfulIngredientsAdded=0;
    private static int successfulBags=0;
    ////////////////////

    private static JLabel moneyLabel;
    private static JButton shopButton;

    private static boolean labHasExploded=false;

    //COUNTDOWN LABELS//
    public final static String INGREDIENT_COUNTDOWN="ingredient";
    public final static String POLICE_COUNTDOWN="police";
    public final static String PROPORTION_COUNTDOWN="proportion";
    public final static String TRAY_COUNTDOWN="tray";
    public final static String FRIDGE_COUNTDOWN="fridge";
    private static JTextArea policeCountdownLabel;
    private static CountdownRunnable policeCountdownRunnable;
    private static JTextArea ingredientCountdownLabel;
    private static CountdownRunnable ingredientCountdownRunnable;
    private static JTextArea proportionsCountdownLabel;
    private static CountdownRunnable proportionsCountdownRunnable;
    private static JTextArea trayCountdownLabel;
    private static CountdownRunnable trayCountdownRunnable;
    private static JTextArea fridgeReadyLabel;
    private static JTextArea fridgeCountdownLabel;
    private static CountdownRunnable fridgeCountdownRunnable;
    ///////////////////////
    private static JProgressBar vanProgressBar;

    private static CookerManagerThread cookermanagerthread;
    private static AnimationThread animationthread;
    private static VanThread vanThread;
    private DragNDropListener dragndroplistener;
    private ShopPanelController shoppanelcontroller;
    private static EndPanelController endpanelcontroller;


    ////////////////////////////////////////////////////////////////////////////////////////////////
    ///SHOP-GAMEPANEL DATA//////////////////////////////////////////////////////////////////////////
    private static int money=250;
    private static int moneyMade=0;

    ////////////////////////////////////////////////////////////////////////////////////////////////
    public GameFrameController(GameFrame gfr,String chefName){
        media = new Media();
        gf=gfr;
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ////GAME PANEL SETUP//////////////////////////////////////////////////////////////////////////////////////////
        animatedCookers=new ArrayList<JLabel>();
        animatedContainers=new ArrayList<JLabel>();
        regularSprites=new ArrayList<JLabel>();
        name=chefName;

        initializeShopButton();
        initializeGamePanelLabels();
        initializeGamePanelSprites();
        regularSprites.get(1).setVisible(false);

        dragndroplistener=new DragNDropListener();

        animatedCookers.forEach((g)-> g.addMouseListener(dragndroplistener));
        animatedCookers.forEach((g)-> g.addMouseMotionListener(dragndroplistener.getMousemotionhandler()));
        animatedContainers.forEach((g)-> g.addMouseListener(dragndroplistener));
        animatedContainers.forEach((g)-> g.addMouseMotionListener(dragndroplistener.getMousemotionhandler()));
        regularSprites.forEach((g)-> g.addMouseListener(dragndroplistener));
        regularSprites.forEach((g)-> g.addMouseMotionListener(dragndroplistener.getMousemotionhandler()));
        shopButton.addActionListener(dragndroplistener);

        SpriteContainer mu=(SpriteContainer)animatedCookers.get(0).getIcon();
        SpriteContainer hcl=(SpriteContainer)animatedCookers.get(1).getIcon();
        SpriteContainer cs=(SpriteContainer)animatedCookers.get(2).getIcon();
        SpriteContainer tray=(SpriteContainer)animatedContainers.get(3).getIcon();
        SpriteContainer fridge=(SpriteContainer)animatedContainers.get(4).getIcon();
        SpriteContainer van=(SpriteContainer)animatedContainers.get(5).getIcon();

        endpanelcontroller=new EndPanelController();
        cookermanagerthread=new CookerManagerThread(mu,cs,hcl,tray,fridge,van);
        animationthread=new AnimationThread();
        vanThread=new VanThread(van,vanProgressBar);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ////SHOP PANEL SETUP//////////////////////////////////////////////////////////////////////////////////////////

        shoppanelcontroller=new ShopPanelController();
        gf.getShopPanel().addMouseListener(shoppanelcontroller);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    }
    private void initializeShopButton(){
        shopButton=new JButton("SHOP");
        shopButton.setFont(new Font(Font.SANS_SERIF,Font.BOLD,(int)media.getImageResizeRatio()*6));
        shopButton.setBounds((int)media.getImageResizeRatio()*25,(int)media.getImageResizeRatio()*115,(int)media.getImageResizeRatio()*30,(int)media.getImageResizeRatio()*10);

        gf.getGamePanel().add(shopButton);
    }
    private void initializeGamePanelLabels(){
        initializeFridgeReadyLabel();
        initializeFridgeCountdownLabel();
        initializePoliceCountdownLabel();
        initializeIngredientCountdownLabel();
        initializeProportionsCountdownLabel();
        initializeTrayCountdownLabel();
        initializeMoneyLabel();
        initializeNameLabel();
    }
    private void initializeNameLabel(){
        nameLabel=new JLabel("Chef: "+name);
        nameLabel.setFont(new Font(Font.SANS_SERIF,Font.BOLD,(int)media.getImageResizeRatio()*6));
        nameLabel.setForeground(Color.orange);
        nameLabel.setBounds((int)media.getImageResizeRatio()*0,(int)media.getImageResizeRatio()*0,(int)media.getImageResizeRatio()*90,(int)media.getImageResizeRatio()*5);

        gf.getGamePanel().add(nameLabel);
    }
    private void initializeFridgeReadyLabel(){
        fridgeReadyLabel=new JTextArea("");
        fridgeReadyLabel.setFont(new Font(Font.SANS_SERIF,Font.BOLD,(int)media.getImageResizeRatio()*4));
        fridgeReadyLabel.setEditable(false);
        fridgeReadyLabel.setHighlighter(null);
        fridgeReadyLabel.setForeground(Color.green);
        fridgeReadyLabel.setBounds((int)media.getImageResizeRatio()*170,(int)media.getImageResizeRatio()*55,(int)media.getImageResizeRatio()*30,(int)media.getImageResizeRatio()*5);

        gf.getGamePanel().add(fridgeReadyLabel);
    }
    private void initializeFridgeCountdownLabel(){
        fridgeCountdownLabel=new JTextArea("");
        fridgeCountdownLabel.setFont(new Font(Font.SANS_SERIF,Font.BOLD,(int)media.getImageResizeRatio()*4));
        fridgeCountdownLabel.setEditable(false);
        fridgeCountdownLabel.setHighlighter(null);
        fridgeCountdownLabel.setForeground(Color.orange);
        fridgeCountdownLabel.setBounds((int)media.getImageResizeRatio()*170,(int)media.getImageResizeRatio()*50,(int)media.getImageResizeRatio()*10,(int)media.getImageResizeRatio()*5);

        gf.getGamePanel().add(fridgeCountdownLabel);
    }
    private void initializePoliceCountdownLabel(){
        policeCountdownLabel=new JTextArea("");
        policeCountdownLabel.setFont(new Font(Font.SANS_SERIF,Font.BOLD,(int)media.getImageResizeRatio()*6));
        policeCountdownLabel.setEditable(false);
        policeCountdownLabel.setHighlighter(null);
        policeCountdownLabel.setForeground(Color.red);
        policeCountdownLabel.setBounds((int)media.getImageResizeRatio()*120,0,(int)media.getImageResizeRatio()*117,(int)media.getImageResizeRatio()*15);

        gf.getGamePanel().add(policeCountdownLabel);
    }
    private void initializeIngredientCountdownLabel(){
        ingredientCountdownLabel=new JTextArea("");
        ingredientCountdownLabel.setFont(new Font(Font.SANS_SERIF,Font.BOLD,(int)media.getImageResizeRatio()*5));
        ingredientCountdownLabel.setEditable(false);
        ingredientCountdownLabel.setHighlighter(null);
        ingredientCountdownLabel.setForeground(Color.red);
        ingredientCountdownLabel.setBounds((int)media.getImageResizeRatio()*20,(int)media.getImageResizeRatio()*98,(int)media.getImageResizeRatio()*63,(int)media.getImageResizeRatio()*7);

        gf.getGamePanel().add(ingredientCountdownLabel);
    }
    private void initializeProportionsCountdownLabel(){
        proportionsCountdownLabel=new JTextArea("");
        proportionsCountdownLabel.setFont(new Font(Font.SANS_SERIF,Font.BOLD,(int)media.getImageResizeRatio()*5));
        proportionsCountdownLabel.setEditable(false);
        proportionsCountdownLabel.setHighlighter(null);
        proportionsCountdownLabel.setForeground(Color.red);
        proportionsCountdownLabel.setBounds((int)media.getImageResizeRatio()*20,(int)media.getImageResizeRatio()*103,(int)media.getImageResizeRatio()*85,(int)media.getImageResizeRatio()*7);

        gf.getGamePanel().add(proportionsCountdownLabel);
    }
    private void initializeTrayCountdownLabel(){
        trayCountdownLabel=new JTextArea("");
        trayCountdownLabel.setFont(new Font(Font.SANS_SERIF,Font.BOLD,(int)media.getImageResizeRatio()*5));
        trayCountdownLabel.setEditable(false);
        trayCountdownLabel.setHighlighter(null);
        trayCountdownLabel.setForeground(Color.cyan);
        trayCountdownLabel.setBounds((int)media.getImageResizeRatio()*115,(int)media.getImageResizeRatio()*83,(int)media.getImageResizeRatio()*15,(int)media.getImageResizeRatio()*7);

        gf.getGamePanel().add(trayCountdownLabel);
    }
    private void initializeMoneyLabel(){
        moneyLabel=new JLabel(money+"$");
        moneyLabel.setFont(new Font(Font.SANS_SERIF,Font.BOLD,(int)media.getImageResizeRatio()*8));
        moneyLabel.setForeground(Color.green);
        moneyLabel.setBounds((int)media.getImageResizeRatio()*180,(int)media.getImageResizeRatio()*123,(int)media.getImageResizeRatio()*60,(int)media.getImageResizeRatio()*8);

        gf.getGamePanel().add(moneyLabel);
    }

    public static boolean isPoliceCountdownActive(){
        if(policeCountdownRunnable==null){
            System.out.print("");
            return false;
        }
        else{
            System.out.print("");
            return true;
        }
    }
    public static boolean isIngredientCountdownActive(){
        if(ingredientCountdownRunnable==null){
            System.out.print("");
            return false;
        }
        else{
            System.out.print("");
            return true;
        }
    }
    public static boolean isProportionsCountdownActive(){
        if(proportionsCountdownRunnable==null){
            System.out.print("");
            return false;
        }
        else{
            System.out.print("");
            return true;
        }
    }
    public static boolean isTraysCountdownActive(){
        if(trayCountdownRunnable==null){
            System.out.print("");
            return false;
        }
        else{
            System.out.print("");
            return true;
        }
    }
    public static boolean isFridgeCountdownActive(){
        if(fridgeCountdownRunnable==null){
            System.out.print("");
            return false;
        }
        else{
            System.out.print("");
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
                trayCountdownRunnable=new CountdownRunnable(TRAY_COUNTDOWN,millisForCookCycle,trayCountdownLabel,"",CountdownRunnable.XXsFORMAT);
                break;
            case FRIDGE_COUNTDOWN:
                if(isFridgeCountdownActive()) fridgeCountdownRunnable.makeItStop();
                fridgeCountdownRunnable=new CountdownRunnable(FRIDGE_COUNTDOWN,millisForCoolingCycle,fridgeCountdownLabel,"",CountdownRunnable.XXsFORMAT);
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
                endpanelcontroller.startEndgameSequence();
                break;
            case PROPORTION_COUNTDOWN: //When the proportion countdown ends
                makeLabExplode();
                proportionsCountdownRunnable=null;
                break;
            case TRAY_COUNTDOWN: //When the cook cycle countdown ends
                trayCountdownRunnable=null;
                cookermanagerthread.cookCycleDone();
                break;
            case FRIDGE_COUNTDOWN: //When the cooling cycle countdown ends
                fridgeCountdownLabel=null;
                cookermanagerthread.coolingCycleDone();
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
    }
    public static boolean hasLabExploded(){
        return labHasExploded;
    }
    public static void addSuccessfulIngredient(){
        successfulIngredientsAdded++;

        resetCountdownRunnable(INGREDIENT_COUNTDOWN);


    }


    private void initializeGamePanelSprites(){
        int nContainer=0;
        int nRegular=0;
        int nCooker=0;

        regularSprites=new ArrayList<>();
        animatedContainers=new ArrayList<>();
        animatedCookers=new ArrayList<>();

        /////////////////////////////////////////////
        //CARDBOARD//
        regularSprites.add(new JLabel(""));
        regularSprites.get(nRegular).setIcon(new Sprite(media.getCardboard(),null,"cardboard",0.35,0.84, regularSprites.get(nRegular)));

        gf.getGamePanel().add(regularSprites.get(nRegular));
        nRegular++;
        //////////////////////////////////////////////
        //MUTANK//


        animatedContainers.add(new JLabel(""));
        animatedContainers.get(nContainer).setIcon(new SpriteContainer(media.getMuTank(),media.getMuTankHighlighted(),"muTank",0.38,0.72,-1,100,animatedContainers.get(nContainer)));

        gf.getGamePanel().add(animatedContainers.get(nContainer));

        nContainer++;

        //////////////////////////////////////////////
        //HCLTANK//


        animatedContainers.add(new JLabel(""));
        animatedContainers.get(nContainer).setIcon(new SpriteContainer(media.getHclTank(),media.getHclTankHighlighted(),"hclTank",0.45,0.68,-1,100,animatedContainers.get(nContainer)));

        gf.getGamePanel().add(animatedContainers.get(nContainer));
        nContainer++;
        //////////////////////////////////////////////
        //CSTANK//


        animatedContainers.add(new JLabel(""));
        animatedContainers.get(nContainer).setIcon(new SpriteContainer(media.getCsTank(),media.getCsTankHighlighted(),"csTank",0.51,0.73,-1,100,animatedContainers.get(nContainer)));

        gf.getGamePanel().add(animatedContainers.get(nContainer));

        nContainer++;
        /////////////////////////////////////////////
        //FIRE//
        regularSprites.add(new JLabel(""));
        regularSprites.get(nRegular).setIcon(new Sprite(media.getFire(),null,"fire",0,0, regularSprites.get(nRegular)));

        gf.getGamePanel().add(regularSprites.get(nRegular));
        nRegular++;
        //////////////////////////////////////////////
        //////////////////////////////////////////////
        //TRAY//


        animatedContainers.add(new JLabel(""));
        animatedContainers.get(nContainer).setIcon(new SpriteContainer(media.getTray(),media.getTrayHighlighted(),"tray",0.4,0.52,100,0,animatedContainers.get(nContainer)));

        gf.getGamePanel().add(animatedContainers.get(nContainer));

        nContainer++;
        //////////////////////////////////////////////
        //POSTIT//
        regularSprites.add(new JLabel(""));
        regularSprites.get(nRegular).setIcon(new Sprite(media.getPostit(),media.getPostitHighlighted(),"postit",0.61,0.22, regularSprites.get(nRegular)));

        gf.getGamePanel().add(regularSprites.get(nRegular));
        nRegular++;
        ///////////////////////////////////////////////
        //MUCOOKER//


        animatedCookers.add(new JLabel(""));
        animatedCookers.get(nCooker).setIcon(new SpriteContainer(media.getMuCooker(),media.getMuCookerHighlighted(),"muCooker",0.06,-0.05,100,0,animatedCookers.get(nCooker)));

        gf.getGamePanel().add(animatedCookers.get(nCooker));

        nCooker++;
        ////////////////////////////////////////////////////
        //HCLCOOKER//


        animatedCookers.add(new JLabel(""));
        animatedCookers.get(nCooker).setIcon(new SpriteContainer(media.getHclCooker(),media.getHclCookerHighlighted(),"hclCooker",0.3,0.22,100,0,animatedCookers.get(nCooker)));

        gf.getGamePanel().add(animatedCookers.get(nCooker));

        nCooker++;
        ////////////////////////////////////////////////////
        //CSCOOKER//


        animatedCookers.add(new JLabel(""));
        animatedCookers.get(nCooker).setIcon(new SpriteContainer(media.getCsCooker(),media.getCsCookerHighlighted(),"csCooker",0.16,0.2,100,0,animatedCookers.get(nCooker)));

        gf.getGamePanel().add(animatedCookers.get(nCooker));

        nCooker++;
        /////////////////////////////////////////////
        //TABLE//
        regularSprites.add(new JLabel(""));
        regularSprites.get(nRegular).setIcon(new Sprite(media.getTable(),null,"table",0.03,0.5, regularSprites.get(nRegular)));

        gf.getGamePanel().add(regularSprites.get(nRegular));

        nRegular++;
        ////////////////////////////////////////////////////
        //FRIDGE//


        animatedContainers.add(new JLabel(""));
        animatedContainers.get(nContainer).setIcon(new SpriteContainer(media.getFridge(),media.getFridgeHighlighted(),"fridge",0.50,0.09,100,0,animatedContainers.get(nContainer)));

        gf.getGamePanel().add(animatedContainers.get(nContainer));

        nContainer++;
        ////////////////////////////////////////////////////
        //VAN//
        vanProgressBar=new JProgressBar(0,100);

        gf.getGamePanel().add(vanProgressBar);

        animatedContainers.add(new JLabel(""));
        animatedContainers.get(nContainer).setIcon(new SpriteContainer(media.getVan(),media.getVanHighlighted(),"van",0.76,0.11,100,0,animatedContainers.get(nContainer)));
        vanProgressBar.setBounds((int)animatedContainers.get(nContainer).getLocation().getX(),(int)animatedContainers.get(nContainer).getLocation().getY(),100,50);
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

    public static CountdownRunnable getFridgeCountdownRunnable() {
        return fridgeCountdownRunnable;
    }

    public static void setFridgeCountdownRunnable(CountdownRunnable fridgeCountdownRunnable) {
        GameFrameController.fridgeCountdownRunnable=fridgeCountdownRunnable;
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
    public static long getUnitsCooledForCoolingCycle() {
        return unitsCooledForCoolingCycle;
    }

    public static GameFrame getGf() {
        return gf;
    }

    public static long getMillisForCookCycle() {
        return millisForCookCycle;
    }
    public static long getMillisForCoolingCycle() {
        return millisForCookCycle;
    }

    public static void setMillisForCoolingCycle(long millisForCoolingCycle) {
        GameFrameController.millisForCoolingCycle=millisForCoolingCycle;
    }

    public static void setUnitsCooledForCoolingCycle(long unitsCooledForCoolingCycle) {
        GameFrameController.unitsCooledForCoolingCycle=unitsCooledForCoolingCycle;
    }

    public static void setPoliceCountdownRunnable(CountdownRunnable newPoliceCountdownRunnable) {
        policeCountdownRunnable=newPoliceCountdownRunnable;
    }

    public static void setIngredientCountdownRunnable(CountdownRunnable newIngredientCountdownRunnable) {
        ingredientCountdownRunnable=newIngredientCountdownRunnable;
    }

    public static void setProportionsCountdownRunnable(CountdownRunnable newProportionsCountdownRunnable) {
        proportionsCountdownRunnable=newProportionsCountdownRunnable;
    }

    public static void setTrayCountdownRunnable(CountdownRunnable newTrayCountdownRunnable) {
        trayCountdownRunnable=newTrayCountdownRunnable;
    }

    public static JTextArea getTrayCountdownLabel() {
        return trayCountdownLabel;
    }

    public static VanThread getVanThread() {
        return vanThread;
    }

    public static JLabel getMoneyLabel() {
        return moneyLabel;
    }

    public static int getMoney() {
        return money;
    }

    public static JButton getShopButton() {
        return shopButton;
    }

    public static JTextArea getFridgeReadyLabel() {
        return fridgeReadyLabel;
    }

    public static void setMillisForCookCycle(long millisForCookCycle) {
        GameFrameController.millisForCookCycle=millisForCookCycle;
    }

    public static void setUnitsCookedForCookCycle(long unitsCookedForCookCycle) {
        GameFrameController.unitsCookedForCookCycle=unitsCookedForCookCycle;
    }

    public static long getMoneyForCookedUnit() {
        return moneyForCookedUnit;
    }

    public static ArrayList<JLabel> getRegularSprites() {
        return regularSprites;
    }

    public static int getSuccessfulIngredientsAdded() {
        return successfulIngredientsAdded;
    }

    public static int getSuccessfulBags() {
        return successfulBags;
    }

    public static void setMoney(int money) {
        GameFrameController.money=money;
    }

    public static void addMoney(long plusMoney){
        money+=plusMoney;
    }
    public static void addMoneyMade(long plusMoneyMade){
        moneyMade+=plusMoneyMade;
    }

    public static int getMoneyMade() {
        return moneyMade;
    }
    public static void addSuccessfullBags(long addedBags){
        successfulBags+=addedBags;
    }

    public static void removeMoney(long minusMoney){
        money-=minusMoney;
    }
    public static boolean transactionPossible(long moneyModifier){
        if(money+moneyModifier>=0){
            return true;
        }
        else{
            return false;
        }
    }
}
