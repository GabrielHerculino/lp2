package jogoyahtzee;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

public class Jogadores {
    //Categorias categorias = new Categorias();
    private String nomeJogadorRodada;
    private String nomeJogador1;
    private String nomeJogador2;
    private int pontuacaoTotalJogador1;
    private int pontuacaoTotalJogador2;
    private Dictionary<Integer, ArrayList> categoriaEscolhidaJogador1 = new Hashtable<>();
    private Dictionary<Integer, ArrayList> categoriaEscolhidaJogador2 = new Hashtable<>();

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

    public void entradaCategoriaEscolhidaJogador1(int categoriaEscolhida, ArrayList<Integer> dados){
        categoriaEscolhidaJogador1.put(categoriaEscolhida,dados);
    }
    public void entradaCategoriaEscolhidaJogador2(int categoriaEscolhida, ArrayList<Integer> dados){
        categoriaEscolhidaJogador2.put(categoriaEscolhida,dados);
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

    public Dictionary<Integer, ArrayList> getCategoriaEscolhidaJogador1() {
        return categoriaEscolhidaJogador1;
    }

    public Dictionary<Integer, ArrayList> getCategoriaEscolhidaJogador2() {
        return categoriaEscolhidaJogador2;
    }


    public String getNomeJogadorRodada() {
        return nomeJogadorRodada;
    }

    public void setNomeJogadorRodada(String nomeJogadorRodada) {
        this.nomeJogadorRodada = nomeJogadorRodada;
    }



    public void carregarDicionarioDoArquivoJogador1() {
        ArquivoTxt arquivo = new ArquivoTxt();
        arquivo.lerTxtJogador1(getNomeJogador1(),getPontuacaoTotalJogador1(),getCategoriaEscolhidaJogador1());
    }

    public void salvarDicionarioNoArquivoJogador1() {
        ArquivoTxt arquivo = new ArquivoTxt();
        arquivo.escreverTxtJogador1(getNomeJogador1(), getPontuacaoTotalJogador1(),getCategoriaEscolhidaJogador1());
    }

    public void carregarDicionarioDoArquivoJogador2() {
        ArquivoTxt arquivo = new ArquivoTxt();
        //entradaCategoriaEscolhidaJogador2(arquivo.lerTxtJogador2());
        arquivo.lerTxtJogador2(getNomeJogador2(), getPontuacaoTotalJogador2(),getCategoriaEscolhidaJogador2());
    }

    public void salvarDicionarioNoArquivoJogador2() {
        ArquivoTxt arquivo = new ArquivoTxt();
        arquivo.escreverTxtJogador2(getNomeJogador2(), getPontuacaoTotalJogador2(), getCategoriaEscolhidaJogador2());
    }
}