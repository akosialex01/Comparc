/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minimips;

import java.util.ArrayList;

/**
 *
 * @author Dreyasaur
 */

public class MainFrameGUI extends javax.swing.JFrame 
{
    private ArrayList<String> labels;
    private ArrayList<String> errorList;
    private ArrayList<String> tempLabels;
    private String codeSegment = "";
    private String codeLine = "";
    private String opcodeBinary = "";
    private String opcodeHex = "";
    private String regTemp = "";
    private String rd = "";
    private String rs = "";
    private String rt = "";
    private String Imm = "";
    private String base = "";
    private String offset = "";
    private int lineNumber = 1;
    private int regNum;
 
    
    private boolean lineValid = true;
    private boolean labelValid = true;
    private boolean ImmValid = true;
    private boolean offsetValid = true;
    
    
    
    public MainFrameGUI() 
    {
        initComponents();
        
        opcodeTxtArea.setEditable(false);
        labels = new ArrayList<String>();
        errorList = new ArrayList<String>();
        tempLabels = new ArrayList<String>();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        runPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        codeTxtArea = new javax.swing.JTextArea();
        runBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        opcodeTxtArea = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        registerTbl = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        memTbl = new javax.swing.JTable();
        pipelinePanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Code Segment"));

        codeTxtArea.setColumns(20);
        codeTxtArea.setRows(5);
        jScrollPane3.setViewportView(codeTxtArea);

        runBtn.setText("Run");
        runBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runBtnActionPerformed(evt);
            }
        });

        clearBtn.setText("Clear");
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(runBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(clearBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(runBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(clearBtn)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Opcode"));

        opcodeTxtArea.setColumns(20);
        opcodeTxtArea.setRows(5);
        jScrollPane4.setViewportView(opcodeTxtArea);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Register"));

        registerTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"R0", "0000000000000000"},
                {"R1", "0000000000000000"},
                {"R2", "0000000000000000"},
                {"R3", "0000000000000000"},
                {"R4", "0000000000000000"},
                {"R5", "0000000000000000"},
                {"R6", "0000000000000000"},
                {"R7", "0000000000000000"},
                {"R8", "0000000000000000"},
                {"R9", "0000000000000000"},
                {"R10", "0000000000000000"},
                {"R11", "0000000000000000"},
                {"R12", "0000000000000000"},
                {"R13", "0000000000000000"},
                {"R14", "0000000000000000"},
                {"R15", "0000000000000000"},
                {"R16", "0000000000000000"},
                {"R17", "0000000000000000"},
                {"R18", "0000000000000000"},
                {"R19", "0000000000000000"},
                {"R20", "0000000000000000"},
                {"R21", "0000000000000000"},
                {"R22", "0000000000000000"},
                {"R23", "0000000000000000"},
                {"R24", "0000000000000000"},
                {"R25", "0000000000000000"},
                {"R26", "0000000000000000"},
                {"R27", "0000000000000000"},
                {"R28", "0000000000000000"},
                {"R29", "0000000000000000"},
                {"R30", "0000000000000000"},
                {"R31", "0000000000000000"}
            },
            new String [] {
                "Register", "Value"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(registerTbl);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Memory"));

        memTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Memory", "Value"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(memTbl);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(233, 233, 233))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout runPanelLayout = new javax.swing.GroupLayout(runPanel);
        runPanel.setLayout(runPanelLayout);
        runPanelLayout.setHorizontalGroup(
            runPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(runPanelLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(runPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(runPanelLayout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        runPanelLayout.setVerticalGroup(
            runPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(runPanelLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(runPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab1", runPanel);

        javax.swing.GroupLayout pipelinePanelLayout = new javax.swing.GroupLayout(pipelinePanel);
        pipelinePanel.setLayout(pipelinePanelLayout);
        pipelinePanelLayout.setHorizontalGroup(
            pipelinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 804, Short.MAX_VALUE)
        );
        pipelinePanelLayout.setVerticalGroup(
            pipelinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 505, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab2", pipelinePanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public String splitInst(String codeCheck)
    {
        String str4[] = codeCheck.split(" "); /*Splits the one-line code by space*/
        /*Prints the content of every index in array str4[]*/
       
      /*  System.out.println("\nThis is the one-line code after splitting by space: ");
        for(int f = 0; f < str4.length; f++)
        {
            System.out.println(str4[f]);
        }*/ 

        /*If str4 is "DADDU" and "R1,R2,R3"*/
        if(str4.length == 2 && !(str4[0].contentEquals("BC")))
        {
            String str5[] = str4[1].split(",");
            
            for(int g = 0; g < str5.length; g++)
            {
                if(g == 0)
                {
                    rd = "";
                    rd = rd.concat(str5[g]);
                }
                
                else if(g == 1)
                {
                    rs = "";
                    rs = rs.concat(str5[g]);
                }
                
                else if(g == 2)
                {
                    rt = "";
                    rt = rt.concat(str5[g]);
                }
            }
        }
        
        /*If str4 is "DADDU" and "R1,", and "R2," and "R3"*/
        else if(str4.length == 4 && !(str4[0].contentEquals("BC")))
        {
            String str6[] = str4[1].split(",");
            rd = "";
            rd = rd.concat(str6[0]);
            
            str6 = str4[2].split(",");
            rs = "";
            rs = rs.concat(str6[0]);
            
            str6 = str4[3].split(",");
            rt = "";
            rt = rt.concat(str6[0]);
        }

        /*System.out.println("RD: " + rd);
        System.out.println("RS: " + rs);
        System.out.println("RT: " + rt);
        */

        if(str4[0].contentEquals("SD") || str4[0].contentEquals("LD"))   
        {
          
          String str6[] = str4[3].split("\\(");
          String str7[] = str6[1].split("\\)");
           rt = "";
           rt = rt.concat(str7[0]);
            
        }
        
       /* System.out.println("RD: " + rd);
        System.out.println("RS: " + rs);
        System.out.println("RT: " + rt);
        */
       
       if(str4[0].contentEquals("BC"))
       {
           if(str4.length > 2)
           {
               offsetValid = false;
               
               
           }
          offset = "";
          offset = offset.concat(str4[1]);
           
       }
  
        return str4[0];
    }
    
     public void getLabels(String codeSegment)
    {
        String str1[] = codeSegment.split("\n");
        
        
        for(int i = 0; i < str1.length; i++)
        {
            
            String str2[] = str1[i].split(" ");
            
             if(str2[0].contains(":")) /*If instruction has a label*/
            {
                if(str2[0].length() > 1)
                {
                    String str3[] = str2[0].split(":"); /*Split label name and colon*/
                    tempLabels.add(str3[0]);
                }
            }
          
        }
     
    }
    public void checkLabel(String codeCheck)
    {
       //System.out.println("\nThe code is: " + codeCheck);
        
        String str2[] = codeCheck.split(" "); /*Splits the one-line code by space*/
        
        /*For example, codeCheck == L1: DADDU R1, R2, R3 after splitting by space,
          str2[] would have the values "L1:" and "DADDU" and "R1," and "R2," and "R3"*/
        
        if(str2[0].contains(":")) /*If instruction has a label*/
        {
            //System.out.println("This instruction has a label: " + codeCheck);
            
            /*For example, label name == L1: after splitting by colon,
              str3[] would have the value "L1" only without the colon*/
            
            /*Stores the label name in the array labels[]
              For example, stores "L1" into labels[0]*/

                
                if(!str2[0].matches("^[a-zA-Z]+[0-9]*[a-zA-Z]*[:]$"))
                {
                
                labelValid = false;
               
                }
             if (str2[0].length() > 1 )
             {
                 String str3[] = str2[0].split(":");
             
             
             if(labels.contains(str3[0]))
             {
                 labelValid = false;
                 
             }
             }
           if(labelValid && str2[0].length() > 1 )
           {
             String str3[] = str2[0].split(":"); /*Split label name and colon*/
                labels.add(str3[0]);
            
                 for(int e = 1; e < str2.length; e++)
                {
                    codeLine = codeLine.concat(str2[e]); /*Store the instruction without the label name*/
                    codeLine = codeLine.concat(" ");
                }
            
               // System.out.println("The instruction without label name is: " + codeLine);
                this.checkFirst(codeLine);
           }
           else if(!labelValid)
           {
                //String str3[] = str2[0].split(":"); /*Split label name and colon*/
               for(int e = 1; e < str2.length; e++)
                {
                    codeLine = codeLine.concat(str2[e]); /*Store the instruction without the label name*/
                    codeLine = codeLine.concat(" ");
                }
            
               // System.out.println("The instruction without label name is: " + codeLine);
                this.checkFirst(codeLine);
               
           }
           
        }
        
        else this.checkFirst(codeCheck);
    }
    
    public void checkRegister(String rd, String rs, String rt)
    {
        /*Check if registers is R1, R2, R3 not A1, B2, C3 or any other letter*/
        if(rd.charAt(0) == 82) /*82 is ASCII for 'R'*/
        {
            if(rs.charAt(0) == 82)
            {
                if(rt.charAt(0) == 82)
                {
                    String temp[] = rt.split("R");
                    
                        if(Integer.parseInt(temp[1]) < 0 || Integer.parseInt(temp[1]) > 32)
                        {
                            lineValid = false;
                            
                        }            
                }
                     
                else lineValid = false;
                
            String temp[] = rs.split("R");
            
                if(Integer.parseInt(temp[1]) < 0 || Integer.parseInt(temp[1]) > 32)
                {  
                    lineValid = false;         
                }   
            }
                    
            else lineValid = false;
            
        String temp[] = rd.split("R");
        
            if(Integer.parseInt(temp[1]) < 0 || Integer.parseInt(temp[1]) > 32)
            { 
                lineValid = false;              
            }
        }       
        else lineValid = false;
           
    }
    
    public void checkImm(String rd, String rs, String rt)
    {
        if(rd.charAt(0) == 82)
        {
            if(rs.charAt(0) == 82)
            {
                if(rt.matches("^#[0-9]{1,4}"))
                {
                    //System.out.println("Instruction is valid!");
                    ImmValid = true;
                }
                
                else ImmValid = false; 
                    //System.out.println("Instruction is invalid!");
              
                String temp[] = rs.split("R");
            
                if(Integer.parseInt(temp[1]) < 0 || Integer.parseInt(temp[1]) > 32)
                {  
                    lineValid = false;         
                }      
                    
            }
            
            else lineValid = false;
            
            String temp[] = rd.split("R");
            
                if(Integer.parseInt(temp[1]) < 0 || Integer.parseInt(temp[1]) > 32)
                {  
                    lineValid = false;         
                }
        }
        
        else lineValid = false;
    }
    
    public void checkOffset(String rd, String rs, String rt)//FOR SD AND LD
    {
      if(rd.charAt(0) == 82)
      {
            if(rs.matches("^[2-3]+[0-9A-aF-f]{3}") && rs.length() == 4)
            {
              if(rt.charAt(0) == 82)
              {
                  String temp[] = rt.split("R");
            
                if(Integer.parseInt(temp[1]) < 0 || Integer.parseInt(temp[1]) > 32)
                {  
                    lineValid = false;         
                }      
                  
              }
              else lineValid = false;
                
            } 
            else offsetValid = false;
            
            String temp[] = rd.split("R");
            
                if(Integer.parseInt(temp[1]) < 0 || Integer.parseInt(temp[1]) > 32)
                {  
                    lineValid = false;         
                }   
            
       }  
      else lineValid = false;
    
    }

    public void checkBeqc(String rd, String rs, String rt)
    {
        if(rd.charAt(0) == 82)
        {
            if(rs.charAt(0) == 82)
            {
                
                if(!tempLabels.contains(rt))
                {
                    offsetValid = false;
                    
                }
                
                 String temp[] = rs.split("R");
            
                if(Integer.parseInt(temp[1]) < 0 || Integer.parseInt(temp[1]) > 32)
                {  
                    lineValid = false;         
                }      
                
            }
            else lineValid = false;
            
             String temp[] = rd.split("R");
            
                if(Integer.parseInt(temp[1]) < 0 || Integer.parseInt(temp[1]) > 32)
                {  
                    lineValid = false;         
                }  
            
        }
        else lineValid = false;
        
        
        
        
    }
    
    public void generateOpcode(String rd, String rs, String rt)
    {
        /*Generate opcode for rs*/
        String str5[] = rs.split("R");
        
        regTemp = "";
        regTemp = regTemp.concat(str5[1]);
        regNum = Integer.parseInt(regTemp);
        
        if(regNum >= 0 && regNum <= 31)
        {
            switch(regNum)
            {
                case 0:  opcodeBinary = opcodeBinary.concat(" 00000"); break;
                case 1:  opcodeBinary = opcodeBinary.concat(" 00001"); break;
                case 2:  opcodeBinary = opcodeBinary.concat(" 00010"); break;
                case 3:  opcodeBinary = opcodeBinary.concat(" 00011"); break;
                case 4:  opcodeBinary = opcodeBinary.concat(" 00100"); break;
                case 5:  opcodeBinary = opcodeBinary.concat(" 00101"); break;
                case 6:  opcodeBinary = opcodeBinary.concat(" 00110"); break;
                case 7:  opcodeBinary = opcodeBinary.concat(" 00111"); break;
                case 8:  opcodeBinary = opcodeBinary.concat(" 01000"); break;
                case 9:  opcodeBinary = opcodeBinary.concat(" 01001"); break;
                case 10: opcodeBinary = opcodeBinary.concat(" 01010"); break;
                case 11: opcodeBinary = opcodeBinary.concat(" 01011"); break;
                case 12: opcodeBinary = opcodeBinary.concat(" 01100"); break;
                case 13: opcodeBinary = opcodeBinary.concat(" 01101"); break;
                case 14: opcodeBinary = opcodeBinary.concat(" 01110"); break;
                case 15: opcodeBinary = opcodeBinary.concat(" 01111"); break;
                case 16: opcodeBinary = opcodeBinary.concat(" 10000"); break;
                case 17: opcodeBinary = opcodeBinary.concat(" 10001"); break;
                case 18: opcodeBinary = opcodeBinary.concat(" 10010"); break;
                case 19: opcodeBinary = opcodeBinary.concat(" 10011"); break;
                case 20: opcodeBinary = opcodeBinary.concat(" 10100"); break;
                case 21: opcodeBinary = opcodeBinary.concat(" 10101"); break;
                case 22: opcodeBinary = opcodeBinary.concat(" 10110"); break;
                case 23: opcodeBinary = opcodeBinary.concat(" 10111"); break;
                case 24: opcodeBinary = opcodeBinary.concat(" 11000"); break;
                case 25: opcodeBinary = opcodeBinary.concat(" 11001"); break;
                case 26: opcodeBinary = opcodeBinary.concat(" 11010"); break;
                case 27: opcodeBinary = opcodeBinary.concat(" 11011"); break;
                case 28: opcodeBinary = opcodeBinary.concat(" 11100"); break;
                case 29: opcodeBinary = opcodeBinary.concat(" 11101"); break;
                case 30: opcodeBinary = opcodeBinary.concat(" 11110"); break;
                case 31: opcodeBinary = opcodeBinary.concat(" 11111"); break;
            }
        }
        
        else 
        {
            System.out.println("Instruction is invalid!");
            lineValid = false;
        }
        
        /*Generate opcode for rt*/
        String str6[] = rt.split("R");
        
        regTemp = "";
        regTemp = regTemp.concat(str6[1]);
        regNum = Integer.parseInt(regTemp);
        
        if(regNum >= 0 && regNum <= 31)
        {
            switch(regNum)
            {
                case 0:  opcodeBinary = opcodeBinary.concat(" 00000"); break;
                case 1:  opcodeBinary = opcodeBinary.concat(" 00001"); break;
                case 2:  opcodeBinary = opcodeBinary.concat(" 00010"); break;
                case 3:  opcodeBinary = opcodeBinary.concat(" 00011"); break;
                case 4:  opcodeBinary = opcodeBinary.concat(" 00100"); break;
                case 5:  opcodeBinary = opcodeBinary.concat(" 00101"); break;
                case 6:  opcodeBinary = opcodeBinary.concat(" 00110"); break;
                case 7:  opcodeBinary = opcodeBinary.concat(" 00111"); break;
                case 8:  opcodeBinary = opcodeBinary.concat(" 01000"); break;
                case 9:  opcodeBinary = opcodeBinary.concat(" 01001"); break;
                case 10: opcodeBinary = opcodeBinary.concat(" 01010"); break;
                case 11: opcodeBinary = opcodeBinary.concat(" 01011"); break;
                case 12: opcodeBinary = opcodeBinary.concat(" 01100"); break;
                case 13: opcodeBinary = opcodeBinary.concat(" 01101"); break;
                case 14: opcodeBinary = opcodeBinary.concat(" 01110"); break;
                case 15: opcodeBinary = opcodeBinary.concat(" 01111"); break;
                case 16: opcodeBinary = opcodeBinary.concat(" 10000"); break;
                case 17: opcodeBinary = opcodeBinary.concat(" 10001"); break;
                case 18: opcodeBinary = opcodeBinary.concat(" 10010"); break;
                case 19: opcodeBinary = opcodeBinary.concat(" 10011"); break;
                case 20: opcodeBinary = opcodeBinary.concat(" 10100"); break;
                case 21: opcodeBinary = opcodeBinary.concat(" 10101"); break;
                case 22: opcodeBinary = opcodeBinary.concat(" 10110"); break;
                case 23: opcodeBinary = opcodeBinary.concat(" 10111"); break;
                case 24: opcodeBinary = opcodeBinary.concat(" 11000"); break;
                case 25: opcodeBinary = opcodeBinary.concat(" 11001"); break;
                case 26: opcodeBinary = opcodeBinary.concat(" 11010"); break;
                case 27: opcodeBinary = opcodeBinary.concat(" 11011"); break;
                case 28: opcodeBinary = opcodeBinary.concat(" 11100"); break;
                case 29: opcodeBinary = opcodeBinary.concat(" 11101"); break;
                case 30: opcodeBinary = opcodeBinary.concat(" 11110"); break;
                case 31: opcodeBinary = opcodeBinary.concat(" 11111"); break;
            }
        }
        
        else
        {
            System.out.println("Instruction is invalid!");
            lineValid = false;
        }
        
        /*Generate opcode for rd*/
        String str7[] = rd.split("R");
        
        regTemp = "";
        regTemp = regTemp.concat(str7[1]);
        regNum = Integer.parseInt(regTemp);
        
        if(regNum >= 0 && regNum <= 31)
        {
            switch(regNum)
            {
                case 0:  opcodeBinary = opcodeBinary.concat(" 00000"); break;
                case 1:  opcodeBinary = opcodeBinary.concat(" 00001"); break;
                case 2:  opcodeBinary = opcodeBinary.concat(" 00010"); break;
                case 3:  opcodeBinary = opcodeBinary.concat(" 00011"); break;
                case 4:  opcodeBinary = opcodeBinary.concat(" 00100"); break;
                case 5:  opcodeBinary = opcodeBinary.concat(" 00101"); break;
                case 6:  opcodeBinary = opcodeBinary.concat(" 00110"); break;
                case 7:  opcodeBinary = opcodeBinary.concat(" 00111"); break;
                case 8:  opcodeBinary = opcodeBinary.concat(" 01000"); break;
                case 9:  opcodeBinary = opcodeBinary.concat(" 01001"); break;
                case 10: opcodeBinary = opcodeBinary.concat(" 01010"); break;
                case 11: opcodeBinary = opcodeBinary.concat(" 01011"); break;
                case 12: opcodeBinary = opcodeBinary.concat(" 01100"); break;
                case 13: opcodeBinary = opcodeBinary.concat(" 01101"); break;
                case 14: opcodeBinary = opcodeBinary.concat(" 01110"); break;
                case 15: opcodeBinary = opcodeBinary.concat(" 01111"); break;
                case 16: opcodeBinary = opcodeBinary.concat(" 10000"); break;
                case 17: opcodeBinary = opcodeBinary.concat(" 10001"); break;
                case 18: opcodeBinary = opcodeBinary.concat(" 10010"); break;
                case 19: opcodeBinary = opcodeBinary.concat(" 10011"); break;
                case 20: opcodeBinary = opcodeBinary.concat(" 10100"); break;
                case 21: opcodeBinary = opcodeBinary.concat(" 10101"); break;
                case 22: opcodeBinary = opcodeBinary.concat(" 10110"); break;
                case 23: opcodeBinary = opcodeBinary.concat(" 10111"); break;
                case 24: opcodeBinary = opcodeBinary.concat(" 11000"); break;
                case 25: opcodeBinary = opcodeBinary.concat(" 11001"); break;
                case 26: opcodeBinary = opcodeBinary.concat(" 11010"); break;
                case 27: opcodeBinary = opcodeBinary.concat(" 11011"); break;
                case 28: opcodeBinary = opcodeBinary.concat(" 11100"); break;
                case 29: opcodeBinary = opcodeBinary.concat(" 11101"); break;
                case 30: opcodeBinary = opcodeBinary.concat(" 11110"); break;
                case 31: opcodeBinary = opcodeBinary.concat(" 11111"); break;
            }
        }
        
        else 
        {
            System.out.println("Instruction is invalid!");
            lineValid = false;
        } 
    }
    
    public void generateImm(String rd, String rs, String rt)
    {
        /*Generate opcode for rs*/
        String str5[] = rs.split("R");
        
        regTemp = "";
        regTemp = regTemp.concat(str5[1]);
        regNum = Integer.parseInt(regTemp);
        
        if(regNum >= 0 && regNum <= 31)
        {
            switch(regNum)
            {
                case 0:  opcodeBinary = opcodeBinary.concat(" 00000"); break;
                case 1:  opcodeBinary = opcodeBinary.concat(" 00001"); break;
                case 2:  opcodeBinary = opcodeBinary.concat(" 00010"); break;
                case 3:  opcodeBinary = opcodeBinary.concat(" 00011"); break;
                case 4:  opcodeBinary = opcodeBinary.concat(" 00100"); break;
                case 5:  opcodeBinary = opcodeBinary.concat(" 00101"); break;
                case 6:  opcodeBinary = opcodeBinary.concat(" 00110"); break;
                case 7:  opcodeBinary = opcodeBinary.concat(" 00111"); break;
                case 8:  opcodeBinary = opcodeBinary.concat(" 01000"); break;
                case 9:  opcodeBinary = opcodeBinary.concat(" 01001"); break;
                case 10: opcodeBinary = opcodeBinary.concat(" 01010"); break;
                case 11: opcodeBinary = opcodeBinary.concat(" 01011"); break;
                case 12: opcodeBinary = opcodeBinary.concat(" 01100"); break;
                case 13: opcodeBinary = opcodeBinary.concat(" 01101"); break;
                case 14: opcodeBinary = opcodeBinary.concat(" 01110"); break;
                case 15: opcodeBinary = opcodeBinary.concat(" 01111"); break;
                case 16: opcodeBinary = opcodeBinary.concat(" 10000"); break;
                case 17: opcodeBinary = opcodeBinary.concat(" 10001"); break;
                case 18: opcodeBinary = opcodeBinary.concat(" 10010"); break;
                case 19: opcodeBinary = opcodeBinary.concat(" 10011"); break;
                case 20: opcodeBinary = opcodeBinary.concat(" 10100"); break;
                case 21: opcodeBinary = opcodeBinary.concat(" 10101"); break;
                case 22: opcodeBinary = opcodeBinary.concat(" 10110"); break;
                case 23: opcodeBinary = opcodeBinary.concat(" 10111"); break;
                case 24: opcodeBinary = opcodeBinary.concat(" 11000"); break;
                case 25: opcodeBinary = opcodeBinary.concat(" 11001"); break;
                case 26: opcodeBinary = opcodeBinary.concat(" 11010"); break;
                case 27: opcodeBinary = opcodeBinary.concat(" 11011"); break;
                case 28: opcodeBinary = opcodeBinary.concat(" 11100"); break;
                case 29: opcodeBinary = opcodeBinary.concat(" 11101"); break;
                case 30: opcodeBinary = opcodeBinary.concat(" 11110"); break;
                case 31: opcodeBinary = opcodeBinary.concat(" 11111"); break;
            }
        }
        
        else 
        {
            System.out.println("Instruction is invalid!");
            lineValid = false;
        }
        
        /*Generate opcode for rd*/
        String str7[] = rd.split("R");
        
        regTemp = "";
        regTemp = regTemp.concat(str7[1]);
        regNum = Integer.parseInt(regTemp);
        
        if(regNum >= 0 && regNum <= 31)
        {
            switch(regNum)
            {
                case 0:  opcodeBinary = opcodeBinary.concat(" 00000"); break;
                case 1:  opcodeBinary = opcodeBinary.concat(" 00001"); break;
                case 2:  opcodeBinary = opcodeBinary.concat(" 00010"); break;
                case 3:  opcodeBinary = opcodeBinary.concat(" 00011"); break;
                case 4:  opcodeBinary = opcodeBinary.concat(" 00100"); break;
                case 5:  opcodeBinary = opcodeBinary.concat(" 00101"); break;
                case 6:  opcodeBinary = opcodeBinary.concat(" 00110"); break;
                case 7:  opcodeBinary = opcodeBinary.concat(" 00111"); break;
                case 8:  opcodeBinary = opcodeBinary.concat(" 01000"); break;
                case 9:  opcodeBinary = opcodeBinary.concat(" 01001"); break;
                case 10: opcodeBinary = opcodeBinary.concat(" 01010"); break;
                case 11: opcodeBinary = opcodeBinary.concat(" 01011"); break;
                case 12: opcodeBinary = opcodeBinary.concat(" 01100"); break;
                case 13: opcodeBinary = opcodeBinary.concat(" 01101"); break;
                case 14: opcodeBinary = opcodeBinary.concat(" 01110"); break;
                case 15: opcodeBinary = opcodeBinary.concat(" 01111"); break;
                case 16: opcodeBinary = opcodeBinary.concat(" 10000"); break;
                case 17: opcodeBinary = opcodeBinary.concat(" 10001"); break;
                case 18: opcodeBinary = opcodeBinary.concat(" 10010"); break;
                case 19: opcodeBinary = opcodeBinary.concat(" 10011"); break;
                case 20: opcodeBinary = opcodeBinary.concat(" 10100"); break;
                case 21: opcodeBinary = opcodeBinary.concat(" 10101"); break;
                case 22: opcodeBinary = opcodeBinary.concat(" 10110"); break;
                case 23: opcodeBinary = opcodeBinary.concat(" 10111"); break;
                case 24: opcodeBinary = opcodeBinary.concat(" 11000"); break;
                case 25: opcodeBinary = opcodeBinary.concat(" 11001"); break;
                case 26: opcodeBinary = opcodeBinary.concat(" 11010"); break;
                case 27: opcodeBinary = opcodeBinary.concat(" 11011"); break;
                case 28: opcodeBinary = opcodeBinary.concat(" 11100"); break;
                case 29: opcodeBinary = opcodeBinary.concat(" 11101"); break;
                case 30: opcodeBinary = opcodeBinary.concat(" 11110"); break;
                case 31: opcodeBinary = opcodeBinary.concat(" 11111"); break;
            }
        }
        
        else 
        {
            System.out.println("Instruction is invalid!");
            lineValid = false;
        } 
        
        /*Generate opcode for rt*/
        if(rt.length() == 5 && lineValid == true)
        {
            for(int i = 1; i < rt.length(); i++)
            {
                switch(rt.charAt(i))
                {
                    case '0': opcodeBinary = opcodeBinary.concat(" 0000"); break;
                    case '1': opcodeBinary = opcodeBinary.concat(" 0001"); break;
                    case '2': opcodeBinary = opcodeBinary.concat(" 0010"); break;
                    case '3': opcodeBinary = opcodeBinary.concat(" 0011"); break;
                    case '4': opcodeBinary = opcodeBinary.concat(" 0100"); break;
                    case '5': opcodeBinary = opcodeBinary.concat(" 0101"); break;
                    case '6': opcodeBinary = opcodeBinary.concat(" 0110"); break;
                    case '7': opcodeBinary = opcodeBinary.concat(" 0111"); break;
                    case '8': opcodeBinary = opcodeBinary.concat(" 1000"); break;
                    case '9': opcodeBinary = opcodeBinary.concat(" 1001"); break;
                    case 'A': opcodeBinary = opcodeBinary.concat(" 1010"); break;
                    case 'B': opcodeBinary = opcodeBinary.concat(" 1011"); break;
                    case 'C': opcodeBinary = opcodeBinary.concat(" 1100"); break;
                    case 'D': opcodeBinary = opcodeBinary.concat(" 1101"); break;
                    case 'E': opcodeBinary = opcodeBinary.concat(" 1110"); break;
                    case 'F': opcodeBinary = opcodeBinary.concat(" 1111"); break;
                }
            }
        }
        
        else
        {
            System.out.println("Instruction is invalid!");
            lineValid = false;
        }   
    }
    
    public void generateHex(String opcodeBinary)
    {
        String hexTemp = "";
        String temp1 = "";
        int j = 0;
        int k = 0;
        
        opcodeHex = "";
        
        for(int i = 0; i < opcodeBinary.length(); i++)
        {
            if(opcodeBinary.charAt(i) != 32)
            {
                hexTemp = hexTemp.concat(Character.toString(opcodeBinary.charAt(i)));
            }
        }
     
        while (j < 8)
        {
            temp1 = "";
            
            for(int i = 0; i < 4; i++)
            {
                temp1 = temp1.concat(Character.toString(hexTemp.charAt(k)));
                k++;
            }
            
            switch(temp1)
            {
                case "0000": opcodeHex = opcodeHex.concat("0"); break;
                case "0001": opcodeHex = opcodeHex.concat("1"); break;
                case "0010": opcodeHex = opcodeHex.concat("2"); break;
                case "0011": opcodeHex = opcodeHex.concat("3"); break;
                case "0100": opcodeHex = opcodeHex.concat("4"); break;
                case "0101": opcodeHex = opcodeHex.concat("5"); break;
                case "0110": opcodeHex = opcodeHex.concat("6"); break;
                case "0111": opcodeHex = opcodeHex.concat("7"); break;
                case "1000": opcodeHex = opcodeHex.concat("8"); break;
                case "1001": opcodeHex = opcodeHex.concat("9"); break;
                case "1010": opcodeHex = opcodeHex.concat("A"); break;
                case "1011": opcodeHex = opcodeHex.concat("B"); break;
                case "1100": opcodeHex = opcodeHex.concat("C"); break;
                case "1101": opcodeHex = opcodeHex.concat("D"); break;
                case "1110": opcodeHex = opcodeHex.concat("E"); break;
                case "1111": opcodeHex = opcodeHex.concat("F"); break;    
            }
            
            j++;
        }
    }
    
    public void generateOffset(String rd, String rs, String rt)
    {
        /*Generate opcode for base (RT) when instruction is LD or SD*/
        System.out.println(rt);
        
        String str8[] = rt.split("R");
        
        regTemp = "";
        regTemp = regTemp.concat(str8[1]);
        regNum = Integer.parseInt(regTemp);
        
        if(regNum >= 0 && regNum <= 31)
        {
            switch(regNum)
            {
                case 0:  opcodeBinary = opcodeBinary.concat(" 00000"); break;
                case 1:  opcodeBinary = opcodeBinary.concat(" 00001"); break;
                case 2:  opcodeBinary = opcodeBinary.concat(" 00010"); break;
                case 3:  opcodeBinary = opcodeBinary.concat(" 00011"); break;
                case 4:  opcodeBinary = opcodeBinary.concat(" 00100"); break;
                case 5:  opcodeBinary = opcodeBinary.concat(" 00101"); break;
                case 6:  opcodeBinary = opcodeBinary.concat(" 00110"); break;
                case 7:  opcodeBinary = opcodeBinary.concat(" 00111"); break;
                case 8:  opcodeBinary = opcodeBinary.concat(" 01000"); break;
                case 9:  opcodeBinary = opcodeBinary.concat(" 01001"); break;
                case 10: opcodeBinary = opcodeBinary.concat(" 01010"); break;
                case 11: opcodeBinary = opcodeBinary.concat(" 01011"); break;
                case 12: opcodeBinary = opcodeBinary.concat(" 01100"); break;
                case 13: opcodeBinary = opcodeBinary.concat(" 01101"); break;
                case 14: opcodeBinary = opcodeBinary.concat(" 01110"); break;
                case 15: opcodeBinary = opcodeBinary.concat(" 01111"); break;
                case 16: opcodeBinary = opcodeBinary.concat(" 10000"); break;
                case 17: opcodeBinary = opcodeBinary.concat(" 10001"); break;
                case 18: opcodeBinary = opcodeBinary.concat(" 10010"); break;
                case 19: opcodeBinary = opcodeBinary.concat(" 10011"); break;
                case 20: opcodeBinary = opcodeBinary.concat(" 10100"); break;
                case 21: opcodeBinary = opcodeBinary.concat(" 10101"); break;
                case 22: opcodeBinary = opcodeBinary.concat(" 10110"); break;
                case 23: opcodeBinary = opcodeBinary.concat(" 10111"); break;
                case 24: opcodeBinary = opcodeBinary.concat(" 11000"); break;
                case 25: opcodeBinary = opcodeBinary.concat(" 11001"); break;
                case 26: opcodeBinary = opcodeBinary.concat(" 11010"); break;
                case 27: opcodeBinary = opcodeBinary.concat(" 11011"); break;
                case 28: opcodeBinary = opcodeBinary.concat(" 11100"); break;
                case 29: opcodeBinary = opcodeBinary.concat(" 11101"); break;
                case 30: opcodeBinary = opcodeBinary.concat(" 11110"); break;
                case 31: opcodeBinary = opcodeBinary.concat(" 11111"); break;
            }
        }
        
        /*Generate opcode for RD when instruction is LD or SD*/
        System.out.println(rd);
        
        String str9[] = rd.split("R");
        
        regTemp = "";
        regTemp = regTemp.concat(str9[1]);
        regNum = Integer.parseInt(regTemp);
        
        if(regNum >= 0 && regNum <= 31)
        {
            switch(regNum)
            {
                case 0:  opcodeBinary = opcodeBinary.concat(" 00000"); break;
                case 1:  opcodeBinary = opcodeBinary.concat(" 00001"); break;
                case 2:  opcodeBinary = opcodeBinary.concat(" 00010"); break;
                case 3:  opcodeBinary = opcodeBinary.concat(" 00011"); break;
                case 4:  opcodeBinary = opcodeBinary.concat(" 00100"); break;
                case 5:  opcodeBinary = opcodeBinary.concat(" 00101"); break;
                case 6:  opcodeBinary = opcodeBinary.concat(" 00110"); break;
                case 7:  opcodeBinary = opcodeBinary.concat(" 00111"); break;
                case 8:  opcodeBinary = opcodeBinary.concat(" 01000"); break;
                case 9:  opcodeBinary = opcodeBinary.concat(" 01001"); break;
                case 10: opcodeBinary = opcodeBinary.concat(" 01010"); break;
                case 11: opcodeBinary = opcodeBinary.concat(" 01011"); break;
                case 12: opcodeBinary = opcodeBinary.concat(" 01100"); break;
                case 13: opcodeBinary = opcodeBinary.concat(" 01101"); break;
                case 14: opcodeBinary = opcodeBinary.concat(" 01110"); break;
                case 15: opcodeBinary = opcodeBinary.concat(" 01111"); break;
                case 16: opcodeBinary = opcodeBinary.concat(" 10000"); break;
                case 17: opcodeBinary = opcodeBinary.concat(" 10001"); break;
                case 18: opcodeBinary = opcodeBinary.concat(" 10010"); break;
                case 19: opcodeBinary = opcodeBinary.concat(" 10011"); break;
                case 20: opcodeBinary = opcodeBinary.concat(" 10100"); break;
                case 21: opcodeBinary = opcodeBinary.concat(" 10101"); break;
                case 22: opcodeBinary = opcodeBinary.concat(" 10110"); break;
                case 23: opcodeBinary = opcodeBinary.concat(" 10111"); break;
                case 24: opcodeBinary = opcodeBinary.concat(" 11000"); break;
                case 25: opcodeBinary = opcodeBinary.concat(" 11001"); break;
                case 26: opcodeBinary = opcodeBinary.concat(" 11010"); break;
                case 27: opcodeBinary = opcodeBinary.concat(" 11011"); break;
                case 28: opcodeBinary = opcodeBinary.concat(" 11100"); break;
                case 29: opcodeBinary = opcodeBinary.concat(" 11101"); break;
                case 30: opcodeBinary = opcodeBinary.concat(" 11110"); break;
                case 31: opcodeBinary = opcodeBinary.concat(" 11111"); break;
            }
        }
        
        /*Generate opcode for offset (RS) when LD or SD*/
        if(rs.length() == 4 && lineValid == true)
        {
            for(int i = 0; i < rs.length(); i++)
            {
                switch(rs.charAt(i))
                {
                    case '0': opcodeBinary = opcodeBinary.concat(" 0000"); break;
                    case '1': opcodeBinary = opcodeBinary.concat(" 0001"); break;
                    case '2': opcodeBinary = opcodeBinary.concat(" 0010"); break;
                    case '3': opcodeBinary = opcodeBinary.concat(" 0011"); break;
                    case '4': opcodeBinary = opcodeBinary.concat(" 0100"); break;
                    case '5': opcodeBinary = opcodeBinary.concat(" 0101"); break;
                    case '6': opcodeBinary = opcodeBinary.concat(" 0110"); break;
                    case '7': opcodeBinary = opcodeBinary.concat(" 0111"); break;
                    case '8': opcodeBinary = opcodeBinary.concat(" 1000"); break;
                    case '9': opcodeBinary = opcodeBinary.concat(" 1001"); break;
                    case 'A': opcodeBinary = opcodeBinary.concat(" 1010"); break;
                    case 'B': opcodeBinary = opcodeBinary.concat(" 1011"); break;
                    case 'C': opcodeBinary = opcodeBinary.concat(" 1100"); break;
                    case 'D': opcodeBinary = opcodeBinary.concat(" 1101"); break;
                    case 'E': opcodeBinary = opcodeBinary.concat(" 1110"); break;
                    case 'F': opcodeBinary = opcodeBinary.concat(" 1111"); break;
                }
            }
        }
    }

    public void checkFirst(String codeCheck)
    {

        if(codeCheck.length() == 0)
        {
            if(!labelValid)
            {
                errorList.add("Line Number " + lineNumber +": " + "Invalid Label.");
            
            }
        }
           
        else if(splitInst(codeCheck).equals("DADDU"))
        {
            this.checkRegister(rd, rs, rt);
            
            if(!labelValid)
            {
                errorList.add("Line Number " + lineNumber +": " + "Invalid Label.");
            
            }
            
            if (lineValid == false)
            {
                errorList.add("Line Number " + lineNumber +": " + "Invalid Register.");
               
            }
      
        }
        
        else if(splitInst(codeCheck).equals("DMULU"))
        {
            this.checkRegister(rd, rs, rt);
            
            if(!labelValid)
            {
                errorList.add("Line Number " + lineNumber +": " + "Invalid Label.");
            
            }
            
            if (lineValid == false)
            {
                errorList.add("Line Number " + lineNumber +": " + "Invalid Register.");
               
            }
           
        }
        
        else if(splitInst(codeCheck).equals("DMUHU"))
        {
            this.checkRegister(rd, rs, rt);
            
            if(!labelValid)
            {
                errorList.add("Line Number " + lineNumber +": " + "Invalid Label.");
            
            }
            
            if (lineValid == false)
            {
                errorList.add("Line Number " + lineNumber +": " + "Invalid Register.");
               
            }
       
        }
        
        else if(splitInst(codeCheck).equals("SLT"))
        {
            this.checkRegister(rd, rs, rt);
            
            if(!labelValid)
            {
                errorList.add("Line Number " + lineNumber +": " + "Invalid Label.");
            
            }
            
            if (lineValid == false)
            {
                errorList.add("Line Number " + lineNumber +": " + "Invalid Register.");
               
            }
        
        }
        
        else if(splitInst(codeCheck).equals("SELEQZ"))
        {
            this.checkRegister(rd, rs, rt);
            
            if(!labelValid)
            {
                errorList.add("Line Number " + lineNumber +": " + "Invalid Label.");
            
            }
            
            if (lineValid == false)
            {
                errorList.add("Line Number " + lineNumber +": " + "Invalid Register.");
               
            }
            
        }
        
        
        else if(splitInst(codeCheck).equals("DADDIU"))
        {
            Imm = rt;
            rt = rd;
            this.checkImm(rt, rs, Imm);
            
            if(!labelValid)
            {
                errorList.add("Line Number " + lineNumber +": " + "Invalid Label.");
            
            }
            
            if (lineValid == false)
            {
                errorList.add("Line Number " + lineNumber +": " + "Invalid Register.");
               
            }
            
            if(!ImmValid)
                errorList.add("Line Number " + lineNumber + ": " + "Invalid Immediate");
      
        }
        
        else if(splitInst(codeCheck).equals("LD"))
        {
            base = rt;
            rt = rd;
            offset =rs;
            this.checkOffset(rt, offset, base);
            
            if(!labelValid)
            {
                errorList.add("Line Number " + lineNumber +": " + "Invalid Label.");
            
            }
            
            if (lineValid == false)
            {
                errorList.add("Line Number " + lineNumber +": " + "Invalid Register.");
               
            }
            
            if(!offsetValid)
                errorList.add("Line Number " + lineNumber + ": " + "Invalid Offset");
      
        }
        
        else if(splitInst(codeCheck).equals("SD"))
        {
            base = rt;
            rt = rd;
            offset = rs;
            this.checkOffset(rt, offset, base);
            
            if(!labelValid)
            {
                errorList.add("Line Number " + lineNumber +": " + "Invalid Label.");
            
            }
            
            if (lineValid == false)
            {
                errorList.add("Line Number " + lineNumber +": " + "Invalid Register.");
               
            }
            
            if(!offsetValid)
                errorList.add("Line Number " + lineNumber + ": " + "Invalid Offset");
      
        }
        
        else if(splitInst(codeCheck).equals("BEQC"))
        {
            offset = rt;
            rt = rs;
            rs = rd;
            
            this.checkBeqc(rs, rt, offset);
            
            if(!labelValid)
            {
                errorList.add("Line Number " + lineNumber +": " + "Invalid Label.");
            
            }
            
            if (lineValid == false)
            {
                errorList.add("Line Number " + lineNumber +": " + "Invalid Register.");
               
            }
            
            if(!offsetValid)
                errorList.add("Line Number " + lineNumber + ": " + "Invalid Offset");
      
        }
        
        else if(splitInst(codeCheck).equals("BC"))
        {
            
            if(!tempLabels.contains(offset) || !offsetValid)
                errorList.add("Line Number " + lineNumber + ": " + "Invalid Offset");
            
            
        }
        
        else
            errorList.add("Line Number " + lineNumber +": "+ "Invalid Instruction.");
     
             
        lineNumber++;
        lineValid = true;
        labelValid = true;
        ImmValid = true;
        offsetValid = true;
        
    }
    
    public void errorCheck(String codeCheck)
    {   
        if(splitInst(codeCheck).equals("DADDU"))
        {
            System.out.println("Instruction is DADDU.");
            
            opcodeBinary = "";
            
            if(lineValid == true)
            {
                /*Generates the opcode*/
                opcodeBinary = opcodeBinary.concat("000000");
                
                this.generateOpcode(rd, rs, rt);
                
                if(lineValid == true)
                {

                    opcodeBinary = opcodeBinary.concat(" 00000");
                    opcodeBinary = opcodeBinary.concat(" 101101");
                
                    this.generateHex(opcodeBinary);
                    
                    opcodeTxtArea.setText(opcodeTxtArea.getText() + codeCheck + "\t" + opcodeHex + "\t" + opcodeBinary + "\n");
                }
            }
        }
        
        /**************************************************************************************/
        
        else if(splitInst(codeCheck).equals("DMULU"))
        {
            System.out.println("Instruction is DMULU.");
            
            opcodeBinary = "";
            
            if(lineValid == true)
            {
                /*Generates the opcode*/
                opcodeBinary = opcodeBinary.concat("000000");
                
                this.generateOpcode(rd, rs, rt);
                if(lineValid == true)
                {

                    opcodeBinary = opcodeBinary.concat(" 00010");
                    opcodeBinary = opcodeBinary.concat(" 011101");
                
                    this.generateHex(opcodeBinary);
                    
                    opcodeTxtArea.setText(opcodeTxtArea.getText() + codeCheck + "\t" + opcodeHex + "\t" + opcodeBinary + "\n");
                }                
            }
        }
        
        /**************************************************************************************/
        
        else if(splitInst(codeCheck).equals("DMUHU"))
        {
            System.out.println("Instruction is DMUHU.");
            
            opcodeBinary = "";
            
            if(lineValid == true)
            {
                /*Generates the opcode*/
                opcodeBinary = opcodeBinary.concat("000000");
                
                this.generateOpcode(rd, rs, rt);
                if(lineValid == true)
                {

                    opcodeBinary = opcodeBinary.concat(" 00011");
                    opcodeBinary = opcodeBinary.concat(" 011101");
                
                    this.generateHex(opcodeBinary);
                    
                    opcodeTxtArea.setText(opcodeTxtArea.getText() + codeCheck + "\t" + opcodeHex + "\t" + opcodeBinary + "\n");
                }                
            }
        }
        
        /**************************************************************************************/
        
        else if(splitInst(codeCheck).equals("SLT"))
        {
            System.out.println("Instruction is SLT.");
            
            opcodeBinary = "";
            
            if(lineValid == true)
            {
                /*Generates the opcode*/
                opcodeBinary = opcodeBinary.concat("000000");
                
                this.generateOpcode(rd, rs, rt);
                if(lineValid == true)
                {

                    opcodeBinary = opcodeBinary.concat(" 00000");
                    opcodeBinary = opcodeBinary.concat(" 101010");
                
                    this.generateHex(opcodeBinary);
                    
                    opcodeTxtArea.setText(opcodeTxtArea.getText() + codeCheck);
                    opcodeTxtArea.setText(opcodeTxtArea.getText() + "\t\t");
                    opcodeTxtArea.setText(opcodeTxtArea.getText() + opcodeHex);
                    opcodeTxtArea.setText(opcodeTxtArea.getText() + "\t");
                    opcodeTxtArea.setText(opcodeTxtArea.getText() + opcodeBinary);
                    opcodeTxtArea.setText(opcodeTxtArea.getText() + "\n");
                }                
            }
        }
        
        /**************************************************************************************/
        
        else if(splitInst(codeCheck).equals("SELEQZ"))
        {
            System.out.println("Instruction is SELEQZ.");
            
            opcodeBinary = "";
            
            if(lineValid == true)
            {
                /*Generates the opcode*/
                opcodeBinary = opcodeBinary.concat("000000");
                
                this.generateOpcode(rd, rs, rt);
                if(lineValid == true)
                {

                    opcodeBinary = opcodeBinary.concat(" 00000");
                    opcodeBinary = opcodeBinary.concat(" 110101");
                
                    this.generateHex(opcodeBinary);
                    
                    opcodeTxtArea.setText(opcodeTxtArea.getText() + codeCheck + "\t" + opcodeHex + "\t" + opcodeBinary + "\n");
                }                
            }
        }
        
        /**************************************************************************************/
        
        else if(splitInst(codeCheck).equals("BEQC"))
        {
            
        }
        
        /**************************************************************************************/
        
        else if(splitInst(codeCheck).equals("LD"))
        {
            System.out.println("Instruction is LD.");
            
            opcodeBinary = "";
            
            if(lineValid == true)
            {
                /*Generates the opcode*/
                opcodeBinary = opcodeBinary.concat("110111");
                
                this.generateOffset(rd, rs, rt);
                if(lineValid == true)
                {
                    this.generateHex(opcodeBinary);
                    
                    opcodeTxtArea.setText(opcodeTxtArea.getText() + codeCheck + "\t" + opcodeHex + "\t" + opcodeBinary + "\n");
                }                
            }
        }
        
        /**************************************************************************************/
        
        else if(splitInst(codeCheck).equals("SD"))
        {
            System.out.println("Instruction is SD.");
            
            opcodeBinary = "";
            
            if(lineValid == true)
            {
                /*Generates the opcode*/
                opcodeBinary = opcodeBinary.concat("111111");
                
                this.generateOffset(rd, rs, rt);
                if(lineValid == true)
                {
                    this.generateHex(opcodeBinary);
                    
                    opcodeTxtArea.setText(opcodeTxtArea.getText() + codeCheck + "\t" + opcodeHex + "\t" + opcodeBinary + "\n");
                }                
            }
        }
        
        /**************************************************************************************/
        
        else if(splitInst(codeCheck).equals("DADDIU"))
        {
            System.out.println("Instruction is DADDIU.");
            
            opcodeBinary = "";
            
            if(lineValid == true)
            {
                /*Generates the opcode*/
                opcodeBinary = opcodeBinary.concat("011001");
                
                this.generateImm(rd, rs, rt);
                
                if(lineValid == true)
                {
                    this.generateHex(opcodeBinary);
                    
                    opcodeTxtArea.setText(opcodeTxtArea.getText() + codeCheck + "\t" + opcodeHex + "\t" + opcodeBinary + "\n");
                }                
            }
        }
        
        /**************************************************************************************/
        
        else if(splitInst(codeCheck).equals("BC"))
        {
            
        }
        
        else System.out.println("Instruction not available");
        
    }
    
    private void runBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runBtnActionPerformed
        
        System.out.println("The run button was clicked.");
        
        codeSegment = codeTxtArea.getText(); /*Gets the contents of the code text area*/
        codeSegment = codeSegment.toUpperCase(); /*Capitalizes the code segment*/
        System.out.println("\nThis is the code segment:\n" + codeSegment);
        
        this.getLabels(codeSegment);
        
        String str1[] = codeSegment.split("\n"); /*Splits the code segment line per line*/
        
        /*Prints the content of every index in array str1[]*/
        System.out.println("\nThis is the code segment after splitting: ");
        for(int a = 0; a < str1.length; a++)
        {
            System.out.println("Line number " + (a + 1) + ": " + str1[a]);
        }
        
        System.out.println("Total number of lines: " + str1.length); /*str1.length contains the total number of lines*/
        
        for(int b = 0; b < str1.length; b++)
        {
            this.checkLabel(str1[b]); /*Passes line per line code to check if it has label*/
        }
        
        if(!errorList.isEmpty())
        System.out.println("\nWarning!\n");
        
        for(int i = 0; i < errorList.size(); i++)
        {
            System.out.println(errorList.get(i));
            
        }
        
        if(errorList.isEmpty())
        {
            for(int c = 0; c < str1.length; c++)
            {
                this.errorCheck(str1[c]);
            }
        }
    }//GEN-LAST:event_runBtnActionPerformed

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        // TODO add your handling code here:
        
        this.dispose();
        
        new MainFrameGUI().setVisible(true);
        
        /*for(int j = 0; j < registerTbl.getRowCount(); j++)
        {
            registerTbl.setValueAt(0000000000000001, j, 1);
        }*/
    }//GEN-LAST:event_clearBtnActionPerformed


    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrameGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearBtn;
    private javax.swing.JTextArea codeTxtArea;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable memTbl;
    private javax.swing.JTextArea opcodeTxtArea;
    private javax.swing.JPanel pipelinePanel;
    private javax.swing.JTable registerTbl;
    private javax.swing.JButton runBtn;
    private javax.swing.JPanel runPanel;
    // End of variables declaration//GEN-END:variables
}
