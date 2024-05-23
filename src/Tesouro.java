public class Tesouro {
    private String nome;
    private String localizacao;
    private int valor;
    private boolean chave;

    public Tesouro(String nome, int valor) {
        this.nome = nome;
        this.valor = valor;
        this.chave = false;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public boolean isChave() {
        return chave;
    }

    public void setChave(boolean chave) {
        this.chave = chave;
    }
}
