
// Write by Wael Almattar, waelsy123@gmail.com
//


import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class frame extends  JFrame {
    
    double sum = 0 ; 
        Vector v1 = new Vector() ; 
    Vector v2 = new Vector() ; 
    
    Vector res1 = new Vector() ; 
    Vector res2 = new Vector() ; 
    Vector tot1 = new Vector() ; 
    
    public frame(Vector vec1 , Vector vec2 ){
        setBounds(50,50,550,550);
        JTextArea jTextArea1 = new JTextArea() ;
        JTextArea jTextArea2 = new JTextArea() ;
     
      //  setContentPane(jTextArea1) ;
        
        
        v1 = vec1 ; 
        v2 = vec2 ; 
        String maxs = null ;
        double max = 0  ;
        for(int ii = 0 ;ii<v1.size() ; ii++){
            max = 0 ;
            maxs = null ; 
            
          for(int jj = 0 ;jj<v2.size() ; jj++){
             
             
             
             
        File  filei  = new File(v1.elementAt(ii).toString()) ; 
        File  fileii  = new File(v2.elementAt(jj).toString()) ; 
       

         
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
                
               
            }
        }
     //// THE END OF TEXTAREA1 >> we have :
       // L1 , L2 , strbuilder 
        
     //// START OF TEXTAREA1 
        
        ArrayList <Integer> L11 = new ArrayList<Integer>();
        ArrayList <Integer> L22 = new ArrayList<Integer>();
        ArrayList <String> SS = new ArrayList<String>() ; 
        
        Text = jTextArea2.getText() ;
                
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
                
              
            }
        }
        
 /// END OF TEXTAREA2 
        
        double total = 0 ;
/// START OF COMPARE ;
        boolean[] B1 = new boolean[S.size()]  ;
        boolean[] B2 = new boolean[SS.size()] ;
        
        for(int w =0;w<S.size();w++){
            
            for(int z=0;z<SS.size();z++){
                if(S.get(w).equals(SS.get(z))){
                    B1[w] = true ;
                    B2[z] = true ;
                    total += 1  ;
                    break ;
                }
            }
        }
        
        /// END OF CMOPARE ; 
        
            double tt ;
            tt =  total / S.size() ;
            tt *= 100 ;
            
            if(max < tt ) {
                max = tt ;
                maxs = v2.elementAt(jj).toString() ;
            }
            
           // System.out.println(v1.elementAt(ii).toString() + "    and    " + v2.elementAt(jj).toString() + "  == " + tt);
             
         } // next file 
        res1.addElement(v1.elementAt(ii).toString());
        res2.addElement(maxs);
        tot1.addElement(max) ;

        
        }
      
      

     
        
        
    

    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

    Object rowData[][] = new Object[res1.size()][3];
    
    
    for(int i =0;i<res1.size();i++){
        rowData[i][0] = res1.elementAt(i).toString() ;
        rowData[i][1] = res2.elementAt(i).toString() ;
        rowData[i][2] = tot1.elementAt(i).toString() ;
        
    }
    
    
    Object columnNames[] = { "Project1", "Project2", "Surmmay" };
    JTable table = new JTable(rowData, columnNames);

    JScrollPane scrollPane = new JScrollPane(table);
    scrollPane.setBounds(200, 200, 700, 900);
    frame.add(scrollPane, BorderLayout.CENTER);
    frame.setSize(500, 500);
    frame.setVisible(true);
    
    double d  = 0 ; 
    for(int i =0;i<res1.size() ;i++){
        d += (double) tot1.elementAt(i) ;
    }
    
    d /= res1.size() ; 
   // System.out.println(d);
     sum = d ;
    
    
    if (sum > 95.5) sum =100 ;
    
    
    
  }
  public static void main(String args[]) {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

   
    

   

  }
}