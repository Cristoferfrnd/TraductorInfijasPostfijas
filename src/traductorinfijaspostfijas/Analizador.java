/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traductorinfijaspostfijas;

import java.util.Scanner;
import javax.swing.JOptionPane;

class Analizador {
     String res="";
      int i=0;
    char[] cadena;
    Scanner s=new Scanner(System.in); 

    String expr(String preanálisis) {
        
       cadena=preanálisis.toCharArray();
        term(cadena[i]);
        i=i+1;
        while (i<cadena.length) {
            if (cadena[i] == '+') {
                coincidir('+',cadena[i]);
                term(cadena[i]);                
                System.out.print("+");
                 res=res+"+";
            } else if(cadena[i] == '-') {
                coincidir('-',cadena[i]);
                term(cadena[i]);
                System.out.write('-');
                 res=res+"-";
            }
            else{
                JOptionPane.showMessageDialog(null, 
               "Error de sintaxis la operación "+cadena[i]+" no esta definida");       
                res="";
                return res;
            }
            i=i+1;
             }
        return res; }

    private void term(char t) {
        if (Character.isDigit(t)) {           
            System.out.print(t);   
            res=res+t;
        } 
        else{
            JOptionPane.showMessageDialog(null, "Error de sintaxis");  }   }

    private void coincidir(char c,char t) {
        if (t == c) {
            i= i+1;
        } else {
            throw new Error("Error de sintaxis");
        }  }
}
