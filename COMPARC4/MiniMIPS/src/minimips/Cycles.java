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
public class Cycles 
{
    /*Cycle 1*/
    private String IFID_IR = "";
    private String IFID_NPC = "";
    
    /*Cycle 2*/
    private String IDEX_A = "";
    private String IDEX_B = "";
    private String IDEX_Imm = "";
    private String IDEX_IR = "";
    
    /*Cycle 3*/
    private String EXMEM_ALUOutput = "";
    private String EXMEM_COND = "";
    private String EXMEM_IR = "";
    private String EXMEM_B = "";
    
    /*Cycle 4*/
    private String MEMWB_LMD = "";
    private String MEMWB_IR = "";
    private String MEMWB_ALUOutput = "";
    
    /*Cycle 5*/
    private String WB_Rn = "";
    
    
    /*Cycle 1*/
    public String getIFID_IR()
    {
        return this.IFID_IR;
    }
    
    public void setIFID_IR(String IFID_IR)
    {
        this.IFID_IR = IFID_IR;
    }
 
    public String getIFID_NPC()
    {
        return this.IFID_NPC;
    }
    
    public void setIFID_NPC(String IFID_NPC)
    {
        this.IFID_NPC = IFID_NPC;
    }
    
    /*Cycle 2*/
    public String getIDEX_A()
    {
        return this.IDEX_A;
    }
    
    public void setIDEX_A(String IDEX_A)
    {
        this.IDEX_A = IDEX_A;
    }
    
    public String getIDEX_B()
    {
        return this.IDEX_B;
    }
    
    public void setIDEX_B(String IDEX_B)
    {
        this.IDEX_B = IDEX_B;
    }
    
    public String getIDEX_Imm()
    {
        return this.IDEX_Imm;
    }
    
    public void setIDEX_Imm(String IDEX_Imm)
    {
        this.IDEX_Imm = IDEX_Imm;
    }
    
    /*Cycle 3*/
    public String getEXMEM_ALU()
    {
        return this.EXMEM_ALUOutput;
    }
    
    public void setEXMEM_ALU(String EXMEM_ALUOutput)
    {
        this.EXMEM_ALUOutput = EXMEM_ALUOutput;
    }
    
    public String getEXMEM_COND()
    {
        return this.EXMEM_COND;
    }
    
    public void setEXMEM_COND(String EXMEM_COND)
    {
        this.EXMEM_COND = EXMEM_COND;
    }
    
    public String getEXMEM_IR()
    {
        return this.EXMEM_IR;
    }
    
    public void setEXMEM_IR(String EXMEM_IR)
    {
        this.EXMEM_IR = EXMEM_IR;
    }
    
    public String getEXMEM_B()
    {
        return this.EXMEM_B;
    }
    
    public void setEXMEM_B(String EXMEM_B)
    {
        this.EXMEM_B = EXMEM_B;
    }
    
    /*Cycle 4*/
    public String getMEMWB_LMD()
    {
        return this.MEMWB_LMD;
    }
    
    public void setMEMWB_LMD(String MEMWB_LMD)
    {
        this.MEMWB_LMD = MEMWB_LMD;
    }
}
