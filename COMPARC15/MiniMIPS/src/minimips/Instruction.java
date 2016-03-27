/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minimips;

/**
 *
 * @author Dreyasaur
 */

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Instruction 
{
    private String PC = "";
    private String label = "";
    private String opInst = "";
    private String RD = "";
    private String RS = "";
    private String RT = "";
    private String opcodeHex = "";
    
    public Instruction(String PC, String opcodeHex, String label, String opInst, String RD, String RS, String RT)
    {
        this.PC = PC;
        this.opcodeHex = opcodeHex;
        this.label = label;
        this.opInst = opInst;
        this.RD = RD;
        this.RS = RS;
        this.RT = RT;
    }
    
    public String getPC()
    {
        return this.PC;
    }
    
    public void setPC()
    {
        this.PC = PC;
    }
    
    public String getOpcodeHex()
    {
        return this.opcodeHex;
    }
    
    public void setOpcodeHex(String opcodeHex)
    {
        this.opcodeHex = opcodeHex;
    }
    
    public String getLabel()
    {
        return this.label;
    }
    
    public void setLabel()
    {
        this.label = label;
    }
    
    public String getOpInst()
    {
        return this.opInst;
    }
    
    public void setOpInst(String opInst)
    {
        this.opInst = opInst;
    }
    
    public String getRD()
    {
        return this.RD;
    }
    
    public void setRD(String rd)
    {
        this.RD = rd;
    }
    
    public String getRS()
    {
        return this.RS;
    }
    
    public void setRS(String rs)
    {
        this.RS = rs;
    }
    
    public String getRT()
    {
        return this.RT;
    }
    
    public void setRT(String rt)
    {
        this.RT = rt;
    }
}
