/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assembler;

import java.util.HashMap;

/**
 *
 * @author ANURAG
 */
public class opcode {
    public HashMap<String, String> hr = new HashMap<String, String>();
    public void opcode(){
        hr.put("ADD","18");
       hr.put("AND","40");
       hr.put("COMP","28");
       hr.put("DIV","24");
       hr.put("J", "3C");
       hr.put("JLT", "38");
       hr.put("JSUB","48");
       hr.put("JGT","34");
       hr.put("LDA", "00");
       hr.put("LDCH", "50");
       hr.put("LDL", "08");
       hr.put("LDX", "04");
       hr.put("MUL", "20");
       hr.put("OR", "44");
       hr.put("RD", "D8");
       hr.put("RSUB", "4C");
       hr.put("STA", "0C");
       hr.put("STCH", "54");
       hr.put("STL", "14");
       hr.put("STSW", "E8");
       hr.put("STX", "10");
       hr.put("SUB", "1C");
       hr.put("TD", "E0");
       hr.put("TIX", "2C");
       hr.put("WD", "DC");
    }
    
}
