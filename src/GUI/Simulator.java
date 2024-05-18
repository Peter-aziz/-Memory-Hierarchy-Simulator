/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hassan
 */
public class Simulator extends javax.swing.JFrame {
DefaultTableModel model;
public static int instances_Counter = 0;
public void PopulateTableini(){

for (int i=0; i < index.size(); i++){
          
model.addRow(new Object[]{index.get(i),valid_bit.get(i),tag.get(i)});
}



}
public void PopulateTable(){
model.addRow(new Object[]{index.get(counter), valid_bit.get(counter),tag.get(counter)});

}
    //Global Var
    int CacheSize, CacheLineSize, Cycles, no_of_lines, counter = 0;
    double index_size,disp,tag_size,hit_count,miss_count;
    ArrayList<String> index;
    ArrayList<String> access_seq_str;
    ArrayList<String> access_seq_bin;
    ArrayList<String> tag = new ArrayList<>(no_of_lines);
    ArrayList<Character> valid_bit;
    // Restart Varibels 
    int CacheSize_rst, CacheLineSize_rst, Cycles_rst;
    ArrayList<String> access_seq_str_rst;

    // Writing policies
    private String writeHitPolicy; // e.g., "write-through" or "write-back"
    private String writeMissPolicy; // e.g., "write-allocate" or "no-write-allocate"

    // Read/Write access information
    private ArrayList<String> accessTypes; // e.g., "read" or "write"
    private ArrayList<Character> dirty_bit;
   
    //Constructer for GUI
    public Simulator(int cachesize, int cachelinesize, int Cyc, ArrayList<String> sequence) {
        initComponents();
        System.out.println("Sequence inside sim:" + sequence + "\n");
  
        model = (DefaultTableModel)table.getModel();
        model.setRowCount(0);
       
        CacheSize = cachesize;
        CacheSize_rst = cachesize;
        CacheLineSize = cachelinesize;
        CacheLineSize_rst = cachelinesize;
        Cycles = Cyc;
        Cycles_rst = Cyc;
        access_seq_str_rst = sequence;
        access_seq_str = sequence;  
        no_of_lines = CacheSize/CacheLineSize;
         index_size = Math.log(no_of_lines) / Math.log(2); 
         disp = Math.log(cachelinesize) / Math.log(2); 
         tag_size = 30 - index_size - disp;
         
        //Tracked parameters 
         hit_count = 0;
         miss_count = 0;
         instrbttn.setVisible(false);
   //     System.out.println("index_size:" + index_size + "\n");
   //     System.out.println("tag_size:" + tag_size + "\n");
       //Index
      index = new ArrayList<String>(no_of_lines); 
        for (int i = 0; i < no_of_lines; i++){
             String binary = Integer.toBinaryString(i);
             index.add(binary);
         //     System.out.println("Index:" + index + "\n");
        }
        
         System.out.println("Index:" + index + "\n");
                int size = (int) index_size;
        for (int i = 0; i < index.size(); i++){
            while (index.get(i).length() < size){
                char prefixChar = '0';
                String element = index.get(i);
                element = prefixChar + element;
                index.set(i, element);
            }   
        }

        //Valid Bit
      valid_bit = new ArrayList<Character>(no_of_lines); 
        for (int i = 0; i < no_of_lines; i++){
             valid_bit.add('N');
        //     System.out.println("Valid bit:" + valid_bit + "\n");  
        }
        //Tag
        for (int i = 0 ; i < no_of_lines; i++){
            tag.add("---");
        }
     //converting access sequence to binary
         access_seq_bin = new ArrayList<>();

        for (int i = 0; i < access_seq_str.size(); i++){
            int element = Integer.parseInt(access_seq_str.get(i));
            String binary = Integer.toBinaryString(element);
            access_seq_bin.add(binary);
        }
        // unifing address size to 30 bits
        for (int i = 0; i < access_seq_bin.size(); i++){
            while (access_seq_bin.get(i).length() < 30){
                char prefixChar = '0';
                String element = access_seq_bin.get(i);
                element = prefixChar + element;
                access_seq_bin.set(i, element);
            }   
        }
        PopulateTableini();
        ProgressBar.setMaximum(access_seq_bin.size());

        // Initialize writing policies
        this.writeHitPolicy = writeHitPolicy;
        this.writeMissPolicy = writeMissPolicy;

        // Initialize read/write access information
        this.accessTypes = accessTypes;

        // Initialize the dirty bit list
        dirty_bit = new ArrayList<>(no_of_lines);
        for (int i = 0; i < no_of_lines; i++) {
            dirty_bit.add('N'); // 'N' for clean
    }

    }
     public Simulator() {
        initComponents();
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        AMAT = new javax.swing.JTextField();
        Hit_Ratio1 = new javax.swing.JTextField();
        Miss_Ratio1 = new javax.swing.JTextField();
        Accesses = new javax.swing.JTextField();
        Bi_addr = new javax.swing.JTextField();
        HitMiss1 = new javax.swing.JTextField();
        Next = new javax.swing.JToggleButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        ProgressBar = new javax.swing.JProgressBar();
        instrbttn = new javax.swing.JButton();

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setText("Memory Hierarchy ");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MHS Simulator ");
        setAlwaysOnTop(true);
        setResizable(false);

        table.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Index", "Valid Bit ", "Tag"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setResizable(false);
            table.getColumnModel().getColumn(1).setResizable(false);
            table.getColumnModel().getColumn(2).setResizable(false);
        }

        jPanel1.setBackground(new java.awt.Color(51, 102, 0));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ram_1.png"))); // NOI18N

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Memory Hiearchy Simulator ");

        jButton1.setBackground(new java.awt.Color(102, 102, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Exit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(102, 102, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Restart");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ram_1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel8)
                .addGap(60, 60, 60)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2))
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(32, 32, 32))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Hit Ratio : ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Miss Ratio : ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("AMAT : ");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Accesses:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Hit/Miss");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Binary Address : ");

        AMAT.setEditable(false);

        Hit_Ratio1.setEditable(false);

        Miss_Ratio1.setEditable(false);

        Accesses.setEditable(false);

        Bi_addr.setEditable(false);

        HitMiss1.setEditable(false);
        HitMiss1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        Next.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Next.setText("Next ");
        Next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextActionPerformed(evt);
            }
        });

        instrbttn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        instrbttn.setText("Run Instruction File");
        instrbttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                instrbttnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(HitMiss1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Bi_addr, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(instrbttn)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 791, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Next, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel4))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Accesses)
                                            .addComponent(Hit_Ratio1)
                                            .addComponent(AMAT)
                                            .addComponent(Miss_Ratio1)))
                                    .addComponent(jSeparator1)
                                    .addComponent(jSeparator2))
                                .addContainerGap())
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(Hit_Ratio1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(Miss_Ratio1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(AMAT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(Accesses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Next, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(HitMiss1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(Bi_addr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(31, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(instrbttn)
                        .addContainerGap())))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void NextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextActionPerformed
        // TODO add your handling code here:
        if(counter == access_seq_bin.size()){
            
            Next.setText("Complete!");
            Next.setEnabled(false);
            Hit_Ratio1.setText(Double.toString(hit_count/access_seq_bin.size()));
            Miss_Ratio1.setText(Double.toString(miss_count/access_seq_bin.size()));
            Accesses.setText(Integer.toString(access_seq_bin.size()));
            AMAT.setText(Double.toString(Cycles + (150*miss_count/access_seq_bin.size())));
            if(instances_Counter != 2){
            instrbttn.setVisible(true);
            }
            
         
        }
        else {
            String cache_block = access_seq_bin.get(counter).substring((int) tag_size);
            Bi_addr.setText(access_seq_bin.get(counter));
            String current_tag = access_seq_bin.get(counter).substring(0, (int) tag_size);
            String accessType = accessTypes.get(counter); // Get the access type (read or write)
    
            boolean hit = false;
            for (int j = 0; j < index.size(); j++) {
                if (cache_block.equals(index.get(j))) {
                    if (tag.get(j).equals(current_tag)) {
                        // Hit
                        hit_count++;
                        HitMiss1.setText("HIT");
                        HitMiss1.setForeground(Color.green);
                        hit = true;
    
                        // Handle write hit based on the writing policy
                        if (accessType.equalsIgnoreCase("write")) {
                            if (writeHitPolicy.equalsIgnoreCase("write-through")) {
                                // Write-through policy: Update cache and main memory
                                tag.set(j, current_tag);
                                valid_bit.set(j, 'Y');
                                // Update other relevant statistics if necessary
                            } else if (writeHitPolicy.equalsIgnoreCase("write-back")) {
                                // Write-back policy: Update cache only, set the dirty bit
                                tag.set(j, current_tag);
                                valid_bit.set(j, 'Y');
                                dirty_bit.set(j, 'D'); // Assuming 'D' indicates a dirty block
                                // Update other relevant statistics if necessary
                            }
                        }
                        break;
                    } else {
                        // Miss but the block is found with a different tag
                        HitMiss1.setText("MISS");
                        HitMiss1.setForeground(Color.red);
                        miss_count++;
    
                        // Handle write miss based on the writing policy
                        if (accessType.equalsIgnoreCase("write")) {
                            if (writeMissPolicy.equalsIgnoreCase("write-allocate")) {
                                // Write-allocate policy: Allocate a new cache block and write to it
                                valid_bit.set(j, 'Y');
                                tag.set(j, current_tag);
                                dirty_bit.set(j, 'D'); // Assuming write-allocate marks the block as dirty
                            } else if (writeMissPolicy.equalsIgnoreCase("no-write-allocate")) {
                                // No-write-allocate policy: Write directly to main memory without allocating a cache block
                                // Only update statistics related to memory writes if necessary
                            }
                        }
    
                        PopulateTableini();
                        break;
                    }
                }
            }
    
            if (!hit) {
                // If no hit was found in the entire cache, it's a miss
                HitMiss1.setText("MISS");
                HitMiss1.setForeground(Color.red);
                miss_count++;
    
                // If it's a read miss or write miss with write-allocate, we need to allocate a new cache block
                if (accessType.equalsIgnoreCase("read") || 
                    (accessType.equalsIgnoreCase("write") && writeMissPolicy.equalsIgnoreCase("write-allocate"))) {
                    // Find an empty spot or use a replacement policy (e.g., LRU) if necessary
                    boolean allocated = false;
                    for (int j = 0; j < index.size(); j++) {
                        if (valid_bit.get(j) == 'N') {
                            index.set(j, cache_block);
                            tag.set(j, current_tag);
                            valid_bit.set(j, 'Y');
                            if (accessType.equalsIgnoreCase("write")) {
                                dirty_bit.set(j, 'D');
                            }
                            allocated = true;
                            break;
                        }
                    }
                    if (!allocated) {
                        // Handle the replacement logic if no empty spot is found
                        // For simplicity, let's assume the first block is replaced (FIFO)
                        index.set(0, cache_block);
                        tag.set(0, current_tag);
                        valid_bit.set(0, 'Y');
                        if (accessType.equalsIgnoreCase("write")) {
                            dirty_bit.set(0, 'D');
                        }
                    }
                    PopulateTableini();
                }
            }
    
            counter++;
            ProgressBar.setValue(counter);
        }
    }//GEN-LAST:event_NextActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Index i = new Index();
        i.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Simulator s = new Simulator(CacheSize_rst,CacheLineSize_rst,Cycles_rst,access_seq_str_rst);
        s.setVisible(true);
        this.dispose();        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void instrbttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_instrbttnActionPerformed
        // TODO add your handling code here:
        
        Simulator s = new Simulator(CacheSize_rst,CacheLineSize_rst,Cycles_rst,Index.instr_str);
        s.setVisible(true);
        Simulator.instances_Counter++;
        this.dispose();
        
        
        
        
    }//GEN-LAST:event_instrbttnActionPerformed



    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Simulator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Simulator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Simulator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Simulator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Simulator().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AMAT;
    private javax.swing.JTextField Accesses;
    private javax.swing.JTextField Bi_addr;
    private javax.swing.JTextField HitMiss1;
    private javax.swing.JTextField Hit_Ratio1;
    private javax.swing.JTextField Miss_Ratio1;
    private javax.swing.JToggleButton Next;
    private javax.swing.JProgressBar ProgressBar;
    private javax.swing.JButton instrbttn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
