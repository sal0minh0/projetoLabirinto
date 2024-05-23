import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Aventureiro jogador = new Aventureiro("Aventureiro1");
        Labirinto labirinto = null;

        // Mapa gerado
        boolean mapaGerado = false;

        while (true) {
            // Verificando se o mapa já foi gerado
            if (!mapaGerado) {
                labirinto = new Labirinto(10); // Cria um labirinto de tamanho 10
                labirinto.adicionarTesouro(new Tesouro("Chave", 10)); // Adiciona um tesouro-chave
                // Exibindo o labirinto inicialmente
                exibirLabirinto(jogador, labirinto);
                mapaGerado = true; // Marcando o mapa como gerado
            }

            // Verificando se o jogador alcançou o final do labirinto
            if (jogador.checaPassagemDeFase()) {
                System.out.println("Parabéns! Você passou de fase!");
                break;
            }

            // Solicitando comando de movimento ao jogador
            System.out.print("Para onde deseja ir? (w - cima, s - baixo, a - esquerda, d - direita): ");
            String comando = scanner.nextLine();

            // Movendo o jogador
            switch (comando) {
                case "w":
                    jogador.moverLabirinto("cima");
                    break;
                case "s":
                    jogador.moverLabirinto("baixo");
                    break;
                case "a":
                    jogador.moverLabirinto("esquerda");
                    break;
                case "d":
                    jogador.moverLabirinto("direita");
                    break;
                default:
                    System.out.println("Comando inválido!");
                    break;
            }

            // Exibindo o labirinto após a movimentação do jogador
            exibirLabirinto(jogador, labirinto);

            // Checando se há tesouros no labirinto
            for (Tesouro tesouro : labirinto.getListaTesouros()) {
                if (tesouro.getLocalizacao().equals(jogador.getLocalizacaoAtual())) {
                    if (tesouro.isChave()) {
                        jogador.setChave(true);
                        System.out.println("Você encontrou uma chave!");
                    } else {
                        jogador.coletarTesouro(tesouro);
                        System.out.println("Você encontrou um tesouro " + tesouro.getNome() + " (+ " + tesouro.getValor() + " pontos)!");
                    }
                }
            }
        }

        scanner.close();
    }

    // Método para exibir o labirinto com a posição atual do jogador
    private static void exibirLabirinto(Aventureiro jogador, Labirinto labirinto) {
        ArrayList<ArrayList<String>> estruturaLabirinto = labirinto.getEstruturaLabirinto();
        for (int i = 0; i < estruturaLabirinto.size(); i++) {
            for (int j = 0; j < estruturaLabirinto.get(i).size(); j++) {
                if (i == Integer.parseInt(jogador.getLocalizacaoAtual().split("/")[0]) && j == Integer.parseInt(jogador.getLocalizacaoAtual().split("/")[1])) {
                    // Verifica se a posição atual corresponde à posição do jogador
                    System.out.print("J "); // Imprime 'J' para representar o jogador
                } else {
                    System.out.print(estruturaLabirinto.get(i).get(j) + " "); // Imprime o conteúdo do labirinto
                }
            }
            System.out.println(); // Nova linha para cada linha do labirinto
        }
    }
}
