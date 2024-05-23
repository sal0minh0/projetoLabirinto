import java.util.ArrayList;
import java.util.Random;

public class Labirinto {
    private ArrayList<ArrayList<String>> estruturaLabirinto;
    private ArrayList<Tesouro> listaTesouros;
    private ArrayList<Perigo> listaPerigos;

    public Labirinto(int tamanho) {
        this.estruturaLabirinto = new ArrayList<>();
        this.listaTesouros = new ArrayList<>();
        this.listaPerigos = new ArrayList<>();
        gerarLabirinto(tamanho);
    }

    public ArrayList<ArrayList<String>> getEstruturaLabirinto() {
        return estruturaLabirinto;
    }

    public ArrayList<Tesouro> getListaTesouros() {
        return listaTesouros;
    }

    public ArrayList<Perigo> getListaPerigos() {
        return listaPerigos;
    }

    // Método para gerar o labirinto
    private void gerarLabirinto(int tamanho) {
        Random rand = new Random();
        for (int i = 0; i < tamanho; i++) {
            ArrayList<String> linhaLabirinto = new ArrayList<>();
            for (int j = 0; j < tamanho; j++) {
                linhaLabirinto.add(rand.nextBoolean() ? " " : "#"); // Espaço vazio ou parede
            }
            estruturaLabirinto.add(linhaLabirinto);
        }
    }

    // Método para adicionar tesouro ao labirinto
    public void adicionarTesouro(Tesouro tesouro) {
        Random rand = new Random();
        int x, y;
        do {
            x = rand.nextInt(estruturaLabirinto.size());
            y = rand.nextInt(estruturaLabirinto.get(0).size());
        } while (!posicaoValida(x, y));

        tesouro.setLocalizacao(x + "/" + y); // Separando as coordenadas por barras
        listaTesouros.add(tesouro);
    }

    // Método para verificar se a posição está ocupada por outro tesouro ou perigo
    private boolean posicaoValida(int x, int y) {
        String posicao = x + "/" + y;
        for (Tesouro t : listaTesouros) {
            if (t.getLocalizacao().equals(posicao)) {
                return false;
            }
        }
        for (Perigo p : listaPerigos) {
            if (p.getLocalizacao().equals(posicao)) {
                return false;
            }
        }
        return true;
    }
}
