package t4.modelagem;

/**
 *
 * @author Otavio Migliavacca Madalosso
 */
public class ModeloDrive extends ModeloGeral {

    public ModeloDrive() {
        super(50, 50, 300, 0.5f, 5);
    }
    
    public void escreve(){
        super.escreve("drive");
    }
}
