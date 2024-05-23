import java.util.ArrayList;

public class Aventureiro {
    private String nome;
    private String localizacaoAtual;
    private ArrayList<Tesouro> tesourosColetados;
    private boolean chave;

    public Aventureiro(String nome) {
        this.nome = nome;
        this.localizacaoAtual = "0/0"; // Definindo a localização inicial do aventureiro
        this.tesourosColetados = new ArrayList<>();
        this.chave = false;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalizacaoAtual() {
        return localizacaoAtual;
    }

    public void setLocalizacaoAtual(String localizacaoAtual) {
        this.localizacaoAtual = localizacaoAtual;
    }

    public ArrayList<Tesouro> getTesourosColetados() {
        return tesourosColetados;
    }

    public void setTesourosColetados(ArrayList<Tesouro> tesourosColetados) {
        this.tesourosColetados = tesourosColetados;
    }

    public boolean isChave() {
        return chave;
    }

    public void setChave(boolean chave) {
        this.chave = chave;
    }

    // Método para mover-se pelo labirinto
    public void moverLabirinto(String direcao) {
        String[] coordenadas = this.localizacaoAtual.split("/");
        int x = Integer.parseInt(coordenadas[0]);
        int y = Integer.parseInt(coordenadas[1]);

        switch (direcao) {
            case "cima":
                x--;
                break;
            case "baixo":
                x++;
                break;
            case "esquerda":
                y--;
                break;
            case "direita":
                y++;
                break;
            default:
                System.out.println("Direção inválida!");
                return;
        }

        this.localizacaoAtual = x + "/" + y;
    }

    // Método para verificar se o jogador alcançou o local para passar de fase
    public boolean checaPassagemDeFase() {
        String[] coordenadas = this.localizacaoAtual.split("/");
        int x = Integer.parseInt(coordenadas[0]);
        int y = Integer.parseInt(coordenadas[1]);
        return x == 9 && y == 9 && this.chave;
    }

    // Método para coletar tesouro
    public void coletarTesouro(Tesouro tesouro) {
        this.tesourosColetados.add(tesouro);
    }
}
