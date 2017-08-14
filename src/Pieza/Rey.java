
package Pieza;

/**
 *
 * @author Owner
 */
public class Rey extends Piezas {
    
    private int x = 9;
    private int y = 9;
    
    
    
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
        posiciones[x][y] = true;
        posiciones[8][9] = true;
        posiciones[10][9] = true;
        posiciones[9][8] = true;
        posiciones[9][10] = true;
       
        
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public char getSirviente(){
        return 'ⓞ';
        
    }
    
    public boolean IsLife(){
        return posiciones[x][y];
        
    }
        
    @Override
    public String toString() {
        return "Rey";
    }
}
