package minimips;

import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;

import java.util.*;
import java.awt.*;
import java.math.BigInteger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dreyasaur
 */
public class MainFrameGUI extends javax.swing.JFrame 
{
    private ErrorGUI errorGUI;
    private ArrayList<Instruction> instructions;
    private ArrayList<Register> registers;
    private ArrayList<Cycles> cycles;
    private Cycles cycle;
    
    private ArrayList<String> labels;       /*Arraylist of labels*/
    private ArrayList<String> tempLabels;   /*Arraylist of labels evel invalid*/
    private ArrayList<String> errorList;    /*Arraylist of errors*/
    private ArrayList<String> codes;        /*Arraylist of all valid codes*/
    private ArrayList<Integer> lines;       /*Arraylist of line numbers*/
    
    private String codeSegment = "";            /*Contains the whole code entered*/
    private String tempCodeSegment = "";
    private String rd = "";
    private String rs = "";
    private String rt = "";
    private String Imm = "";
    private String base = "";
    private String offset = "";
    private String opcodeBinary = "";
    private String opcodeHex = "";
    private String regTemp = "";
    private String addressHex = "";
    private String addressTemp = "";
    private String memoryHex = "";
    
    /*Variables to store in arraylist of instruction*/
    private String rd1 = "";
    private String rs1 = "";
    private String rt1 = "";
    private String code1 = "";
    private String instCode = "";
    private String pcNum = "";
    private String label1 = "";
    private String hexCode = "";
    
    /*Variables to store in arraylist of register*/
    private String tempReg = "";
    private String tempReg1 = "";
    private String regVal = "";
    private String regNumber = "";
    
    private int lineNumber = 1;
    private int regNum;
    private int g = 0;
    private int runBtnCtr = 0;
    ////////////////////////////////////////////////////////////////////
    /*Cycle 1*/
    private String IFID_IR = "";
    private String IFID_NPC = "";
    
    /*Cycle 2*/
    private String IDEX_A = "";
    private String IDEX_B = "";
    private String IDEX_IMM = "";
    private String IDEX_IR = "";
    private String IDEX_NPC = "";
    
    /*Cycle 3*/
    private String EXMEM_ALUOUTPUT = "";
    private String EXMEM_COND = "";
    private String EXMEM_IR = "";
    private String EXMEM_B = "";
    
    /*Cycle 4*/
    private String MEMWB_LMD = "";
    private String MEMWB_IR = "";
    private String MEMWB_ALUOUTPUT = "";
    
    /*Cycle 5*/
    private String WB_RN = "";
    
    private int PC = 0;
    private int CC = 0;
    private String EXMEM_OPCODE = "";
    private int p = 0;
    private int instNum = 0;
    private int q = 0;
    private int dNum = 0;
    private int fetch = 0;
    private int totLines = 0;
    private int dCtr = 0;
    private int cCtr = 0;
    private int tempPC = 0;
    private int run = 0;
    private int stallCtr = 0;
    //////////////////////////////////////////////////////////////////
    private boolean lineValid = true;
    private boolean labelValid = true;
    private boolean notBlank = true;
    private boolean registerValid = true;
    private boolean immValid = true;
    private boolean offsetValid = true;
    private boolean dHazard = false;
    private boolean isDone = false;
    private boolean stall = false;
    private boolean cHazard = false;
    
    private JTable memoryTable;
    private DefaultTableModel memoryModel;
    private JScrollPane memSP;

    public MainFrameGUI()
    {
        initComponents();
        
        errorGUI = new ErrorGUI();
        instructions = new ArrayList<Instruction>();
        registers = new ArrayList<Register>();
        cycles = new ArrayList<Cycles>();
        cycle = new Cycles();
        
        cyclesTxtArea.setEditable(false);
        mapTxtArea.setEditable(false);
        
        /*Memory Table*/
        memoryModel = new DefaultTableModel();
        
        memoryModel.addColumn("Memory");
        memoryModel.addColumn("Value");
        
        memoryTable = new JTable(memoryModel);
        memSP = new JScrollPane(memoryTable);
        
        memSP.setBounds(10, 25, 269, 278);
        memoryPanel.add(memSP);
        
        int a = 8192;
        
        for(int b = 0; b < 8192; b++)
        {
            memoryHex = "";
            
            memoryHex = Integer.toHexString(a);
            memoryHex = memoryHex.toUpperCase();
            a++;
            
            DefaultTableModel memoryModel = (DefaultTableModel) memoryTable.getModel();
            memoryModel.addRow(new Object[]{memoryHex, "00"});
        }
        
        /*Set width of register table column*/
        registerTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        registerTable.getColumnModel().getColumn(0).setPreferredWidth(70);
        registerTable.getColumnModel().getColumn(1).setPreferredWidth(175);
        
        /*Set width of opcode table column*/
        opcodeTbl.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        opcodeTbl.getColumnModel().getColumn(0).setPreferredWidth(150);
        opcodeTbl.getColumnModel().getColumn(1).setPreferredWidth(100);
        opcodeTbl.getColumnModel().getColumn(2).setPreferredWidth(70);
        opcodeTbl.getColumnModel().getColumn(3).setPreferredWidth(275);
        
        /*Instantiate arraylists*/
        labels      = new ArrayList<String>();
        errorList   = new ArrayList<String>();
        tempLabels  = new ArrayList<String>();
        codes       = new ArrayList<String>();
        lines       = new ArrayList<Integer>();
        
        
        int q = 0;
        
        for(int r = 0; r < 2048; r++)
        {
            addressHex = "";
            
            addressTemp = Integer.toHexString(q);
            q += 4;
            
            addressTemp = addressTemp.toUpperCase();
            
            for(int s = 0; s < 16 - addressTemp.length(); s++)
            {
                addressHex = addressHex.concat("0");
            }
            
            addressHex = addressHex.concat(addressTemp);
            opcodeTbl.setValueAt(addressHex, r, 0);
            opcodeTbl.setValueAt("00000000", r, 1);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        registerPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        registerTable = new javax.swing.JTable();
        memoryPanel = new javax.swing.JPanel();
        pipelinePanel = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        mapTxtArea = new javax.swing.JTextArea();
        opcodePanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        opcodeTbl = new javax.swing.JTable();
        cyclesPanel = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        cyclesTxtArea = new javax.swing.JTextArea();
        singleBtn = new javax.swing.JButton();
        fullBtn = new javax.swing.JButton();
        codePanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        codeTxtArea = new javax.swing.JTextArea();
        runBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        registerPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Register", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18))); // NOI18N

        registerTable.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        registerTable.setModel(new javax.swing.table.DefaultTableModel(
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
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(registerTable);

        javax.swing.GroupLayout registerPanelLayout = new javax.swing.GroupLayout(registerPanel);
        registerPanel.setLayout(registerPanelLayout);
        registerPanelLayout.setHorizontalGroup(
            registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registerPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(201, 201, 201))
        );
        registerPanelLayout.setVerticalGroup(
            registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registerPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                .addContainerGap())
        );

        memoryPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Memory", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18))); // NOI18N

        javax.swing.GroupLayout memoryPanelLayout = new javax.swing.GroupLayout(memoryPanel);
        memoryPanel.setLayout(memoryPanelLayout);
        memoryPanelLayout.setHorizontalGroup(
            memoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        memoryPanelLayout.setVerticalGroup(
            memoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 284, Short.MAX_VALUE)
        );

        pipelinePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pipeline Map", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18))); // NOI18N

        mapTxtArea.setColumns(20);
        mapTxtArea.setRows(5);
        jScrollPane6.setViewportView(mapTxtArea);

        javax.swing.GroupLayout pipelinePanelLayout = new javax.swing.GroupLayout(pipelinePanel);
        pipelinePanel.setLayout(pipelinePanelLayout);
        pipelinePanelLayout.setHorizontalGroup(
            pipelinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pipelinePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6)
                .addContainerGap())
        );
        pipelinePanelLayout.setVerticalGroup(
            pipelinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pipelinePanelLayout.createSequentialGroup()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                .addContainerGap())
        );

        opcodePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opcode", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18))); // NOI18N

        opcodeTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Address", "Representation", "Label", "Instruction"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(opcodeTbl);

        javax.swing.GroupLayout opcodePanelLayout = new javax.swing.GroupLayout(opcodePanel);
        opcodePanel.setLayout(opcodePanelLayout);
        opcodePanelLayout.setHorizontalGroup(
            opcodePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(opcodePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        opcodePanelLayout.setVerticalGroup(
            opcodePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(opcodePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cyclesPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cycles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18))); // NOI18N

        cyclesTxtArea.setColumns(20);
        cyclesTxtArea.setRows(5);
        jScrollPane5.setViewportView(cyclesTxtArea);

        singleBtn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        singleBtn.setText("Single");

        fullBtn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        fullBtn.setText("Full");
        fullBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fullBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout cyclesPanelLayout = new javax.swing.GroupLayout(cyclesPanel);
        cyclesPanel.setLayout(cyclesPanelLayout);
        cyclesPanelLayout.setHorizontalGroup(
            cyclesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cyclesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cyclesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane5)
                    .addGroup(cyclesPanelLayout.createSequentialGroup()
                        .addComponent(singleBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fullBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        cyclesPanelLayout.setVerticalGroup(
            cyclesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cyclesPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cyclesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fullBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(singleBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        codePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Code", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18))); // NOI18N

        codeTxtArea.setColumns(20);
        codeTxtArea.setRows(5);
        jScrollPane2.setViewportView(codeTxtArea);

        runBtn.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        runBtn.setText("Run");
        runBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout codePanelLayout = new javax.swing.GroupLayout(codePanel);
        codePanel.setLayout(codePanelLayout);
        codePanelLayout.setHorizontalGroup(
            codePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(codePanelLayout.createSequentialGroup()
                .addGroup(codePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(runBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(codePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)))
                .addContainerGap())
        );
        codePanelLayout.setVerticalGroup(
            codePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(codePanelLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(runBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(registerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(memoryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cyclesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(codePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pipelinePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(opcodePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(opcodePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pipelinePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(registerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(memoryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(codePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cyclesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public String splitInstruction(String codeLine) /*codeLine is the 1-liner code & returns only the instruction without the registers*/
    {
        rd = "";
        rs = "";
        rt = "";
        
        if(codeLine.matches("([A-Z0-9]*: )*[A-Z]+ [A-Z0-9]+, [A-Z0-9]+, [A-Z0-9#]+") ||         /*For R-Type Instructions, DADDIU, & BEQC*/
           codeLine.matches("([A-Z0-9]*: )*[A-Z]+ [A-Z0-9]+, [A-Z0-9]+ [(][(A-Z0-9)]+[)]") ||   /*For LD and SD*/
           codeLine.matches("([A-Z0-9]*: )*[BC]+ [A-Z0-9]+"))                                  /*For BC*/
        {
            String str2[] = codeLine.split(" ");                        /*Splits the 1-liner code by space*/
            String strInst = "";
            
            if(str2[0].contains(":"))                                  /*If instruction has a label*/
            {
                if(str2[0].matches("^[a-zA-Z]+[0-9]*[a-zA-Z]*[:]$"))    /*If label name is valid*/
                {
                    String str3[] = str2[0].split(":");                 /*Remove the colon(:)*/
                    
                    if(!labels.contains(str3[0]))                       /*If label is not yet in the list*/
                    {
                        labels.add(str3[0]);                            /*Add label name into arraylist*/
                        lines.add(lineNumber);                          /*Add line number of the label in arraylist*/ 
                    }
                    else if(labels.contains(str2[0]) && !lines.contains(lineNumber))
                        labelValid = false;                             /*If label is already in the list*/
                }
                
                else labelValid = false;                                 /*If label is invalid*/
                
                if(codeLine.matches("([A-Z0-9]*: )*[A-Z]+ [A-Z0-9]+, [A-Z0-9]+, [A-Z0-9#]+"))   /*If R-Type Instruction*/
                {
                    String str4[] = str2[2].split(",");
                    rd = "";
                    rd = rd.concat(str4[0]);
                    
                    String str5[] = str2[3].split(",");
                    rs = "";
                    rs = rs.concat(str5[0]);
                    
                    String str6[] = str2[4].split(",");
                    rt = "";
                    rt = rt.concat(str6[0]);
                    
                    strInst = str2[1];
                }
                
                else if(codeLine.matches("([A-Z0-9]*: )*[A-Z]+ [A-Z0-9]+, [A-Z0-9]+ [(][(A-Z0-9)]+[)]")) /*If LD and SD*/
                {
                    String str4[] = str2[2].split(",");
                    rd = "";
                    rd = rd.concat(str4[0]);
                    
                    rs = "";
                    rs = rs.concat(str2[3]);
                    
                    String str5[] = str2[4].split("\\(");
                    String str6[] = str5[1].split("\\)");
                    rt = "";
                    rt = rt.concat(str6[0]);
                    
                    strInst = str2[1];
                }
                
                else if(codeLine.matches("([A-Z0-9]*: )*[A-Z]+ [A-Z0-9]+")) /*If BC*/
                {
                    offset = "";
                    offset = offset.concat(str2[2]);
                    
                    strInst = str2[1];
                }
            }
            
            else
            {
                if(codeLine.matches("([A-Z0-9]*: )*[A-Z]+ [A-Z0-9]+, [A-Z0-9]+, [A-Z0-9#]+")) /*If R-Type Instruction*/
                {
                    String str4[] = str2[1].split(",");
                    rd = "";
                    rd = rd.concat(str4[0]);
                    
                    String str5[] = str2[2].split(",");
                    rs = "";
                    rs = rs.concat(str5[0]);
                    
                    String str6[] = str2[3].split(",");
                    rt = "";
                    rt = rt.concat(str6[0]);
                    
                    strInst = str2[0];
                }
                
                else if(codeLine.matches("([A-Z0-9]*: )*[A-Z]+ [A-Z0-9]+, [A-Z0-9]+ [(][(A-Z0-9)]+[)]")) /*If LD and SD*/
                {
                    String str4[] = str2[1].split(",");
                    rd = "";
                    rd = rd.concat(str4[0]);
                    
                    rs = "";
                    rs = rs.concat(str2[2]);
                    
                    String str5[] = str2[3].split("\\(");
                    String str6[] = str5[1].split("\\)");
                    rt = "";
                    rt = rt.concat(str6[0]);
                    
                    strInst = str2[0];    
                }
                
                else if(codeLine.matches("([A-Z0-9]*: )*[A-Z]+ [A-Z0-9]+")) /*If BC*/
                {
                    offset = "";
                    offset = offset.concat(str2[1]);
                    
                    strInst = str2[0];
                }
            }
            
            return strInst;
        }
        
        else
        {
            String str = "";
            return str;
        }
    }
    
    public void getLabels(String codeSegment) /*Being used for checking BC or BEQC*/
    {
        String str7[] = codeSegment.split("\n");
       
        for(int a = 0; a < str7.length; a++)
        {
            String str8[] = str7[a].split(" ");
            
            if(str8[0].contains(":")) /*If instruction has a label*/
            {
                if(str8[0].length() > 1)
                {
                    String str9[] = str8[0].split(":"); /*Split label name and colon*/
                    tempLabels.add(str9[0]);
                }
            }
        }
    }
    
    public void checkRegister(String rd, String rs, String rt) /*Checks if registers are valid*/
    {
        /*Checks if registers are R1, R2, R3 not A1, B2, C3 (or the like)*/
        if(rd.charAt(0) == 82) /*82 is ASCII for 'R'*/
        {
            if(rs.charAt(0) == 82)
            {
                if(rt.charAt(0) == 82)
                {
                    String str10[] = rt.split("R");
                    
                    if(Integer.parseInt(str10[1]) < 0 || Integer.parseInt(str10[1]) > 32)
                    {
                        registerValid = false;
                    }
                }
                
                else registerValid = false;
                
                String str11[] = rs.split("R");
                
                if(Integer.parseInt(str11[1]) < 0 || Integer.parseInt(str11[1]) > 32)
                {
                    registerValid = false;
                }
            }
            
            else registerValid = false;
            
            String str12[] = rs.split("R");
            
            if(Integer.parseInt(str12[1]) < 0 || Integer.parseInt(str12[1]) > 32)
            {
                registerValid = false;
            }
        }
        
        else registerValid = false;
    }
    
    public void checkImmediate(String rd, String rs, String rt) /*Checks if immediate is valid*/
    {
        if(rd.charAt(0) == 82)
        {
            if(rs.charAt(0) == 82)
            {
                if(!rt.matches("^#[0-9A-F]{1,4}"))
                    immValid = false;
                
                String str12[] = rs.split("R");
                
                if(Integer.parseInt(str12[1]) < 0 || Integer.parseInt(str12[1]) > 32)
                    registerValid = false;
            }
            
            else registerValid = false;
            
            String str13[] = rd.split("R");
            
            if(Integer.parseInt(str13[1]) < 0 || Integer.parseInt(str13[1]) > 32)
                registerValid = false;
        }
        
        else registerValid = false;
    }
    
    public void checkOffset(String rd, String rs, String rt) /*Checks if offset is valid for LD & SD*/
    {
        if(rd.charAt(0) == 82)
        {
            if(rs.matches("^[2-3]+[0-9A-aF-f]{3}") && rs.length() == 4)
            {
                if(rt.charAt(0) == 82)
                {
                    String str14[] = rt.split("R");
                    
                    if(Integer.parseInt(str14[1]) < 0 || Integer.parseInt(str14[1]) > 32)
                        registerValid = false; 
                }
                
                else registerValid = false;
            }
            
            else offsetValid = false;
            
            String str15[] = rd.split("R");
            
            if(Integer.parseInt(str15[1]) < 0 || Integer.parseInt(str15[1]) > 32)
                registerValid = false; 
        }
        
        else registerValid = false;
    }
    
    public void checkBEQC(String rd, String rs, String rt) /*Checks if label is in the list using getLabels method*/
    {
        if(rd.charAt(0) == 82)
        {
            if(rs.charAt(0) == 82)
            {
                if(!tempLabels.contains(rt))
                    offsetValid = false;
                
                String str16[] = rs.split("R");
                
                if(Integer.parseInt(str16[1]) < 0 || Integer.parseInt(str16[1]) > 32)
                    registerValid = false;
            }
            
            else registerValid = false;
            
            String str17[] = rd.split("R");
        
            if(Integer.parseInt(str17[1]) < 0 || Integer.parseInt(str17[1]) > 32)
                registerValid = false;
        }
        
        else registerValid = false;
    }
    
    public void errorCheck(String codeLine) /*codeLine is the 1-liner code & checks for errors per line*/
    {
        if(codeLine.length() == 0) /*If line is empty*/
        {
            notBlank = false;
            errorList.add("Line Number " + lineNumber + ": Invalid Instruction.");
        }
        
        else if(splitInstruction(codeLine).equals("DADDU"))
        {
            this.checkRegister(rd, rs, rt);
            
            if(labelValid == false)
                errorList.add("Line Number " + lineNumber +": Invalid Label.");
            
            if (registerValid == false)
                errorList.add("Line Number " + lineNumber +": Invalid Register.");
        }
        
        else if(splitInstruction(codeLine).equals("DMULU"))
        {
            this.checkRegister(rd, rs, rt);
            
            if(labelValid == false)
                errorList.add("Line Number " + lineNumber +": Invalid Label.");
            
            if (registerValid == false)
                errorList.add("Line Number " + lineNumber +": Invalid Register.");
        }
        
        else if(splitInstruction(codeLine).equals("DMUHU"))
        {
            this.checkRegister(rd, rs, rt);
            
            if(labelValid == false)
                errorList.add("Line Number " + lineNumber +": Invalid Label.");
            
            if (registerValid == false)
                errorList.add("Line Number " + lineNumber +": Invalid Register.");
        }
        
        else if(splitInstruction(codeLine).equals("SLT"))
        {
            this.checkRegister(rd, rs, rt);
            
            if(labelValid == false)
                errorList.add("Line Number " + lineNumber +": Invalid Label.");
            
            if (registerValid == false)
                errorList.add("Line Number " + lineNumber +": Invalid Register.");
        }
        
        else if(splitInstruction(codeLine).equals("SELEQZ"))
        {
            this.checkRegister(rd, rs, rt);
            
            if(labelValid == false)
                errorList.add("Line Number " + lineNumber +": Invalid Label.");
            
            if (registerValid == false)
                errorList.add("Line Number " + lineNumber +": Invalid Register.");
        }
        
        else if(splitInstruction(codeLine).equals("DADDIU"))
        {
            Imm = rt;
            rt  = rd;
            this.checkImmediate(rt, rs, Imm);
            
            if(labelValid == false)
                errorList.add("Line Number " + lineNumber +": Invalid Label.");
            
            if (registerValid == false)
                errorList.add("Line Number " + lineNumber +": Invalid Register.");
            
            if(immValid == false)
                errorList.add("Line Number " + lineNumber + ": Invalid Immediate.");
        }
        
        else if(splitInstruction(codeLine).equals("LD"))
        {
            base = rt;
            rt   = rd;
            offset = rs;
            this.checkOffset(rt, offset, base);
            
            if(labelValid == false)
                errorList.add("Line Number " + lineNumber +": Invalid Label.");
            
            if (registerValid == false)
                errorList.add("Line Number " + lineNumber +": Invalid Register.");
            
            if(offsetValid == false)
                errorList.add("Line Number " + lineNumber + ": Invalid Offset.");
        }
        
        else if(splitInstruction(codeLine).equals("SD"))
        {
            base = rt;
            rt   = rd;
            offset = rs;
            this.checkOffset(rt, offset, base);
            
            if(labelValid == false)
                errorList.add("Line Number " + lineNumber +": Invalid Label.");
            
            if (registerValid == false)
                errorList.add("Line Number " + lineNumber +": Invalid Register.");
            
            if(offsetValid == false)
                errorList.add("Line Number " + lineNumber + ": Invalid Offset.");
        }
        
        else if(splitInstruction(codeLine).equals("BEQC"))
        {
            offset = rt;
            rt = rs;
            rs = rd;
            
            this.checkBEQC(rs, rt, offset);
            
            if(labelValid == false)
                errorList.add("Line Number " + lineNumber +": Invalid Label.");
            
            if (registerValid == false)
                errorList.add("Line Number " + lineNumber +": Invalid Register.");
            
            if(offsetValid == false)
                errorList.add("Line Number " + lineNumber + ": Invalid Offset.");
        }
        
        else if(splitInstruction(codeLine).equals("BC"))
        {
            
            if(!tempLabels.contains(offset))
                errorList.add("Line Number " + lineNumber + ": Invalid Offset.");
        }
 
        else
        {
            errorList.add("Line Number " + lineNumber + ": Invalid Instruction.");
        }
        
        lineNumber++;
        
        registerValid   = true;
        labelValid      = true;
        immValid        = true;
        offsetValid     = true;
        notBlank        = true;
    }
     
    public void generateCodes(String codeLine) /*codeLine is the 1-liner code*/
    {
        if(codeLine.contains(":")) /*If 1-liner code has label*/
        {
            String str18[] = codeLine.split(":");
            String temp1 = "";
            
            for(int f = 1; f < str18[1].length(); f++)
            {
                temp1 = temp1.concat(Character.toString(str18[1].charAt(f)));
            }
            
            codes.add(temp1);
        }
        
        else codes.add(codeLine);
    }
    
    public String generateBinary(String register)
    {
        String str19[] = register.split("R");
        
        regTemp = "";
        regTemp = regTemp.concat(str19[1]);
        regNum = Integer.parseInt(regTemp);
        
        String temp2 = Integer.toBinaryString(regNum);
        String temp3 = "";
        
        for(int h = 0; h < 5 - temp2.length(); h++)
        {
            temp3 = temp3.concat("0");
        }
        
        temp3 = temp3.concat(temp2);
        
        return temp3;
    }
    
    public void generateHex(String opcodeBinary)
    {
        String hexTemp = "";
        String temp4 = "";
        
        int i = 0;
        int j = 0;
        
        opcodeHex = "";
        
        for(int k = 0; k < opcodeBinary.length(); k++)
        {
            if(opcodeBinary.charAt(k) != 32)
            {
                hexTemp = hexTemp.concat(Character.toString(opcodeBinary.charAt(k)));
            }
        }
        
        while (i < 8)
        {
            temp4 = "";
            
            for(int l = 0; l < 4; l++)
            {
                temp4 = temp4.concat(Character.toString(hexTemp.charAt(j)));
                j++;
            }
            
            switch(temp4)
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
            
            i++;
        }
    }
    
    public String hexToBinary(String offset)
    {
       int m = Integer.parseInt(offset,16); 
       
       String temp5 = Integer.toBinaryString(m);
       String temp6 = "";
        
       for(int n = 0; n < 16 - temp5.length(); n++)
       {
            temp6 = temp6.concat("0");
       }
        
        temp6 = temp6.concat(temp5);
        
        return temp6;
    }
    
    public String offsetToBinary(int offset)
    {
        String temp9 = Integer.toBinaryString(offset);
       
        return temp9; 
    }
    
    public void generateOpcode(String codeLine) /*codeLine is the 1-liner code & generates the binary opcode*/
    {
        if(splitInstruction(codeLine).equals("DADDU"))
        {
            opcodeBinary = "";
            
            /*Generates the opcode*/
            opcodeBinary = opcodeBinary.concat("000000");
            opcodeBinary = opcodeBinary.concat(generateBinary(rs));
            opcodeBinary = opcodeBinary.concat(generateBinary(rt));
            opcodeBinary = opcodeBinary.concat(generateBinary(rd));
            opcodeBinary = opcodeBinary.concat("00000");
            opcodeBinary = opcodeBinary.concat("101101");
                
            this.generateHex(opcodeBinary);
                    
            opcodeTbl.setValueAt(opcodeHex, g, 1);
        }
        
        /**************************************************************************************/
        
        else if(splitInstruction(codeLine).equals("DMULU"))
        {
            opcodeBinary = "";
            
            /*Generates the opcode*/
            opcodeBinary = opcodeBinary.concat("000000");
            opcodeBinary = opcodeBinary.concat(generateBinary(rs));
            opcodeBinary = opcodeBinary.concat(generateBinary(rt));
            opcodeBinary = opcodeBinary.concat(generateBinary(rd));
            opcodeBinary = opcodeBinary.concat("00010");
            opcodeBinary = opcodeBinary.concat("011101");
                
            this.generateHex(opcodeBinary);
          
            opcodeTbl.setValueAt(opcodeHex, g, 1);
        }
        
        /**************************************************************************************/
        
        else if(splitInstruction(codeLine).equals("DMUHU"))
        {
            opcodeBinary = "";
            
            /*Generates the opcode*/
            opcodeBinary = opcodeBinary.concat("000000");
            opcodeBinary = opcodeBinary.concat(generateBinary(rs));
            opcodeBinary = opcodeBinary.concat(generateBinary(rt));
            opcodeBinary = opcodeBinary.concat(generateBinary(rd));
            opcodeBinary = opcodeBinary.concat("00011");
            opcodeBinary = opcodeBinary.concat("011101");
                
            this.generateHex(opcodeBinary);
                    
            opcodeTbl.setValueAt(opcodeHex, g, 1);  
        }
        
        /**************************************************************************************/
        
        else if(splitInstruction(codeLine).equals("SLT"))
        {
            opcodeBinary = "";
           
            /*Generates the opcode*/
            opcodeBinary = opcodeBinary.concat("000000");
            opcodeBinary = opcodeBinary.concat(generateBinary(rs));
            opcodeBinary = opcodeBinary.concat(generateBinary(rt));
            opcodeBinary = opcodeBinary.concat(generateBinary(rd));
            opcodeBinary = opcodeBinary.concat("00000");
            opcodeBinary = opcodeBinary.concat("101010");
                
            this.generateHex(opcodeBinary);
                    
            opcodeTbl.setValueAt(opcodeHex, g, 1);
        }
        
        /**************************************************************************************/
        
        else if(splitInstruction(codeLine).equals("SELEQZ"))
        {
            opcodeBinary = "";
            
            /*Generates the opcode*/
            opcodeBinary = opcodeBinary.concat("000000");
            opcodeBinary = opcodeBinary.concat(generateBinary(rs));
            opcodeBinary = opcodeBinary.concat(generateBinary(rt));
            opcodeBinary = opcodeBinary.concat(generateBinary(rd));
            opcodeBinary = opcodeBinary.concat("00000");
            opcodeBinary = opcodeBinary.concat("110101");
                
            this.generateHex(opcodeBinary);
                    
            opcodeTbl.setValueAt(opcodeHex, g, 1);
        }
        
        /**************************************************************************************/
        
        else if(splitInstruction(codeLine).equals("LD"))
        {
            opcodeBinary = "";
           
            /*Generates the opcode*/
            opcodeBinary = opcodeBinary.concat("110111");
            opcodeBinary = opcodeBinary.concat(generateBinary(rt));
            opcodeBinary = opcodeBinary.concat(generateBinary(rd));
            opcodeBinary = opcodeBinary.concat(hexToBinary(rs));
            
            this.generateHex(opcodeBinary);
                    
            opcodeTbl.setValueAt(opcodeHex, g, 1);    
        }
        
        /**************************************************************************************/
        
        else if(splitInstruction(codeLine).equals("SD"))
        {
            opcodeBinary = "";
            
            /*Generates the opcode*/
            opcodeBinary = opcodeBinary.concat("111111");
            opcodeBinary = opcodeBinary.concat(generateBinary(rt));
            opcodeBinary = opcodeBinary.concat(generateBinary(rd));
            opcodeBinary = opcodeBinary.concat(hexToBinary(rs));
              
            this.generateHex(opcodeBinary);
                    
            opcodeTbl.setValueAt(opcodeHex, g, 1);
        }
        
        /**************************************************************************************/
        
        else if(splitInstruction(codeLine).equals("DADDIU"))
        {
            opcodeBinary = "";
            
            /*Generates the opcode*/
            opcodeBinary = opcodeBinary.concat("011001");
            opcodeBinary = opcodeBinary.concat(generateBinary(rs));
            opcodeBinary = opcodeBinary.concat(generateBinary(rd));
            
            String str20[] = rt.split("#");
            opcodeBinary = opcodeBinary.concat(hexToBinary(str20[1]));
                
            this.generateHex(opcodeBinary);
                    
            opcodeTbl.setValueAt(opcodeHex, g, 1);
        }
        
        /**************************************************************************************/

        else if(splitInstruction(codeLine).equals("BC"))
        {
            opcodeBinary = "";
            opcodeBinary = opcodeBinary.concat("110010");
            
            boolean find = false;
            int distance = 0;
            int lineNum = 0;
            int o = 0;
            
            while(!find && o < labels.size())
            {
                if(labels.get(o).matches(offset))
                {
                    lineNum= lines.get(o);
                    find = true;
                }
                
                o++;
            };
            
            distance = lineNum - (g + 2); 
            String temp7 = "";
            String temp8 = "";
            
            temp7 = offsetToBinary(distance);
               
            if(distance >= 0)
            {
                for(int k = 0; k < 26 - temp7.length(); k++)
                {
                    temp8 = temp8.concat("0");
                }
            
                temp8 = temp8.concat(temp7);
            }
               
            else
            {
                for(int m = 6; m < 32; m++)
                {
                    temp8 = temp8.concat(Character.toString(temp7.charAt(m)));
                }
            }
               
            opcodeBinary = opcodeBinary.concat(temp8);
            this.generateHex(opcodeBinary);
                 
            opcodeTbl.setValueAt(opcodeHex, g, 1);
        }
        
        /**************************************************************************************/     
        
        else if(splitInstruction(codeLine).equals("BEQC"))
        {
            opcodeBinary = "";
            opcodeBinary = opcodeBinary.concat("001000");
            
            boolean find = false;
            int distance = 0;
            int lineNum = 0;
            int p = 0;
            
            while(!find && p < labels.size())
            {
                if(labels.get(p).matches(rt))
                {
                    lineNum= lines.get(p);
                    find = true;
                }
            
                p++;
            };
            
            distance = lineNum - (g + 2); 
            String temp10 = "";
            String temp11 = "";
            
            temp10 = offsetToBinary(distance);
            
            if(distance >= 0)
            {
                for(int k = 0; k < 16 - temp10.length(); k++)
                {
                    temp11 = temp11.concat("0");
                }
            
                temp11 = temp11.concat(temp10);
            }
               
            else
            {
                for(int m = 16; m < 32; m++)
                {
                    temp11 = temp11.concat(Character.toString(temp10.charAt(m)));
                }
            }
            
            opcodeBinary = opcodeBinary.concat(generateBinary(rd));
            opcodeBinary = opcodeBinary.concat(generateBinary(rs));
            opcodeBinary = opcodeBinary.concat(temp11);
            this.generateHex(opcodeBinary);
                 
            opcodeTbl.setValueAt(opcodeHex, g, 1);
        }
        
        else System.out.println("Instruction not available");
    }
    
    public String PCtoHex(int PC)
    {
        String temp = "";
        String hex = "";
        PC *= 4;
        
        temp = Integer.toHexString(PC);
        temp = temp.toUpperCase();
        
        for(int s = 0; s < 16 - temp.length(); s++)
                hex = hex.concat("0");
        
        hex = hex.concat(temp);
        
        return hex;
        
    }
    
    public int HextoPC(String PC)
    {
        int temp = 0;
        
        
        temp = Integer.parseInt(PC, 16);
        
        temp /= 4;
        
        return temp;
    }
    
    public void checkRegValue(String Str)
    {
        Str = Str.toUpperCase();
        
        if(!Str.matches("[0-9A-F]{16}"))
            errorList.add("Invalid Register at R" + p);
        
        
    }
    
    public void checkMemValue(String Str)
    {
        Str = Str.toUpperCase();
        int temp = 0;
        String temp2 = "";
        
        temp = q;
        temp += 8192;
        temp2 = Integer.toHexString(temp);
     
        if(!Str.matches("[0-9A-F]{2}"))
            errorList.add("Invalid at Memory Adress: " + temp2);
        
    }
    
    public int getIndex(String Str) // anong index sa registers yung parameter
    {
        int k = 0;
        for(int i = 0; i < 32; i++)
            if(registers.get(i).getRegNum().matches(Str))
                k = i;
            
       
        return k;
    }
    
    public String getImmediate(String Str)
    {
        String temp = "";
        String temp2 = "";
        int intB = 0;        
        
        for(int i = 4; i < 8; i++)
            temp = temp.concat(Character.toString(Str.charAt(i)));
        
        intB = Integer.valueOf(temp,16 ).shortValue();
        
        for(int s = 0; s < 16 - temp.length(); s++)
        {
            if(intB >= 0)
                temp2 = temp2.concat("0");
        
            else
                temp2 = temp2.concat("F");
        }
        temp2 = temp2.concat(temp);
        
        return temp2;
     
        
    }
    
    
    private void runBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runBtnActionPerformed
            
            System.out.println("The run button was clicked.");

            codeSegment = codeTxtArea.getText(); /*Gets the whole chunk of code*/
            codeSegment = codeSegment.toUpperCase(); /*Capitalizes the code*/

            /*Splitting of whole code to line by line*/
            String str1[] = codeSegment.split("\n");

            if(str1.length > 2048)
            {
                lineValid = false;
            }

            if(lineValid)
            {
                System.out.println("This is the code segment:\n" + codeSegment);

                this.getLabels(codeSegment); /*Being used for checking BC/BEQC*/

                /*Prints the content of every index in array str1[]*/
                System.out.println("\nThis is the code segment after splitting: ");

                for(int a = 0; a < str1.length; a++)
                {
                    System.out.println("Line number " + (a + 1) + ": " + str1[a]);
                }

                System.out.println("Total number of lines: " + str1.length); /*str1.length contains the total number of lines*/

                totLines = str1.length;
                
                /*This loop is used for error checking*/
                for(int b = 0; b < str1.length; b++)
                {
                    this.errorCheck(str1[b]); /*Passes line per line code to check if there are errors*/
                }
            } 

            else errorList.add("Code out of bounds.");
            
           if(!registerTable.getValueAt(0,1).toString().matches("0000000000000000"))
                    errorList.add("Invalid Register at R0"); 
            
            for(p = 1; p < 32; p++)
            {
                    
                String temp = "";
                
                temp = registerTable.getValueAt(p, 1).toString();
                
                this.checkRegValue(temp);
                
            }
            
            for(q = 0; q < 700; q++)
            {
                String temp = "";
                
                temp = memoryTable.getValueAt(q, 1).toString();
                
                this.checkMemValue(temp);
                
            }
            
            

            /*Displays all errors*/
            if(!errorList.isEmpty())
            {
                System.out.println("\nWarning!\n");

                for(int c = 0; c < errorList.size(); c++)
                {
                    System.out.println(errorList.get(c));
                    errorGUI.errorTxtArea.setText(errorGUI.errorTxtArea.getText() + errorList.get(c) + "\n");
                }

                errorGUI.setVisible(true);
            }

            /*Get opcode*/
            if(errorList.isEmpty())
            {
                int d = 0;

                for(int e = 0; e < str1.length; e++)
                {
                    this.generateCodes(str1[e]); /*Passes line per line code to check if there are errors*/
                }

                for(g = 0; g < str1.length; g++)
                {
                    opcodeTbl.setValueAt(codes.get(g), g, 3);
                    this.generateOpcode(str1[g]);

                    if(d < lines.size())
                    {
                        if(lines.get(d) - 1 == g)
                        {
                            opcodeTbl.setValueAt(labels.get(d), g, 2);
                            d++;
                        }
                    }
                }
                
                /*Store into instruction arraylist*/
                for(int t = 0; t < str1.length; t++)
                {
                    /*If there is an instruction in a row*/
                    if(!opcodeTbl.getValueAt(t, 1).toString().equals("00000000"))
                    {
                        rd1 = "";
                        rs1 = "";
                        rt1 = "";
                        instCode = "";
                        pcNum = "";
                        hexCode = "";
                        label1 = "";
                            
                        code1 = opcodeTbl.getValueAt(t, 3).toString(); /*Converts first object to string*/
                        instCode = instCode.concat(this.splitInstruction(code1));
                        
                        rd1 = rd;
                        rs1 = rs;
                        rt1 = rt;
                           
                        pcNum = opcodeTbl.getValueAt(t, 0).toString(); /*Converts PC (Object) to String*/
                        hexCode = opcodeTbl.getValueAt(t, 1).toString(); /*Converts hex opcode (Object) to String*/
                        
                        if(opcodeTbl.getValueAt(t, 2) != null)
                            label1 = opcodeTbl.getValueAt(t, 2).toString(); /*Converts label (Object) to String*/
                        
                        else label1 = label1.concat("null");
                        
                        instructions.add(new Instruction(pcNum, hexCode, label1, instCode, rd1, rs1, rt1));
                    }
                }
                
                for(int v = 0; v < instructions.size(); v++)
                {
                    System.out.println("\n");
                    System.out.println("This is the PC: "           + "\t\t"    + instructions.get(v).getPC());
                    System.out.println("This is the hex opcode: "   + "\t"      + instructions.get(v).getOpcodeHex());
                    System.out.println("This is the label: "        + "\t\t"    + instructions.get(v).getLabel());
                    System.out.println("This is the instruction: "  + "\t"      + instructions.get(v).getOpInst());
                    System.out.println("This is the RD: "           + "\t\t"    + instructions.get(v).getRD());
                    System.out.println("This is the RS: "           + "\t\t"    + instructions.get(v).getRS());
                    System.out.println("This is the RT: "           + "\t\t"    + instructions.get(v).getRT());
                }
                
                /*Stores values of register in register class*/
                for(int w = 0; w < 32; w++)
                {
                    regNumber = "";
                    tempReg = "";
                    tempReg1 = "";
                    regVal = "";

                    regNumber = registerTable.getValueAt(w, 0).toString(); /*Converts register (Object) to string*/
                    
                    regVal = registerTable.getValueAt(w, 1).toString();
                    
                    registers.add(new Register(regNumber, regVal));
                }
                /*
                for(int x = 0; x < registers.size(); x++)
                {
                    System.out.println("\n");
                    System.out.println("This is the register number: "  + "\t"  + registers.get(x).getRegNum());
                    System.out.println("This is the register value: "   + "\t"  + registers.get(x).getRegValue());
                }
                */
 ///////////////////////////////////CYCLES////////////////////////////////////////////////////////////
              do
              {
                //Start of Cycle
                Cycles cycle = new Cycles();
                
                if(stall == false && CC > 0 && totLines >= 2)
                {
                    String rd = "";
                    String r1 = "";
                    String r2 = "";
                    String andrea = "";
                    String alex = "";
                    int insIndex = 0;

                    insIndex =  PC - 1;

                    if(insIndex >= 0)
                    {
                        rd = instructions.get(insIndex).getRD();
                        alex = instructions.get(insIndex).getOpInst();
                    }


                    if(!alex.matches("SD") && !rd.matches("R0") && !alex.matches("BEQC")) //walang data hazard kapag SD
                    {
                        if(insIndex + 1 < totLines)
                        {   
                            andrea = instructions.get(insIndex + 1).getOpInst();

                            if(andrea.matches("BEQC"))
                            {
                                r1 = instructions.get(insIndex + 1).getRD();
                                r2 = instructions.get(insIndex + 1).getRS();
                            }


                            else if(andrea.matches("SD"))
                            {
                                r1 = instructions.get(insIndex + 1).getRD();
                                r2 = instructions.get(insIndex + 1).getRT();
                            }

                            else if(andrea.matches("LD"))
                            {
                                r1 = "";
                                r2 = instructions.get(insIndex + 1).getRT();
                            }

                            else
                            {
                                r1 = instructions.get(insIndex + 1).getRS();
                                r2 = instructions.get(insIndex + 1).getRT();

                            }

                            if(rd.equals(r1) || rd.equals(r2))
                            {
                                dCtr = 3;
                                dHazard = true;
                            }

                        }

                        if(stall == false && insIndex + 2 < totLines)
                        {
                            andrea = instructions.get(insIndex + 2).getOpInst();

                            if(andrea.matches("BEQC"))
                            {
                                r1 = instructions.get(insIndex + 2).getRD();
                                r2 = instructions.get(insIndex + 2).getRS();
                            }


                            else if(andrea.matches("SD"))
                            {
                                r1 = instructions.get(insIndex + 2).getRD();
                                r2 = instructions.get(insIndex + 2).getRT();
                            }

                            else if(andrea.matches("LD"))
                            {
                                r1 = "";
                                r2 = instructions.get(insIndex + 2).getRT();
                            }

                            else
                            {
                                r1 = instructions.get(insIndex + 2).getRS();
                                r2 = instructions.get(insIndex + 2).getRT();

                            }

                            if(rd.equals(r1) || rd.equals(r2))
                            {
                                dCtr = 2;
                                dHazard = true;
                            }

                        }

                        if(stall == false && insIndex + 3 < totLines)
                        {
                            andrea = instructions.get(insIndex + 3).getOpInst();

                            if(andrea.matches("BEQC"))
                            {
                                r1 = instructions.get(insIndex + 3).getRD();
                                r2 = instructions.get(insIndex + 3).getRS();
                            }


                            else if(andrea.matches("SD"))
                            {
                                r1 = instructions.get(insIndex + 3).getRD();
                                r2 = instructions.get(insIndex + 3).getRT();
                            }

                            else if(andrea.matches("LD"))
                            {
                                r1 = "";
                                r2 = instructions.get(insIndex + 3).getRT();
                            }

                            else
                            {
                                r1 = instructions.get(insIndex + 3).getRS();
                                r2 = instructions.get(insIndex + 3).getRT();

                            }

                            if(rd.equals(r1) || rd.equals(r2))
                            {
                                dCtr = 1;
                                dHazard = true;
                            }

                        }

                    }   
                 }
                 
 /////////////////////////////////Start of IF//////////////////////////////////
                if(PC < totLines && stall == false)
                {
                    cycle.setIFInstNum(PC);
                    cycle.setIFID_PC(Integer.toString(PC));

                    IFID_IR = instructions.get(PC).getOpcodeHex();
                    IFID_NPC = this.PCtoHex(PC+1);
                        
                    cycle.setIF_IR(IFID_IR);
                    cycle.setIF_NPC(IFID_NPC);
                    cycle.setIF(true);
                    PC++;
                }
               
                //END OF IF
             /*
            if(cHazard == false)
            {
                    
            String control = "";
            int insIndex2 = 0;
            
            insIndex2 = cycle.getIFInstNum();
            
            control = instructions.get(insIndex2).getOpInst();
            
            if(control.equals("BEQC") || control.equals("BC"))
            {
                cHazard = true;
                tempPC = PC;
                
                
            }
            
            } 
                    
            cycle.setcHazard(cHazard); */
           
             
                if(CC - 1 >= 0)
                {
 /////////////////////////////////Start of ID//////////////////////////////////
                  
                    if(cycles.get(CC - 1).getIF() && stall == false) // IF NAG FETCH NA
                    {
                        int currInst = 0;
                        String RS = ""; // kinukuha kung ano yung A
                        String RT = "";
                        String Imm = "";
                        String Str = "";
                        String Opcode = "";
                        int index = 0;
                        
                        currInst = cycles.get(CC-1).getIFInstNum(); // kinukuha kung anong instruction index
                        cycle.setIDInstNum(currInst);
                        
                        Str = instructions.get(currInst).getOpInst();
                        
                        if(Str.matches("DADDU") || Str.matches("DMULU") || Str.matches("DMUHU") ||
                           Str.matches("SLT") || Str.matches("SELEQZ"))
                        {
                            RS = instructions.get(currInst).getRS(); 
                            index = this.getIndex(RS);
                            IDEX_A = registers.get(index).getRegValue();
                            cycle.setIDEX_A(IDEX_A);

            
            
                            RT = instructions.get(currInst).getRT();
                            index = this.getIndex(RT);
                            IDEX_B = registers.get(index).getRegValue();
                            cycle.setIDEX_B(IDEX_B);
            
            
                        }
        
                        else if(Str.matches("BEQC"))
                        {
                            RS = instructions.get(currInst).getRD(); 
                            index = this.getIndex(RS);
                            IDEX_A = registers.get(index).getRegValue();
                            cycle.setIDEX_A(IDEX_A);
                        
                            RT = instructions.get(currInst).getRS();
                            index = this.getIndex(RT);
                            IDEX_B = registers.get(index).getRegValue();
                            cycle.setIDEX_B(IDEX_B);
            
                        }
        
                        else if(Str.matches("LD") | Str.matches("SD"))
                        {
                            RS = instructions.get(currInst).getRT(); 
                            index = this.getIndex(RS);
                            IDEX_A = registers.get(index).getRegValue();
                            cycle.setIDEX_A(IDEX_A);
                        
                            RT = instructions.get(currInst).getRD();
                            index = this.getIndex(RT);
                            IDEX_B = registers.get(index).getRegValue();
                            cycle.setIDEX_B(IDEX_B);
            
                        }
        
                        else if(Str.matches("DADDIU"))
                        {
                            RS = instructions.get(currInst).getRS(); 
                            index = this.getIndex(RS);
                            IDEX_A = registers.get(index).getRegValue();
                            cycle.setIDEX_A(IDEX_A);
                        
                            RT = instructions.get(currInst).getRD();
                            index = this.getIndex(RT);
                            IDEX_B = registers.get(index).getRegValue();
                            cycle.setIDEX_B(IDEX_B);
            
                        }
                        
                        else if(Str.matches("BC"))
                        {
                            String temp = "";
                            String binAddr = "";
                            String temp2 = "";
                            String temp3 = "";
                            int num1 = 0;
                            int num2 = 0;
                           
                                    
                            Opcode = instructions.get(currInst).getOpcodeHex();
                            
                            binAddr = Long.toBinaryString((Long.parseLong(Opcode, 16)));
                            
                            for(int i =0; i< 32 - binAddr.length(); i++)
                                temp = temp.concat("0");
                            
                            temp = temp.concat(binAddr);
                            
                            
                            for(int f = 6; f < 11; f++)
                                temp2 = temp2.concat(Character.toString(temp.charAt(f)));
            
                            
                            for(int f = 11; f < 16; f++)
                                temp3 = temp3.concat(Character.toString(temp.charAt(f)));
                            
                            
                            num1 = Integer.parseInt(temp2, 2);
                            num2 = Integer.parseInt(temp3, 2);
                            
                            RS = "R";
                            RT = "R";
                            
                            RS = RS.concat(Integer.toString(num1));
                            RT = RT.concat(Integer.toString(num2));
                            
                            index = this.getIndex(RS);
                            IDEX_A = registers.get(index).getRegValue();
                            cycle.setIDEX_A(IDEX_A);
                            
                            index = this.getIndex(RT);
                            IDEX_B = registers.get(index).getRegValue();
                            cycle.setIDEX_B(IDEX_B);
                          
      
                        }
                        
                        
                        
                        if(CC-2 >= 0)
                        {
                            if(cycles.get(CC-2).getdHazard() == true)
                            {
                                IDEX_NPC = cycles.get(CC-1).getIFID_NPC();
                                IDEX_IR = cycles.get(CC-1).getIFID_IR();
                                IDEX_IMM = this.getImmediate(cycles.get(CC-1).getIFID_IR());
                                
                            }
                            
                        }
                        
                        else
                        {
                            IDEX_IMM = this.getImmediate(cycles.get(CC-1).getIF_IR());
                            IDEX_NPC = cycles.get(CC-1).getIF_NPC();
                            IDEX_IR = cycles.get(CC-1).getIF_IR();
                        }
                        cycle.setIDEX_IMM(IDEX_IMM);        
                        cycle.setIDEX_NPC(IDEX_NPC);
                        cycle.setIDEX_IR(IDEX_IR);
                        
                        cycle.setID(true);
                       
                    }
                    
                   
                    //END NG ID
                  
                    

 /////////////////////////////////Start of EX//////////////////////////////////                  
                    if(cycles.get(CC - 1).getID())
                    {
                        int currInst = 0; 
                        String Str = ""; // eto yung instruction ex: "DADDU"
                        
                        currInst = cycles.get(CC-1).getIDInstNum();
                        cycle.setEXInstNum(currInst);
                        
                        Str = instructions.get(currInst).getOpInst();
                        
                    if(Str.matches("DADDU"))
                    {
                        long intA = 0;
                        long intB = 0;
                        long ans = 0;
                        String strA = "";
                        String strB = "";
                        String temp = "";
                        String temp2 = "";
            
                        strA = cycles.get(CC-1).getIDEX_A();
                        strB = cycles.get(CC-1).getIDEX_B();
            
                        intA = Long.parseUnsignedLong(strA, 16);
                        intB = Long.parseUnsignedLong(strB, 16);
            
                        ans = intA + intB;
            
                        temp = Long.toHexString(ans);
                        temp = temp.toUpperCase();
            
                        for(int s = 0; s < 16 - temp.length(); s++)
                            temp2 = temp2.concat("0");
            
            
                        temp2 = temp2.concat(temp);
            
                        EXMEM_ALUOUTPUT = temp2;
                        cycle.setEXMEM_ALU(EXMEM_ALUOUTPUT);
                        EXMEM_IR = cycles.get(CC-1).getIDEX_IR();
                        cycle.setEXMEM_IR(EXMEM_IR);
                        EXMEM_COND = "0";
                        cycle.setEXMEM_COND(EXMEM_COND);
                        cycle.setEXMEM_B(cycles.get(CC-1).getIDEX_B());

                    }
                    else if(Str.matches("DADDIU"))
                    {
                        long intA = 0;
                        long intB = 0;
                        long ans = 0;
                        String strA = "";
                        String strB = "";
                        String temp = "";
                        String temp2 = "";

                        strA = cycles.get(CC-1).getIDEX_A();
                        strB = cycles.get(CC-1).getIDEX_IMM();

                        intA = Long.parseUnsignedLong(strA, 16);
                        intB = Long.parseUnsignedLong(strB, 16);

                        ans = intA + intB;

                        temp = Long.toHexString(ans);
                        temp = temp.toUpperCase();

                        for(int s = 0; s < 16 - temp.length(); s++)
                            temp2 = temp2.concat("0");

                        temp2 = temp2.concat(temp);

                        EXMEM_ALUOUTPUT = temp2;
                        cycle.setEXMEM_ALU(EXMEM_ALUOUTPUT);
                        EXMEM_IR = cycles.get(CC-1).getIDEX_IR();
                        cycle.setEXMEM_IR(EXMEM_IR);
                        EXMEM_COND = "0";
                        cycle.setEXMEM_COND(EXMEM_COND);
                        
                        cycle.setEXMEM_B(cycles.get(CC-1).getIDEX_B());
                    }

                    else if(Str.matches("DMULU"))
                    {
                        long intA = 0;
                        long intB = 0;
                        long ans = 0;
                        String strA = "";
                        String strB = "";
                        String temp = "";
                        String temp2 = "";

                        strA = cycles.get(CC-1).getIDEX_A();
                        strB = cycles.get(CC-1).getIDEX_B();

                        intA = Long.parseUnsignedLong(strA, 16);
                        intB = Long.parseUnsignedLong(strB, 16);

                        ans = intA * intB;

                        temp = Long.toHexString(ans);
                        temp = temp.toUpperCase();

                        for(int s = 0; s < 16 - temp.length(); s++)
                            temp2 = temp2.concat("0");


                        temp2 = temp2.concat(temp);

                        EXMEM_ALUOUTPUT = temp2;
                        cycle.setEXMEM_ALU(EXMEM_ALUOUTPUT);
                        EXMEM_IR = cycles.get(CC-1).getIDEX_IR();
                        cycle.setEXMEM_IR(EXMEM_IR);
                        EXMEM_COND = "0";
                        cycle.setEXMEM_COND(EXMEM_COND);
                        
                        cycle.setEXMEM_B(cycles.get(CC-1).getIDEX_B());

                    }

                    else if(Str.matches("DMUHU"))
                    {
                        long intA = 0;
                        long intB = 0;
                        long ans = 0;
                        String strA = "";
                        String strB = "";
                        String temp = "";
                        String temp2 = "";

                        strA = cycles.get(CC-1).getIDEX_A();
                        strB = cycles.get(CC-1).getIDEX_B();

                        intA = Long.parseUnsignedLong(strA, 16);
                        intB = Long.parseUnsignedLong(strB, 16);

                        ans = intA * intB;

                        if(ans >= 0)
                            temp2 = temp2.concat("0000000000000000");
                        else
                            temp2 = temp2.concat("FFFFFFFFFFFFFFFF");

                        EXMEM_ALUOUTPUT = temp2;
                        cycle.setEXMEM_ALU(EXMEM_ALUOUTPUT);
                        EXMEM_IR = cycles.get(CC-1).getIDEX_IR();
                        cycle.setEXMEM_IR(EXMEM_IR);
                        EXMEM_COND = "0";
                        cycle.setEXMEM_COND(EXMEM_COND);
                        
                        cycle.setEXMEM_B(cycles.get(CC-1).getIDEX_B());

                    }
                    else if(Str.matches("SLT"))
                    {
                        long intA = 0;
                        long intB = 0;
                        long ans = 0;
                        String strA = "";
                        String strB = "";
                        String temp = "";
                        String temp2 = "";

                        strA = cycles.get(CC-1).getIDEX_A();
                        strB = cycles.get(CC-1).getIDEX_B();

                        intA = Long.parseUnsignedLong(strA, 16);
                        intB = Long.parseUnsignedLong(strB, 16);

                        if(intA < intB)
                            temp2 = temp2.concat("0000000000000001");
                        else
                            temp2 = temp2.concat("0000000000000000");

                        EXMEM_ALUOUTPUT = temp2;
                        cycle.setEXMEM_ALU(EXMEM_ALUOUTPUT);
                        EXMEM_IR = cycles.get(CC-1).getIDEX_IR();
                        cycle.setEXMEM_IR(EXMEM_IR);
                        EXMEM_COND = "0";
                        cycle.setEXMEM_COND(EXMEM_COND);
                        
                        cycle.setEXMEM_B(cycles.get(CC-1).getIDEX_B());
                    }
                    else if(Str.matches("SELEQZ"))
                    {
                        long intA = 0;
                        long intB = 0;
                        long ans = 0;
                        String strA = "";
                        String strB = "";
                        String temp = "";
                        String temp2 = "";

                        strA = cycles.get(CC-1).getIDEX_A();
                        strB = cycles.get(CC-1).getIDEX_B();

                        intA = Long.parseUnsignedLong(strA, 16);
                        intB = Long.parseUnsignedLong(strB, 16);

                        if(intB == 0)
                            temp2 = strA;
                        else
                            temp2 = "0000000000000000";

                        EXMEM_ALUOUTPUT = temp2;
                        cycle.setEXMEM_ALU(EXMEM_ALUOUTPUT);
                        EXMEM_IR = cycles.get(CC-1).getIDEX_IR();
                        cycle.setEXMEM_IR(EXMEM_IR);
                        EXMEM_COND = "0";
                        cycle.setEXMEM_COND(EXMEM_COND);
                        
                        cycle.setEXMEM_B(cycles.get(CC-1).getIDEX_B());

                    }

                    else if(Str.matches("LD") || Str.matches("SD"))
                    {
                        long intA = 0;
                        long intB = 0;
                        long ans = 0;
                        String strA = "";
                        String strB = "";
                        String temp = "";
                        String temp2 = "";

                        strA = cycles.get(CC-1).getIDEX_A();
                        strB = cycles.get(CC-1).getIDEX_IMM();

                        intA = Long.parseUnsignedLong(strA, 16);
                        intB = Long.parseUnsignedLong(strB, 16);

                        ans = intA + intB;

                        temp = Long.toHexString(ans);
                        temp = temp.toUpperCase();

                        for(int s = 0; s < 16 - temp.length(); s++)
                            temp2 = temp2.concat("0");

                        temp2 = temp2.concat(temp);

                        EXMEM_ALUOUTPUT = temp2;
                        cycle.setEXMEM_ALU(EXMEM_ALUOUTPUT);
                        EXMEM_IR = cycles.get(CC-1).getIDEX_IR();
                        cycle.setEXMEM_IR(EXMEM_IR);
                        EXMEM_COND = "0";
                        cycle.setEXMEM_COND(EXMEM_COND);
                        EXMEM_B = cycles.get(CC-1).getIDEX_B();
                        cycle.setEXMEM_B(EXMEM_B);


                    }

                    else if(Str.matches("BEQC"))
                    {
                        long intA = 0;
                        long intB = 0;
                        long ans = 0;
                        String strA = "";
                        String strB = "";
                        String temp = "";
                        String temp2 = "";

                        strA = cycles.get(CC-1).getIDEX_NPC();
                        strB = cycles.get(CC-1).getIDEX_IMM();

                        intA = Long.parseUnsignedLong(strA, 16);
                        intB = Long.parseUnsignedLong(strB, 16);

                        intB *= 4;

                        ans = intA + intB;

                        temp = Long.toHexString(ans);
                        temp = temp.toUpperCase();

                        for(int s = 0; s < 16 - temp.length(); s++)
                            temp2 = temp2.concat("0");

                        temp2 = temp2.concat(temp);

                        EXMEM_ALUOUTPUT = temp2;
                        cycle.setEXMEM_ALU(EXMEM_ALUOUTPUT);
                        EXMEM_OPCODE = "001000";
                        cycle.setEXMEM_OPCODE(EXMEM_OPCODE);
                        

                        strA = cycles.get(CC-1).getIDEX_A();
                        strB = cycles.get(CC-1).getIDEX_B();

                        long intC = Long.parseUnsignedLong(strA, 16);
                        long intD = Long.parseUnsignedLong(strB, 16);

                        if(intC == intD)
                            EXMEM_COND = "1";
                        else
                            EXMEM_COND = "0";

                        EXMEM_B = cycles.get(CC-1).getIDEX_B();
                        EXMEM_IR = cycles.get(CC-1).getIDEX_IR();
                        cycle.setEXMEM_COND(EXMEM_COND);
                        cycle.setEXMEM_IR(EXMEM_IR);
                        cycle.setEXMEM_B(EXMEM_B);
                        

                    }
                    else if(Str.matches("BC"))
                    {
                        long intA = 0;
                        long intB = 0;
                        long ans = 0;
                        String strA = "";
                        String strB = "";
                        String temp = "";
                        String temp2 = "";

                        strA = cycles.get(CC-1).getIDEX_NPC();
                        strB = cycles.get(CC-1).getIDEX_IMM();

                        intA = Long.parseUnsignedLong(strA, 16);
                        intB = Long.parseUnsignedLong(strB, 16);

                        intB *= 4;

                        ans = intA + intB;

                        temp = Long.toHexString(ans);
                        temp = temp.toUpperCase();

                        for(int s = 0; s < 16 - temp.length(); s++)
                            temp2 = temp2.concat("0");

                        temp2 = temp2.concat(temp);

                        EXMEM_ALUOUTPUT = temp2;
                        cycle.setEXMEM_ALU(EXMEM_ALUOUTPUT);
                        EXMEM_COND = "1";
                        cycle.setEXMEM_COND(EXMEM_COND);
                        
                        EXMEM_OPCODE = "110010";
                        cycle.setEXMEM_OPCODE(EXMEM_OPCODE);

                        
                        EXMEM_B = cycles.get(CC-1).getIDEX_B();
                        EXMEM_IR = cycles.get(CC-1).getIDEX_IR();
                        cycle.setEXMEM_COND(EXMEM_COND);
                        cycle.setEXMEM_IR(EXMEM_IR);
                        cycle.setEXMEM_B(EXMEM_B);
                    }
                        
                        cycle.setEX(true);
                    }
                    //END NG EX
                    
/////////////////////////////////Start of MEM//////////////////////////////////
                    if(cycles.get(CC - 1).getEX())
                    {
                        
                        int currInst = 0;
                        String Str = "";
                        
                        currInst = cycles.get(CC-1).getEXInstNum();
                        cycle.setMEMInstNum(currInst);
                        
                        Str = instructions.get(currInst).getOpInst();
                        
                        if(Str.matches("LD"))
                        {
                            String temp = "";
                            long num1 = 0;
                            String temp2 = "";
                            
                            
                            MEMWB_IR = cycles.get(CC-1).getEXMEM_IR();
                            cycle.setMEMWB_IR(MEMWB_IR);
                            
                            temp = cycles.get(CC-1).getEXMEM_ALU();
                            
                            num1 = Long.parseLong(temp,16);
                            
                            num1 -= 8192;
                            num1 += 7;
                            
                           
                            for(int i = 0; i < 8; i++)
                                temp2 = temp2.concat(memoryTable.getValueAt((int)num1 - i, 1).toString());
                            
                            MEMWB_LMD = temp2;
                            cycle.setMEMWB_LMD(MEMWB_LMD);
                            cycle.setMEMWB_ALUOUTPUT(cycles.get(CC-1).getEXMEM_ALU());
                            
                        }
                        
                        else if(Str.matches("SD"))
                        {
                            String temp = "";
                            String temp2 = "";
                            String temp3 = "";
                            long num1 = 0;
                            int start = 0;
                            int end = 2;
                            
                            
                            MEMWB_IR = cycles.get(CC-1).getEXMEM_IR();
                            cycle.setMEMWB_IR(MEMWB_IR);
                            
                            temp = cycles.get(CC-1).getEXMEM_ALU();
                            temp2 = cycles.get(CC-1).getEXMEM_B();
                            
                            
                            num1 = Long.parseLong(temp,16);
                             
                            num1 -= 8192;
                            num1 += 7;
                            
                            
                            for(int i = 0; i < 8; i++)
                            {
                                temp3 = temp2.substring(start, end);
                                memoryTable.setValueAt(temp3, (int)num1 -i, 1);
                                start += 2;
                                end += 2;
                                
                            }
                            
                            cycle.setMEMWB_ALUOUTPUT(cycles.get(CC-1).getEXMEM_ALU());
                            cycle.setMEMWB_RANGE(temp2);
                            
                        }
                        
                        else
                        {
                            MEMWB_IR = cycles.get(CC-1).getEXMEM_IR();
                            cycle.setMEMWB_IR(MEMWB_IR);
                            MEMWB_ALUOUTPUT = cycles.get(CC-1).getEXMEM_ALU();
                            cycle.setMEMWB_ALUOUTPUT(MEMWB_ALUOUTPUT);
                           
                        }
                        
                        cycle.setMEM(true);
                    }
                        //END OF MEM
                        
/////////////////////////////////Start of WB//////////////////////////////////                    
                        if(cycles.get(CC-1).getMEM())
                        {
                            int currInst = 0;
                            String Str = "";
                        
                            currInst = cycles.get(CC-1).getMEMInstNum();
                            cycle.setWBInstNum(currInst);

                            Str = instructions.get(currInst).getOpInst();
                            
                            if(Str.matches("LD"))
                            {
                               String RD = "";
                               int index = 0;
                               String temp = "";
                               
                               RD = instructions.get(currInst).getRD(); 
                               index = this.getIndex(RD);
                                
                               temp = cycles.get(CC-1).getMEMWB_LMD();
                               
                               if(!RD.equals("R0"))
                               {
                               registerTable.setValueAt(temp, index, 1);
                               registers.get(index).setRegValue(temp);
                               }
                               
                               cycle.setWB_RN(RD);
                                
                            }
                            else if(Str.matches("DADDIU"))
                            {
                                
                               String RD = "";
                               int index = 0;
                               String temp = "";
                               
                               RD = instructions.get(currInst).getRD(); 
                               index = this.getIndex(RD);
                                
                               temp = cycles.get(CC-1).getMEMWB_ALUOUTPUT();
                               
                               if(!RD.equals("R0"))
                               {
                               registerTable.setValueAt(temp, index, 1);
                               registers.get(index).setRegValue(temp);
                               }
                               
                               cycle.setWB_RN(RD);
                                
                            }
                            else if(Str.matches("DADDU") || Str.matches("DMULU") ||
                                    Str.matches("DMUHU") || Str.matches("SLT") || 
                                    Str.matches("SELEQZ"))
                            {
                               String RD = "";
                               int index = 0;
                               String temp = "";
                               
                               RD = instructions.get(currInst).getRD(); 
                               index = this.getIndex(RD);
                               
                               temp = cycles.get(CC-1).getMEMWB_ALUOUTPUT();
                               
                               if(!RD.equals("R0"))
                               {
                               registerTable.setValueAt(temp, index, 1);
                               registers.get(index).setRegValue(temp);
                               }
                               cycle.setWB_RN(RD);
                               
                               
                            }
                            
                            currInst++;
                            
                            if(currInst == totLines)
                                isDone = true;
                            
                            cycle.setWB(true);
                            
                            
                            
                        }
                    
                }
                
                if(cycle.getWB() && cycles.get(CC-1).getdHazard() == true)
                {
                    int PCnum = 0;
                    
                    PCnum = cycles.get(CC-dCtr).getIFInstNum();
                    cycle.setIFInstNum(PCnum);
                    IFID_IR = instructions.get(PCnum).getOpcodeHex();
                    IFID_NPC = this.PCtoHex(PCnum + 1);
                    
                    cycle.setIFID_IR(IFID_IR);
                    cycle.setIFID_NPC(IFID_NPC);
                    cycle.setIF(true);
                    
                }
                
                
                if(stall == true)
                    stallCtr++;
                if(stallCtr == dCtr)
                {
                    dHazard = false;
                    stallCtr = 0;
                }
                
                stall = dHazard;
                cycle.setdHazard(dHazard);
                
                cycles.add(cycle);
                CC++;
   
              }while(isDone == false);
                
              for(int a = 0 ; a < cycles.size(); a++)
        {
            System.out.println("Cycle No. "             + (a + 1));
            System.out.println( "\n"    +   "IF/ID.IR:"              + "\t\t"   + cycles.get(a).getIF_IR());
            System.out.println("IF/ID.NPC:"             + "\t\t"   + cycles.get(a).getIF_NPC());
            System.out.println("PC:"                    + "\t\t"   + cycles.get(a).getIFID_PC());
            
            System.out.println("\n\n"  +   "ID/EX.A:"               + "\t\t"   + cycles.get(a).getIDEX_A());
            System.out.println("ID/EX.B:"               + "\t\t"   + cycles.get(a).getIDEX_B());
            System.out.println("ID/EX.Imm:"             + "\t\t"   + cycles.get(a).getIDEX_IMM());
            System.out.println("ID/EX.NPC:"             + "\t\t"   + cycles.get(a).getIDEX_NPC());
            System.out.println("ID/EX.IR:"              + "\t\t"   + cycles.get(a).getIDEX_IR());

            System.out.println("\n\n"  +   "EX/MEM.ALUOutput:"      + "\t"     + cycles.get(a).getEXMEM_ALU());
            System.out.println("EX/MEM.B:"              + "\t\t"   + cycles.get(a).getEXMEM_B());
            System.out.println("EX/MEM.COND:"           + "\t"     + cycles.get(a).getEXMEM_COND());
            System.out.println("EX/MEM.IR:"             + "\t\t"   + cycles.get(a).getEXMEM_IR());

            System.out.println("\n\n"  +   "MEM/WB.IR:"             + "\t\t"   + cycles.get(a).getMEMWB_IR());
            System.out.println("MEM/WB.LMD:"            + "\t\t"   + cycles.get(a).getMEMWB_LMD());
            System.out.println("MEM/WB.ALUOutput:"      + "\t"     + cycles.get(a).getMEMWB_ALUOUTPUT());
            System.out.println("MEM[ALUOUTPUT]:"        + "\t"     + cycles.get(a).getMEMWB_RANGE());
            
            
            
            System.out.println("\n\n"  +   "WB.Rn:"                 + "\t\t"   + cycles.get(a).getWB_RN());
            System.out.println("\n\n");
        }
              
                
              
              
           
              
              
              
              
              
              
              
                
            }
    }//GEN-LAST:event_runBtnActionPerformed

    private void fullBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fullBtnActionPerformed
        // TODO add your handling code here:

        for(int a = 0 ; a < cycles.size(); a++)
        {
            cyclesTxtArea.setText(cyclesTxtArea.getText() + "Cycle No. "             + (a + 1));
            cyclesTxtArea.setText(cyclesTxtArea.getText() + "\n"    +   "IF/ID.IR:"              + "\t\t"   + cycles.get(a).getIF_IR());
            cyclesTxtArea.setText(cyclesTxtArea.getText() + "\n"    +   "IF/ID.NPC:"             + "\t\t"   + cycles.get(a).getIF_NPC());
            cyclesTxtArea.setText(cyclesTxtArea.getText() + "\n"    +   "PC:"                    + "\t\t"   + cycles.get(a).getIFID_PC());
            
            cyclesTxtArea.setText(cyclesTxtArea.getText() + "\n\n"  +   "ID/EX.A:"               + "\t\t"   + cycles.get(a).getIDEX_A());
            cyclesTxtArea.setText(cyclesTxtArea.getText() + "\n"    +   "ID/EX.B:"               + "\t\t"   + cycles.get(a).getIDEX_B());
            cyclesTxtArea.setText(cyclesTxtArea.getText() + "\n"    +   "ID/EX.Imm:"             + "\t\t"   + cycles.get(a).getIDEX_IMM());
            cyclesTxtArea.setText(cyclesTxtArea.getText() + "\n"    +   "ID/EX.NPC:"             + "\t\t"   + cycles.get(a).getIDEX_NPC());
            cyclesTxtArea.setText(cyclesTxtArea.getText() + "\n"    +   "ID/EX.IR:"              + "\t\t"   + cycles.get(a).getIDEX_IR());

            cyclesTxtArea.setText(cyclesTxtArea.getText() + "\n\n"  +   "EX/MEM.ALUOutput:"      + "\t"     + cycles.get(a).getEXMEM_ALU());
            cyclesTxtArea.setText(cyclesTxtArea.getText() + "\n"    +   "EX/MEM.B:"              + "\t\t"   + cycles.get(a).getEXMEM_B());
            cyclesTxtArea.setText(cyclesTxtArea.getText() + "\n"    +   "EX/MEM.COND:"           + "\t"     + cycles.get(a).getEXMEM_COND());
            cyclesTxtArea.setText(cyclesTxtArea.getText() + "\n"    +   "EX/MEM.IR:"             + "\t\t"   + cycles.get(a).getEXMEM_IR());

            cyclesTxtArea.setText(cyclesTxtArea.getText() + "\n\n"  +   "MEM/WB.IR:"             + "\t\t"   + cycles.get(a).getMEMWB_IR());
            cyclesTxtArea.setText(cyclesTxtArea.getText() + "\n"    +   "MEM/WB.LMD:"            + "\t\t"   + cycles.get(a).getMEMWB_LMD());
            cyclesTxtArea.setText(cyclesTxtArea.getText() + "\n"    +   "MEM/WB.ALUOutput:"      + "\t"     + cycles.get(a).getMEMWB_ALUOUTPUT());
            cyclesTxtArea.setText(cyclesTxtArea.getText() + "\n"    +   "MEM[ALUOUTPUT]:"        + "\t"     + cycles.get(a).getMEMWB_RANGE());
            
            
            
            cyclesTxtArea.setText(cyclesTxtArea.getText() + "\n\n"  +   "WB.Rn:"                 + "\t\t"   + cycles.get(a).getWB_RN());
            cyclesTxtArea.setText(cyclesTxtArea.getText() + "\n\n");
        }
    }//GEN-LAST:event_fullBtnActionPerformed

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
    private javax.swing.JPanel codePanel;
    private javax.swing.JTextArea codeTxtArea;
    private javax.swing.JPanel cyclesPanel;
    private javax.swing.JTextArea cyclesTxtArea;
    private javax.swing.JButton fullBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextArea mapTxtArea;
    private javax.swing.JPanel memoryPanel;
    private javax.swing.JPanel opcodePanel;
    private javax.swing.JTable opcodeTbl;
    private javax.swing.JPanel pipelinePanel;
    private javax.swing.JPanel registerPanel;
    private javax.swing.JTable registerTable;
    private javax.swing.JButton runBtn;
    private javax.swing.JButton singleBtn;
    // End of variables declaration//GEN-END:variables
}
