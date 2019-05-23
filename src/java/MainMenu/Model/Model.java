/*
         * To change this license header, choose License Headers in Project Properties.
         * To change this template file, choose Tools | Templates
         * and open the template in the editor.
         */
        package MainMenu.Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author dario
 */
public class Model {

    private String fileName;



    public void saveName(String s) throws IOException{

//        String fileName = "myTextFile.txt";
//        PrintWriter writer;
//        writer = new PrintWriter(new BufferedWriter(new FileWriter("myTextFile.txt")));
//        writer.write("1"+" "+s);
//        System.out.println(s);
//        writer.close();

        File save = new File ("myTextFile.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(save));
        writer.write("1"+" "+s);
        writer.close();


    }


    public String readName() throws IOException{
        String s=null;
        try{
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            for(String line = reader.readLine(); line != null; line = reader.readLine()){
                System.out.println(line);
                s=line;
                reader.close();
            }
        }
        catch(IOException e){
        }
        return s;
    }
}