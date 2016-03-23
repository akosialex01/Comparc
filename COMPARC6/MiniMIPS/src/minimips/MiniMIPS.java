package minimips;

public class MiniMIPS 
{
    public String code = "";
    
    public String getCode()
    {
        return this.code;
    }
    
    public void setCode(String code)
    {
        this.code = code;
    }
    
    public static void main(String[] args) 
    {
        MainFrameGUI startGUI = new MainFrameGUI();
        startGUI.setTitle("MiniMIPS");
        startGUI.setResizable(false);
        startGUI.setVisible(true);
        
    }
}
