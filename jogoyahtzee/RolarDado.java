package jogoyahtzee;

//biblioteca para lista
import java.util.ArrayList;

// biblioteca para sorteio do numero dos dados
import java.util.Random;
public class RolarDado {
    private int dado;
    private ArrayList<Integer> dados = new ArrayList<>();

    public ArrayList<Integer> getDados() {
        return dados;
    }

    //rola um unico dado, o que ajuda na hora de rolar novamente algum dado
    public int rolarUmDado(){
        Random random = new Random();
        dado = random.nextInt(6)+1;
        return dado;
    }

    //rola cinco dados ao inicio do jogo, usando rolarUmDado
    public void rolarCincoDados(ArrayList<Integer> dados){
        dados.clear();
        for (int i = 0; i < 5; i++){
            dados.add(rolarUmDado());
        }
    }
}