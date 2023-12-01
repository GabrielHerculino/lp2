import java.util.ArrayList;
import java.util.Scanner;
import jogoyahtzee.*;

public class Principal {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        Categorias categoria = new Categorias();
        RolarDado rolarDado = new RolarDado();
        Pontuacao pontuacao = new Pontuacao();
        Jogadores jogadores = new Jogadores();

        System.out.println("Qual o nome do jogador1: ");
        jogadores.setNomeJogador1(leitura.nextLine());
        System.out.println("Qual o nome do jogador2: ");
        jogadores.setNomeJogador2(leitura.nextLine());

        for (int rodada = 1; rodada <= 26; rodada++) { //o for faz as 13 rodadas que o jogo precisa ter
            float escolhaJogador = rodada%2;

            if(escolhaJogador != 0){
                jogadores.setNomeJogadorRodada(jogadores.getNomeJogador1());
            }
            if(escolhaJogador == 0){
                jogadores.setNomeJogadorRodada(jogadores.getNomeJogador2());
            }
            //inicio, limpa a lista dados, para iniciar um novo jogo
            rolarDado.getDados().clear();
            if(jogadores.getNomeJogadorRodada() == jogadores.getNomeJogador1()){
                jogadores.carregarDicionarioDoArquivoJogador1();
            }
            if(jogadores.getNomeJogadorRodada() == jogadores.getNomeJogador2()){
                jogadores.carregarDicionarioDoArquivoJogador2();
            }

            //informa a rodada e da a instrução para iniciar
            System.out.println("\nRodada " + rodada + "\n");
            System.out.println("Vez do jogador: " + jogadores.getNomeJogadorRodada());
            System.out.println("Pressione Enter para rolar os dados");
            leitura.nextLine();

            //faz a rolagem dos dados e da a opção de rolar novamente
            rolarDado.rolarCincoDados(rolarDado.getDados());
            System.out.println("\nDados: " + rolarDado.getDados() + "\n");
            System.out.print("Deseja rolar novamente algum dado? ");
            String rolarNovamente = leitura.nextLine().toUpperCase();

            //caso deseje rolar, vai entrar nesse if. Você pode rolar quantos dados quiser uma unica vez
            if ("SIM".equals(rolarNovamente)) {
                //informa a posição de cada dado rolado dentro da lista e quantos irá rolar novamnete
                System.out.print("Quantos dados vai rolar novamente? ");

                //quando se coloca "int qntDados = leitura.nextInt();" ele acha que "qntDados" é uma string
                int qntDados = Integer.parseInt(leitura.nextLine());

                for (int i = 0; i < rolarDado.getDados().size(); i++) { // .size() é usado para pegar o tamanho total da lista
                    System.out.println("Posição: " + (i + 1) + " Dado: " + rolarDado.getDados().get(i));
                }
                //pergunta a posição dos dados que vai rolar novamnete
                for (int j = 0; j < qntDados; j++) {
                    System.out.print("Qual posição está o número? ");
                    int posicao = Integer.parseInt(leitura.nextLine()) - 1;
                    rolarDado.getDados().set(posicao, rolarDado.rolarUmDado());
                }
            }

            //informa as categorias do jogo e mostra de novo os dados rolados
            if(jogadores.getNomeJogadorRodada() == jogadores.getNomeJogador1()){
                jogadores.entradaDicionarioJogador1(categoria.getCategoriaEscolhida(), rolarDado.getDados());
            }
            if(jogadores.getNomeJogadorRodada() == jogadores.getNomeJogador2()){
                jogadores.entradaDicionarioJogador2(categoria.getCategoriaEscolhida(), rolarDado.getDados());
            }
            categoria.menuDeCategorias();
            System.out.println("\nDados: " + rolarDado.getDados() + "\n");
            //pede que escolha uma categoria

            while(pontuacao.getPontuacaoRodada() == 0) {
                System.out.print("Escolha a categoria: ");
                categoria.setCategoriaEscolhida(leitura.nextInt());

                if(jogadores.getNomeJogadorRodada() == jogadores.getNomeJogador1()){
                    boolean verifica = categoria.contemCategoriaJogador1(categoria.getCategoriaEscolhida());
                    if (!verifica) {
                        jogadores.entradaDicionarioJogador1(categoria.getCategoriaEscolhida(), rolarDado.getDados());
                        //faz a contagem dos pontos baseado na Classe Categorias
                        pontuacao.setPontuacaoRodada(categoria.pontosObtidos(categoria.getCategoriaEscolhida(), rolarDado.getDados()));
                        System.out.println("Pontuacao na rodada: " + pontuacao.getPontuacaoRodada());
                        //faz a soma dapontuação da rodada com a posição total
                        jogadores.setNumeroInteiroJogador1(pontuacao.getPontuacaoRodada());
                        //jogadores.entradaDicionarioJogador1(categoria.getCategoriaEscolhida(), rolarDado.getDados());

                    } else {
                        System.out.println("Categoria já escolhida, escolha novamente");
                    }
                    jogadores.entradaDicionarioJogador1(categoria.getCategoriaEscolhida(), rolarDado.getDados());
                    jogadores.salvarDicionarioNoArquivoJogador1();
                }
                if(jogadores.getNomeJogadorRodada() == jogadores.getNomeJogador2()){
                    boolean verifica = categoria.contemCategoriaJogador2(categoria.getCategoriaEscolhida());
                    if (!verifica) {
                        jogadores.entradaDicionarioJogador2(categoria.getCategoriaEscolhida(), rolarDado.getDados());
                        //faz a contagem dos pontos baseado na Classe Categorias
                        pontuacao.setPontuacaoRodada(categoria.pontosObtidos(categoria.getCategoriaEscolhida(), rolarDado.getDados()));
                        System.out.println("Pontuacao na rodada: " + pontuacao.getPontuacaoRodada());
                        //faz a soma dapontuação da rodada com a posição total
                        jogadores.setNumeroInteiroJogador2(pontuacao.getPontuacaoRodada());

                    } else {
                        System.out.println("Categoria já escolhida, escolha novamente");
                    }
                    jogadores.salvarDicionarioNoArquivoJogador2();
                }
            }

            pontuacao.setPontuacaoRodada(0);
        }

        //ao fim do jogo a pontuação total é mostrada
        System.out.println("Pontuacao total: " + pontuacao.getPontuacaoTotal());
    }
}