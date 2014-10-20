package t4.modelagem;

/**
 *
 * @author Otavio Migliavacca Madalosso
 */
public class ModeloATM extends ModeloGeral {

    public ModeloATM() {
        super(100, 150, 1440, 0.5f, 5);
    }
    public void escreve(){
        super.escreve("atm");
    }
    
}
