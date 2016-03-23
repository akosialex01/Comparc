package minimips;

import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;

import java.util.*;
import java.awt.*;

/**
 *
 * @author Dreyasaur
 */
public class MainFrameGUI extends javax.swing.JFrame 
{
    private ArrayList<String> labels;       /*Arraylist of labels*/
    private ArrayList<String> tempLabels;   /*Arraylist of labels evel invalid*/
    private ArrayList<String> errorList;    /*Arraylist of errors*/
    private ArrayList<String> codes;        /*Arraylist of all valid codes*/
    private ArrayList<Integer> lines;       /*Arraylist of line numbers*/
    
    private String codeSegment = "";            /*Contains the whole code entered*/
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
    
    private int lineNumber = 1;
    private int regNum;
    private int g = 0;
    
    private boolean lineValid = true;
    private boolean labelValid = true;
    private boolean notBlank = true;
    private boolean registerValid = true;
    private boolean immValid = true;
    private boolean offsetValid = true;

    public MainFrameGUI()
    {
        initComponents();
        
        /*Set width of table column*/
        registerTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        registerTable.getColumnModel().getColumn(0).setPreferredWidth(70);
        registerTable.getColumnModel().getColumn(1).setPreferredWidth(175);
        
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
            
            for(int s = 0; s < 4 - addressTemp.length(); s++)
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
        opcodePanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        opcodeTbl = new javax.swing.JTable();
        cyclesPanel = new javax.swing.JPanel();
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
                false, false
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                .addContainerGap())
        );

        memoryPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Memory", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18))); // NOI18N

        javax.swing.GroupLayout memoryPanelLayout = new javax.swing.GroupLayout(memoryPanel);
        memoryPanel.setLayout(memoryPanelLayout);
        memoryPanelLayout.setHorizontalGroup(
            memoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 284, Short.MAX_VALUE)
        );
        memoryPanelLayout.setVerticalGroup(
            memoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pipelinePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pipeline Map", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18))); // NOI18N

        javax.swing.GroupLayout pipelinePanelLayout = new javax.swing.GroupLayout(pipelinePanel);
        pipelinePanel.setLayout(pipelinePanelLayout);
        pipelinePanelLayout.setHorizontalGroup(
            pipelinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pipelinePanelLayout.setVerticalGroup(
            pipelinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 105, Short.MAX_VALUE)
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
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
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

        javax.swing.GroupLayout cyclesPanelLayout = new javax.swing.GroupLayout(cyclesPanel);
        cyclesPanel.setLayout(cyclesPanelLayout);
        cyclesPanelLayout.setHorizontalGroup(
            cyclesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        cyclesPanelLayout.setVerticalGroup(
            cyclesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 270, Short.MAX_VALUE)
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
                .addComponent(jScrollPane2)
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
                    .addComponent(registerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 296, Short.MAX_VALUE)
                    .addComponent(memoryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(opcodePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pipelinePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cyclesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(codePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(opcodePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pipelinePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(registerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cyclesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(memoryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(codePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public String splitInstruction(String codeLine) /*codeLine is the 1-liner code & returns only the instruction without the registers*/
    {
        if(codeLine.matches("([A-Z0-9]*: )*[A-Z]+ [A-Z0-9]+, [A-Z0-9]+, [A-Z0-9#]+") ||         /*For R-Type Instructions, DADDIU, & BEQC*/
           codeLine.matches("([A-Z0-9]*: )*[A-Z]+ [A-Z0-9]+, [A-Z0-9]+ [(][(A-Z0-9)]+[)]") ||   /*For LD and SD*/
           codeLine.matches("([A-Z0-9]*: )*[A-Z]+ [A-Z0-9]+"))                                  /*For BC*/
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
                    
                    else labelValid = false;                             /*If label is already in the list*/
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
                if(!rt.matches("^#[0-9]{1,4}"))
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
            
            for(int f = 0; f < str18[1].length(); f++)
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
            
            /*This loop is used for error checking*/
            for(int b = 0; b < str1.length; b++)
            {
                this.errorCheck(str1[b]); /*Passes line per line code to check if there are errors*/
            }
        } 
        
        else errorList.add("Code out of bounds.");
        
        /*Displays all errors*/
        if(!errorList.isEmpty())
        {
            System.out.println("\nWarning!\n");
            
            for(int c = 0; c < errorList.size(); c++)
            {
                System.out.println(errorList.get(c));
            }
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
        }
    }//GEN-LAST:event_runBtnActionPerformed

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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel memoryPanel;
    private javax.swing.JPanel opcodePanel;
    private javax.swing.JTable opcodeTbl;
    private javax.swing.JPanel pipelinePanel;
    private javax.swing.JPanel registerPanel;
    private javax.swing.JTable registerTable;
    private javax.swing.JButton runBtn;
    // End of variables declaration//GEN-END:variables
}
