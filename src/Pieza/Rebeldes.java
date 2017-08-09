
package Pieza;

public class Rebeldes extends Piezas {

    public Rebeldes() {
        super();
        super.setFigura('⛔');
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
        posiciones[0][2] = true;
        posiciones[0][5] = true;
        posiciones[0][13] = true;
        posiciones[0][16] = true;
        posiciones[2][0] = true;
        posiciones[2][5] = true;
        posiciones[2][13] = true;
        posiciones[2][18] = true;
        posiciones[3][7] = true;
        posiciones[3][9] = true;
        posiciones[3][11] = true;
        posiciones[4][6] = true;
        posiciones[4][12] = true;
        posiciones[5][0] = true;
        posiciones[5][2] = true;
        posiciones[5][5] = true;
        posiciones[5][13] = true;
        posiciones[5][16] = true;
        posiciones[5][18] = true;
        posiciones[6][4] = true;
        posiciones[6][14] = true;
        posiciones[7][3] = true;
        posiciones[7][15] = true;

        posiciones[9][3] = true;
        posiciones[9][15] = true;
        
        posiciones[18][2] = true;
        posiciones[18][5] = true;
        posiciones[18][13] = true;
        posiciones[18][16] = true;
        posiciones[16][0] = true;
        posiciones[16][5] = true;
        posiciones[16][13] = true;
        posiciones[16][18] = true;
        posiciones[15][7] = true;
        posiciones[15][9] = true;
        posiciones[15][11] = true;
        posiciones[14][6] = true;
        posiciones[14][12] = true;
        posiciones[13][0] = true;
        posiciones[13][2] = true;
        posiciones[13][5] = true;
        posiciones[13][13] = true;
        posiciones[13][16] = true;
        posiciones[13][18] = true;
        posiciones[12][4] = true;
        posiciones[12][14] = true;
        posiciones[11][3] = true;
        posiciones[11][15] = true;
    }

}
