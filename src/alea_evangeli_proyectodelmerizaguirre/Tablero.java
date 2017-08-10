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
    private char[][] tablero = new char[tam][tam];
    private final Piezas duques;
    private final Piezas rebeldes;
    private final Piezas rey;

    public Tablero() {

        duques = new Duques();
        rebeldes = new Rebeldes();
        rey = new Rey();
        tablero = getTablero();

    }

    public static byte getTam() {
        return tam;
    }

    public Piezas getDuques() {
        return duques;
    }

    public Piezas getRebeldes() {
        return rebeldes;
    }

    public Piezas getRey() {
        return rey;
    }

    private char[][] getTablero() {
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                tablero[i][j] = 'ᅚ';
            }
        }
        char X = '╳';
        tablero[0][0] = X;
        tablero[0][1] = X;
        tablero[1][0] = X;
        tablero[1][1] = X;
        tablero[0][tam - 2] = X;
        tablero[0][tam - 1] = X;
        tablero[1][tam - 2] = X;
        tablero[1][tam - 1] = X;
        tablero[tam - 2][0] = X;
        tablero[tam - 2][1] = X;
        tablero[tam - 1][0] = X;
        tablero[tam - 1][1] = X;
        tablero[tam - 2][tam - 1] = X;
        tablero[tam - 2][tam - 2] = X;
        tablero[tam - 1][tam - 1] = X;
        tablero[tam - 1][tam - 2] = X;
        tablero[tam / 2][tam / 2] = X;

        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                if (duques.getPosiciones()[i][j]) {
                    tablero[i][j] = duques.getFigura();
                }
                if (rebeldes.getPosiciones()[i][j]) {
                    tablero[i][j] = rebeldes.getFigura();
                }
                if (rey.getPosiciones()[i][j]) {
                    tablero[i][j] = rey.getFigura();
                }

            }

        }

        return tablero;

    }

    //METODO RECURSIVO
    public void ImprimirTablero(int fila, int colum) {
        char[][] tab = getTablero();
        if (fila == tam - 1 && colum == tam - 1) {

            System.out.println("|" + tab[fila][colum] + "| ");
            System.out.println("   AᅚBᅚCᅚDᅚEᅚFᅚGᅚHᅚIᅚJᅚKᅚLᅚMᅚNᅚOᅚPᅚQᅚRᅚS\n");

        } else if (colum == tam - 1) {
            System.out.println("|" + tab[fila][colum] + "| ");
            colum = 0;
            fila++;
            ImprimirTablero(fila, colum);

        } else {
            if (colum == 0 && fila < 10) {
                System.out.print(fila + " ");
            } else if (colum == 0 && fila > 9) {
                System.out.print(fila);
            }
            System.out.print("|" + tab[fila][colum]);
            colum++;
            ImprimirTablero(fila, colum);

        }

    }

    public void moverDuque(int x1, int y1, int x2, int y2) {
        try {
            if (duques.getPosiciones()[x1][y1]) {
                if (tablero[x2][y2] != '╳' && (x1 != x2 || y1 != y2)) {

                    Mover(x1, y1, x2, y2, duques);

                    duques.getPosiciones()[((Rey) rey).getX()][((Rey) rey).getY()] = true;
                    Captura(duques, rebeldes, x2, y2);
                    duques.getPosiciones()[((Rey) rey).getX()][((Rey) rey).getY()] = false;

                } else {
                    JOptionPane.showMessageDialog(null, "No puedes mover esta pieza aqui");
                }
            } else if (rey.getPosiciones()[x1][y1]) {
                if (!(x2 == 9 && y2 == 9) && (x1 != x2 || y1 != y2)) {

                    Mover(x1, y1, x2, y2, rey);
                    ((Rey) rey).setX(x2);
                    ((Rey) rey).setY(y2);

                    Captura(duques, rebeldes, x2, y2);

                } else {
                    JOptionPane.showMessageDialog(null, "No puedes mover esta pieza aqui");
                }
            } else {
                JOptionPane.showMessageDialog(null, "No hay ningun duque o rey en esta posicion");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Fuera del rango del tablero");
        }

    }

    public void moverRebelde(int x1, int y1, int x2, int y2) {
        try {
            if (rebeldes.getPosiciones()[x1][y1]) {
                if (tablero[x2][y2] != '╳' && (x1 != x2 || y1 != y2)) {

                    Mover(x1, y1, x2, y2, rebeldes);
                    Captura(rebeldes, duques, x2, y2);
                    JaqueMate();

                } else {
                    JOptionPane.showMessageDialog(null, "No puedes mover esta pieza aqui");
                }
            } else {
                JOptionPane.showMessageDialog(null, "No hay ningun rebelde en esta posicion");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Fuera del rango del tablero");
        }

    }

    public void Mover(int x1, int y1, int x2, int y2, Piezas pieza) {
        boolean posible = true;
        if (x1 == x2) { //Movimiento horizontal
            if (y2 > y1) {//Derecha
                for (int i = y2; i > y1; i--) {
                    if (isPieza(x2, i)) {
                        posible = false;
                    }
                }
            } else {//Izquierda
                for (int i = y2; i < y1; i++) {
                    if (isPieza(x2, i)) {
                        posible = false;
                    }
                }

            }
            if (posible) {
                pieza.getPosiciones()[x1][y1] = false;
                pieza.getPosiciones()[x2][y2] = true;
            } else {
                JOptionPane.showMessageDialog(null, "No puedes mover esta pieza aqui");
            }

        } else if (y1 == y2) { //Movimiento Vertical
            if (x2 > x1) {//Arriba
                for (int i = x2; i > x1; i--) {
                    if (isPieza(i, y2)) {
                        posible = false;
                    }
                }
            } else {//Abajo
                for (int i = x2; i < x1; i++) {
                    if (isPieza(i, y2)) {
                        posible = false;
                    }
                }
            }
            if (posible) {
                pieza.getPosiciones()[x1][y1] = false;
                pieza.getPosiciones()[x2][y2] = true;
            } else {
                JOptionPane.showMessageDialog(null, "No puedes mover esta pieza aqui");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Las piezas solo se pueden mover vertical u horizontalmente");

        }

    }

    private boolean isPieza(int x, int y) {
        return rey.getPosiciones()[x][y] || rebeldes.getPosiciones()[x][y] || duques.getPosiciones()[x][y];
    }

    private void Captura(Piezas amiga, Piezas capturada, int x, int y) {
        //hacia arriba
        if (x >= 2) {
            if (amiga.getPosiciones()[x - 2][y]) {
                capturada.getPosiciones()[x - 1][y] = false;
            }
        }
        //hacia abajo
        if (x <= tam - 3) {
            if (amiga.getPosiciones()[x + 2][y]) {
                capturada.getPosiciones()[x + 1][y] = false;
            }
        }
        //hacia la izquierda
        if (y >= 2) {
            if (amiga.getPosiciones()[x][y - 2]) {
                capturada.getPosiciones()[x][y - 1] = false;
            }
        }
        //hacia la derecha
        if (y <= tam - 3) {
            if (amiga.getPosiciones()[x][y + 2]) {
                capturada.getPosiciones()[x][y + 1] = false;
            }
        }

    }

    private void JaqueMate() {

        int x = ((Rey)rey).getX();
        int y = ((Rey)rey).getY();
              
        boolean up = false;
        boolean down = false;
        boolean left = false;
        boolean right = false;
        
        try {
            up = rebeldes.getPosiciones()[x - 1][y];
        } catch (Exception e) {}
        try {
            down = rebeldes.getPosiciones()[x + 1][y];
        } catch (Exception e) {}
        try {
            right = rebeldes.getPosiciones()[x][y + 1];
        } catch (Exception e) {}
        try {
            left = rebeldes.getPosiciones()[x][y - 1];
        } catch (Exception e) {}
        
        if(x == 0){
            up = true;
        }
        if(x == tam-1){
            down = true;
        }
        if(y == tam-1){
            right = true;
        }
        if(y == 0){
            left = true;
        }
      
        //Termina el juego
        if(up && down && left && right){
            rey.getPosiciones()[x][y] = false;
        }
        
    }
  

    @Override
    public String toString() {
        return "Alea Evangeli";
    }

}
