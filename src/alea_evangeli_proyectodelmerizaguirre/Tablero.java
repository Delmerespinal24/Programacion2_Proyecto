/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alea_evangeli_proyectodelmerizaguirre;

import Pieza.*;
import javax.swing.JOptionPane;

public class Tablero {

    public static final byte tam = 19;
    private final char[][] tablero;
    private Piezas duques;
    private Piezas rebeldes;
    private Piezas reyna;

    public Tablero() {
        tablero = tablero();
        duques = new Duques();
        

    }

    private char[][] tablero() {
        char[][] tab = new char[tam][tam];
        for (int i = 0; i < tam; i++) {
            for (int j = 2; j < tam; j++) {
                tab[i][j] = ' ';
            }
        }
        tab[0][0] = 'X';
        tab[0][1] = 'X';
        tab[1][0] = 'X';
        tab[1][1] = 'X';
        tab[0][tam - 2] = 'X';
        tab[0][tam - 1] = 'X';
        tab[1][tam - 2] = 'X';
        tab[1][tam - 1] = 'X';
        tab[tam - 2][0] = 'X';
        tab[tam - 2][1] = 'X';
        tab[tam - 1][0] = 'X';
        tab[tam - 1][1] = 'X';
        tab[tam - 2][tam - 1] = 'X';
        tab[tam - 2][tam - 2] = 'X';
        tab[tam - 1][tam - 1] = 'X';
        tab[tam - 1][tam - 2] = 'X';
        tab[tam / 2][tam / 2] = 'X';

        return tab;

    }
    //METODO RECURSIVO
    public void ImprimirTablero(int fila, int colum, char[][] tablero) {
       
        if (fila == tam - 1 && colum == tam - 1) {
            System.out.println("|" + tablero[fila][colum] + "|");
        } else if (colum == tam - 1) {
            System.out.println("|" + tablero[fila][colum] + "|");
            colum = 0;
            fila++;
            ImprimirTablero(fila, colum, tablero);

        } else {
            System.out.print("|" + tablero[fila][colum]);
            colum++;
            ImprimirTablero(fila, colum, tablero);

        }

    }
    
    public char[][] getTablero(){
        char[][] tab = tablero;
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                if(duques.getPosiciones()[i][j]){
                    tab[i][j] = duques.getFigura();
                }   
            }
            
        }
        return tab;
        
    }
    
    public void moverPieza(int x1, int y1, int x2, int y2, char pieza) {
        try {
            if (tablero[x2][y2] == ' ') {
                
                tablero[x2][y2] = pieza;
                tablero[x1][y1] = ' ';
                
            }else{
                JOptionPane.showMessageDialog(null, "No puedes mover esta pieza aqui");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Fuera del rango del tablero");
        }
        

    }

}
