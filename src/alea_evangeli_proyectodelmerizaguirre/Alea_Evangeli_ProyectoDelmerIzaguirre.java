
package alea_evangeli_proyectodelmerizaguirre;

import javax.swing.JOptionPane;

/**
 *
 * @author Delmer♕
 */

public class Alea_Evangeli_ProyectoDelmerIzaguirre {

    public static void main(String[] args) {
        Tablero tab = new Tablero();
        while(true){
            tab.ImprimirTablero(0, 0);
            int x1 = Integer.parseInt(
                    JOptionPane.showInputDialog("X1")
            );
            int y1 = JOptionPane.showInputDialog("Y1")
                    .toUpperCase().charAt(0) - 65;
            
            int x2 = Integer.parseInt(
                    JOptionPane.showInputDialog("X2")
            );
            int y2 = JOptionPane.showInputDialog("Y2")
                    .toUpperCase().charAt(0) - 65;
            
            tab.moverRebelde(x1, y1, x2, y2);
            System.out.println(x1+" " +y1 + " " + x2 + " " + y2);
            
            
        }
        
        
        
        
        
       
        
    }
    
}
