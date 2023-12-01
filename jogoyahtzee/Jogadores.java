package jogoyahtzee;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

public class Jogadores {
    //Categorias categorias = new Categorias();
    private String nomeJogadorRodada;
    private String nomeJogador1;
    private String nomeJogador2;
    private int numeroInteiroJogador1;
    private int numeroInteiroJogador2;
    private Dictionary<Integer, ArrayList> dicionarioJogador1 = new Hashtable<>();
    private Dictionary<Integer, ArrayList> dicionarioJogador2 = new Hashtable<>();

    public Jogadores(String nomeJogador1, int numeroInteiroJogador1, String nomeJogador2, int numeroInteiroJogador2) {
        this.nomeJogador1 = nomeJogador1;
        this.numeroInteiroJogador1 = numeroInteiroJogador1;
        this.nomeJogador2 = nomeJogador2;
        this.numeroInteiroJogador2 = numeroInteiroJogador2;
    }

    public Jogadores(){
        this.nomeJogador1 = "";
        this.numeroInteiroJogador1 = 0;
        this.nomeJogador2 = "";
        this.numeroInteiroJogador2 = 0;
    }

    public void entradaDicionarioJogador1(int categoriaEscolhida, ArrayList<Integer> dados){
        dicionarioJogador1.put(categoriaEscolhida,dados);
    }
    public void entradaDicionarioJogador2(int categoriaEscolhida, ArrayList<Integer> dados){
        dicionarioJogador2.put(categoriaEscolhida,dados);
    }

    public String getNomeJogador1() {
        return this.nomeJogador1;
    }

    public String getNomeJogador2() {
        return this.nomeJogador2;
    }

    public int getNumeroInteiroJogador1() {
        return this.numeroInteiroJogador1;
    }

    public int getNumeroInteiroJogador2() {
        return this.numeroInteiroJogador2;
    }

    public void setNomeJogador1(String nomeJogador1) {
        this.nomeJogador1 = nomeJogador1;
    }

    public void setNomeJogador2(String nomeJogador2) {
        this.nomeJogador2 = nomeJogador2;
    }

    public void setNumeroInteiroJogador1(int numeroInteiroJogador1) {
        this.numeroInteiroJogador1 += numeroInteiroJogador1;
    }

    public void setNumeroInteiroJogador2(int numeroInteiroJogador2) {
        this.numeroInteiroJogador2 += numeroInteiroJogador2;
    }

    public Dictionary<Integer, ArrayList> getDicionarioJogador1() {
        return dicionarioJogador1;
    }

    public Dictionary<Integer, ArrayList> getDicionarioJogador2() {
        return dicionarioJogador2;
    }


    public String getNomeJogadorRodada() {
        return nomeJogadorRodada;
    }

    public void setNomeJogadorRodada(String nomeJogadorRodada) {
        this.nomeJogadorRodada = nomeJogadorRodada;
    }



    public void carregarDicionarioDoArquivoJogador1() {
        ArquivoTxt arquivo = new ArquivoTxt();
        arquivo.lerTxtJogador1(getNomeJogador1(),getNumeroInteiroJogador1(),getDicionarioJogador1());
    }

    public void salvarDicionarioNoArquivoJogador1() {
        ArquivoTxt arquivo = new ArquivoTxt();
        arquivo.escreverTxtJogador1(getNomeJogador1(), getNumeroInteiroJogador1(),getDicionarioJogador1());
    }

    public void carregarDicionarioDoArquivoJogador2() {
        ArquivoTxt arquivo = new ArquivoTxt();
        //entradaDicionarioJogador2(arquivo.lerTxtJogador2());
        arquivo.lerTxtJogador2(getNomeJogador2(), getNumeroInteiroJogador2(),getDicionarioJogador2());
    }

    public void salvarDicionarioNoArquivoJogador2() {
        ArquivoTxt arquivo = new ArquivoTxt();
        arquivo.escreverTxtJogador2(getNomeJogador2(), getNumeroInteiroJogador2(), getDicionarioJogador2());
    }
}