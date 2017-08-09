
package Pieza;

/**
 *
 * @author Owner
 */
public class Rey extends Piezas {
    
    public Rey() {
        super();
        super.setFigura('♕');
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
        posiciones[9][9] = true;
        
    }
}
