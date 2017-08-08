package Pieza;

import alea_evangeli_proyectodelmerizaguirre.Tablero;
/**
 *
 * @author Owner
 */
public abstract class Piezas {

    protected final byte tam = Tablero.tam;
    protected boolean[][] posiciones;
    private char figura;

    public Piezas() {
         
    }

    public boolean[][] getPosiciones() {
        return posiciones;
    }

    public void setPosiciones(boolean[][] posiciones) {
        this.posiciones = posiciones;
    }

    public char getFigura() {
        return figura;
    }

    public void setFigura(char figura) {
        this.figura = figura;
    }

    /////
    public char getPosicion(int x, int y) {
        if (posiciones[x][y]) {
            return figura;
        } else {
            return ' ';
        }

    }

    public void setPosicion(int x, int y, char figura) {
        this.posiciones[x][y] = figura == this.figura;

    }
    
    /////

    public abstract void LlenarTablero();

}
