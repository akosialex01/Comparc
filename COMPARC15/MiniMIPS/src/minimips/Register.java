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
public class Register 
{
    private String regNum = "";
    private String regValue = "";
    
    public Register(String regNum, String regValue)
    {
        this.regNum = regNum;
        this.regValue = regValue;
    }
    
    public String getRegNum()
    {
        return this.regNum;
    }
    
    public void setRegNum(String regNum)
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
