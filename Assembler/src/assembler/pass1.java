/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assembler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 *
 * @author ANURAG
 */
public class pass1 {
    HashMap<String,String> sym= new HashMap();
    public void pass1() throws FileNotFoundException, IOException{
         opcode p=new opcode();
        
        String opcode;
        File file = new File("C:/Users/PDN SRNIVAS/Desktop/assembler.txt");
        File inter= new File("C:/Users/PDN SRNIVAS/Desktop/inter.txt");
        BufferedReader br= new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        BufferedWriter bw= new BufferedWriter(new FileWriter(inter,true));
        
        String t;
        int loc=0;
        String loc_h=null;
        ArrayList<String> to= new ArrayList();
        //System.out.println(br.readLine());
        //int d=Integer.parseInt("1000",16);
        //System.out.println(d);
        while((t=br.readLine())!=null)
        {
            StringTokenizer s=new StringTokenizer(t," ");
            while(s.hasMoreTokens())
            {
                to.add(s.nextToken(" "));
            }
            //System.out.println(s.nextToken(""));
           if(to.size()==3)
           {
            if(to.get(1).equals("START"))
            {
                loc=Integer.parseInt(to.get(2),16);
                loc=loc-3;
                String l=to.get(0)+" "+to.get(1)+" "+to.get(2);
                bw.write(l);
                bw.newLine();
            }
            else if(loc!=0)
            {
                
                //System.out.println(to.get(1));
               
                
                p.opcode();
                opcode=p.hr.get(to.get(1));
                if(to.get(1).equals("RESW"))
              {
                  int k=Integer.parseInt(to.get(2),16);
                  loc+=3*k;
                  loc_h=Integer.toHexString(loc);
              }
                else if(to.get(1).equals("RESB"))
              {
                  int l=Integer.parseInt(to.get(2),16);
                  loc+=l;
                  loc_h=Integer.toHexString(loc);
              }
                else if(to.get(1).equals("BYTE"))
              {
                  loc+=1;
                  loc_h=Integer.toHexString(loc);
              }
                else
                {
                  loc+=3;
                loc_h=Integer.toHexString(loc);
                }
                
                //System.out.println(opcode);
                String line=to.get(0)+" "+opcode+" "+to.get(2);
                if(!line.contains("null")){
                    bw.write(line);
                    bw.newLine();
                }
                
                if(!sym.containsKey(to.get(0)))
                sym.put(to.get(0),loc_h);
                
                
                
                
            }
            
         }
           if(to.size()==2)
           {
               p.opcode();
               
              opcode=p.hr.get(to.get(0));
              if(to.get(0).equals("RESW"))
              {
                  int k=Integer.parseInt(to.get(1),16);
                  loc+=3*k;
                  loc_h=Integer.toHexString(loc);
              }
              else if(to.get(0).equals("RESB"))
              {
                  int l=Integer.parseInt(to.get(1),16);
                  loc+=l;
                  loc_h=Integer.toHexString(loc);
              }
              else if(to.get(0).equals("BYTE"))
              {
                  loc+=1;
                  loc_h=Integer.toHexString(loc);
              }
              else
              {
                  loc+=3;
                  loc_h=Integer.toHexString(loc);
              }
               String li=opcode+" "+to.get(1);
               
              if(!li.contains("null")){
                    bw.write(li);
                    bw.newLine();
                }
               
           }
            to.clear();
            
            
            
        }
        System.out.println("");
        br.close();
        bw.close();
        
        //System.out.println(sym);
    }
    

}
