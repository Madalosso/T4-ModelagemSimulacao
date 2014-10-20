package t4.modelagem;
/**
 *
 * @author Otavio Migliavacca Madalosso
 */
public class ModeloCaixa extends ModeloGeral {

    public ModeloCaixa() {
        super(60, 40, 300, 0.5f, 5);
    }
    public void escreve(){
        super.escreve("caixa");
    }
    
    @Override
    public void escreve(String numero){
        super.escreve("caixa"+numero);
    }
}
