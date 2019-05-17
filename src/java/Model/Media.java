package Model;

import javax.swing.*;
import java.awt.*;

public class Media{
    private Image[] table;
    private Image[] muCooker;
    private Image[] muCookerHighlighted;
    private Image[] hclCooker;
    private Image[] hclCookerHighlighted;
    private Image[] csCooker;
    private Image[] csCookerHighlighted;
    private Image[] tray;
    private Image[] trayHighlighted;
    private Image[] fridge;
    private Image[] fridgeHighlighted;
    private Image[] van;
    private Image[] vanHighlighted;
    private Image[] background;
    private Image[] shopBackground;

    private Image[] postit;
    private Image[] postitHighlighted;
    private Image[] fire;
    private Image[] cardboard;
    private Image[] muTank;
    private Image[] muTankHighlighted;
    private Image[] hclTank;
    private Image[] hclTankHighlighted;
    private Image[] csTank;
    private Image[] csTankHighlighted;

    private Image[] instructions;

    private double imageResizeRatio;
    private Toolkit tk;

    public Media() {
        tk=Toolkit.getDefaultToolkit();
        importAllImages();
        imageResizeRatio= Toolkit.getDefaultToolkit().getScreenSize().getWidth()/new ImageIcon(background[0]).getIconWidth();
        adjustImagesSize();
    }
    public double getImageResizeRatio() {
        return imageResizeRatio;
    }

    public void adjustImagesSize(){
        imageResizeRatio= Toolkit.getDefaultToolkit().getScreenSize().getWidth()/new ImageIcon(background[0]).getIconWidth();
        adjustBackgroundSize();
        adjustShopBackgroundImage();
        adjustCSSize();
        adjustFridgeSize();
        adjustHCLSize();
        adjustMUSize();
        adjustTableSize();
        adjustTrayAndSize();
        adjustVanSize();
        adjustPostitSize();
        adjustCardboardSize();
        adjustMuTankSize();
        adjustHclTankSize();
        adjustCsTankSize();
        adjustFireSize();
    }
    public void adjustShopBackgroundImage(){
        double ratio=imageResizeRatio;
        Image[] image;
        image= shopBackground;
        for(int n=0;n<image.length;n++){
            image[n]=image[n].getScaledInstance((int)(new ImageIcon(image[n]).getIconWidth()*ratio),(int)(new ImageIcon(image[n]).getIconHeight()*ratio),Image.SCALE_SMOOTH);
        }
    }
    public void adjustMUSize(){
        double ratio=imageResizeRatio;
        Image[] image;
        image=muCooker;
        for(int n=0;n<image.length;n++){
            image[n]=image[n].getScaledInstance((int)(new ImageIcon(image[n]).getIconWidth()*ratio),(int)(new ImageIcon(image[n]).getIconHeight()*ratio),Image.SCALE_SMOOTH);
        }
        image=muCookerHighlighted;
        for(int n=0;n<image.length;n++){
            image[n]=image[n].getScaledInstance((int)(new ImageIcon(image[n]).getIconWidth()*ratio),(int)(new ImageIcon(image[n]).getIconHeight()*ratio),Image.SCALE_SMOOTH);
        }
    }
    public void adjustHCLSize(){
        double ratio=imageResizeRatio;
        Image[] image;
        image=hclCooker;
        for(int n=0;n<image.length;n++){
            image[n]=image[n].getScaledInstance((int)(new ImageIcon(image[n]).getIconWidth()*ratio),(int)(new ImageIcon(image[n]).getIconHeight()*ratio),Image.SCALE_SMOOTH);
        }
        image=hclCookerHighlighted;
        for(int n=0;n<image.length;n++){
            image[n]=image[n].getScaledInstance((int)(new ImageIcon(image[n]).getIconWidth()*ratio),(int)(new ImageIcon(image[n]).getIconHeight()*ratio),Image.SCALE_SMOOTH);
        }

    }
    public void adjustCSSize(){
        double ratio=imageResizeRatio;
        Image[] image;
        image=csCooker;
        for(int n=0;n<image.length;n++){
            image[n]=image[n].getScaledInstance((int)(new ImageIcon(image[n]).getIconWidth()*ratio),(int)(new ImageIcon(image[n]).getIconHeight()*ratio),Image.SCALE_SMOOTH);
        }
        image=csCookerHighlighted;
        for(int n=0;n<image.length;n++){
            image[n]=image[n].getScaledInstance((int)(new ImageIcon(image[n]).getIconWidth()*ratio),(int)(new ImageIcon(image[n]).getIconHeight()*ratio),Image.SCALE_SMOOTH);
        }
    }
    public void adjustBackgroundSize(){
        double ratio=imageResizeRatio;
        Image[] image;
        image= background;
        for(int n=0;n<image.length;n++){
            image[n]=image[n].getScaledInstance((int)(new ImageIcon(image[n]).getIconWidth()*ratio),(int)(new ImageIcon(image[n]).getIconHeight()*ratio),Image.SCALE_SMOOTH);
        }
    }
    public void adjustTableSize(){
        double ratio=imageResizeRatio;
        Image[] image;
        image= table;
        for(int n=0;n<image.length;n++){
            image[n]=image[n].getScaledInstance((int)(new ImageIcon(image[n]).getIconWidth()*ratio),(int)(new ImageIcon(image[n]).getIconHeight()*ratio),Image.SCALE_SMOOTH);
        }
    }
    public void adjustFridgeSize(){
        double ratio=imageResizeRatio;
        Image[] image;
        image= fridge;
        for(int n=0;n<image.length;n++){
            image[n]=image[n].getScaledInstance((int)(new ImageIcon(image[n]).getIconWidth()*ratio),(int)(new ImageIcon(image[n]).getIconHeight()*ratio),Image.SCALE_SMOOTH);
        }
        image=fridgeHighlighted;
        for(int n=0;n<image.length;n++){
            image[n]=image[n].getScaledInstance((int)(new ImageIcon(image[n]).getIconWidth()*ratio),(int)(new ImageIcon(image[n]).getIconHeight()*ratio),Image.SCALE_SMOOTH);
        }
    }
    public void adjustTrayAndSize(){
        double ratio=imageResizeRatio;
        Image[] image;
        image= tray;
        for(int n=0;n<image.length;n++){
            image[n]=image[n].getScaledInstance((int)(new ImageIcon(image[n]).getIconWidth()*ratio),(int)(new ImageIcon(image[n]).getIconHeight()*ratio),Image.SCALE_SMOOTH);
        }
        image=trayHighlighted;
        for(int n=0;n<image.length;n++){
            image[n]=image[n].getScaledInstance((int)(new ImageIcon(image[n]).getIconWidth()*ratio),(int)(new ImageIcon(image[n]).getIconHeight()*ratio),Image.SCALE_SMOOTH);
        }
    }
    public void adjustVanSize(){
        double ratio=imageResizeRatio;
        Image[] image;
        image= van;
        for(int n=0;n<image.length;n++){
            image[n]=image[n].getScaledInstance((int)(new ImageIcon(image[n]).getIconWidth()*ratio),(int)(new ImageIcon(image[n]).getIconHeight()*ratio),Image.SCALE_SMOOTH);
        }
        image=vanHighlighted;
        for(int n=0;n<image.length;n++){
            image[n]=image[n].getScaledInstance((int)(new ImageIcon(image[n]).getIconWidth()*ratio),(int)(new ImageIcon(image[n]).getIconHeight()*ratio),Image.SCALE_SMOOTH);
        }
    }
    public void adjustPostitSize(){
        double ratio=imageResizeRatio;
        Image[] image;
        image= postit;
        for(int n=0;n<image.length;n++){
            image[n]=image[n].getScaledInstance((int)(new ImageIcon(image[n]).getIconWidth()*ratio),(int)(new ImageIcon(image[n]).getIconHeight()*ratio),Image.SCALE_SMOOTH);
        }
        image=postitHighlighted;
        for(int n=0;n<image.length;n++){
            image[n]=image[n].getScaledInstance((int)(new ImageIcon(image[n]).getIconWidth()*ratio),(int)(new ImageIcon(image[n]).getIconHeight()*ratio),Image.SCALE_SMOOTH);
        }
    }
    public void adjustCardboardSize(){
        double ratio=imageResizeRatio;
        Image[] image;
        image= cardboard;
        for(int n=0;n<image.length;n++){
            image[n]=image[n].getScaledInstance((int)(new ImageIcon(image[n]).getIconWidth()*ratio),(int)(new ImageIcon(image[n]).getIconHeight()*ratio),Image.SCALE_SMOOTH);
        }
    }
    public void adjustMuTankSize(){
        double ratio=imageResizeRatio;
        Image[] image;
        image= muTank;
        for(int n=0;n<image.length;n++){
            image[n]=image[n].getScaledInstance((int)(new ImageIcon(image[n]).getIconWidth()*ratio),(int)(new ImageIcon(image[n]).getIconHeight()*ratio),Image.SCALE_SMOOTH);
        }
        image=muTankHighlighted;
        for(int n=0;n<image.length;n++){
            image[n]=image[n].getScaledInstance((int)(new ImageIcon(image[n]).getIconWidth()*ratio),(int)(new ImageIcon(image[n]).getIconHeight()*ratio),Image.SCALE_SMOOTH);
        }
    }
    public void adjustHclTankSize(){
        double ratio=imageResizeRatio;
        Image[] image;
        image= hclTank;
        for(int n=0;n<image.length;n++){
            image[n]=image[n].getScaledInstance((int)(new ImageIcon(image[n]).getIconWidth()*ratio),(int)(new ImageIcon(image[n]).getIconHeight()*ratio),Image.SCALE_SMOOTH);
        }
        image=hclTankHighlighted;
        for(int n=0;n<image.length;n++){
            image[n]=image[n].getScaledInstance((int)(new ImageIcon(image[n]).getIconWidth()*ratio),(int)(new ImageIcon(image[n]).getIconHeight()*ratio),Image.SCALE_SMOOTH);
        }
    }
    public void adjustCsTankSize(){
        double ratio=imageResizeRatio;
        Image[] image;
        image= csTank;
        for(int n=0;n<image.length;n++){
            image[n]=image[n].getScaledInstance((int)(new ImageIcon(image[n]).getIconWidth()*ratio),(int)(new ImageIcon(image[n]).getIconHeight()*ratio),Image.SCALE_SMOOTH);
        }
        image=csTankHighlighted;
        for(int n=0;n<image.length;n++){
            image[n]=image[n].getScaledInstance((int)(new ImageIcon(image[n]).getIconWidth()*ratio),(int)(new ImageIcon(image[n]).getIconHeight()*ratio),Image.SCALE_SMOOTH);
        }
    }
    public void adjustFireSize(){
        double ratio=imageResizeRatio;
        Image[] image;
        image= fire;
        for(int n=0;n<image.length;n++){
            image[n]=image[n].getScaledInstance((int)(new ImageIcon(image[n]).getIconWidth()*ratio),(int)(new ImageIcon(image[n]).getIconHeight()*ratio),Image.SCALE_SMOOTH);
        }
    }

    public void importAllImages(){
        importMUImages();
        importHCLImages();
        importCSImages();
        importFRIDGEImages();
        importVANImages();
        importTRAYImages();
        importTABLEImage();
        importPOSTITImage();
        importCARDBOARDImage();
        importMUTANKImage();
        importCSTANKImage();
        importHCLTANKImage();
        importINSTRUCTIONSImage();
        importFIREImage();
        importSHOPBACKGROUNDImage();
        importBACKGROUNDImage();
    }
    public void importMUImages(){
        muCooker=new Image[3];

        muCooker[0]=tk.getImage(getClass().getResource("/mu/mu_0.png"));
        muCooker[1]=tk.getImage(getClass().getResource("/mu/mu_1.png"));
        muCooker[2]=tk.getImage(getClass().getResource("/mu/mu_2.png"));
        if(muCooker[0]==null|| muCooker[1]==null|| muCooker[2]==null){
            JFrame a =new JFrame("");
            a.setVisible(false);

            JOptionPane.showMessageDialog(a,"Error loading 'mu_' images","Media Error",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        muCookerHighlighted=new Image[3];

        muCookerHighlighted[0]=tk.getImage(getClass().getResource("/mu/muHighlighted_0.png"));
        muCookerHighlighted[1]=tk.getImage(getClass().getResource("/mu/muHighlighted_1.png"));
        muCookerHighlighted[2]=tk.getImage(getClass().getResource("/mu/muHighlighted_2.png"));
        if(muCookerHighlighted[0]==null|| muCookerHighlighted[1]==null|| muCookerHighlighted[2]==null){
            JFrame a =new JFrame("");
            a.setVisible(false);

            JOptionPane.showMessageDialog(a,"Error loading 'mu_' images","Media Error",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
    public void importHCLImages(){
        hclCooker=new Image[3];

        hclCooker[0]=tk.getImage(getClass().getResource("/hcl/hcl_0.png"));
        hclCooker[1]=tk.getImage(getClass().getResource("/hcl/hcl_1.png"));
        hclCooker[2]=tk.getImage(getClass().getResource("/hcl/hcl_0.png"));

        if(hclCooker[0]==null|| hclCooker[1]==null|| hclCooker[2]==null){
            JFrame a =new JFrame("");
            a.setVisible(false);

            JOptionPane.showMessageDialog(a,"Error loading 'hcl_' images","Media Error",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        hclCookerHighlighted=new Image[3];

        hclCookerHighlighted[0]=tk.getImage(getClass().getResource("/hcl/hclHighlighted_0.png"));
        hclCookerHighlighted[1]=tk.getImage(getClass().getResource("/hcl/hclHighlighted_1.png"));
        hclCookerHighlighted[2]=tk.getImage(getClass().getResource("/hcl/hclHighlighted_0.png"));

        if(hclCookerHighlighted[0]==null|| hclCookerHighlighted[1]==null|| hclCookerHighlighted[2]==null){
            JFrame a =new JFrame("");
            a.setVisible(false);

            JOptionPane.showMessageDialog(a,"Error loading 'hcl_' images","Media Error",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
    public void importCSImages(){
        csCooker=new Image[3];

        csCooker[0]=tk.getImage(getClass().getResource("/cs/cs_0.png"));
        csCooker[1]=tk.getImage(getClass().getResource("/cs/cs_1.png"));
        csCooker[2]=tk.getImage(getClass().getResource("/cs/cs_2.png"));
        if(csCooker[0]==null|| csCooker[1]==null|| csCooker[2]==null){
            JFrame a =new JFrame("");
            a.setVisible(false);

            JOptionPane.showMessageDialog(a,"Error loading 'cs_' images","Media Error",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        csCookerHighlighted=new Image[3];

        csCookerHighlighted[0]=tk.getImage(getClass().getResource("/cs/csHighlighted_0.png"));
        csCookerHighlighted[1]=tk.getImage(getClass().getResource("/cs/csHighlighted_1.png"));
        csCookerHighlighted[2]=tk.getImage(getClass().getResource("/cs/csHighlighted_2.png"));
        if(csCookerHighlighted[0]==null|| csCookerHighlighted[1]==null|| csCookerHighlighted[2]==null){
            JFrame a =new JFrame("");
            a.setVisible(false);

            JOptionPane.showMessageDialog(a,"Error loading 'cs_' images","Media Error",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
    public void importFRIDGEImages(){
        fridge=new Image[5];

        fridge[0]=tk.getImage(getClass().getResource("/fridge/fridge_0.png"));
        fridge[1]=tk.getImage(getClass().getResource("/fridge/fridge_1.png"));
        fridge[2]=tk.getImage(getClass().getResource("/fridge/fridge_2.png"));
        fridge[3]=tk.getImage(getClass().getResource("/fridge/fridge_3.png"));
        fridge[4]=tk.getImage(getClass().getResource("/fridge/fridge_4.png"));
        if(fridge[0]==null||fridge[1]==null||fridge[2]==null||fridge[3]==null||fridge[4]==null){
            JFrame a =new JFrame("");
            a.setVisible(false);

            JOptionPane.showMessageDialog(a,"Error loading 'fridge_' images","Media Error",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        fridgeHighlighted=new Image[5];

        fridgeHighlighted[0]=tk.getImage(getClass().getResource("/fridge/fridgeHighlighted_0.png"));
        fridgeHighlighted[1]=tk.getImage(getClass().getResource("/fridge/fridgeHighlighted_1.png"));
        fridgeHighlighted[2]=tk.getImage(getClass().getResource("/fridge/fridgeHighlighted_2.png"));
        fridgeHighlighted[3]=tk.getImage(getClass().getResource("/fridge/fridgeHighlighted_3.png"));
        fridgeHighlighted[4]=tk.getImage(getClass().getResource("/fridge/fridgeHighlighted_4.png"));
        if(fridgeHighlighted[0]==null||fridgeHighlighted[1]==null||fridgeHighlighted[2]==null||fridgeHighlighted[3]==null||fridgeHighlighted[4]==null){
            JFrame a =new JFrame("");
            a.setVisible(false);

            JOptionPane.showMessageDialog(a,"Error loading 'fridge_' images","Media Error",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

    }
    public void importVANImages(){
        van=new Image[5];

        van[0]=tk.getImage(getClass().getResource("/van/van_0.png"));
        van[1]=tk.getImage(getClass().getResource("/van/van_1.png"));
        van[2]=tk.getImage(getClass().getResource("/van/van_2.png"));
        van[3]=tk.getImage(getClass().getResource("/van/van_3.png"));
        van[4]=tk.getImage(getClass().getResource("/van/van_4.png"));
        if(van[0]==null||van[1]==null||van[2]==null||van[3]==null||van[4]==null){
            JFrame a =new JFrame("");
            a.setVisible(false);

            JOptionPane.showMessageDialog(a,"Error loading 'van_' images","Media Error",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        vanHighlighted=new Image[5];

        vanHighlighted[0]=tk.getImage(getClass().getResource("/van/vanHighlighted_0.png"));
        vanHighlighted[1]=tk.getImage(getClass().getResource("/van/vanHighlighted_1.png"));
        vanHighlighted[2]=tk.getImage(getClass().getResource("/van/vanHighlighted_2.png"));
        vanHighlighted[3]=tk.getImage(getClass().getResource("/van/vanHighlighted_3.png"));
        vanHighlighted[4]=tk.getImage(getClass().getResource("/van/vanHighlighted_4.png"));
        if(vanHighlighted[0]==null||vanHighlighted[1]==null||vanHighlighted[2]==null||vanHighlighted[3]==null||vanHighlighted[4]==null){
            JFrame a =new JFrame("");
            a.setVisible(false);

            JOptionPane.showMessageDialog(a,"Error loading 'van_' images","Media Error",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
    public void importTRAYImages(){
        tray=new Image[5];

        tray[0]=tk.getImage(getClass().getResource("/tray/tray_0.png"));
        tray[1]=tk.getImage(getClass().getResource("/tray/tray_1.png"));
        tray[2]=tk.getImage(getClass().getResource("/tray/tray_2.png"));
        tray[3]=tk.getImage(getClass().getResource("/tray/tray_3.png"));
        tray[4]=tk.getImage(getClass().getResource("/tray/tray_4.png"));
        if(tray[0]==null||tray[1]==null||tray[2]==null||tray[3]==null||tray[4]==null){
            JFrame a =new JFrame("");
            a.setVisible(false);

            JOptionPane.showMessageDialog(a,"Error loading 'tray_' images","Media Error",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        trayHighlighted=new Image[5];

        trayHighlighted[0]=tk.getImage(getClass().getResource("/tray/trayHighlighted_0.png"));
        trayHighlighted[1]=tk.getImage(getClass().getResource("/tray/trayHighlighted_1.png"));
        trayHighlighted[2]=tk.getImage(getClass().getResource("/tray/trayHighlighted_2.png"));
        trayHighlighted[3]=tk.getImage(getClass().getResource("/tray/trayHighlighted_3.png"));
        trayHighlighted[4]=tk.getImage(getClass().getResource("/tray/trayHighlighted_4.png"));
        if(trayHighlighted[0]==null||trayHighlighted[1]==null||trayHighlighted[2]==null||trayHighlighted[3]==null||trayHighlighted[4]==null){
            JFrame a =new JFrame("");
            a.setVisible(false);

            JOptionPane.showMessageDialog(a,"Error loading 'tray_' images","Media Error",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
    public void importTABLEImage(){
        table=new Image[1];

        table[0]=tk.getImage(getClass().getResource("/table_0.png"));

        if(table==null){
            JFrame a =new JFrame("");
            a.setVisible(false);

            JOptionPane.showMessageDialog(a,"Error loading 'table_0.png'","Media Error",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
    public void importSHOPBACKGROUNDImage(){
        shopBackground=new Image[1];

        shopBackground[0]=tk.getImage(getClass().getResource("/shop_0.png"));
        if(shopBackground==null){
            JFrame a =new JFrame("");
            a.setVisible(false);

            JOptionPane.showMessageDialog(a,"Error loading 'shop_0.png'","Media Error",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    public void importBACKGROUNDImage(){
        background=new Image[1];

        background[0]=tk.getImage(getClass().getResource("/background_0.png"));
        if(background==null){
            JFrame a =new JFrame("");
            a.setVisible(false);

            JOptionPane.showMessageDialog(a,"Error loading 'background_0.png'","Media Error",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
    public void importPOSTITImage(){
        postit=new Image[1];

        postit[0]=tk.getImage(getClass().getResource("/postit/postit_0.png"));
        if(postit==null){
            JFrame a =new JFrame("");
            a.setVisible(false);

            JOptionPane.showMessageDialog(a,"Error loading 'postit_0.png'","Media Error",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        postitHighlighted=new Image[1];

        postitHighlighted[0]=tk.getImage(getClass().getResource("/postit/postitHighlighted_0.png"));
        if(postitHighlighted==null){
            JFrame a =new JFrame("");
            a.setVisible(false);

            JOptionPane.showMessageDialog(a,"Error loading 'postit_0.png'","Media Error",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
    public void importCARDBOARDImage(){
        cardboard=new Image[1];

        cardboard[0]=tk.getImage(getClass().getResource("/cardboard_0.png"));
        if(cardboard==null){
            JFrame a =new JFrame("");
            a.setVisible(false);

            JOptionPane.showMessageDialog(a,"Error loading 'cardboard_0.png'","Media Error",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
    public void importMUTANKImage(){
        muTank=new Image[1];

        muTank[0]=tk.getImage(getClass().getResource("/mu/muTank_0.png"));
        if(muTank==null){
            JFrame a =new JFrame("");
            a.setVisible(false);

            JOptionPane.showMessageDialog(a,"Error loading 'muTank_0.png'","Media Error",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        muTankHighlighted=new Image[1];

        muTankHighlighted[0]=tk.getImage(getClass().getResource("/mu/muTankHighlighted_0.png"));
        if(muTankHighlighted==null){
            JFrame a =new JFrame("");
            a.setVisible(false);

            JOptionPane.showMessageDialog(a,"Error loading 'muTank_0.png'","Media Error",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
    public void importHCLTANKImage(){
        hclTank=new Image[1];

        hclTank[0]=tk.getImage(getClass().getResource("/hcl/hclTank_0.png"));
        if(hclTank==null){
            JFrame a =new JFrame("");
            a.setVisible(false);

            JOptionPane.showMessageDialog(a,"Error loading 'hclTank_0.png'","Media Error",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        hclTankHighlighted=new Image[1];

        hclTankHighlighted[0]=tk.getImage(getClass().getResource("/hcl/hclTankHighlighted_0.png"));
        if(hclTankHighlighted==null){
            JFrame a =new JFrame("");
            a.setVisible(false);

            JOptionPane.showMessageDialog(a,"Error loading 'hclTank_0.png'","Media Error",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
    public void importCSTANKImage(){
        csTank=new Image[1];

        csTank[0]=tk.getImage(getClass().getResource("/cs/csTank_0.png"));
        if(csTank==null){
            JFrame a =new JFrame("");
            a.setVisible(false);

            JOptionPane.showMessageDialog(a,"Error loading 'csTank_0.png'","Media Error",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        csTankHighlighted=new Image[1];

        csTankHighlighted[0]=tk.getImage(getClass().getResource("/cs/csTankHighlighted_0.png"));
        if(csTankHighlighted==null){
            JFrame a =new JFrame("");
            a.setVisible(false);

            JOptionPane.showMessageDialog(a,"Error loading 'csTank_0.png'","Media Error",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
    public void importFIREImage(){
        fire=new Image[3];

        fire[0]=tk.getImage(getClass().getResource("/fire/fire_0.png"));
        fire[1]=tk.getImage(getClass().getResource("/fire/fire_1.png"));
        fire[2]=tk.getImage(getClass().getResource("/fire/fire_2.png"));
        if(fridge[0]==null||fridge[1]==null||fridge[2]==null){
            JFrame a =new JFrame("");
            a.setVisible(false);

            JOptionPane.showMessageDialog(a,"Error loading 'fire_' images","Media Error",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
    public void importINSTRUCTIONSImage(){
        instructions=new Image[1];

        instructions[0]=tk.getImage(getClass().getResource("/instructions.png"));
        if(instructions==null){
            JFrame a =new JFrame("");
            a.setVisible(false);

            JOptionPane.showMessageDialog(a,"Error loading 'instructions.png'","Media Error",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }


    public Image[] getTable() {
        return table;
    }
    public Image[] getMuCooker() {
        return muCooker;
    }
    public Image[] getHclCooker() {
        return hclCooker;
    }
    public Image[] getCsCooker() {
        return csCooker;
    }
    public Image[] getTray() {
        return tray;
    }
    public Image[] getFridge() {
        return fridge;
    }
    public Image[] getVan() {
        return van;
    }
    public Image[] getBackground() {
        return background;
    }
    public Image[] getPostit() {
        return postit;
    }
    public Image[] getCardboard() {
        return cardboard;
    }
    public Image[] getMuTank() {
        return muTank;
    }
    public Image[] getHclTank() {
        return hclTank;
    }
    public Image[] getCsTank() {
        return csTank;
    }
    public Image[] getInstructions() {
        return instructions;
    }
    public Image[] getFire() {
        return fire;
    }
    public Image[] getMuCookerHighlighted() {
        return muCookerHighlighted;
    }
    public Image[] getHclCookerHighlighted() {
        return hclCookerHighlighted;
    }
    public Image[] getCsCookerHighlighted() {
        return csCookerHighlighted;
    }
    public Image[] getTrayHighlighted() {
        return trayHighlighted;
    }
    public Image[] getFridgeHighlighted() {
        return fridgeHighlighted;
    }
    public Image[] getVanHighlighted() {
        return vanHighlighted;
    }
    public Image[] getPostitHighlighted() {
        return postitHighlighted;
    }
    public Image[] getMuTankHighlighted() {
        return muTankHighlighted;
    }
    public Image[] getHclTankHighlighted() {
        return hclTankHighlighted;
    }
    public Image[] getCsTankHighlighted() {
        return csTankHighlighted;
    }
}

