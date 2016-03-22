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
public class Register 
{
    private int regNum = 0;
    private String regValue = "";
    
    public Register(int regNum, String regValue)
    {
        this.regNum = regNum;
        this.regValue = regValue;
    }
    
    public int getRegNum()
    {
        return this.regNum;
    }
    
    public void setRegNum(int regNum)
    {
        this.regNum = regNum;
    }
    
    public String getRegValue()
    {
        return this.regValue;
    }
    
    public void setRegValue(String regValue)
    {
        this.regValue = regValue;
    }
}
