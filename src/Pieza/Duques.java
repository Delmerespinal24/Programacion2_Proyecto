
package Pieza;

public class Duques extends Piezas {
    
    public Duques() {
        super();
        super.setFigura('ⓞ');
        LlenarTablero();
       
    }
    
    @Override
    public final void LlenarTablero() {
        super.posiciones = new boolean[tam][tam];
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                posiciones[i][j] = false;
            }
        }
        
        posiciones[4][8] = true;
        posiciones[4][10] = true;
        posiciones[6][9] = true;
        posiciones[7][8] = true;
        posiciones[7][10] = true;
        posiciones[8][7] = true;
        posiciones[8][11] = true;
        posiciones[8][4] = true;
        posiciones[8][14] = true;
        posiciones[9][6] = true;
        posiciones[9][12] = true;
        posiciones[10][4] = true;
        posiciones[10][7] = true;
        posiciones[10][11] = true;
        posiciones[10][14] = true;
        posiciones[11][8] = true;
        posiciones[11][10] = true;
        posiciones[12][9] = true;
        posiciones[14][8] = true;
        posiciones[14][10] = true;
        
    }
    
    @Override
    public String toString() {
        return "Duques";
    }
    

}
