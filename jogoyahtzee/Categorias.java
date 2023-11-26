package jogoyahtzee;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//bibliotecas para o dicionario
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Enumeration;

public class Categorias{
    Jogadores jogadores = new Jogadores();
    private int categoriaEscolhida;

    public void menuDeCategorias(){
        System.out.println("""
                1 - Soma dos 1s
                2 - Soma dos 2s
                3 - Soma dos 3s
                4 - Soma dos 4s
                5 - Soma dos 5s
                6 - Soma dos 6s
                7 - Trinca
                8 - Quadra
                9 - Full House
                10 - Sequência curta
                11 - Sequência longa
                12 - Yahtzee
                13 - Sorte""");
    }

    public void setCategoriaEscolhida(int categoriaEcolhida) {
        this.categoriaEscolhida = categoriaEcolhida;
    }

    public int getCategoriaEscolhida() {
        return categoriaEscolhida;
    }

    public static int pontosObtidos(int categoriaEscolhida, ArrayList<Integer> dados) {
        switch (categoriaEscolhida) {
            //posição de 1 a 6 iram cair na case abaixo da "case 6"
            //é feito assim pois a condição é a mesma e o que importa é a o numero da categoriaEcolhdida
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return dados.stream().filter(d -> d == categoriaEscolhida).mapToInt(Integer::intValue).sum();

            // o mesmo vale para case 7 e 8, teram a mesma funcionalidade
            case 7://verificar
                Set<Integer> uniqueValues = new HashSet<>(dados);
                for (int value : uniqueValues) {
                    if (dados.stream().filter(d -> d == value).count() >= 3) {
                        dados.stream().mapToInt(Integer::intValue).sum();
                    }
                }
                break;
            case 8: //verificar
                Set<Integer> uniqueValues1 = new HashSet<>(dados);
                for (int value : uniqueValues1) {
                    if (dados.stream().filter(d -> d == value).count() >= 4) {
                        dados.stream().mapToInt(Integer::intValue).sum();
                    }
                }
                break;

            //uma trinca e um par
            case 9:
                Set<Integer> uniqueValues2 = new HashSet<>(dados);
                for (int value : uniqueValues2) {
                    if (dados.stream().filter(d -> d == value).count() >= 3) {
                        for (int j : uniqueValues2) {
                            if (value != j && dados.stream().filter(d -> d == j).count() >= 2) {
                                return 25;
                            }
                        }
                    }
                }
                break;

            //busca por sequencias CURTA especificas dentro da lista dados
            case 10:
                if (Arrays.equals(dados.stream().distinct().sorted().toArray(), new Integer[]{1, 2, 3, 4})
                        || Arrays.equals(dados.stream().distinct().sorted().toArray(), new Integer[]{2, 3, 4, 5})
                        || Arrays.equals(dados.stream().distinct().sorted().toArray(), new Integer[]{3, 4, 5, 6})) {
                    return 30;
                }
                break;

            //busca por sequencias LONGA especificas dentro da lista dados
            case 11: //"new Integer[]" usado para adicionar uma nova lista
                if (Arrays.equals(dados.stream().distinct().sorted().toArray(), new Integer[]{1, 2, 3, 4, 5})
                        || Arrays.equals(dados.stream().distinct().sorted().toArray(), new Integer[]{2, 3, 4, 5, 6})) {
                    return 40;
                }
                break;

            //5dados com o mesmo numero
            case 12: //HashSet é uma implementação da interface Set
                for (int value : new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6))) {
                    if (dados.stream().filter(d -> d == value).count() == 5) {
                        return 50;
                    }
                }
                break;

            //suma todos os dados
            case 13:
                return dados.stream().mapToInt(Integer::intValue).sum();
        }
        return 0;
    }

    //verifica se a categorai já foi escolhida antes
    public boolean contemCategoriaJogador1(int categoriaEscolhida){
       Enumeration<Integer> keys = jogadores.getDicionarioJogador1().keys();
       while (keys.hasMoreElements()){
           if(keys.nextElement().equals(categoriaEscolhida)){
               return true;
           }
       }
       return false;
    }
    public boolean contemCategoriaJogador2(int categoriaEscolhida){
        Enumeration<Integer> keys = jogadores.getDicionarioJogador2() .keys();
        while (keys.hasMoreElements()){
            if(keys.nextElement().equals(categoriaEscolhida)){
                return true;
            }
        }
        return false;
    }
}