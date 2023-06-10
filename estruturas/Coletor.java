package estruturas;

public class Coletor {
    public String login;
    public boolean existe;
    public int posicao;

    public Coletor(String login, Boolean existe, int posicao) {
        this.login = login;
        this.existe = existe;
        this.posicao = posicao;
    }
}