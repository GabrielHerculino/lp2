package jogoyahtzee;

public class Pontuacao {
    private int pontuacaoTotal = 0;
    private int pontuacaoRodada = 0;



    public void setPontuacaoRodada(int pontuacaoRodada) {

        this.pontuacaoRodada = pontuacaoRodada;
    }
    public int getPontuacaoRodada() {

        return pontuacaoRodada;
    }
    public int getPontuacaoTotal() {

        return pontuacaoTotal;
    }
    public int setPontuacaoTotal() {

        pontuacaoTotal += pontuacaoRodada;
        return pontuacaoTotal;
    }
}