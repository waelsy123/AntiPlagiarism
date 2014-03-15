
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Wael
 */
public class F3 extends javax.swing.JFrame {
    String file1 = null ; 
    String file2 = null ; 
    
    public F3() {
        initComponents();
    }
    public F3(String f1 , String f2) {
        file1  = f1 ; 
        file2  = f2 ;
        
        initComponents();
         File filei = new File(file1); 
         
         FileReader fr = null;
        try {
            fr = new FileReader(filei.getAbsoluteFile());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(F3.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedReader br = new BufferedReader(fr);
        
        String str = null  ; 
        try {
            str =  br.readLine() ;
        } catch (IOException ex) {
            Logger.getLogger(F3.class.getName()).log(Level.SEVERE, null, ex);
        }
        jTextArea1.setText("");
        while(str !=null ){
            char [] q = str.toCharArray() ;
            jTextArea1.append(str);
            jTextArea1.append("\n");
            
            for (int j =0 ;j<str.length() ; j++){
                //System.out.print(q[j]);
               
            }
           // System.out.println();
            try {
                str =  br.readLine() ;
            } catch (IOException ex) {
                Logger.getLogger(F3.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
     
        
         File fileii = new File(file2); 
         
         FileReader fr2 = null;
        try {
            fr2 = new FileReader(fileii.getAbsoluteFile());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(F3.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedReader br2 = new BufferedReader(fr2);
        
        String str2 = null  ; 
        try {
            str2 =  br2.readLine() ;
        } catch (IOException ex) {
            Logger.getLogger(F3.class.getName()).log(Level.SEVERE, null, ex);
        }
        jTextArea2.setText("");
        while(str2 !=null ){
            char [] q = str2.toCharArray() ;
            jTextArea2.append(str2);
            jTextArea2.append("\n");
            
            for (int j =0 ;j<str2.length() ; j++){
                //System.out.print(q[j]);
               
            }
           // System.out.println();
            try {
                str2 =  br2.readLine() ;
            } catch (IOException ex) {
                Logger.getLogger(F3.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
     
        ArrayList <Integer> L1 = new ArrayList<Integer>();
        ArrayList <Integer> L2 = new ArrayList<Integer>();
        ArrayList <String> S = new ArrayList<String>() ; 
        
        String Text = jTextArea1.getText() ;
        System.out.println("File1 lenght = " + Text.length());
                
        int ind = -1 ; 
        while(ind < Text.length()-1){
          
          //  System.out.println(ind);
            ind++;
            
            if(Text.charAt(ind) == ' ' ||Text.charAt(ind) == '\t' || Text.charAt(ind) == '{' || Text.charAt(ind) == '}' || Text.charAt(ind) == '\n') 
                continue;
            else if(Text.charAt(ind) == '/'){
                ind++;
                if(Text.charAt(ind) == '/'){
                    while(Text.charAt(ind) != '\n') {
                        //System.out.print(Text.charAt(ind));
                        ind++;
                    }
                    continue ;
                    }
                else if(Text.charAt(ind) == '*'){
                    ind++;
                    if(ind+1>=Text.length()) break ; // finish the algo
                    while(! (Text.charAt(ind) == '*' && Text.charAt(ind+1) == '/')  ){
                        //System.out.print(Text.charAt(ind));
                        ind++;
                    }
                    ind+=2;
                    continue ;
                }
                
            }
            
            else{  
                // let make string builder ;
                StringBuilder strbuilder = new StringBuilder();
                
                if(ind+4<Text.length()-1 && Text.charAt(ind) == 'f' && Text.charAt(ind+1) == 'o' && Text.charAt(ind+2) == 'r'&& Text.charAt(ind+3) == '('  ){
                    L1.add(ind);
                    //System.out.print("index of letter:" + ind + '\t');
                    int key =1 ;
                    while( Text.charAt(ind) != '(' ) {
                        if(Text.charAt(ind) != ' ' && Text.charAt(ind) != '\n'  && Text.charAt(ind) != '\t' ){
                            strbuilder.append(Text.charAt(ind));
                        }
                        ind++ ;                        
                    } 
                    while(key!=0){
 
                        if(Text.charAt(ind) != ' ' && Text.charAt(ind) != '\n'  && Text.charAt(ind) != '\t' ){
                            strbuilder.append(Text.charAt(ind));
                        }
                        ind++ ;
                        if(Text.charAt(ind) == '(') key++ ;
                        if(Text.charAt(ind) == ')') key--;
                        
                    }
                    //System.out.println  (Text.charAt(ind));
                    if(Text.charAt(ind) != ' ' && Text.charAt(ind) != '\n'  && Text.charAt(ind) != '\t' ){
                          strbuilder.append(Text.charAt(ind));
                    }
                    S.add(strbuilder.toString() ) ;
                    L2.add(ind+1);
                }
                else{
                    L1.add(ind);
                    //System.out.print("index of letter:" + ind + '\t');
                    while(! (Text.charAt(ind) == ';' ||Text.charAt(ind) == '{') ){
                        if(Text.charAt(ind) != ' ' && Text.charAt(ind) != '\n'  && Text.charAt(ind) != '\t' ){
                            strbuilder.append(Text.charAt(ind));
                        } 
                        ind++ ;
                    }
                    //System.out.println(Text.charAt(ind)); 
                    S.add(strbuilder.toString() ) ;
                    L2.add(ind);
                    
              }
                
                System.out.println(S.get(S.size()-1));
            }
        }
     //// THE END OF TEXTAREA1 >> we have :
       // L1 , L2 , strbuilder 
        
     //// START OF TEXTAREA1 
        
        ArrayList <Integer> L11 = new ArrayList<Integer>();
        ArrayList <Integer> L22 = new ArrayList<Integer>();
        ArrayList <String> SS = new ArrayList<String>() ; 
        
        Text = jTextArea2.getText() ;
        System.out.println("File1 lenght = " + Text.length());
                
        ind = -1 ; 
        while(ind < Text.length()-1){
          
          //  System.out.println(ind);
            ind++;
            
            if(Text.charAt(ind) == ' ' ||Text.charAt(ind) == '\t' || Text.charAt(ind) == '{' || Text.charAt(ind) == '}' || Text.charAt(ind) == '\n') 
                continue;
            else if(Text.charAt(ind) == '/'){
                ind++;
                if(Text.charAt(ind) == '/'){
                    while(Text.charAt(ind) != '\n') {
                        //System.out.print(Text.charAt(ind));
                        ind++;
                    }
                    continue ;
                    }
                else if(Text.charAt(ind) == '*'){
                    ind++;
                    if(ind+1>=Text.length()) break ; // finish the algo
                    while(! (Text.charAt(ind) == '*' && Text.charAt(ind+1) == '/')  ){
                        //System.out.print(Text.charAt(ind));
                        ind++;
                    }
                    ind+=2;
                    continue ;
                }
                
            }
            
            else{  
                // let make string builder ;
                StringBuilder strbuilder = new StringBuilder();
                
                if(ind+4<Text.length()-1 && Text.charAt(ind) == 'f' && Text.charAt(ind+1) == 'o' && Text.charAt(ind+2) == 'r'&& Text.charAt(ind+4) == '('  ){
                    L11.add(ind);
                    //System.out.print("index of letter:" + ind + '\t');
                    int key =1 ;
                    while( Text.charAt(ind) != '(' ) {
                        if(Text.charAt(ind) != ' ' && Text.charAt(ind) != '\n'  && Text.charAt(ind) != '\t' ){
                            strbuilder.append(Text.charAt(ind));
                        }
                        ind++ ;                        
                    } 
                    while(key!=0){
 
                        if(Text.charAt(ind) != ' ' && Text.charAt(ind) != '\n'  && Text.charAt(ind) != '\t' ){
                            strbuilder.append(Text.charAt(ind));
                        }
                        ind++ ;
                        if(Text.charAt(ind) == '(') key++ ;
                        if(Text.charAt(ind) == ')') key--;
                        
                    }
                    //System.out.println  (Text.charAt(ind));
                    if(Text.charAt(ind) != ' ' && Text.charAt(ind) != '\n'  && Text.charAt(ind) != '\t' ){
                          strbuilder.append(Text.charAt(ind));
                    }
                    SS.add(strbuilder.toString() ) ;
                    L22.add(ind+1);
                }
                else{
                    L11.add(ind);
                    //System.out.print("index of letter:" + ind + '\t');
                    while(! (Text.charAt(ind) == ';' ||Text.charAt(ind) == '{') ){
                        if(Text.charAt(ind) != ' ' && Text.charAt(ind) != '\n'  && Text.charAt(ind) != '\t' ){
                            strbuilder.append(Text.charAt(ind));
                        } 
                        ind++ ;
                    }
                    //System.out.println(Text.charAt(ind)); 
                    SS.add(strbuilder.toString() ) ;
                    L22.add(ind);
                    
              }
                
                System.out.println(SS.get(SS.size()-1));
            }
        }
        
 /// END OF TEXTAREA2 
        
        double total = 0 ;
/// START OF COMPARE ;
        boolean[] B1 = new boolean[S.size()]  ;
        boolean[] B2 = new boolean[SS.size()] ;
        
        for(int i =0;i<S.size();i++){
            
            for(int j=0;j<SS.size();j++){
                if(S.get(i).equals(SS.get(j))){
                    B1[i] = true ;
                    B2[j] = true ;
                    total += 1  ;
                    break ;
                }
            }
        }
        
        /// END OF CMOPARE ; 
        
       double tt ;
       tt =  total / S.size() ;
       tt *= 100 ;
       
      // let's try highlight every good statment ; 
       
        jLabel1.setText("Plagiarism Rate is:  " + tt + " %.");
       for(int i =0 ;i<S.size();i++) {
           if(B1[i] == true){
                Highlighter h = jTextArea1.getHighlighter();
                try {
                    h.addHighlight(L1.get(i), L2.get(i) , DefaultHighlighter.DefaultPainter);
                } catch (BadLocationException ex) {
                    Logger.getLogger(F3.class.getName()).log(Level.SEVERE, null, ex);
                }
           }
        }
       for(int i =0 ;i<SS.size();i++) {
           if(B2[i] == true){
                Highlighter h = jTextArea2.getHighlighter();
                try {
                    h.addHighlight(L11.get(i), L22.get(i) , DefaultHighlighter.DefaultPainter);
                } catch (BadLocationException ex) {
                    Logger.getLogger(F3.class.getName()).log(Level.SEVERE, null, ex);
                }
           }
        }
       
    }

        

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Statistics");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

         this.setVisible(false);
       //  F1 f = new F1() ;
        // f.setVisible(true);

    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(F3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(F3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(F3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(F3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new F3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    // End of variables declaration//GEN-END:variables
}
