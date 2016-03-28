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
public class Cycles 
{
    /*Cycle 1*/
    private String IFID_IR = "";
    private String IFID_NPC = "";
    private String IFID_PC = "";
    private boolean IF = false;
    private int IFinstNum = 0;
    private String IF_IR = "";
    private String IF_NPC = "";
    
    /*Cycle 2*/
    private String IDEX_A = "";
    private String IDEX_B = "";
    private String IDEX_IMM = "";
    private String IDEX_IR = "";
    private String IDEX_NPC = "";
    private boolean ID = false;
    private int IDinstNum = 0;
    
    /*Cycle 3*/
    private String EXMEM_ALUOUTPUT = "";
    private String EXMEM_COND = "";
    private String EXMEM_IR = "";
    private String EXMEM_B = "";
    private String EXMEM_OPCODE = "";
    private boolean EX = false;
    private int EXinstNum = 0;
    
    /*Cycle 4*/
    private String MEMWB_LMD = "";
    private String MEMWB_IR = "";
    private String MEMWB_ALUOUTPUT = "";
    private boolean MEM = false;
    private int MEMinstNum = 0;
    private String MEMWB_RANGE = "";
    
    /*Cycle 5*/
    private String WB_RN = "";
    private boolean WB = false;
    private int WBinstNum = 0;
    
    private boolean IFstall =false;
    private boolean IDstall = false;
    private boolean EXstall = false;
    private boolean MEMstall = false;
    private boolean WBstall = false;
    
    private boolean dHazard = false;
    private boolean cHazard = false;
    
    
    
  /*  public Cycles(String IDEX_A,String IDEX_B, String IDEX_IMM, String IDEX_IR, 
                  String EXMEM_ALUOUTPUT, String EXMEM_COND, String EXMEM_IR, String EXMEM_B,
                  String MEMWB_LMD, String MEMWB_IR, String MEMWB_ALUOUTPUT, String WB_RN)
    {
        this.IDEX_A = IDEX_A;
        this.IDEX_B = IDEX_B;
        this.IDEX_IMM = IDEX_IMM;
        this.IDEX_IR = IDEX_IR;
        
        this.EXMEM_ALUOUTPUT = EXMEM_ALUOUTPUT;
        this.EXMEM_COND = EXMEM_COND;
        this.EXMEM_IR = EXMEM_IR;
        this.EXMEM_B = EXMEM_B;
        
        this.MEMWB_LMD = MEMWB_LMD;
        this.MEMWB_IR = MEMWB_IR;
        this.MEMWB_ALUOUTPUT = MEMWB_ALUOUTPUT;
        
        this.WB_RN = WB_RN;
        
    }
    */
    
    
    
    /*Cycle 1*/
    public String getIFID_PC()
    {
        return this.IFID_PC;
    }
    
    public void setIFID_PC(String IFID_PC)
    {
        this.IFID_PC = IFID_PC;
        
    }
            
    public String getIF_IR()
    {
        return this.IF_IR;
    }
    public void setIF_IR(String IF_IR)
    {
        this.IF_IR = IF_IR;
        
    }
    public String getIF_NPC()
    {
        return this.IF_NPC;
    }
    public void setIF_NPC(String IF_NPC)
    {
        this.IF_NPC = IF_NPC;
        
    }
    
    
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
    
    public String getIDEX_IMM()
    {
        return this.IDEX_IMM;
    }
    
    public void setIDEX_IMM(String IDEX_IMM)
    {
        this.IDEX_IMM = IDEX_IMM;
    }
    
    public String getIDEX_NPC()
    {
        return this.IDEX_NPC;
        
    }
    
    public void setIDEX_NPC(String IDEX_NPC)
    {
        this.IDEX_NPC = IDEX_NPC;
    }
    
    public String getIDEX_IR()
    {
        return this.IDEX_IR;
        
    }
    
    public void setIDEX_IR(String IDEX_IR)
    {
        this.IDEX_IR = IDEX_IR;
    }
    
    
    /*Cycle 3*/
    public String getEXMEM_ALU()
    {
        return this.EXMEM_ALUOUTPUT;
    }
    
    public void setEXMEM_ALU(String EXMEM_ALUOUTPUT)
    {
        this.EXMEM_ALUOUTPUT = EXMEM_ALUOUTPUT;
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
    
    public void setEXMEM_OPCODE(String EXMEM_OPCODE)
    {
        this.EXMEM_OPCODE = EXMEM_OPCODE;
    }
    
    public String getEXMEM_OPCODE()
    {
        return this.EXMEM_OPCODE;
    }
    
    /*Cycle 4*/
    public void setMEMWB_RANGE(String MEMWB_RANGE)
    {
        this.MEMWB_RANGE = MEMWB_RANGE;
        
    }
    
    public String getMEMWB_RANGE()
    {
        return this.MEMWB_RANGE;
        
    }
    
    public String getMEMWB_LMD()
    {
        return this.MEMWB_LMD;
    }
    
    public void setMEMWB_LMD(String MEMWB_LMD)
    {
        this.MEMWB_LMD = MEMWB_LMD;
    }
    
    public String getMEMWB_IR()
    {
        return this.MEMWB_IR;
    }
    
    public String getMEMWB_ALUOUTPUT()
    {
        return this.MEMWB_ALUOUTPUT;
    }
    
    public void setMEMWB_IR(String MEMWB_IR)
    {
        this.MEMWB_IR = MEMWB_IR;
    }
    
    public void setMEMWB_ALUOUTPUT(String MEMWB_ALUOUTPUT)
    {
        this.MEMWB_ALUOUTPUT = MEMWB_ALUOUTPUT;
    }
    
    /*Cyle 5*/
    public String getWB_RN()
    {
        return this.WB_RN;
    }
    
    public void setWB_RN(String WB_RN)
    {
        this.WB_RN = WB_RN;
    }

    public void setIF(boolean IF)
    {
        this.IF = IF;   
    }

    public void setID(boolean ID)
    {
        this.ID = ID;   
    }
    
    public void setEX(boolean EX)
    {
        this.EX = EX;   
    }
    
    public void setMEM(boolean MEM)
    {
        this.MEM = MEM;   
    }
    
    public void setWB(boolean WB)
    {
        this.WB = WB;   
    }
    
    public boolean getIF()
    {
        return this.IF;   
    }
    public boolean getID()
    {
        return this.ID;   
    }
    public boolean getEX()
    {
        return this.EX;   
    }
    public boolean getMEM()
    {
        return this.MEM;   
    }
    public boolean getWB()
    {
        return this.WB;   
    }
    
    public void setIFInstNum(int instNum)
    {
        this.IFinstNum = instNum;
    }
    public int getIFInstNum()
    {
        return this.IFinstNum;
        
    }
    
    public void setIDInstNum(int instNum)
    {
        this.IDinstNum = instNum;
    }
    public int getIDInstNum()
    {
        return this.IDinstNum;
        
    }
    
    public void setEXInstNum(int instNum)
    {
        this.EXinstNum = instNum;
    }
    public int getEXInstNum()
    {
        return this.EXinstNum;
        
    }
    
    public void setMEMInstNum(int instNum)
    {
        this.MEMinstNum = instNum;
    }
    public int getMEMInstNum()
    {
        return this.MEMinstNum;
        
    }
    
    public void setWBInstNum(int instNum)
    {
        this.WBinstNum = instNum;
    }
    public int getWBInstNum()
    {
        return this.WBinstNum;
        
    }
    
    public void setIFstall(boolean IFstall)
    {
        this.IFstall = IFstall;
    }
    
    public void setIDstall(boolean IDstall)
    {
        this.IDstall = IDstall;
    }
    public void setEXstall(boolean EXstall)
    {
        this.EXstall = EXstall;
    }
    public void setMEMstall(boolean MEMstall)
    {
        this.MEMstall = MEMstall;
    }
    public void setWBstall(boolean WBstall)
    {
        this.WBstall = WBstall;
    }
    
    public boolean getIFstall()
    {
        return this.IFstall;
    }
    
    public boolean getIDstall()
    {
        return this.IDstall;
    }
    public boolean getEXstall()
    {
        return this.EXstall;
    }
    public boolean getMEMstall()
    {
        return this.MEMstall;
    }
    public boolean getWBstall()
    {
        return this.WBstall;
    }
    
    public boolean getdHazard()
    {
        return this.dHazard;
    }
    
    public void setdHazard(boolean dHazard)
    {
        this.dHazard = dHazard;
    }
    
    public boolean getcHazard()
    {
        return this.cHazard;
    }
    
    public void setcHazard(boolean cHazard)
    {
        this.cHazard = cHazard;
    }
    
}
