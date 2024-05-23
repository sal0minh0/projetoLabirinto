public class Perigo {
    private String localizacao;
    private int danoPotencial;

    public Perigo(String localizacao, int danoPotencial) {
        this.localizacao = localizacao;
        this.danoPotencial = danoPotencial;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public int getDanoPotencial() {
        return danoPotencial;
    }

    public void setDanoPotencial(int danoPotencial) {
        this.danoPotencial = danoPotencial;
    }
}
