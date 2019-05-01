package Model;

import Controller.GameFrameController;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.StringTokenizer;

public class Media{
    private Image[] table;
    private Image[] mu;
    private Image[] hcl;
    private Image[] cs;
    private Image[] tray;
    private Image[] fridge;
    private Image[] van;
    private Image[] background;

    private  final double imageResizeRatio;
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
        adjustBackgroundSize();
        adjustCSSize();
        adjustFridgeSize();
        adjustHCLSize();
        adjustMUSize();
        adjustTableSize();
        adjustTrayAndSize();
        adjustVanSize();
    }
    public void adjustMUSize(){
        double ratio=imageResizeRatio;
        Image[] image;
        image= mu;
        for(int n=0;n<image.length;n++){
            image[n]=image[n].getScaledInstance((int)(new ImageIcon(image[n]).getIconWidth()*ratio),(int)(new ImageIcon(image[n]).getIconHeight()*ratio),Image.SCALE_SMOOTH);
        }
    }
    public void adjustHCLSize(){
        double ratio=imageResizeRatio;
        Image[] image;
        image= hcl;
        for(int n=0;n<image.length;n++){
            image[n]=image[n].getScaledInstance((int)(new ImageIcon(image[n]).getIconWidth()*ratio),(int)(new ImageIcon(image[n]).getIconHeight()*ratio),Image.SCALE_SMOOTH);
        }
    }
    public void adjustCSSize(){
        double ratio=imageResizeRatio;
        Image[] image;
        image= cs;
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
    }
    public void adjustTrayAndSize(){
        double ratio=imageResizeRatio;
        Image[] image;
        image= tray;
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
    }

    public void importAllImages(){
        refreshMUImages();
        refreshHCLImages();
        refreshCSImages();
        refreshFRIDGEImages();
        refreshVANImages();
        refreshTRAYImages();
        refreshTABLEImage();
        refreshBACKGROUNDImage();
    }
    public void refreshMUImages(){
        mu=new Image[3];


        mu[0]=tk.getImage(getClass().getResource("/mu/mu_0.png"));
        mu[1]=tk.getImage(getClass().getResource("/mu/mu_1.png"));
        mu[2]=tk.getImage(getClass().getResource("/mu/mu_2.png"));
        if(mu[0]==null||mu[1]==null||mu[2]==null){
            JFrame a =new JFrame("");
            a.setVisible(false);

            JOptionPane.showMessageDialog(a,"Error loading 'mu_' images","Media Error",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
    public void refreshHCLImages(){
        hcl=new Image[2];

        hcl[0]=tk.getImage(getClass().getResource("/hcl/hcl_0.png"));
        hcl[1]=tk.getImage(getClass().getResource("/hcl/hcl_1.png"));

        if(hcl[0]==null||hcl[1]==null){
            JFrame a =new JFrame("");
            a.setVisible(false);

            JOptionPane.showMessageDialog(a,"Error loading 'hcl_' images","Media Error",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
    public void refreshCSImages(){
        cs=new Image[3];

        cs[0]=tk.getImage(getClass().getResource("/cs/cs_0.png"));
        cs[1]=tk.getImage(getClass().getResource("/cs/cs_1.png"));
        cs[2]=tk.getImage(getClass().getResource("/cs/cs_2.png"));
        if(cs[0]==null||cs[1]==null||cs[2]==null){
            JFrame a =new JFrame("");
            a.setVisible(false);

            JOptionPane.showMessageDialog(a,"Error loading 'cs_' images","Media Error",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
    public void refreshFRIDGEImages(){
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
    }
    public void refreshVANImages(){
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
    }
    public void refreshTRAYImages(){
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
    }
    public void refreshTABLEImage(){
        table=new Image[1];

        table[0]=tk.getImage(getClass().getResource("/table_0.png"));

        if(table==null){
            JFrame a =new JFrame("");
            a.setVisible(false);

            JOptionPane.showMessageDialog(a,"Error loading 'table_0.png'","Media Error",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
    public void refreshBACKGROUNDImage(){
        background=new Image[1];

        background[0]=tk.getImage(getClass().getResource("/background_0.png"));
        if(background==null){
            JFrame a =new JFrame("");
            a.setVisible(false);

            JOptionPane.showMessageDialog(a,"Error loading 'background_0.png'","Media Error",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    public Image[] getTable() {
        return table;
    }
    public Image[] getMu() {
        return mu;
    }
    public Image[] getHcl() {
        return hcl;
    }
    public Image[] getCs() {
        return cs;
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
}

