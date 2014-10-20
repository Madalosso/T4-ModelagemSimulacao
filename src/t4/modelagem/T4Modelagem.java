
/**
 *
 * @author Otavio Migliavacca Madalosso
 */
package t4.modelagem;
public class T4Modelagem {
    
    public static void main(String[] args) {
        ModeloCaixa cx1,cx2;
        ModeloDrive drive;
        ModeloATM atm;
        
        System.out.println("Gerando dados...");
        System.out.println("Gerando caixa 1");
        cx1 = new ModeloCaixa();
        cx1.geraNumeros();
//        cx1.printChegada();
//        cx1.printAtendimento();
//        System.out.println(cx1.getSoma());
        cx1.escreve("1");
        
        System.out.println("Gerando caixa 2");
        cx2 = new ModeloCaixa();
        cx2.geraNumeros();
//        cx2.printChegada();
//        cx2.printAtendimento();
//        System.out.println(cx2.getSoma());
        cx2.escreve("2");
        
        System.out.println("Gerando drive thru");
        drive = new ModeloDrive();
        drive.geraNumeros();
//        drive.printChegada();
//        drive.printAtendimento();
//        System.out.println(drive.getSoma());
        drive.escreve();
        
        System.out.println("Gerando ATM");
        atm = new ModeloATM();
        atm.geraNumeros();
//        atm.printChegada();
//        atm.printAtendimento();
//        System.out.println(atm.getSoma());
        atm.escreve();
    }
    
}
