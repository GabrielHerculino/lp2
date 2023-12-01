package jogoyahtzee;

import java.io.*;
import java.util.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ArquivoTxt {

    Jogadores jogadores = new Jogadores();

    // Escreve as informações em um arquivo
    public void escreverTxtJogador1(String nomeJogador1, int pontuacaoTotalJogador1, Dictionary<Integer, ArrayList> categoriasDefinidas) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeJogador1 + ".txt"))) {
            // Escreva as informações do jogador no arquivo
            writer.write(String.valueOf(pontuacaoTotalJogador1));
            writer.newLine();
            writer.write(categoriasDefinidas.toString().charAt(1));

            System.out.println("Informações do jogador salvas com sucesso em " + nomeJogador1);
        } catch (IOException e) {
            System.err.println("Erro ao salvar informações do jogador no arquivo: " + e.getMessage());
        }
    }

    // Lê as informações de um arquivo
    public void lerTxtJogador1(String nomeJogador1, int pontuacaoTotalJogador1, Dictionary<Integer, ArrayList> categoriaEscolhidaJogador1) {
        try {
            File arquivo = new File(nomeJogador1+ ".txt");
            arquivo.createNewFile();
            Scanner scanner = new Scanner(arquivo);

            jogadores.setNomeJogador1(nomeJogador1);

            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();

                jogadores.setPontuacaoTotalJogador1(Integer.parseInt(linha));
            }

            scanner.close();
            System.out.println("Arquivo lido com sucesso.");
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado. Criando novo arquivo.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void escreverTxtJogador2(String nomeJogador2, int pontuacaoTotalJogador2, Dictionary<Integer, ArrayList> categoriasDefinidas) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeJogador2 + ".txt"))) {
            // Escreva as informações do jogador no arquivo
            writer.write(String.valueOf(pontuacaoTotalJogador2));
            writer.newLine();
            writer.write(categoriasDefinidas.toString().charAt(1));

            System.out.println("Informações do jogador salvas com sucesso em " + nomeJogador2);
        } catch (IOException e) {
            System.err.println("Erro ao salvar informações do jogador no arquivo: " + e.getMessage());
        }
    }


    // Lê as informações de um arquivo
    public void lerTxtJogador2(String nomeJogador2, int pontuacaoTotalJogador2, Dictionary<Integer, ArrayList> categoriaEscolhidaJogador2) {
        try {
            File arquivo = new File(nomeJogador2+ ".txt");
            arquivo.createNewFile();
            Scanner scanner = new Scanner(arquivo);

            jogadores.setNomeJogador2(nomeJogador2);

            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();

                jogadores.setPontuacaoTotalJogador2(Integer.parseInt(linha));
            }

            scanner.close();
            System.out.println("Arquivo lido com sucesso.");
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado. Criando novo arquivo.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}