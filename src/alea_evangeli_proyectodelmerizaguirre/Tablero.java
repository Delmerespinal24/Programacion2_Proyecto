/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alea_evangeli_proyectodelmerizaguirre;

import java.awt.HeadlessException;
import javax.swing.JOptionPane;

public class Tablero {

    private final int tam = 19;
    private char[][] tablero;

    public Tablero() {
        tablero = tablero();

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

    public void ImprimirTablero(int fila, int colum) {
        if (fila == tam - 1 && colum == tam - 1) {
            System.out.println("|" + tablero[fila][colum] + "|");
        } else if (colum == tam - 1) {
            System.out.println("|" + tablero[fila][colum] + "|");
            colum = 0;
            fila++;
            ImprimirTablero(fila, colum);

        } else {
            System.out.print("|" + tablero[fila][colum]);
            colum++;
            ImprimirTablero(fila, colum);

        }

    }

    public void moverPieza(int x1, int y1, int x2, int y2, char pieza) {
        try {
            if (tablero[x2][y2] == ' ') {
                tablero[x1][y1] = ' ';
                tablero[x2][y2] = pieza;
                
            }else{
                JOptionPane.showMessageDialog(null, "No puedes mover esta pieza aqui");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Fuera del rango del tablero");
        }
        

    }

}
