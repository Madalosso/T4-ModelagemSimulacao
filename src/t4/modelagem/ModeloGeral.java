package t4.modelagem;

/**
 *
 * @author Otavio Migliavacca Madalosso
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class ModeloGeral {
    private final ArrayList<Float> lChegada;
    private final ArrayList<Float> lAtendimento;
    private float soma;
    private final int tAtividade;//variavel informada no construtor para definir 
                                 //quanto tempo a função será exercida
    private final int nMinClientes,varClientes;//Numero mínimo de clientes esperados
                                               // e a variação
    private final float tMinTrans,tMaxTrans; //tempo minimo e maximo de ocupacao pelo cliente
                                             //construtor
    public ModeloGeral(int varClientes,int nMinClientes,int tAtividade,
            float tMinTrans, float tMaxTrans) {
        lChegada = new ArrayList<>();
        lAtendimento = new ArrayList<>();
        this.varClientes=varClientes;        
        this.tAtividade=tAtividade; 
        this.nMinClientes=nMinClientes;
        this.tMinTrans=tMinTrans;
        this.tMaxTrans=tMaxTrans;
    }

    public void geraNumeros(){
        Random gerador = new Random();
        //gera numero de clientes com uma variacao controlado e um minimo
        int nClientes = gerador.nextInt(varClientes)+nMinClientes;
        //variavel soma utilizada para nao estourar o tempo de funcionamento
        soma = 0;
        for(int i = 0 ; i<nClientes ; i++ ){
            float ran,ran2;
            //gera float simbolizando o numero de minutos entre a chegada de clientes
            do{
                ran = gerador.nextFloat()*10;
            }while(ran > 6 || ran < 0.1);
            
            //gera float simbolizando o numero de minutos de duracao do atendimento
            //o while faz com que os numeros gerados sejam consistentes
            do{
                ran2 = gerador.nextFloat()*10;
            }while( ran2 > tMaxTrans || ran2 < tMinTrans);
            //adiciona os numeros gerados nas listas que serao escritas em arquivo posteriormente
            lChegada.add(ran);
            lAtendimento.add(ran2);
            soma += ran2;
        }
        //caso a soma de duracao de atendimento seja maior q o funcionamento do aparelho
        // retira ultimos registros ate que torne aceitavel
        while(soma > tAtividade){
            soma -= lAtendimento.get(lAtendimento.size()-1);
            lChegada.remove(lChegada.size()-1);
            lAtendimento.remove(lAtendimento.size()-1);
            nClientes--;
        }
        System.out.println("Numero de clientes: "+nClientes);
        
    }

    public float getSoma() {
        return soma;
    }

    public ArrayList<Float> getLista() {
        return lChegada;
    }
    
    //funcao imprime o conteudo da lista de chegada
    public void printChegada(){
        for(int i = 0;i<lChegada.size();i++){
            if(i%10==0)System.out.println("");
            System.out.print(lChegada.get(i).toString().substring(0, 4) + " ");
        }
        System.out.println("");
    }

    //funcao imprime o conteudo da lista de Atendimento
    public void printAtendimento(){
        for(int i = 0;i<lAtendimento.size();i++){
            if(i%10==0)System.out.println("");
            System.out.print(lAtendimento.get(i).toString().substring(0, 4) + " ");
        }
        System.out.println("");
    }
    
    //escreve no arquivo tornando os floats com grau de precisao 2 e adicionando
    //quebra de linha a cada 10 elementos.
    public void escreve(String nome){
        String content = "";
        String content2 ="";
        for(int i = 0 ; i < lChegada.size() ; i++){
            if( i%10==0 && i != 0){
                content = content.concat("\n");
                content2= content2.concat("\n");
            }
            content = content.concat(lChegada.get(i).toString().substring(0, 4)+" ");
            content2 = content2.concat(lAtendimento.get(i).toString().substring(0, 4)+" ");
        }
        try{
            final String dir = System.getProperty("user.dir");
            File file = new File(dir+"/"+nome+"Chegadas.txt");
            if(!file.exists()){
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();
            
            file = new File(dir+"/"+nome+"TempoUso.txt");
            if(!file.exists()){
                file.createNewFile();
            }
            fw = new FileWriter(file.getAbsoluteFile());
            bw = new BufferedWriter(fw);
            bw.write(content2);
            bw.close();
            System.out.println("Gravado");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
