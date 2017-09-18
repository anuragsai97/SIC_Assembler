/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assembler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 *
 * @author ANURAG
 */
public class Assembler {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        pass1 p=new pass1();
        p.pass1();
        HashMap<String,String> hm=new HashMap<String,String>(); 
        hm=p.sym;
        try {

            File f = new File("C:/Users/PDN SRNIVAS/Desktop/inter.txt");
            File out = new File("C:/Users/PDN SRNIVAS/Desktop/object.txt");
            BufferedReader b = new BufferedReader(new FileReader(f));
            BufferedWriter writer = new BufferedWriter(new FileWriter(out, true));
            
            
            String readLine = "";

            System.out.println("Reading file using Buffered Reader");
            int count=0;
            while ((readLine = b.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(readLine," ");  
                ArrayList<String> arr=new ArrayList<String>();
                while (st.hasMoreTokens()) {  
                    arr.add(st.nextToken());
                    //System.out.println(st.nextToken());  
                } 
                if(count>=1){
                    if(arr.size()==3){
                        String label;
                        String add="";
                        if(arr.get(2).contains(",")){
                            StringTokenizer s = new StringTokenizer(arr.get(2),",");
                            //s.nextToken();
                            label=s.nextToken();
                            int d=Integer.parseInt("8000",16);
                            String temp=hm.get(label);
                            int decimal=Integer.parseInt(temp,16);
                            int dec_address=d+decimal;
                            add=Integer.toHexString(dec_address);
                        }                    
                        else{
                            label=arr.get(2);
                            add=hm.get(label);
                        }                       
                        
                        String object=arr.get(1)+add;
                        writer.write(object);
                        writer.newLine();
                    }
                    else if(arr.size()==2){
                        String label;
                        String add="";
                        
                        if(arr.get(1).contains(",")){
                            StringTokenizer s = new StringTokenizer(arr.get(1),",");
                            //s.nextToken();
                            label=s.nextToken();
                            int d=Integer.parseInt("8000",16);
                            String temp=hm.get(label);
                            int decimal=Integer.parseInt(temp,16);
                            int dec_address=d+decimal;
                            add=Integer.toHexString(dec_address);
                        }
                        else{
                            label=arr.get(1);
                            add=hm.get(label);
                        }
                        
                        
                        String object=arr.get(0)+add;
                        writer.write(object);
                        writer.newLine();
                              
                    }
                }
                
                count++;
                //System.out.println(readLine);
                
                
            }
            
          writer.close();  

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    
}
