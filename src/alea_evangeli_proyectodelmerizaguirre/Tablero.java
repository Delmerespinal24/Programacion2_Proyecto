/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alea_evangeli_proyectodelmerizaguirre;

import Pieza.*;
import javax.swing.JOptionPane;

public class Tablero {

    boolean runGame = true;
    public static final byte tam = 19;
    private char[][] tablero = new char[tam][tam];
    private final Piezas duques;
    private final Piezas rebeldes;
    private final Piezas rey;

    public Tablero() {

        duques = new Duques();
        rebeldes = new Rebeldes();
        rey = new Rey();

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

    private void iterarTablero() {

        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                if (duques.getPosiciones()[i][j]) {
                    tablero[i][j] = duques.getFigura();
                } else if (rebeldes.getPosiciones()[i][j]) {
                    tablero[i][j] = rebeldes.getFigura();
                } else if (rey.getPosiciones()[i][j]) {
                    tablero[i][j] = ((Rey) rey).getSirviente();
                } else {
                    tablero[i][j] = 'ᅚ';
                }

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

        if (((Rey) rey).IsLife()) {
            tablero[((Rey) rey).getX()][((Rey) rey).getY()] = rey.getFigura();
        }

    }

    //METODO RECURSIVO
    public void ImprimirTablero(int fila, int colum) {
        if (fila == 0 && colum == 0) {
            iterarTablero();
        }
        if (fila == tam - 1 && colum == tam - 1) {

            System.out.println("|" + tablero[fila][colum] + "| ");
            System.out.println("   AᅚBᅚCᅚDᅚEᅚFᅚGᅚHᅚIᅚJᅚKᅚLᅚMᅚNᅚOᅚPᅚQᅚRᅚS\n");

        } else if (colum == tam - 1) {
            System.out.println("|" + tablero[fila][colum] + "| ");
            colum = 0;
            fila++;
            ImprimirTablero(fila, colum);

        } else {
            if (colum == 0 && fila < 10) {
                System.out.print(fila + " ");
            } else if (colum == 0 && fila > 9) {
                System.out.print(fila);
            }
            System.out.print("|" + tablero[fila][colum]);
            colum++;
            ImprimirTablero(fila, colum);

        }

    }

    private boolean[][] unirMatrices() {
        boolean[][] matriz = new boolean[tam][tam];
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                matriz[i][j] = duques.getPosiciones()[i][j] || rey.getPosiciones()[i][j];
            }
        }
        return matriz;

    }

    public boolean moverDuque(int x1, int y1, int x2, int y2) {//Un boolean para saber si el movimiento se efectuo

        boolean mover = false;
        try {
            if (duques.getPosiciones()[x1][y1]) {
                if (tablero[x2][y2] != '╳' && (x1 != x2 || y1 != y2)) {

                    if (Mover(x1, y1, x2, y2, duques)) {
                        mover = true;
                        Captura(unirMatrices(), rebeldes, x2, y2);
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "No puedes mover esta pieza aqui");
                }
            } else if (rey.getPosiciones()[x1][y1]) {   // Mover el rey
                mover = moverRey(x1, y1, x2, y2);

            } else {
                JOptionPane.showMessageDialog(null, "No hay ningun duque o rey en esta posicion");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Fuera del rango del tablero");
        }
        return mover;

    }

    public boolean moverRebelde(int x1, int y1, int x2, int y2) {

        boolean mover = false;
        try {
            if (rebeldes.getPosiciones()[x1][y1]) {
                if (tablero[x2][y2] != '╳' && (x1 != x2 || y1 != y2)) {

                    if (Mover(x1, y1, x2, y2, rebeldes)) {
                        mover = true;
                        Captura(rebeldes.getPosiciones(), duques, x2, y2);
                        JaqueMate();
                    }
                    
                } else {
                    JOptionPane.showMessageDialog(null, "No puedes mover esta pieza aqui");
                }
            } else {
                JOptionPane.showMessageDialog(null, "No hay ningun rebelde en esta posicion");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Fuera del rango del tablero");
        }
        return mover;
    }

    private boolean moverRey(int x1, int y1, int x2, int y2) {

        boolean mover = false;
        if (!(x2 == 9 && y2 == 9) && (x1 != x2 || y1 != y2)) {

            if (x1 == ((Rey) rey).getX() && y1 == ((Rey) rey).getY()) {
                if (Mover(x1, y1, x2, y2, rey)) {

                    ((Rey) rey).setX(x2);
                    ((Rey) rey).setY(y2);
                    mover = true;
                    if (tablero[((Rey) rey).getX()][((Rey) rey).getY()] == '╳') {

                        ImprimirTablero(0, 0);
                        JOptionPane.showMessageDialog(null, "El rey ha llegado a la x"
                                + "\nEl rey y los duques han ganado!");
                        runGame = false;
                    }

                }
            } else if (tablero[x2][y2] != '╳') { // Movimiento del los duques al lado del rey
                mover = Mover(x1, y1, x2, y2, rey);
            } else {
                JOptionPane.showMessageDialog(null, "Solo el rey puede estar en una X");
            }
            if (mover) {
                Captura(unirMatrices(), rebeldes, x2, y2);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No puedes mover esta pieza aqui");
        }
        return mover;
    }

    public boolean Mover(int x1, int y1, int x2, int y2, Piezas pieza) {
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
            posible = false;
            JOptionPane.showMessageDialog(null, "Las piezas solo se pueden mover vertical u horizontalmente");

        }
        return posible;

    }

    private boolean isPieza(int x, int y) {
        return rey.getPosiciones()[x][y] || rebeldes.getPosiciones()[x][y] || duques.getPosiciones()[x][y];
    }

    private void Captura(boolean[][] amiga, Piezas capturada, int x, int y) {
        //hacia arriba

        if (x >= 2) {
            if (amiga[x - 2][y]) {
                capturada.getPosiciones()[x - 1][y] = false;
            }
        }
        //hacia abajo
        if (x <= tam - 3) {
            if (amiga[x + 2][y]) {
                capturada.getPosiciones()[x + 1][y] = false;
            }
        }
        //hacia la izquierda
        if (y >= 2) {
            if (amiga[x][y - 2]) {
                capturada.getPosiciones()[x][y - 1] = false;
            }
        }
        //hacia la derecha
        if (y <= tam - 3) {
            if (amiga[x][y + 2]) {
                capturada.getPosiciones()[x][y + 1] = false;
            }
        }

    }

    private void JaqueMate() {

        int x = ((Rey) rey).getX();
        int y = ((Rey) rey).getY();

        boolean up = false;
        boolean down = false;
        boolean left = false;
        boolean right = false;

        try {
            up = rebeldes.getPosiciones()[x - 1][y];
        } catch (Exception e) {
        }
        try {
            down = rebeldes.getPosiciones()[x + 1][y];
        } catch (Exception e) {
        }
        try {
            right = rebeldes.getPosiciones()[x][y + 1];
        } catch (Exception e) {
        }
        try {
            left = rebeldes.getPosiciones()[x][y - 1];
        } catch (Exception e) {
        }

        if (x == 0) {
            up = true;
        }
        if (x == tam - 1) {
            down = true;
        }
        if (y == tam - 1) {
            right = true;
        }
        if (y == 0) {
            left = true;
        }
        
        try {
            if(tablero[x-1][y] == '╳')
                up = true;
        } catch (Exception ex) {
        }
        try {
            if(tablero[x+1][y] == '╳')
                down = true;
        } catch (Exception ex) {
        }
        try {
            if(tablero[x][y+1] == '╳')
                right = true;
        } catch (Exception ex) {
        }
        try {
            if(tablero[x][y-1] == '╳')
                left = true;
        } catch (Exception ex) {
        }
        

        //Termina el juego
        if (up && down && left && right) {
            rey.getPosiciones()[x][y] = false;

            ImprimirTablero(0, 0);
            JOptionPane.showMessageDialog(null, "El rey ha sido capturado\n"
                    + "Los rebeldes han ganado!");
            runGame = false;
        }

    }

    @Override
    public String toString() {
        return "Alea Evangeli";
    }

}
