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
public class Memory 
{
    private String memAddress = "";
    private String memValue = "";
    
    public Memory(String memAddress, String memValue)
    {
        this.memAddress = memAddress;
        this.memValue = memValue;
    }
    
    public String getMemAddress()
    {
        return this.memAddress;
    }
    
    public String getMemValue()
    {
        return this.memValue;
    }
    
    public void setMemValue(String memValue)
    {
        this.memValue = memValue;
    }
}
