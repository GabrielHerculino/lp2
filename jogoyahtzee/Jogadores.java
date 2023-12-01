package jogoyahtzee;

import java.util.ArrayList;

public class Jogadores {
    private String nomeJogadorRodada;
    private String nomeJogador1;
    private String nomeJogador2;
    private int pontuacaoTotalJogador1;
    private int pontuacaoTotalJogador2;
    private ArrayList<Integer> categoriaEscolhidaJogador1 = new ArrayList<>();
    private ArrayList<Integer> categoriaEscolhidaJogador2 = new ArrayList<>();

    public Jogadores(String nomeJogador1, int pontuacaoTotalJogador1, String nomeJogador2, int pontuacaoTotalJogador2) {
        this.nomeJogador1 = nomeJogador1;
        this.pontuacaoTotalJogador1 = pontuacaoTotalJogador1;
        this.nomeJogador2 = nomeJogador2;
        this.pontuacaoTotalJogador2 = pontuacaoTotalJogador2;
    }

    public Jogadores(){
        this.nomeJogador1 = "";
        this.pontuacaoTotalJogador1 = 0;
        this.nomeJogador2 = "";
        this.pontuacaoTotalJogador2 = 0;
    }

    public void entradaCategoriaEscolhidaJogador1(int categoriaEscolhida){
        categoriaEscolhidaJogador1.add(categoriaEscolhida);
    }
    public void entradaCategoriaEscolhidaJogador2(int categoriaEscolhida){
        categoriaEscolhidaJogador2.add(categoriaEscolhida);
    }

    public String getNomeJogador1() {
        return this.nomeJogador1;
    }

    public String getNomeJogador2() {
        return this.nomeJogador2;
    }

    public int getPontuacaoTotalJogador1() {
        return this.pontuacaoTotalJogador1;
    }

    public int getPontuacaoTotalJogador2() {
        return this.pontuacaoTotalJogador2;
    }

    public void setNomeJogador1(String nomeJogador1) {
        this.nomeJogador1 = nomeJogador1;
    }

    public void setNomeJogador2(String nomeJogador2) {
        this.nomeJogador2 = nomeJogador2;
    }

    public void setPontuacaoTotalJogador1(int pontuacaoTotalJogador1) {
        this.pontuacaoTotalJogador1 += pontuacaoTotalJogador1;
    }

    public void setPontuacaoTotalJogador2(int pontuacaoTotalJogador2) {
        this.pontuacaoTotalJogador2 += pontuacaoTotalJogador2;
    }

    public ArrayList<Integer> getCategoriaEscolhidaJogador1() {
        return categoriaEscolhidaJogador1;
    }

    public ArrayList<Integer> getCategoriaEscolhidaJogador2() {
        return categoriaEscolhidaJogador2;
    }
    
    public String getNomeJogadorRodada() {
        return nomeJogadorRodada;
    }

    public void setNomeJogadorRodada(String nomeJogadorRodada) {
        this.nomeJogadorRodada = nomeJogadorRodada;
    }
    
    public void carregarListaDoArquivo1() {
        ArquivoTxt arquivo = new ArquivoTxt();
        arquivo.lerTxtJogador1(getNomeJogador1());
    }

    public void salvarListaDoArquivo1() {
        ArquivoTxt arquivo = new ArquivoTxt();
        arquivo.escreverTxtJogador1(getNomeJogador1(), getPontuacaoTotalJogador1(),getCategoriaEscolhidaJogador1());
    }

    public void carregarListaDoArquivo2() {
        ArquivoTxt arquivo = new ArquivoTxt();
        arquivo.lerTxtJogador2(getNomeJogador2());
    }

    public void salvarListaDoArquivo2() {
        ArquivoTxt arquivo = new ArquivoTxt();
        arquivo.escreverTxtJogador2(getNomeJogador2(), getPontuacaoTotalJogador2(), getCategoriaEscolhidaJogador2());
    }
}