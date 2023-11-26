package jogoyahtzee;

import java.io.*;
import java.util.*;

public class ArquivoTxt {

    Jogadores jogadores = new Jogadores();
    Categorias categorias = new Categorias();

    // Escreve as informações em um arquivo
    public void escreverTxtJogador1(String nomeJogador1, int numeroInteiroJogador1, Dictionary<Integer, ArrayList> categoriasDefinidas) {
        try {
            File arquivo = new File(jogadores.getNomeJogador1() + ".txt");
            FileWriter escritor = new FileWriter(arquivo);
            BufferedWriter bufferEscrita = new BufferedWriter(escritor);

            for (Map.Entry<Integer, ArrayList<Integer>> entry : jogadores.getDicionarioJogador1().entreSet()) {
                bufferEscrita.write(entry.getKey() + " " + entry.getValue() + "\n");
            }

            bufferEscrita.close();
            escritor.close();
            System.out.println("Arquivo escrito com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo.");
            e.printStackTrace();
        }
    }

    // Lê as informações de um arquivo
    public void lerTxtJogador1() {
        try {
            File arquivo = new File(jogadores.getNomeJogador1() + ".txt");
            Scanner scanner = new Scanner(arquivo);

            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                String[] partes = linha.split(" ");
                int categoria = Integer.parseInt(partes[0]);
                ArrayList<Integer> dados = new ArrayList<>();
                for (int i = 1; i < partes.length; i++) {
                    dados.add(Integer.parseInt(partes[i]));
                }
                jogadores.getDicionarioJogador1().put(categoria, dados);
            }

            scanner.close();
            System.out.println("Arquivo lido com sucesso.");
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado. Criando novo arquivo para " + jogadores.getNomeJogador1() + ".");
        }
    }

    public void escreverTxtJogador2(String nomeJogador2, int numeroInteiroJogador1, Dictionary<Integer, ArrayList> categoriasDefinidas) {
        try {
            File arquivo = new File(jogadores.getNomeJogador2() + ".txt");
            FileWriter escritor = new FileWriter(arquivo);
            BufferedWriter bufferEscrita = new BufferedWriter(escritor);

            for (Map.Entry<Integer, ArrayList<Integer>> entry : jogadores.getDicionarioJogador2().entrySet()) {
                bufferEscrita.write(entry.getKey() + " " + entry.getValue() + "\n");
            }

            bufferEscrita.close();
            escritor.close();
            System.out.println("Arquivo escrito com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo.");
            e.printStackTrace();
        }
    }

    // Lê as informações de um arquivo
    public void lerTxtJogador2() {
        try {
            File arquivo = new File(jogadores.getNomeJogador2() + ".txt");
            Scanner scanner = new Scanner(arquivo);

            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                String[] partes = linha.split(" ");//delimitador é um espaço em branco
                int categoria = Integer.parseInt(partes[0]);
                ArrayList<Integer> dados = new ArrayList<>();
                for (int i = 1; i < partes.length; i++) {
                    dados.add(Integer.parseInt(partes[i]));
                }
                jogadores.getDicionarioJogador2().put(categoria, dados);
            }

            scanner.close();
            System.out.println("Arquivo lido com sucesso.");
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado. Criando novo arquivo para " + jogadores.getNomeJogador2() + ".");
        }
    }
}