/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minimips;

/**
 *
 * @author ALEX
 */
public class Instruction 
{
    private String opInst = "";
    private String RD = "";
    private String RS = "";
    private String RT = "";
    private String opcodeBinary = "";
    private String opcodeHex = "";
    
    public Instruction(String opInst, String RD, String RS, String RT, String opcodeBinary, String opcodeHex)
    {
        this.opInst = opInst;
        this.RD = RD;
        this.RS = RS;
        this.RT = RT;
        this.opcodeBinary = opcodeBinary;
        this.opcodeHex = opcodeHex;
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
    
    public void setRD(String RD)
    {
        this.RD = RD;
    }
    
    public String getRS()
    {
        return this.RS;
    }
    
    public void setRS(String RS)
    {
        this.RS = RS;
    }
    
    public String getRT()
    {
        return this.RT;
    }
    
    public void setRT(String RT)
    {
        this.RT = RT;
    }
    
    public String getOpcodeBinary()
    {
        return this.opcodeBinary;
    }
    
    public void setOpcodeBinary(String opcodeBinary)
    {
        this.opcodeBinary = opcodeBinary;
    }
    
    public String getOpcodeHex()
    {
        return this.opcodeHex;
    }
    
    public void setOpcodeHex(String opcodeHex)
    {
        this.opcodeHex = opcodeHex;
    }
}
