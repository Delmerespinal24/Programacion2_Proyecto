
package alea_evangeli_proyectodelmerizaguirre;

/**
 *
 * @author Delmer
 */
public class Alea_Evangeli_ProyectoDelmerIzaguirre {

    public static void main(String[] args) {
        Tablero tab = new Tablero();
        
        tab.moverPieza(3, 3, 3, 3, '#');
        tab.ImprimirTablero(0, 0, tab.getTablero());
        
    }
    
}
